package com.learn.dataStructure.D3stack;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author yds
 * @title: S9StackCalculate
 * @description: 中缀表达式 使用栈实现计算器
 *
 * 该案例只是介绍 使用栈实现计算机的思想，如有需要，自行完善
 *
 * 已实现功能：
 * 1.数据格式化
 * 2.数据校验
 * 2.多位数处理
 *
 * 待完善功能：TODO
 * 1.小数点问题
 * 2.括号问题
 *
 * 实现逻辑如下：
 * 1.创建两个栈:一个数值栈 一个操作符栈
 * 2.从左向右遍历
 * 3.数据入栈
 *  3.1)遇到数字,直接入栈到数值栈
 *  3.2)遇到操作符
 *      3.2.1)操作符栈为空,则直接入数值栈
 *      3.2.2)操作符栈非空
 *      3.2.2.1)当前遍历的操作符 比 操作符栈顶 优先级高,则直接入操作符栈
 *      3.2.2.2)当前遍历的操作符 比 操作符栈顶 优先级低
 *          ①弹出数值栈的 栈顶和次栈顶两个数
 *          ②弹出操作符栈的 栈顶操作符
 *          ③进行运算,然后将结果压入数值栈
 *          ②将当前操作符入栈
 * @date 2020/10/22 14:36
 */
public class S901StackInfixCalculate {

    // 定义操作符优先级
    private static Map<String, Integer> operatePriorityMap = new HashMap<String, Integer>();

    static {
        operatePriorityMap.put("*", 5);
        operatePriorityMap.put("/", 5);
        operatePriorityMap.put("+", 3);
        operatePriorityMap.put("-", 3);
    }

    public static void main(String[] args) {
        String infixExpressionStr = "   10+10*10-10   -10/10  ";
        Integer calculateResult = calculate(infixExpressionStr);
        System.out.println(infixExpressionStr + "=" + calculateResult);
    }

    private static Integer calculate(String infixExpressionStr) {
        // 便于遍历，转成集合
        List<String> infixExpList = strToInfixList(infixExpressionStr);

        // 数值栈
        Stack<Integer> valueStack = new Stack<>();
        // 操作符栈
        Stack<String> operateStack = new Stack<>();

        // 遍历中缀表达式
        infixExpList.stream().forEach(item -> {
                    if (checkNum(item)) {
                        valueStack.push(Integer.parseInt(item));
                    } else {
                        if (!operateStack.empty()) {// 操作符非空时
                            // 栈顶操作符
                            String stackTopOperate = operateStack.peek();
                            // 判读当前操作符是否 小于或等于 栈顶操作符 优先级
                            if (!checkCurrentOperateHighPriority(item, stackTopOperate)) {
                                Integer value1 = valueStack.pop();
                                Integer value2 = valueStack.pop();
                                Integer result = calculateByOperate(value1, value2, operateStack.pop());
                                valueStack.push(result);
                            }
                        }
                        operateStack.push(item);
                    }
                }
        );

        while (!operateStack.empty()) {
            Integer value1 = valueStack.pop();
            Integer value2 = valueStack.pop();
            Integer result = calculateByOperate(value1, value2, operateStack.pop());
            valueStack.push(result);
        }
        return valueStack.pop();
    }

    /**
     * 根据操作符计算结果
     *
     * @param value1
     * @param value2
     * @param operate 操作符
     * @return java.lang.Integer
     * @author yds
     * @date 2020/10/23 19:00
     */
    private static Integer calculateByOperate(Integer value1, Integer value2, String operate) {
        switch (operate) {
            case "+":
                return value1 + value2;
            case "-":
                return value2 - value1;
            case "*":
                return value1 * value2;
            case "/":
                return value2 / value1;
            default:
                throw new RuntimeException("当前只支持 +-*/ 计算，后续功能开发中...");
        }
    }


    /**
     * 中缀表达式 转 集合 同时处理多位数
     *
     * @param infixExpressionStr 中缀表达式
     * @return java.util.List<java.lang.String>
     * @author yds
     * @date 2020/10/23 19:02
     */
    private static List<String> strToInfixList(String infixExpressionStr) {
        // 格式化
        infixExpressionStr = infixExpressionStr.trim().replaceAll(" ", "");

        // 参数校验
        validation(infixExpressionStr);

        // 中缀表达式集合结果
        List<String> infixExpList = new ArrayList<>();

        // 多位数处理使用的变量
        StringBuffer bufferNum = new StringBuffer();

        // 遍历集合处理数据
        for (int i = 0; i < infixExpressionStr.length(); i++) {
            char currentItem = infixExpressionStr.charAt(i);

            // 判断是否为数字
            if (checkNum(String.valueOf(currentItem))) {
                bufferNum.append(String.valueOf(currentItem));

                // 多位数处理
                // 非最后一位
                if (i < infixExpressionStr.length() - 1) {
                    // 下探一位，拼装后是否 为数字
                    String nextItemStr = String.valueOf(infixExpressionStr.charAt(i + 1));
                    if (!checkNum(bufferNum.toString() + nextItemStr)) {
                        infixExpList.add(bufferNum.toString());
                        bufferNum = new StringBuffer();
                    }
                    continue;
                }

                // 最后一位
                if (i == infixExpressionStr.length() - 1) {
                    infixExpList.add(bufferNum.toString());
                    bufferNum = new StringBuffer();
                }
            } else {
                infixExpList.add(String.valueOf(currentItem));
            }
        }
        return infixExpList;
    }


    /**
     * 比较两个操作符优先级，当前操作符是否高优先级
     *
     * @param curretntOperate 当前操作符
     * @param stackTopOperate 栈顶操作符
     * @return boolean
     * @author yds
     * @date 2020/10/23 19:00
     */
    private static boolean checkCurrentOperateHighPriority(String curretntOperate, String stackTopOperate) {
        return operatePriorityMap.get(curretntOperate) > operatePriorityMap.get(stackTopOperate);
    }

    /**
     * 检查是否数字
     * 根据需要可自行 完善
     *
     * @param item
     * @return boolean
     * @author yds
     * @date 2020/10/23 17:50
     */
    private static boolean checkNum(String item) {
        return item.matches("^[0-9]*$");
    }

    /**
     * 参数校验
     *
     * @param infixExpressionStr 中缀表达式
     * @return void
     * @author yds
     * @date 2020/10/23 19:01
     */
    private static void validation(String infixExpressionStr) {
        if (StringUtils.isEmpty(infixExpressionStr)) {
            throw new RuntimeException("输入表达式不能为空");
        }
        if (!infixExpressionStr.matches("^\\d+.*\\d$")) {
            throw new RuntimeException("输入表达式不合法");
        }
    }
}
