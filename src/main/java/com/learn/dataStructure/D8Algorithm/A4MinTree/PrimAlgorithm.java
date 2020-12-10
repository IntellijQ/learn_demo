package com.learn.dataStructure.D8Algorithm.A4MinTree;

import com.learn.dataStructure.D7Graph.Graph;
import lombok.Data;

import java.util.*;

/**
 * @author yds
 * @title: PrimAlgorithm
 * @description: 普里姆算法
 * @date 2020/12/8 15:35
 */
public class PrimAlgorithm {
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
                {2, 3, 10000, 10000, 4, 6, 10000}};
        Graph graph = new Graph(Arrays.asList(vertexes), matrix);
        graph.showGraph();

//        List<Integer> path = new PrimAlgorithm().prim(graph, 0);
//        System.out.println(path);
//        for (int i = 0; i < path.size(); i++) {
//            System.out.print(graph.getVertexValueByIndex(path.get(i)));
//            if (i < path.size() - 1){
//                System.out.print("==>");
//            }
//        }

        new PrimAlgorithm().prim(graph, 0);
        new PrimAlgorithm().prim2(graph, 0);
    }


    //    算法如下：
//    设 G=(V,E) 是连通图，T=(U,D)是最小生成树，V,U是顶点集合， E,D是边的集合
//    若从顶点 u开始构造最小生成树，则从集合 V 中取出顶点u 放入集合U中，标记顶点v的 visited[u] = 1
//    若集合 U 中顶点 ui与集合 V-U 中的顶点 vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路，将顶点 vj 加入到集合 U 中，将边 (ui,vj) 加入集合 D 中，标记 visited[vj]=1
//    重复步骤2，直到 U、V相等，即所有顶点都被标记为访问过，此时 D 有 n-1条边
    public MinTree prim(Graph graph, int index) {
        int[][] matrix = graph.getMatrix();
        List<Edge> path = new ArrayList<>();
        Integer numVertexes = graph.getNumVertexes();

        // 辅助数组，记录被访问的顶点
        boolean[] isVisited = new boolean[numVertexes];
        isVisited[index] = true;

        int minWeight = MAX;
        int minStartIndex = -1;
        int minEndIndex = -1;
        // 选最小生成树的边有n-1条
        int n = 1;
        while (n <= 6) {
            // 每找到一条权值最小的边，则已被访问的结点多一个
            for (int i = 0; i < numVertexes; i++) {
                if (isVisited[i]) {
                    for (int j = 0; j < numVertexes; j++) {
                        if (!isVisited[j] && matrix[i][j] < minWeight) {
                            minWeight = matrix[i][j];
                            minStartIndex = i;
                            minEndIndex = j;
                        }
                    }
                }
            }
            isVisited[minEndIndex] = true;

            Edge edge = new Edge();
            edge.startNo = minStartIndex;
            edge.endNo = minEndIndex;
            edge.weight = minWeight;
            path.add(edge);
            //重置最小值
            minWeight = MAX;
            n++;
        }

        MinTree minTree = new MinTree();
        minTree.setEdges(path);
        System.out.println("prim=" + minTree);
        return minTree;
    }


    //    1.1首先将初始化顶点u加入U中，对其余的每个顶点vi，经edge[i]初始化为到u的边的信息。
//    2、循环n-1次，做如下步骤：
//    2.1从各组边edge中选出最小边edge[k],输出此边，
//    2.2将k并入U中
//    2.3更新剩余的每组最小边信息closedge[j]，对于V-U中的边，新增加了一条从k到j的边，如果新边的权值比closedege[j].lowcost小，则将closedege[i].lowcost更新为新边的权值。
    public MinTree prim2(Graph graph, int u) {
        int[][] matrix = graph.getMatrix();
        // 如i=1，表示顶点为B，和startNo 的距离为weight
        Edge[] uvEdges = new Edge[graph.getNumVertexes()];
        for (int vi = 0; vi < graph.getNumVertexes(); vi++) {
            Edge edge = new Edge();
            edge.startNo = u;
            edge.weight = matrix[u][vi];
            uvEdges[vi] = edge;
        }

        // 将节点index放入到U中
        uvEdges[u].setWeight(0);

        List<Edge> path = new ArrayList<>();
        for (int i = 1; i < graph.getNumVertexes(); i++) {
            // 从各组边edge中选出最小边edge[k]
            u = getMinWeightNodeNoFromOther(uvEdges);
            Edge edge = uvEdges[u];

            // 输出此边
            Edge minTreeEdge = new Edge();
            minTreeEdge.startNo = edge.startNo;
            minTreeEdge.endNo = u;
            minTreeEdge.weight = edge.weight;
            path.add(minTreeEdge);

            // 将minWeightNodeNo加入到U中
            uvEdges[u].setWeight(0);
            // 更新当前U到V-U中顶点的距离
            // 信息辅助数组中存储的信息，由于此时树中新加入了一个顶点，
            // 需要判断，由此顶点出发，到达其它各顶点的权值是否比之前记录的权值还要小，如果还小，则更新
            for (int j = 0; j < uvEdges.length; j++) {
                if (matrix[u][j] < uvEdges[j].weight) {
                    uvEdges[j].weight = matrix[u][j];
                    uvEdges[j].startNo = u;
                }
            }
        }

        MinTree minTree = new MinTree();
        minTree.setEdges(path);
        System.out.println("prim2=" + minTree);
        return minTree;
    }


    public int getMinWeightNodeNoFromOther(Edge[] edges) {
        int minWeightNodeNo = -1;
        int minWeight = 10000;
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (edge.getWeight() != 0 && edge.getWeight() < minWeight) {
                minWeight = edge.getWeight();
                minWeightNodeNo = i;
            }
        }
        return minWeightNodeNo;
    }


    @Data
    public static class MinTree {
        List<Edge> edges;
    }

    @Data
    public static class Edge {
        int startNo;
        int endNo;
        int weight;
    }
}
