package com.learn.dataStructure.D8Algorithm.A6ShortestPath;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;

/**
 * @author yds
 * @title: Floyed
 * @description: 弗洛伊德算法
 * @date 2020/12/11 14:21
 */

//弗洛伊德的核心思想是：对于网中的任意两个顶点（例如顶点 A 到顶点 B）来说，之间的最短路径不外乎有 2 种情况：
//    1.直接从顶点 A 到顶点 B 的弧的权值为顶点 A 到顶点 B 的最短路径；
//    2.从顶点 A 开始，经过若干个顶点，最终达到顶点 B，期间经过的弧的权值和为顶点 A 到顶点 B 的最短路径。
//
//所以，弗洛伊德算法的核心为：对于从顶点 A 到顶点 B 的最短路径，拿出网中所有的顶点进行如下判断：
//    Dis（A，K）+ Dis（K，B）< Dis（A，B）
//    其中，K 表示网中所有的顶点；Dis（A，B） 表示顶点 A 到顶点 B 的距离。
//
//也就是说，拿出所有的顶点 K，判断经过顶点 K 是否存在一条可行路径比直达的路径的权值小，如果式子成立，说明确实存在一条权值更小的路径，此时只需要更新记录的权值和即可。
//
//任意的两个顶点全部做以上的判断，最终遍历完成后记录的最终的权值即为对应顶点之间的最短路径。
public class Floyed {

    public static void main(String[] args) {
        Floyed floyed = new Floyed();
        Graph graph = floyed.createGraph();
        floyed.Floyed(graph);
    }

    public void Floyed(Graph graph) {
        int[][] matrix = graph.getMatrix();
        Integer numVertexes = graph.getNumVertexes();
        String[] vertexes = graph.getVertexes();

        // 初始化两个顶点之间的前置顶点
        int[][] prePath = new int[numVertexes][numVertexes];
        for (int i = 0; i < numVertexes; i++) {
            for (int j = 0; j < numVertexes; j++) {
                prePath[i][j] = i;
            }
        }

//        for (int i = 0; i < numVertexes; i++) {
//            System.out.println(Arrays.toString(prePath[i]));
//        }
//        System.out.println();


//    0. Dis（A，K）+ Dis（K，B）< Dis（A，B）
//    1.直接从顶点 A 到顶点 B 的弧的权值为顶点 A 到顶点 B 的最短路径；
//    2.从顶点 A 开始，经过若干个顶点，最终达到顶点 B，期间经过的弧的权值和为顶点 A 到顶点 B 的最短路径。
        int c = 1;
        for (int k = 0; k < numVertexes; k++) {// 中间顶点
            for (int a = 0; a < numVertexes; a++) {// 开始顶点
                if (a == k) {
                    continue;
                }
                int weightA = matrix[a][k];
                for (int b = 0; b < numVertexes; b++) {// 结束顶点
                    if (b == k || b == a) {
                        continue;
                    }

                    int weightB = matrix[k][b];
                    int weightC = matrix[a][b];
                    c++;
                    if (weightA + weightB < weightC) {
                        matrix[a][b] = weightA + weightB;
//                        System.out.println("中间结点：" + k +  "，更新结点（" + a + "," + b + "),原长度：" + weightC + "，新长度：" + matrix[a][b]);
                        prePath[a][b] = prePath[k][b];
//                        System.out.println("["+a+"][" + b + "] 的前驱置为：" + prePath[a][b]);
                    }
                }
            }
        }




//        System.out.println();
//        for (int i = 0; i < numVertexes; i++) {
//            System.out.println(Arrays.toString(prePath[i]));
//        }
//        System.out.println();

        System.out.println();
        for (int i = 0; i < numVertexes; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
        System.out.println("共执行次数：" + c);
        Map<String, ArrayList<NodeResult>> floyedResult = new HashMap<>();
        ArrayList<NodeResult> nodeResultList = null;

        for (int i = 0; i < numVertexes; i++) {
            String reInfo = i + "";
            nodeResultList = new ArrayList<>();
            for (int j = 0; j < numVertexes; j++) {
                if (i == j) {
                    continue;
                }
                NodeResult nodeResult = new NodeResult();
                nodeResult.setFromNodeNo(i);
                nodeResult.setFromNodeDesc(vertexes[i]);
                nodeResult.setToNodeNo(j);
                nodeResult.setToNodeDesc(vertexes[j]);
                nodeResult.setPathDistance(matrix[i][j]);

                int[] pathArray = prePath[i];
                List<Integer> path = new ArrayList<>();
//                System.out.println(vertexes[i] + "到" + vertexes[j] + "的距离" + matrix[i][j]);
//                System.out.println("当前结点：" + j + "-" +vertexes[j] + "的父节点" + pathArray[j]);

                Stack<Integer> pathStack = new Stack<>();
                int preIndex = j;
                pathStack.push(j);
                while (preIndex != pathArray[preIndex]){
                    preIndex = pathArray[preIndex];
                    pathStack.push(preIndex);
                }

                while (!pathStack.isEmpty()){
                    path.add(pathStack.pop());
                }
                nodeResult.setPath(path);

                nodeResultList.add(nodeResult);
//                System.out.println();
            }
            if (nodeResultList.size() > 0) {
                floyedResult.put(reInfo, nodeResultList);
            }
        }

        System.out.println("弗洛伊德结果：" + JSON.toJSONString(floyedResult));
    }

    @Data
    public static class NodeResult {
        int fromNodeNo;
        String fromNodeDesc;
        int toNodeNo;
        String toNodeDesc;
        int pathDistance;
        List<Integer> path;
    }

    @Data
    public static class Graph {
        private Integer numVertexes;// 顶点数
        private String[] vertexes;// 顶点信息
        private int[][] matrix;// 邻接矩阵信息
    }

    public Graph createGraph() {
        Graph graph = new Graph();
        //无向图
//        String[] vertexes = {"A", "B", "C", "D", "E", "F","G"};
//        int[][] matrix = new int[][]{
//                {10000, 5, 7, 10000, 10000, 10000,2},
//                {5, 10000, 10000, 9, 10000, 10000,3},
//                {7, 10000, 10000, 10000, 8, 10000,10000},
//                {10000, 9, 10000, 10000, 10000, 10,10000},
//                {10000, 10000, 8, 10000, 10000, 5,4},
//                {10000, 10000, 10000, 10, 5, 10000,10000},
//                {2, 3, 10000, 10000, 4, 10000,10000},
//
//        };

        // 有向图
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


}
