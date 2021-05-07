package pick;

import java.util.Stack;

/**
 * @author yds
 * @title: MySort
 * @description: TODO
 * @date 2021/4/26 18:02
 */
public class MyReback {

    public static void main(String[] args) {
        String inputStr = "abccde.de...";
        // 初始数据栈
        Stack<String> blockStack = new Stack<>();
        for (int i = 0; i < inputStr.length(); i++) {
            String current = String.valueOf(inputStr.charAt(i));
            blockStack.push(current);
        }

        // 反向输出数据
        StringBuffer resultBuffer = new StringBuffer();
        while (!blockStack.isEmpty()) {
            resultBuffer.append(blockStack.pop());
        }

        // 反转字符串
        String string = resultBuffer.toString();
        StringBuffer buffer = new StringBuffer();
        Stack<String> resultStack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            String item = String.valueOf(string.charAt(i));
            if(i == string.length() - 1){
                resultStack.push(item);
            }
            if (".".equals(item) || i == string.length() - 1) {
                while (!resultStack.isEmpty()) {
                    buffer.append(resultStack.pop());
                }
                if (i != string.length() - 1) {
                    buffer.append(".");
                }
            } else {
                resultStack.push(item);
            }
        }
        System.out.println(buffer.toString());
    }
}
