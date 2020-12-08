package com.learn.dataStructure.D8Algorithm.A3GreedyAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yds
 * @title: PayMoney
 * @description: 钱币找零问题
 * <p>
 * 这个问题在我们的日常生活中就更加普遍了。
 * 假设1元、2元、5元、10元、20元、50元、100元的纸币分别有c0, c1, c2, c3, c4, c5, c6张。
 * 现在要用这些钱来找零K元，至少要用多少张纸币？
 * 用贪心算法的思想，很显然，每一步尽可能用面值大的纸币即可。在日常生活中我们自然而然也是这么做的。在程序中已经事先将Value按照从小到大的顺序排好。
 * @date 2020/11/30 16:56
 */
public class PayMoney {
    public static void main(String[] args) {
        int[] count = {3, 0, 2, 1, 0, 3, 5};
        int[] value = {1, 2, 5, 10, 20, 50, 100};

        Map<String,Integer> pay = solve(76, count, value);
    }

    private static Map<String,Integer> solve(int money, int[] count, int[] value) {
        Map<String,Integer> payMap = new HashMap<>();
        for (int i = value.length - 1; i >= 0; i--) {
            if (money <= 0) {
                break;
            }
            int currentValue = value[i];// 当前最大面值
            int cuurentCount = count[i];// 该面值对应的个数

            int shouldCount = Integer.min(money / currentValue, cuurentCount);
            if (shouldCount > 0) {// 被选中的纸币面额
                money = money - shouldCount * currentValue;
                payMap.put(currentValue + "", shouldCount);
            }
        }

        System.out.println(payMap);

        if(money > 0){
            throw new RuntimeException("老板零钱不够了，还需零钱：" + money);
        }
        return payMap;

    }
}
