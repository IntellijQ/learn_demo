package com.learn.dataStructure.D8Algorithm.A4MinTree;

import com.learn.dataStructure.D7Graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yds
 * @title: KruskalAlgorithm
 * @description: 克鲁斯卡尔算法
 * @date 2020/12/8 15:35
 */
public class KruskalAlgorithm {
    final int MIN = 10000;


    public static void main(String[] args) {
        String[] vertexes = {"A","B","C","D","E","F","G"};
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};
        Graph graph = new Graph(Arrays.asList(vertexes),weight);
        graph.showGraph();

        new KruskalAlgorithm().kruskal(graph, 0);
    }


//    算法如下：
    // 基本思想：按照权值从小到大 选择n-1条边，并保证这n-1条边不构成回路，组成最小生成树
    //1.构造一个含n个顶点的森林
    //2.按照权值将边从小到大加入森林中，并不形成回路，直至森林变成一棵树为止
    public void kruskal(Graph graph, int index){

    }
}
