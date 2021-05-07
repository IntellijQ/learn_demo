package com.learn.dataStructure;

import java.util.Stack;

/**
 * @author yds
 * @title: CaluString
 * @description: TODO
 * @date 2021/4/14 17:25
 */
public class CalculateString {

//    ### 1. 机试题 (字符串算式计算)
//
//> 包含 数字 小数点 加减符 括号 (不可使用大数计算工具及句法解析工具)要求计算算式结果 以字符串打印
//
//    用例举例:
//    String formula = "1234567890 - (3.14159265358979323846 + 2.71828182845904523536) + (299792458 - (1.61803398875- 2))";

    // 不限编程语言(部分语言如python自身支持大数计算,不可直接使用，大数计算库如BigDecimal不可使用, 动态语言如eval方法不可使用) 实现下叙方法
//
    private final static String BRACKETS_STR = "()";
    private final static String OPERATOR_STR = "+-";
    private final static String NUM_STR = "0123456789.";


    public static void main(String[] args) {

//        changeOperate("-1", "-1", 0, "-");

        String formula = "1234567890 - (3.14159265358979323846 + 2.71828182845904523536) + (299792458 - (1.61803398875- 2))";
        String result = new CalculateString().calculate(formula);
        System.out.println("运算结果：" + result);

    }

    /**
     * 计算入口
     *
     * @param formula
     * @return
     */
    public String calculate(String formula) {
        // 空格处理
        formula = formula.replace(" ", "");

        // 计算逻辑开始
        Stack<String> operateStack = new Stack();
        Stack<String> numStack = new Stack();
        int i = 0;
        StringBuffer numer = new StringBuffer();
        while (i < formula.length()) {
            String c = String.valueOf(formula.charAt(i));

            // 数字
            if (isNumber(c)) {
                numer.append(c);
                if (i == formula.length() - 1) {
                    numStack.push(numer.toString());
                    numer = new StringBuffer();
                }

                // 非数字
            } else {
                if (numer.toString().length() != 0) {
                    numStack.push(numer.toString());
                    numer = new StringBuffer();
                }

                // 左括号时，直接放入符号栈
                if ("(".equals(c)) {
                    operateStack.push(c);

                    // 操作符放入符号栈
                } else if (OPERATOR_STR.contains(c)) {
                    // 查看栈顶 是否 存在左括号，如果存在，则需进行计算
                    if (!operateStack.isEmpty() && !"(".equals(operateStack.peek())) {
                        switchOperate(operateStack, numStack);
                    }
                    operateStack.push(c);

                    // 右括号时，需要进行计算
                } else if (")".equals(c)) {
                    while (!operateStack.isEmpty()) {
                        if (!"(".equals(operateStack.peek())) {
                            switchOperate(operateStack, numStack);
                        } else {
                            operateStack.pop();
                        }
                    }
                }
            }
            i++;
        }

        // 运算符栈不为空，需继续进行运算
        while (!operateStack.isEmpty()) {
            if (!"(".equals(operateStack.peek())) {
                switchOperate(operateStack, numStack);
            } else {
                operateStack.pop();
            }
        }

        // 计算逻辑结果
        return numStack.pop();
    }


    /**
     * 目前仅支持 加减法操作
     *
     * @param operateStack
     * @param numStack
     * @return
     */
    private static void switchOperate(Stack<String> operateStack, Stack<String> numStack) {
        String a = numStack.pop();
        String opreate = operateStack.pop();
        String b = numStack.pop();
        if ("-".equals(opreate)) { // 减法运算
            numStack.push(changeOperate(b, a, -1, opreate));
        } else if ("+".equals(opreate)) { // 加法运算
            numStack.push(changeOperate(a, b, -1, opreate));
        }
    }

    /**
     * @param a
     * @param b
     * @param opreate
     */
    private static String doCalculate(String a, String b, int xxx, String opreate) {
        StringBuffer resultPoint = new StringBuffer("");
        // 计算小数部分
        Integer upNum = doCalculateOfPoint(a, b, resultPoint, opreate);// 进位数据
        // 计算整数部分
        String resultPre = doCalculateOfPre(a, b, upNum, opreate);

        StringBuffer resultSb = new StringBuffer("");
        resultSb.append(resultPre);
        if(resultPoint.length() != 0){
            resultSb.append(".");
            resultSb.append(resultPoint);
        }
        return resultSb.toString();
    }


