package com.learn.dataStructure.D8Algorithm.A4MinTree;

import com.learn.dataStructure.D7Graph.Graph;

import java.util.*;

/**
 * @author yds
 * @title: PrimAlgorithm
 * @description: 普里姆算法
 * @date 2020/12/8 15:35
 */
public class PrimAlgorithm {
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

        List<Integer> path = new PrimAlgorithm().prim(graph, 0);
        System.out.println(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(graph.getVertexValueByIndex(path.get(i)));
            if (i < path.size() - 1){
                System.out.print("==>");
            }
        }
    }


//    算法如下：
//    设 G=(V,E) 是连通图，T=(U,D)是最小生成树，V,U是顶点集合， E,D是边的集合
//    若从顶点 u开始构造最小生成树，则从集合 V 中取出顶点u 放入集合U中，标记顶点v的 visited[u] = 1
//    若集合 U 中顶点 ui与集合 V-U 中的顶点 vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路，将顶点 vj 加入到集合 U 中，将边 (ui,vj) 加入集合 D 中，标记 visited[vj]=1
//    重复步骤2，直到 U、V相等，即所有顶点都被标记为访问过，此时 D 有 n-1条边
    public List<Integer> prim(Graph graph, int index){
        List<Integer> path = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.getNumVertexes()];

        isVisited[index] = true;
        path.add(index);

        int[][] edges = graph.getEdges();
        int minWeight = MIN;
        int minStartIndex = -1;


        // 最小生成树的边有n-1条
        while (path.size() <= 6){
            System.out.println("该轮找最小权值开始");
            // 每找到一条权值最小的边，则已被访问的结点多一个
            for (int i = 0; i < graph.getNumVertexes(); i++) {
                if(isVisited[i]){
                    System.out.println("起点：" + graph.getVertexValueByIndex(i));
                    for (int j = 0; j < graph.getNumVertexes(); j++) {
                        if(!isVisited[j] && edges[i][j] < minWeight){
                            minWeight = edges[i][j];
                            minStartIndex = j;
                            System.out.println("比较结点：" + minStartIndex + "-" + graph.getVertexValueByIndex(minStartIndex) + "-" + minWeight);
                        }
                    }
                }
            }
            isVisited[minStartIndex] = true;
            path.add(minStartIndex);
            System.out.println("该轮找最小权值结束：" + minStartIndex + "-" + graph.getVertexValueByIndex(minStartIndex) + "-" + minWeight);
            //重置最小值
            minWeight = MIN;
            System.out.println("");
        }
        return path;
    }
}
