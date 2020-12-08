package com.learn.dataStructure.D6Tree.T1binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/11/12 14:40
 */
public class BinaryTreeTest {
    public static void main(String[] args) {

        List<BNode> list = new ArrayList<>();

        int[] array = {1, 2, 3, 4,5,6,7,8,9,10};
        for (int i = 0; i < array.length; i++) {
            BNode BNode = new BNode(array[i],array[i]);
            list.add(BNode);
        }

//        for (int i = 1; i <= 10; i++) {
//            Student student = new Student();
//            student.setId("ID" + i);
//            student.setUserName("name" + i);
//            student.setAge(i);
//            TNode root = new TNode();
//            root.setE(student);
//            root.setWeight(i);
//            list.add(root);
//        }

        // 初始化二叉树
        BinaryTree binaryTree = new BinaryTree(list);
        BNode root = binaryTree.getRoot().getRight().getLeft();
        System.out.println(root + "的父节点：" + binaryTree.getParent(root));

        // 获取二叉树叶子结点路径
        Map<Integer, List> treePathMap = binaryTree.binaryTreePath(binaryTree.getRoot());
        System.out.println("叶子结点路径：" + treePathMap);
        System.out.println();

        binaryTree.deleteNode(4);
        System.out.println();


//        List prefixList = binaryTree.prefixListStack(binaryTree.getRoot());
//        System.out.println("前栈：" + prefixList);
//        prefixList = new ArrayList();
//        binaryTree.prefixListRecursion(binaryTree.getRoot(), prefixList);
//        System.out.println("前递归：" + prefixList);
//        System.out.println();
//
//        List infixList = binaryTree.infixListStack(binaryTree.getRoot());
//        System.out.println("中栈：" + infixList);
//        infixList = new ArrayList();
//        binaryTree.infixListRecursion(binaryTree.getRoot(), infixList);
//        System.out.println("中递归：" + infixList);
//        System.out.println();
//
//        List sufixList = binaryTree.sufixListStack(binaryTree.getRoot());
//        System.out.println("后栈：" + sufixList);
//        sufixList = new ArrayList();
//        binaryTree.sufixListRecursion(binaryTree.getRoot(), sufixList);
//        System.out.println("后递归：" + sufixList);
//        System.out.println();
    }
}
