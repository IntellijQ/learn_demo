package com.learn.dataStructure.D8Algorithm.A6ShortestPath;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: Dijkstra
 * @description: Dijkstra算法
 * @date 2020/12/10 11:29
 */
public class Dijkstra {

    final int MIN = 10000;


    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        Graph graph = dijkstra.createGraph();
        List<DijkstraResult> dijikstra = dijkstra.dijikstra(graph, 0);
        System.out.println(JSON.toJSONString(dijikstra));
    }

    public List<DijkstraResult> dijikstra(Graph graph, int index) {
        String[] vertexes = graph.vertexes;
        int[][] matrix = graph.matrix;
        Integer numVertexes = graph.numVertexes;
        // 标记是否访问过
        boolean[] isVisited = new boolean[numVertexes];

        // 各个顶点到指定V经过的路径
        int[] pathPre = new int[numVertexes];
        // 各个顶点到指定V的距离
        int[] pathWeightSum = new int[numVertexes];


        // 初始化各个顶点到指定V的信息
        for (int i = 0; i < numVertexes; i++) {
            pathPre[i] = index;
            pathWeightSum[i] = matrix[index][i];
        }


        // 设置指定V被访问
        isVisited[index] = true;

        int check = 0;
        while (check < numVertexes - 1) {
            // 获取最小路径信息
            int currentShortPathIndex = getShortPathIndex(pathWeightSum, isVisited);
            if (currentShortPathIndex == -1) {
                return resutlDijikstra(index, pathPre, pathWeightSum);
            }
            int currentShortPathWeightSum = pathWeightSum[currentShortPathIndex];
            System.out.println("当前最小路径下标：" + vertexes[currentShortPathIndex] + ",距离：" + currentShortPathWeightSum);


            // 设置最短路径结点被访问
            isVisited[currentShortPathIndex] = true;

            // 更新其他未被访问的结点 到指定结点的信息
            for (int i = 0; i < numVertexes; i++) {
                int newShortPathWeightSum = currentShortPathWeightSum + matrix[currentShortPathIndex][i];
                if (!isVisited[i] && newShortPathWeightSum < pathWeightSum[i]) {
                    System.out.print("当前结点为：" + vertexes[i] + ",原前置结点：" + vertexes[pathPre[i]] + ",原距离：" + pathWeightSum[i]);

                    pathPre[i] = currentShortPathIndex;
                    pathWeightSum[i] = newShortPathWeightSum;
                    System.out.println(",更新后前置结点为：" + vertexes[currentShortPathIndex] + ",新距离：" + newShortPathWeightSum);
                }
            }
            System.out.println();
            check++;
        }
        return null;
    }

    private List<DijkstraResult> resutlDijikstra(int index, int[] pathPre, int[] pathWeightSum) {
        List<DijkstraResult> restult = new ArrayList<>();
        for (int i = 0; i < pathWeightSum.length; i++) {
            if (i != index) {
                DijkstraResult dijkstraNode = new DijkstraResult();
                dijkstraNode.targetNo = i;
                dijkstraNode.targetInfo = "";
                dijkstraNode.weight = pathWeightSum[i];

                // 路径
                System.out.print("结点路径：" + i);
                int pre = i;
                while (pre != pathPre[pre] ){
                    pre = pathPre[pre];
                    System.out.print("<==" + pre);
                }
                restult.add(dijkstraNode);
                System.out.println();
            }
        }
        return restult;
    }

    private int getShortPathIndex(int[] pathWeightSum, boolean[] isVisited) {
        int minWeight = MIN;
        int minWeightIndex = -1;
        for (int i = 0; i < pathWeightSum.length; i++) {
            if (!isVisited[i] && pathWeightSum[i] < minWeight) {
                minWeight = pathWeightSum[i];
                minWeightIndex = i;
            }
        }
        return minWeightIndex;
    }

    public static class Graph {
        private Integer numVertexes;// 顶点数
        private String[] vertexes;// 顶点信息
        private int[][] matrix;// 邻接矩阵信息


    }

    public Graph createGraph() {
        Graph graph = new Graph();
        String[] vertexes = {"V0", "V1", "V2", "V3", "V4", "V5"};
        int[][] matrix = new int[][]{
                {10000, 10000, 10, 10000, 30, 100},
                {10000, 10000, 5, 10000, 10000, 10000},
                {10000, 10000, 10000, 50, 10000, 10000},
                {10000, 10000, 10000, 10000, 10000, 10},
                {10000, 10000, 10000, 20, 10000, 60},
                {10000, 10000, 10000, 10000, 10000, 10000},
        };
        graph.matrix = matrix;
        graph.numVertexes = vertexes.length;
        graph.vertexes = vertexes;
        return graph;
    }


    @Data
    public static class DijkstraResult{
        int weight;
        int targetNo;
        String targetInfo;
    }
}
