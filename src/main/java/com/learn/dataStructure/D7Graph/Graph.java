package com.learn.dataStructure.D7Graph;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yds
 * @title: Graph
 * @description: 图
 * @date 2020/12/8 15:36
 */
@Data
public class Graph {
    private Integer numVertexes;// 顶点数
    private List<String> vertexes;// 顶点信息
    private int numEdges;// 边数
    private int[][] edges;// 邻接矩阵信息

    public Graph(Integer numVertexes) {
        this.numVertexes = numVertexes;
        this.edges = new int[numVertexes][numVertexes];
        this.vertexes = new ArrayList<>();
    }

    public Graph(List<String> vertexes, int[][] edges) {
        this.vertexes = vertexes;
        this.numVertexes = vertexes.size();
        this.edges = edges;
        this.numEdges = edges.length;
    }

    // 增加结点
    public void addVertex(String vertex) {
        vertexes.add(vertex);
    }

    // 增加边
    public void addEdge(int startNo, int endNo, int weight) {
        edges[startNo][endNo] = weight;
        edges[endNo][startNo] = weight;
        numEdges++;
    }

    // 获取两个指定顶点组成的边的权
    public int getEdgeWeightByVertexIndex(int startIndex, int endIndex) {
        return edges[startIndex][endIndex];
    }

    // 获取第I个结点
    public String getVertexValueByIndex(int index) {
        return vertexes.get(index);
    }

    // 展示邻接矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


    // 获取指点顶点v的第一个邻接结点
    public int getFirstNeighbor(int v) {
        int[] edgeRow = edges[v];
        for (int i = v + 1; i < edgeRow.length; i++) {
            System.out.println(" 查看v=" + v + "-" + getVertexValueByIndex(v) + "结点的第一个邻接结点：edgeRow[" + i + "]=" + getVertexValueByIndex(i) + "，是否关联=" + edgeRow[i]);
            if (edgeRow[i] > 0) {
                return i;
            }
        }
        System.out.println(" 无法查找到v=" + v + "的第一个邻接结点");
        return -1;
    }

    // 获取顶点V在顶点W之后的下一个邻接结点
    public int getNextNeighborByVertexIndex(int v, int w) {
        int[] edgeRow = edges[v];
        for (int i = w + 1; i < edgeRow.length; i++) {
            System.out.println(" 查看v=" + v + "-" + getVertexValueByIndex(v) + "结点" + w + "之后的下一个邻接结点：edgeRow[" + i + "]=" + getVertexValueByIndex(i) + "，是否关联=" + edgeRow[i]);
            if (edgeRow[i] > 0) {
                return i;
            }
        }

        System.out.println(" 无法查找到v=" + v + "在w=" + w + "之后的下一个邻接结点");
        return -1;
    }

    public List<String> dfsVertex() {
        List<String> path = new ArrayList<>();
        boolean[] isVisited = new boolean[numVertexes];
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                dfsVertex(i, isVisited, path);
            }
        }
        return path;
    }

    // 图的深度优先搜索：从初始访问结点出发，初始访问结点可能有多个邻接结点，
    // 深度优先遍历的策略就是首先访问第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点
    // 递归实现步骤：
    // 1.访问初始结点V，并标记结点V已被访问
    // 2.查找结点V的第一个邻接点W
    // 3.如果W不存在，则回到第一步，将从V的下一个结点继续
    //   如果W存在，则继续执行4，
    // 4.若W未被访问，对W进行深度优先遍历递归（即把W当作另外一个V，然后进行步骤123）
    // 5.若W被访问，查找结点V的W邻接结点的下一个邻接结点，转到步骤3
    private void dfsVertex(int index, boolean[] isVisited, List<String> path) {
        isVisited[index] = true;
        path.add(getVertexValueByIndex(index));

        int firstNeighbor = getFirstNeighbor(index);


        while (firstNeighbor != -1) {
            System.out.println("，isVisited[" + firstNeighbor + "]=" + isVisited[firstNeighbor]);
            if (!isVisited[firstNeighbor]) {
                dfsVertex(firstNeighbor, isVisited, path);
            } else {
                firstNeighbor = getNextNeighborByVertexIndex(index, firstNeighbor);
            }
        }
    }


    // 广度优先搜索：类似一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点
    // 算法步骤：
    // 1.访问初始结点V并标记结点V为已访问
    // 2.结点V入队列
    // 3.当队列为空时，结束
    //   当队列非空时，继续执行
    //4.出队列，取得对头结点U
    //5.查找结点U的第一个邻接结点W
    //6.若结点U的邻接结点W不存在，则跳转到步骤3
    //  若结点W存在，则执行以下步骤
    //6.1.若结点W尚未被访问，则访问结点并标记已访问
    //  6.1.1.结点W入队列
    //6.2.若查找结点U的继W邻接结点后的下一个邻接结点W，转到步骤6
    public List<String> bfsVertex(int index) {
        List<String> path = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[numVertexes];

        // 标记已访问
        isVisited[index] = true;
        path.add(getVertexValueByIndex(index));
        // 入队列
        queue.addLast(index);
        while (!queue.isEmpty()) {
            // 队列头数据u
            int u = queue.removeFirst();
            // u的邻接结点w
            int w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {// 如果未访问过，则进行标记，同时入队列
                    isVisited[w] = true;
                    path.add(getVertexValueByIndex(w));
                    queue.addLast(w);
                }
                // 继续获取w之后的邻接结点
                w = getNextNeighborByVertexIndex(u, w);
            }
        }
        return path;
    }
}