    /**
     * 小数计算
     *
     * @param a        减数
     * @param b        被减数
     * @param resultSb
     * @param opreate
     * @return
     */
    public static int doCalculateOfPoint(String a, String b, StringBuffer resultSb, String opreate) {
        int upNum = 0;
        Stack<Integer> resultStack = new Stack();
        String[] splitArrayA = a.split("\\.");
        String[] splitArrayB = b.split("\\.");

        String pointA = "";
        String pointB = "";
        if (splitArrayA.length == 2) {
            pointA = splitArrayA[1];
        }
        if (splitArrayB.length == 2) {
            pointB = splitArrayB[1];
        }
        if(pointA.length() == 0 && pointB.length() == 0){
            return 0;
        }

        int palen = pointA.length();
        int pblen = pointB.length();
        int maxpLen = Math.max(palen, pblen);
        for (int i = maxpLen - 1; i >= 0; i--) {
            int tempa = 0;
            int tempb = 0;
            if (i < palen) {
                tempa = Integer.parseInt(String.valueOf(pointA.charAt(i)));
            }
            if (i < pblen) {
                tempb = Integer.parseInt(String.valueOf(pointB.charAt(i)));
            }
            int currentNum = 0;
            if ("-".equals(opreate)) {
                if ((tempa + upNum) < tempb) {
                    currentNum = tempa + 10 + upNum- tempb;
                    upNum = -1;
                } else {
                    currentNum = tempa + upNum - tempb;
                    upNum = 0;
                }
            } else {
                int result = tempa + tempb + upNum;
                currentNum = result % 10;
                upNum = result / 10;
            }

            resultStack.push(currentNum);
        }
        while (!resultStack.isEmpty()) {
            resultSb.append(resultStack.pop());
        }
        System.out.println(a + opreate + b + "结果的小数:"+ resultSb.toString());
        return upNum;
    }


    /**
     * 改变操作符状态
     *
     * @param a
     * @param b
     * @param upNum
     * @param opreate
     * @return
     */
    public static String changeOperate(String a, String b, int upNum, String opreate) {
        String[] splitArrayA = a.split("\\.");
        String[] splitArrayB = b.split("\\.");
        String preA = splitArrayA[0];
        String preB = splitArrayB[0];

        if ("-".equals(opreate)) {

            // 全不是负数
            // 如 30.1 - 30.2
            // 如 30 -40
            // 如 30 -10
            // 如 30 -140
            // 如 30 -5
            if (!preA.contains("-") && !preB.contains("-")) {
                if (preA.length() == preB.length()) {
                    if(preA.equals(preB)){
                        if(splitArrayA[1].length() > 0 && splitArrayB[1].length() > 0
                                && Integer.parseInt(String.valueOf(splitArrayA[1].charAt(0))) < Integer.parseInt(String.valueOf(splitArrayB[1].charAt(0)))){
                            return "-" + doCalculate(b, a, upNum, "-");
                        }else {
                            return doCalculate(a, b, upNum, "-");
                        }
                    }
                    if (Integer.parseInt(preA) < Integer.parseInt(preB)) {
                        return "-" + doCalculate(b, a, upNum, "-");
                    } else {
                        return doCalculate(a, b, upNum, "-");
                    }
                }
                if (preA.length() < preB.length()) {
                    return "-" + doCalculate(b, a, upNum, "-");
                }
                if (preA.length() > preB.length()) {
                    return doCalculate(a, b, upNum, "-");
                }
            }


            // 如 30-(-110)=30+110=140
            if (!preA.contains("-") && preB.contains("-")) {
                b = b.replace("-", "");
                return doCalculate(b, a, upNum, "+");
            }


            // 如-30-10=-(30+10)
            if (preA.contains("-") && !preB.contains("-")) {
                a = a.replace("-", "");
                return "-" + doCalculate(a, b, upNum, "+");
            }

            // 如-30-(-40)=40-10
            // 如-30-(-10)=-(30-10)
            // 如-30-(-110)=110-30
            // 如-30-(-5)=-(30-5)
            if (preA.contains("-") && preB.contains("-")) {
                preA = preA.replace("-", "");
                preB = preB.replace("-", "");
                a = a.replace("-", "");
                b = b.replace("-", "");
                if (preA.length() == preB.length()) {
                    if (Integer.parseInt(preA) < Integer.parseInt(preB)) {
                        return doCalculate(b, a, upNum, "-");
                    } else {
                        return "-" + doCalculate(a, b, upNum, "-");
                    }
                }
                if (preA.length() < preB.length()) {
                    return doCalculate(b, a, upNum, "-");
                }
                if (preA.length() > preB.length()) {
                    return "-" + doCalculate(a, b, upNum, "+");
                }
            }
        } else {// 加法时
            // 如 10+1000
            // 加法 两数全不为负数
            if (!preA.contains("-") && !preB.contains("-")) {
                return doCalculate(a, b, upNum, "+");
            }

            // 如 20 + -40
            // 如 20 + -10
            // 如 20 + -110
            // 如 20 + -5
            if (!preA.contains("-") && preB.contains("-")) {
                preB = preB.replace("-", "");
                b = b.replace("-", "");
                if (preA.length() == preB.length()) {
                    if (Integer.parseInt(preA) < Integer.parseInt(preB)) {
                        return "-" + doCalculate(b, a, upNum, "-");
                    } else {
                        return doCalculate(a, b, upNum, "-");
                    }
                }
                if (preA.length() < preB.length()) {
                    return "-" + doCalculate(b, a, upNum, "-");

                }
                if (preA.length() < preB.length()) {
                    return doCalculate(a, b, upNum, "-");
                }
            }

            // 如 -20 + 40
            // 如 -20 + 10
            // 如 -20 + 110
            // 如 -110 + 20
            if (preA.contains("-") && !preB.contains("-")) {
                preA = preA.replace("-", "");
                a = a.replace("-", "");
                if (preA.length() == preB.length()) {
                    if (Integer.parseInt(preA) < Integer.parseInt(preB)) {
                        return doCalculate(b, a, upNum, "-");
                    } else {
                        return "-" + doCalculate(a, b, upNum, "-");
                    }
                }
                if (preA.length() < preB.length()) {
                    return doCalculate(b, a, upNum, "-");
                }
                if (preA.length() > preB.length()) {
                    return "-" + doCalculate(a, b, upNum, "-");
                }

            }
        }
        return "";
    }


