package pick;

import java.util.Arrays;

/**
 * @author yds
 * @title: StringParttenTest
 * @description: 字符串匹配
 * @date 2020/8/29 10:21
 */
public class StringParttenTest {
    public static void main(String[] args) {

        String[] target = {"A", "B", "A", "B", "A", "B", "A", "B", "C", "A", "B", "A", "A",
                           "B","A", "B", "A", "B", "A", "B", "A", "B", "C", "A", "B", "A", "A", "B"};
        String[] pattern = {"A", "B", "A", "B", "C", "A", "B", "A", "A"};

        kmpParten(target, pattern);
    }


    public static int samplePartten(String[] target, String[] pattern) {
        int targetNext = 0;
        int patternNext = 0;
        int okIndex = 0;
        int targetLength = target.length;
        int patternLength = pattern.length;
        while (targetNext < targetLength) {
            if (pattern[patternNext].equals(target[targetNext])) {
                System.out.println("匹配到target[" + targetNext + "] = " + "pattern[" + patternNext + "]");
                patternNext++;
            } else {
                System.out.println("未匹配到target[" + targetNext + "] = " + "pattern[" + patternNext + "],从pattern 的0 开始");
                patternNext = 0;
                okIndex = targetNext + 1;
            }
            targetNext++;

            if (patternNext == patternLength) {
                return okIndex;
            }
        }
        return 0;
    }


    public static int kmpParten(String[] target, String[] pattern) {
        int[] preTable = nextTable(pattern);
        int tlen = target.length;
        int pten = preTable.length;

        int ti = 0;
        int pi = 0;
        while (ti < tlen) {
            if (pattern[pi] == target[ti]) {
                if (pi == pten - 1) {
                    System.out.println("找到了" + ti );
                    System.out.println("找到了" + pi );
                    System.out.println("找到了!!!!" + (ti - pi) );
                    pi = preTable[pi];
                    return ti - pi;
                }
                pi++;
                ti++;
            } else {
                pi = preTable[pi];
                if(pi == -1){
                    pi++;
                    ti++;
                }
            }
        }

        return 0;
    }


    public static int[] nextTable(String[] pattern) {
        if (pattern.length == 0) {
            return null;
        }
        int[] prefix = new int[pattern.length];
        prefix[0] = 0;

        int len = 0;//用来标记当前字符串的 前后缀最大公共长度
        int i = 1;
        while (i < pattern.length) {
            // 将当前字符 与 匹配表位置的字符 做比较，如果相同则 公共长度加1，同时进行下一个字符的比较
            if (pattern[i] == pattern[len]) {
                len++;
            } else if (len - 1 >= 0) {
                len = prefix[len - 1];
            } else {
                len = 0;
            }

            prefix[i] = len;
            i++;
        }
        System.out.println(Arrays.toString(prefix));
        return moveNextTable(prefix);
    }

    private static int[] moveNextTable(int[] prefix) {
        for (int i = prefix.length - 1; i > 0; i--) {
            prefix[i] = prefix[i - 1];
        }
        prefix[0] = -1;
        System.out.println(Arrays.toString(prefix));
        return prefix;
    }
}
