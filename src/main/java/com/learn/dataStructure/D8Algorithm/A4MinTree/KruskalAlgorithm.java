package com.learn.dataStructure.D8Algorithm.A4MinTree;

import com.learn.dataStructure.D7Graph.Graph;

import java.util.Arrays;

/**
 * @author yds
 * @title: KruskalAlgorithm
 * @description: 克鲁斯卡尔算法
 * @date 2020/12/8 15:35
 */
public class KruskalAlgorithm {
    final int MAX = 10000;


    public static void main(String[] args) {
        String[] vertexes = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] matrix = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 10, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 10, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        Graph graph = new Graph(Arrays.asList(vertexes), matrix);
        graph.showGraph();

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        Graph.Edge[] kruskal = kruskalAlgorithm.kruskal(graph);
        System.out.println(Arrays.toString(kruskal));

    }


    //    算法如下：
    // 基本思想：按照权值从小到大 选择n-1条边，并保证这n-1条边不构成回路，组成最小生成树
    //1.构造一个含n个顶点的森林
    //2.按照权值将边从小到大加入森林中，并不形成回路，直至森林变成一棵树为止
    // 最重要的时如何判断 回路问题，涉及到 知识点 查并集
    public Graph.Edge[] kruskal(Graph graph) {
        // 边集合
        Graph.Edge[] edges = getEdges(graph);
        System.out.println("前：" + Arrays.toString(edges));

        // 排序
        sort(edges);
        System.out.println("后：" + Arrays.toString(edges));

        Integer numVertexes = graph.getNumVertexes();

        // 初始化各个顶点对应的头结点---默认自己
        int[] treeHead = new int[numVertexes];
        for (int i = 0; i < numVertexes; i++) {
            treeHead[i] = i;
        }

        // 最小生成树(n个顶点 n-1条边)
        Graph.Edge[] minTree = new Graph.Edge[numVertexes - 1];
        int minTreeIndex = 0;

        // 遍历数组生成最小树
        for (int i = 0; i < edges.length; i++) {
            Graph.Edge edge = edges[i];
            // 判断是否构成回路
            int startParent = findParent(treeHead, edge.getStartNo());
            int endParent = findParent(treeHead, edge.getEndNo());
            if(startParent != endParent){
                treeHead[endParent] = startParent;
                minTree[minTreeIndex] = edge;
                minTreeIndex++;
            }
        }
        return minTree;
    }

    // 查找结点父结点
    public int findParent(int[] treeHead, int index){
        int i = index;
        while (i != treeHead[i]){
            i = treeHead[i];
        }
        return i;
    }













    public Graph.Edge[] getEdges(Graph graph) {
        int edgeNum = 0;
        int[][] matrix = graph.getMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != MAX) {
                    edgeNum++;
                }
            }
        }

        int index = 0;
        Graph.Edge[] edges = new Graph.Edge[edgeNum];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != MAX) {
                    edges[index++] = new Graph.Edge(i, j, matrix[i][j]);
                }
            }
        }
        return edges;
    }


    // 升序
    public void sort(Graph.Edge[] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].getWeight() > edges[j + 1].getWeight()) {
                    Graph.Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

}