    /**
     * 整数计算
     *
     * @param a
     * @param b
     * @param upNum
     * @param opreate
     * @return
     */
    public static String doCalculateOfPre(String a, String b, int upNum, String opreate) {
        Stack<Integer> resultStack = new Stack();
        String[] splitArrayA = a.split("\\.");
        String[] splitArrayB = b.split("\\.");
        String preA = splitArrayA[0];
        String preB = splitArrayB[0];

        int alen = preA.length();
        int blen = preB.length();
        int maxLen = Math.max(alen, blen);
        for (int i = 0; i < maxLen; i++) {
            int tempa = 0;
            int tempb = 0;
            // 字符串a 位长可进行计算
            if (alen - i - 1 >= 0) {
                tempa = Integer.parseInt(String.valueOf(preA.charAt(alen - i - 1)));
            }

            // 字符串b 位长可进行计算
            if (blen - i - 1 >= 0) {
                tempb = Integer.parseInt(String.valueOf(preB.charAt(blen - i - 1)));

            }

            int currentNum = 0;
            if ("-".equals(opreate)) {
                if ((tempa + upNum) < tempb) {
                    currentNum = tempa + 10 + upNum - tempb;
                    upNum = -1;
                } else {
                    currentNum = tempa + upNum - tempb;
                    upNum = 0;
                }
            } else {
                int result = tempa + tempb + upNum;
                currentNum = result % 10;
                upNum = result / 10;
            }
            resultStack.push(currentNum);
        }

        if(upNum > 0){
            resultStack.push(upNum);
        }
        StringBuffer resultSb = new StringBuffer("");
        while (!resultStack.isEmpty()) {
            resultSb.append(resultStack.pop());
        }
        String result = resultSb.toString();
        if (result.length() > 1 && "0".equals(String.valueOf(result.charAt(0)))) {
            result = result.substring(1);
        }
        System.out.println(a + opreate + b + "结果的整数:"+ result);
        return result;
    }


    /**
     * 判断是否合法数据
     *
     * @param c
     * @return
     */
    private static boolean isNumber(String c) {
        // 数字
        if (NUM_STR.contains(c)) {
            return true;
        }
        // 有效的操作符
        if (OPERATOR_STR.contains(c) || BRACKETS_STR.contains(c)) {
            return false;
        }

        throw new RuntimeException("不合法的操作符，请检查后重新输入");
    }
}
