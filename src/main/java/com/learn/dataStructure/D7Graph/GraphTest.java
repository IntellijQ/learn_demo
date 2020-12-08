package com.learn.dataStructure.D7Graph;

import java.util.List;

/**
 * @author yds
 * @title: GraphTest
 * @description: 图
 * 使用场合多对多
 * 1.线性表：仅局限于一个前驱和后继
 * 2.树：虽然可以有多个子节点，但该节点只能有一个（零个）父节点
 * @date 2020/12/1 18:10
 */
public class GraphTest {
    public static void main(String[] args) {
        String[] data = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(data.length);
        for (int i = 0; i < data.length; i++) {
            // 添加顶点
            graph.addVertex(data[i]);
        }

        // 添加边 1=表示有关联
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 4, 1);

        // 显示邻接矩阵
        graph.showGraph();

        List<String> path2 = graph.dfsVertex();
        System.out.println("深度优先：" + path2);

        List<String> path = graph.bfsVertex(0);
        System.out.println("广度优先：" + path);
    }
}

///**
// * 顶点
// */
//@Data
//class Vertex {
//    private int no;
//    private String info;
//}

///**
// * 边
// */
//@Data
//class Edge{
//    private int startNo;
//    private int endNo;
//    private int weight;
//}

//
//    Edge edge = new Edge();
//        edge.setStartNo(startNo);
//                edge.setEndNo(endNo);
//                edge.setWeight(weight);
//                edges[startNo][endNo] = edge;
//
//                Edge edge2 = new Edge();
//                edge2.setStartNo(endNo);
//                edge2.setEndNo(startNo);
//                edge2.setWeight(weight);
//                edges[endNo][startNo] = edge2;