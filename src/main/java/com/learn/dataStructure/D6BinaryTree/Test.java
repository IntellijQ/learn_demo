package com.learn.dataStructure.D6BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/11/12 14:40
 */
public class Test {
    public static void main(String[] args) {
//        BinaryTree<Student> binaryTree = inintStudent();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree binaryTree = inintArrayTree(array);

        List prefixList = binaryTree.prefixListStack(binaryTree.getRoot());
        System.out.println("前栈：" + prefixList);
        prefixList = new ArrayList();
        binaryTree.prefixListRecursion(binaryTree.getRoot(), prefixList);
        System.out.println("前递归：" + prefixList);

        List infixList = binaryTree.infixListStack(binaryTree.getRoot());
        System.out.println("中栈：" + infixList);
        infixList = new ArrayList();
        binaryTree.infixListRecursion(binaryTree.getRoot(),infixList);
        System.out.println("中递归：" + infixList);

        List sufixList = binaryTree.sufixListStack((binaryTree.getRoot()));
        System.out.println("后栈：" + sufixList);
        sufixList = new ArrayList();
        binaryTree.sufixListRecursion(binaryTree.getRoot(), sufixList);
        System.out.println("后递归：" + sufixList);
    }

    public static BinaryTree<Student> inintStudent() {
        BinaryTree<Student> studentBinaryTree = new BinaryTree<>();
        Student student = new Student();
        student.setId("1");
        student.setUserName("1");
        student.setAge(1);
        BinaryTree.BNode root = new BinaryTree.BNode();
        root.setE(student);

        Student student2 = new Student();
        student2.setId("2");
        student2.setUserName("2");
        student2.setAge(2);
        BinaryTree.BNode node2 = new BinaryTree.BNode();
        node2.setE(student2);
        root.setLeft(node2);

        Student student3 = new Student();
        student3.setId("3");
        student3.setUserName("3");
        student3.setAge(3);
        BinaryTree.BNode node3 = new BinaryTree.BNode();
        node3.setE(student3);
        root.setRight(node3);

        Student student4 = new Student();
        student4.setId("4");
        student4.setUserName("4");
        student4.setAge(4);
        BinaryTree.BNode node4 = new BinaryTree.BNode();
        node4.setE(student4);
        node2.setLeft(node4);


        Student student5 = new Student();
        student5.setId("5");
        student5.setUserName("5");
        student5.setAge(5);
        BinaryTree.BNode node5 = new BinaryTree.BNode();
        node5.setE(student5);
        node2.setRight(node5);

        studentBinaryTree.setRoot(root);
        return studentBinaryTree;
    }

    private static BinaryTree inintArrayTree(int[] array) {
        List<BinaryTree.BNode> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            BinaryTree.BNode bNode = new BinaryTree.BNode(array[i]);
            list.add(bNode);
        }

        for (int i = 0; i < list.size() / 2; i++) {
            BinaryTree.BNode bNode = list.get(i);
            bNode.setLeft(list.get(2 * i + 1));
            bNode.setRight(list.get(2 * i + 2));
        }

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(list.get(0));
        return binaryTree;
    }
}
