package com.learn.dataStructure.D8Algorithm.A3GreedyAlgorithm;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yds
 * @title: PackPart
 * @description:
 *
 * 部分背包问题
 *
 * 在从零开始学动态规划中我们已经谈过三种最基本的背包问题：
 * 零一背包，部分背包，完全背包。
 * 很容易证明，背包问题不能使用贪心算法。
 * 然而我们考虑这样一种背包问题：在选择物品i装入背包时，可以选择物品的一部分，
 * 而不一定要全部装入背包。这时便可以使用贪心算法求解了。
 * 计算每种物品的单位重量价值作为贪心选择的依据指标，选择单位重量价值最高的物品，将
 * 尽可能多的该物品装入背包，依此策略一直地进行下去，直到背包装满为止。
 *
 * 在零一背包问题中贪心选择之所以不能得到最优解原因是贪心选择无法保证最终能将背包装满，部分闲置的背包空间使每公斤背包空间的价值降低了。
 * 在程序中已经事先将单位重量价值按照从大到小的顺序排好。
 * @date 2020/11/30 16:04
 */
public class PackPart {

    public static void main(String[] args) {
        List<Pack> allPackList = inint();

        int maxWeight = 50;
        List<Pack> selectedPackList = greedyPack(maxWeight, allPackList);
        System.out.println(selectedPackList);

    }

    private static List<Pack> greedyPack(int maxWeight, List<Pack> allPackList) {
        Collections.sort(allPackList);
        System.out.println(allPackList);


        List<Pack> selectedPackList = new ArrayList<>();
        int selectedIndex = 0;
        while (selectedIndex < allPackList.size()){
            Pack selectedPack = allPackList.get(selectedIndex);
            if(selectedPack.getWeight() > maxWeight){
                break;
            }

            maxWeight = maxWeight - selectedPack.getWeight();
            selectedPackList.add(selectedPack);
            selectedIndex ++;
        }

        return selectedPackList;

    }

    private static List<Pack> inint() {
        List<Pack> allPackList = new ArrayList<>();
        Pack pack = new Pack();
        pack.setName("音响");
        pack.setWeight(30);
        pack.setValue(3000);
        allPackList.add(pack);

        pack = new Pack();
        pack.setName("电脑");
        pack.setWeight(20);
        pack.setValue(2000);
        allPackList.add(pack);

        pack = new Pack();
        pack.setName("吉他");
        pack.setWeight(15);
        pack.setValue(1500);
        allPackList.add(pack);

        return allPackList;
    }

    @Data
    public static class Pack implements Comparable<Pack>{
        private String name;
        private int weight;
        private int value;

        @Override
        public int compareTo(Pack o) {
            return o.value- o.weight - this.value / this.weight;// 按照单位重量价值降序排序
        }
    }
}
