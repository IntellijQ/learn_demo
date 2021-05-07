package pick;

import java.util.Stack;

/**
 * @author yds
 * @title: pick.TestCallBackString
 * @description: TODO
 * @date 2021/4/16 20:27
 *
 *
 *
 *
 * 系统架构:
 *  springcloud
 *  mysql
 *  redis
 *  es 搜索
 *  分布式事务
 *  挑战: 避免重复,如何提升
 *       抽象
     *  区别互联网:
     *      数据相关的
 *   快速发展业务中: 业务日新月异,无法精准粒度
 *   
 */
public class TestCallBackString {

    public static void main(String[] args) {

        String info = "ABABBABA6666666666666666666666666666NNNNNNNNNNNNNNNNNNNN";

        // 1.for 遍历 info
        // 2.向两端扩散 1个 2...
        // 3.进行下一个
        String result = isCallBackString(info);
        System.out.println("回文最长:" + result);
    }

    /**
     * 判断是否回文
     *
     * @param info
     * @return
     */
    private static String isCallBackString(String info) {
        if(info.length() == 0){
            return "";
        }
        if(info.length() == 1){
            return info;
        }

        int length = info.length();
        int begin = 0;//回文开始位置
        int end = 0;//回文结束位置
        int resultLen = 0;//最长回文长度

        for (int i = 0; i < info.length(); i++) {
            int left = i - 1;
            int right = i + 1;

            // 向两边扩散
            while (left >= 0 && right < length
                    && String.valueOf(info.charAt(left)).equals(String.valueOf(info.charAt(right)))) {
                int currentLen = right - left + 1;
                if (currentLen > resultLen) {
                    resultLen = currentLen;
                    begin = left;
                    end = right;
                }
                left--;
                right++;
            }


            left = i;
            right = i + 1;
            // 进行下一个节点
            while (left >= 0 && right < length
                    && String.valueOf(info.charAt(left)).equals(String.valueOf(info.charAt(right)))) {
                int currentLen = right - left + 1;
                if (currentLen > resultLen) {
                    resultLen = currentLen;
                    begin = left;
                    end = right;
                }
                left--;
                right++;
            }
        }
        return info.substring(begin, end + 1);
    }
}
