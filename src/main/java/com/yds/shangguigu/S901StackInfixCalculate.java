package com.yds.shangguigu;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yds
 * @title: S9StackCalculate
 * @description: 中缀表达式
 * 1.创建两个栈:一个数值栈 一个操作符栈
 * 2.从左向右遍历
 * 3.数据入栈
 *  3.1)遇到数字,直接入栈到数值栈
 *  3.2)遇到操作符
 *      3.2.1)操作符栈为空,则直接入数值栈
 *      3.2.2)操作符栈非空
 *          3.2.2.1)当前遍历的操作符 比 操作符栈顶 优先级高,则直接入操作符栈
 *          3.2.2.2)当前遍历的操作符 比 操作符栈顶 优先级低
 *                  ①弹出数值栈的 栈顶和次栈顶两个数
 *                  ②弹出操作符栈的 栈顶操作符
 *                  ③进行运算,然后将结果压入数值栈
 *                  ②将当前操作符入栈
 *
 *
 * @date 2020/10/22 14:36
 */
public class S901StackInfixCalculate {

    static Map<Character, Integer> operateMap = new HashMap<>();
    static Map<Character, Character> map = new HashMap<>();

    static {
        operateMap.put('*', 5);
        operateMap.put('/', 5);
        operateMap.put('+', 3);
        operateMap.put('-', 3);
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }

    public static void main(String[] args) {
        String str2 = "(){}[";
        boolean check = check(str2);
        System.out.println(str2 + ",该字符串配对结果:" + check);
        String str = "2+2*30-4-60/6";
        int reslut = calculate(str);
        System.out.println(str + "=" + reslut);
    }

    private static boolean check(String str) {
        Stack<Character> operateStack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (!operateStack.empty()) {
                Character peek = operateStack.peek();
                if (map.get(peek) == str.charAt(i)) {
                    operateStack.pop();
                    continue;
                }
            }
            operateStack.push(str.charAt(i));
        }
        return operateStack.empty();
    }

    private static int calculate(String str) {
        // 校验参数
        if (StringUtils.isEmpty(str)) {
            throw new RuntimeException("输入数据不能为空");
        }
        String regEx = "^\\d+.*\\d$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            throw new RuntimeException("请输入合法数据");
        }


        Stack<Integer> numStack = new Stack();
        Stack<Character> operateStack = new Stack();

        StringBuffer num = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            String regExNum = "^\\d*\\d$";
            Pattern patternNum = Pattern.compile(regExNum);
            Matcher matcherNum = patternNum.matcher(String.valueOf(str.charAt(i)));
            if (matcherNum.matches()) { // 数字
                num.append(str.charAt(i));

                if (i != str.length() - 1) {
                    StringBuffer numTemp = new StringBuffer(num);
                    numTemp.append(str.charAt(i + 1));
                    Matcher matcherNum2 = patternNum.matcher(numTemp);
                    if (!matcherNum2.matches()) {
                        numStack.push(Integer.parseInt(num.toString()));
                        num = new StringBuffer();
                    }
                } else {
                    numStack.push(Integer.parseInt(num.toString()));
                }
            } else { // 字符
                char currentOperate = str.charAt(i);
                // 非空栈
                if (!operateStack.empty()) {
                    // 查看栈顶操作符
                    char stackTopOperate = operateStack.peek();

                    // 比较运算符优先级
                    Integer stackTopOperateLevel = operateMap.get(stackTopOperate);
                    Integer currentOperateLevel = operateMap.get(currentOperate);
                    boolean isHighLevelCurrentOperate = currentOperateLevel > stackTopOperateLevel;

                    // 当前操作符优先级 低于或等于 栈顶操作符符优先级
                    if (!isHighLevelCurrentOperate) {
                        Integer pop1 = numStack.pop();
                        Integer pop2 = numStack.pop();
                        Character operate = operateStack.pop();
                        Integer result = calOperate(operate, pop1, pop2);
                        numStack.push(result);
                    }
                }
                // 操作符压入栈
                operateStack.push(currentOperate);
            }
        }

        while (!operateStack.empty()) {
            Character operate = operateStack.pop();
            Integer pop1 = numStack.pop();
            Integer pop2 = numStack.pop();
            Integer result = calOperate(operate, pop1, pop2);
            numStack.push(result);
        }
        return numStack.pop();
    }

    private static Integer calOperate(char operate, Integer pop1, Integer pop2) {
        if ('*' == operate) {
            return pop1 * pop2;
        } else if ('/' == operate) {
            return pop2 / pop1;
        } else if ('+' == operate) {
            return pop2 + pop1;
        } else if ('-' == operate) {
            return pop2 - pop1;
        }
        return 0;
    }


    public void operatePriority(char a, char b) {
        if ("*".equals(a) || "/".equals(a)) {

        }
    }

}
