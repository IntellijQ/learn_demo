package com.learn.dataStructure.D8Algorithm.A5UnionFind;

import java.util.Arrays;

/**
 * @author yds
 * @title: UF
 * @description: Union-Find 算法
 * @date 2020/12/9 15:21
 */
public class UF {

    // 记录连通分量
    private int count;
    // 节点 x 的节点是 parent[x]
    private int[] parent;
    // 新增一个数组记录树的重量
    private int[] size;


    public UF(int count) {
        this.count = count;
    }


    public void union(int x, int y) {
        int x_root = findP(x);
        int y_root = findP(y);
        if(x_root == y_root){
            return;
        }

        // 将小树嫁接到大树下面，避免头重脚轻
        if(size[x_root] < size[y_root]){
            parent[x_root] = y_root;
            size[y_root] += size[x_root];
        }else {
            parent[y_root] = x_root;
            size[x_root] += size[y_root];
        }
        count--;
    }

    public int findP(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        int rootP = findP(p);
        int rootQ = findP(q);
        return rootP == rootQ;
    }

    public static void main(String[] args) {
        int num = 3;
        UF uf = new UF(num);
        uf.parent = new int[num];
        uf.size = new int[num];
        for (int i = 0; i < num; i++){
            uf.parent[i] = i;
            uf.size[i] = num;
        }


        // 0-1互为朋友
        // 1-2互为朋友
        // 传递性：0-2也是朋友 那么他们是一个朋友圈
        uf.union(0,1);
        uf.union(1,2);

//        uf.union(6,7);
//        uf.union(6,8);
//        uf.union(6,9);
//
//        uf.union(5,6);
//
//        uf.union(3,5);
//        uf.union(3,6);
//        uf.union(3,7);
//        uf.union(3,8);
//
//        uf.union(7,4);


        System.out.println(Arrays.toString(uf.parent));

        System.out.println(uf.count);
    }
}
