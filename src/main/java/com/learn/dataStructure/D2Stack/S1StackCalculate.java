package com.learn.dataStructure.D2Stack;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author yds
 * @title: S9StackCalculate
 * @description: 使用栈实现计算器
 *
 * 该案例只是介绍 使用栈实现计算机的思想，如有需要，自行完善
 *
 * 已实现功能：
 * 1.数据格式化
 * 2.数据校验
 * 2.多位数处理
 *
 * @date 2020/10/22 14:36
 */
public class S1StackCalculate {

    // 定义操作符优先级
    private static Map<String, Integer> operatePriorityMap = new HashMap<String, Integer>();

    static {
        operatePriorityMap.put("*", 5);
        operatePriorityMap.put("/", 5);
        operatePriorityMap.put("+", 3);
        operatePriorityMap.put("-", 3);
    }

    public static void main(String[] args) {
        // 中序表达式 实现计算器
        String infixExpressionStr = "   10+10*10-10   -10/10  ";
        Integer calculateResult = infixCalculate(infixExpressionStr);
        System.out.println(infixExpressionStr + "=" + calculateResult);

        // 后序表达式 实现计算器 （中序转后续）
        String infixExpressionStr2 = "(30+4)*5-6";
        Integer integer = suffixCalculate(infixExpressionStr2);
        System.out.println(infixExpressionStr2 + "=" + integer);
    }

    /**
     *
     * 中缀表达式--实现计算器
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
     * @param infixExpressionStr
     * @return
     */
    private static Integer infixCalculate(String infixExpressionStr) {
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
     * 后续表达式--实现计算器
     *
     * 实现逻辑如下：
     * 1.创建一个栈：数值栈
     * 2.从左向右遍历
     * 3.遇到数字时，将数字压入栈中，
     *   遇到运算符时，弹出栈顶的两个数，用运算符对他们进行运算，并将结果入栈
     * @param infixExpressionStr
     * @return
     */
    private static Integer suffixCalculate(String infixExpressionStr) {
        // 中序表达式转换为 后续表达式
        List<String> suffixExpList = transferInfixToSuffix(infixExpressionStr);
        // 数值栈
        Stack<Integer> valueStack = new Stack<>();

        suffixExpList.stream().forEach(item -> {
            if (checkNum(item)) {
                valueStack.push(Integer.parseInt(item));
            } else {
                Integer pop1 = valueStack.pop();
                Integer pop2 = valueStack.pop();
                Integer calculateByOperateResult = calculateByOperate(pop1, pop2, item);
                valueStack.push(calculateByOperateResult);
            }
        });
        return valueStack.pop();
    }



    /**
     * 中缀表达式 转换成 后缀表达式
     * 0.创建操作符栈s1，结果栈s2
     * 1.从左向右遍历中缀表达式
     * 2.遇到数值时，将其压入s2
     * 3.遇到操作符时，比较其与s1栈顶的优先级
     *  3.1.如果s1为空 或者 栈顶运算符为左括号，则直接将此运算符入栈
     *  3.2.如果该操作符优先级比栈顶运算符的高，则直接将此运算符入栈
     *  3.3.如果该操作符优先级低，则将s1栈顶的运算符弹出并压入到s2中，再次转到3.1与s1中新的栈顶运算符相比较
     * 4.遇到括号是：
     *  4.1.遇到左括号，入栈s1
     *  4.2.遇到右括号，则依次弹出s1的运算符，并压入s2，直到遇见左括号为止，此时将这一对括号丢弃
     *
     * 5.遍历结束后，将s1中剩余的运算符依次弹出并压入s2
     * 6.将s2弹出，并进行逆序，则为后缀表达式
     * @param infixExpressionStr
     * @return
     */
    private static List<String> transferInfixToSuffix(String infixExpressionStr) {
        List<String> infixExpList = strToInfixList(infixExpressionStr);

        Stack<String> operateStack = new Stack<>();
        List<String> resultStack = new ArrayList<>();

        infixExpList.stream().forEach(item -> {
            if (checkNum(item)) {// 数字
                resultStack.add(item);
            } else if ("(".equals(item)) {// 括号-左
                operateStack.push(item);
            } else if (")".equals(item)) {// 括号-右
                while (true) {
                    if (operateStack.peek().equals("(")) { // 去除()
                        operateStack.pop();
                        break;
                    } else {
                        resultStack.add(operateStack.pop());
                    }
                }
            } else {// 运算符
                while (true) {
                    // 操作符栈为空 或者 栈顶为左括号
                    if (operateStack.isEmpty() || operateStack.peek().equals("(")) {
                        operateStack.push(item);
                        break;
                    } else if (checkCurrentOperateHighPriority(item, operateStack.peek())) {
                        operateStack.push(item);
                        break;
                    } else {
                        resultStack.add(operateStack.pop());
                    }
                }
            }
        });

        while (!operateStack.isEmpty()) {
            resultStack.add(operateStack.pop());
        }
        System.out.println("后续表达式：" + resultStack);
        return resultStack;
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
//        if (!infixExpressionStr.matches("^\\d+.*\\d$")) {
//            throw new RuntimeException("输入表达式不合法");
//        }
    }
}
