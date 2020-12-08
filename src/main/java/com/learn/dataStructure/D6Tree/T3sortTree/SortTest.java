package com.learn.dataStructure.D6Tree.T3sortTree;

import com.learn.dataStructure.D6Tree.T1binaryTree.BNode;

/**
 * @author yds
 * @title: SortTest
 * @description: 二叉排序树测试
 * @date 2020/11/20 17:46
 */
public class SortTest {
    public static void main(String[] args) {
        SortTree<Integer> sortTree = new SortTree();

        BNode<Integer> integerBNode = new BNode<>();
        integerBNode.setWeight(10);
        sortTree.add(integerBNode);

        BNode<Integer> integerBNode2 = new BNode<>();
        integerBNode2.setWeight(5);
        sortTree.add(integerBNode2);

        BNode<Integer> integerBNode4 = new BNode<>();
        integerBNode4.setWeight(15);
        sortTree.add(integerBNode4);

        BNode<Integer> integerBNode5 = new BNode<>();
        integerBNode5.setWeight(4);
        sortTree.add(integerBNode5);

        BNode<Integer> integerBNode6 = new BNode<>();
        integerBNode6.setWeight(13);
        sortTree.add(integerBNode6);

        BNode<Integer> integerBNode7 = new BNode<>();
        integerBNode7.setWeight(14);
        sortTree.add(integerBNode7);

        BNode<Integer> integerBNode8 = new BNode<>();
        integerBNode8.setWeight(8);
        sortTree.add(integerBNode8);

        BNode<Integer> integerBNode3 = new BNode<>();
        integerBNode3.setWeight(7);
        sortTree.add(integerBNode3);

        BNode<Integer> integerBNode10 = new BNode<>();
        integerBNode10.setWeight(9);
        sortTree.add(integerBNode10);

        BNode<Integer> integerBNode9 = new BNode<>();
        integerBNode9.setWeight(19);
        sortTree.add(integerBNode9);

        System.out.println(sortTree.infixListStack(sortTree.getRoot()));

        sortTree.deleteNode(5);
        System.out.println(sortTree.infixListStack(sortTree.getRoot()));
    }
}
