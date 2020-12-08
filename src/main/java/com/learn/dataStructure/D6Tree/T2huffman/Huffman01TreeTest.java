package com.learn.dataStructure.D6Tree.T2huffman;

import com.learn.dataStructure.D6Tree.T1binaryTree.BinaryTree;
import com.learn.dataStructure.D6Tree.T1binaryTree.BNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yds
 * @title: Huffman
 * @description: 哈夫曼树测试案例
 * @date 2020/11/17 16:40
 */
public class Huffman01TreeTest {
    public static void main(String[] args) {
        // 哈夫曼树生成测试
        int[] array = {4, 1, 6, 2};
        ArrayList<BNode> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            BNode node = new BNode();
            node.setE(Byte.valueOf(array[i] + ""));
            node.setWeight(array[i]);
            list.add(node);
        }


        Huffman01Tree huffman01Tree = new Huffman01Tree(list);
        BNode root = huffman01Tree.getRoot();
        BinaryTree binaryTree = new BinaryTree<>();
        List<BNode> BNodes = binaryTree.infixListStack(root);
        System.out.println("哈夫曼树：" + BNodes);
        Map treePathMap = binaryTree.binaryTreePath(root);
        System.out.println("哈夫曼树叶子节点路径：" + treePathMap);

        Map binaryTreePath = binaryTree.binaryTreePath(root);
        System.out.println("哈夫曼树叶子节点二进制路径：" + binaryTreePath);
    }

}
