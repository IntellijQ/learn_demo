package com.learn.dataStructure.D6Tree.T2huffman;

import com.learn.dataStructure.D6Tree.T1binaryTree.BNode;
import com.learn.dataStructure.D6Tree.T1binaryTree.BinaryTree;

import java.util.Collections;
import java.util.List;

/**
 * @author yds
 * @title: Huffman
 * @description: 哈夫曼树测试案例
 * @date 2020/11/17 16:40
 */
public class Huffman01Tree<E> extends BinaryTree<E> {
    public Huffman01Tree() {
    }

    public Huffman01Tree(List<BNode<E>> list) {
        createHuffmanTree(list);
        this.setRoot(list.get(0));
    }

    public void createHuffmanTree(List<BNode<E>> list) {
        Collections.sort(list);
        while (list.size() > 1) {
            BNode left = list.get(0);
            BNode right = list.get(1);
            int i = left.getWeight() + right.getWeight();
            BNode root = new BNode(i, i, left, right);
            list.remove(left);
            list.remove(right);
            list.add(root);
            Collections.sort(list);
        }
    }
}
