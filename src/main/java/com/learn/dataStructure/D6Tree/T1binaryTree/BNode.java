package com.learn.dataStructure.D6Tree.T1binaryTree;

import lombok.Data;

/**
 * @author yds
 * @title: TreeNode
 * @description: 二叉树结点
 * @date 2020/11/17 16:41
 */
@Data
public class BNode<E> implements Comparable<BNode<E>>{
    private E e;
    private Integer weight; //权值 用来判断存放位置 左边还是右 还是 是否发生旋转
    private BNode left;
    private BNode right;

    public BNode() {
    }

    public BNode(E e, Integer weight) {
        this.e = e;
        this.weight = weight;
    }

    public BNode(E e, Integer weight, BNode left, BNode right) {
        this.e = e;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "HNode{" +
                "e=" + e +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(BNode o) {
        return this.getWeight() - o.getWeight();
    }
}
