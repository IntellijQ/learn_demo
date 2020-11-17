package com.learn.dataStructure.D6BinaryTree;

import lombok.Data;

import java.util.*;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/11/12 14:26
 */
@Data
public class BinaryTree<E> {

    private BNode<E> root;

    /**
     * 递归形式-前序遍历
     * @param root
     * @return
     */
    public void prefixListRecursion(BNode<E> root, List<E> list){
        if (root == null) {
            return;
        }
        list.add(root.getE());
        if(root.getLeft() != null){
            prefixListRecursion(root.getLeft(), list);
        }
        if(root.getRight() != null){
            prefixListRecursion(root.getRight(), list);
        }
    }
    /**
     * 栈形式-前序遍历
     * 根左右
     *
     * @return
     */
    public List<E> prefixListStack(BNode<E> root) {
        if (root == null) {
            return null;
        }

        List list = new ArrayList<>();
        Stack<BNode<E>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root.getE());
                stack.push(root);
                root = root.getLeft();
            } else {
                BNode<E> pop = stack.pop();
                root = pop.getRight();
            }

        }
        return list;
    }


    /**
     * 递归形式-中序遍历
     * @param root
     * @return
     */
    public void infixListRecursion(BNode<E> root, List<E> list){
        if (root == null) {
            return;
        }

        if(root.getLeft() != null){
            infixListRecursion(root.getLeft(), list);
        }
        list.add(root.getE());
        if(root.getRight() != null){
            infixListRecursion(root.getRight(), list);
        }
    }
    /**
     * 栈形式-中序遍历
     * 左根右
     *
     * @return
     */
    public List<E> infixListStack(BNode<E> root) {
        if (root == null) {
            return null;
        }
        List list = new ArrayList<>();
        Stack<BNode<E>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                BNode<E> pop = stack.pop();
                list.add(pop.getE());
                root = pop.getRight();
            }
        }
        return list;
    }

    /**
     * 递归形式-中序遍历
     * @param root
     * @return
     */
    public void sufixListRecursion(BNode<E> root, List<E> list){
        if (root == null) {
            return;
        }
        if(root.getLeft() != null){
            sufixListRecursion(root.getLeft(), list);
        }
        if(root.getRight() != null){
            sufixListRecursion(root.getRight(), list);
        }
        list.add(root.getE());
    }
    /**
     * 栈形式-后续遍历
     * 左右根
     *
     * @return
     */
    public List<E> sufixListStack(BNode<E> root) {
        if (root == null) {
            return null;
        }

        // 栈形式
        List list = new ArrayList<>();
        Stack<BNode<E>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root.getE());
                stack.push(root);
                root = root.getRight();
            } else {
                BNode<E> pop = stack.pop();
                root = pop.getLeft();
            }
        }
        Collections.reverse(list);
        return list;
    }



    @Data
    public static class BNode<E> {
        private E e;

        private BNode left;
        private BNode right;

        public BNode() {
        }

        public BNode(E e) {
            this.e = e;
        }
    }
}
