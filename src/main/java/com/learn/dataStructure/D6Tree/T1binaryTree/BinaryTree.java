package com.learn.dataStructure.D6Tree.T1binaryTree;

import java.util.*;

/**
 * @author yds
 * @title: Test
 * @description: 二叉树
 * @date 2020/11/12 14:26
 */
public class BinaryTree<E> {
    public BNode<E> root;

    public BinaryTree() {
    }

    public BinaryTree(BNode<E> root) {
        this.root = root;
    }

    /**
     * 构造二叉树
     * @param list
     */
    public BinaryTree(List<BNode<E>> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            BNode<E> root = list.get(i);
            if (2 * i + 1 < list.size()) {
                root.setLeft(list.get(2 * i + 1));
            }
            if (2 * i + 2 < list.size()) {
                root.setRight(list.get(2 * i + 2));
            }
            if (i == 0) {
                this.root = root;
            }
        }
    }

    /**
     * 获取指定结点的父节点
     * @param son
     * @return
     */
    public BNode<E> getParent(BNode<E> son) {
        return getParent(root, son);
    }


    /**
     * 获取指定结点的父节点
     * @param start 开始位置结点
     * @param son 指定结点
     * @return
     */
    public BNode<E> getParent(BNode<E> start, BNode<E> son) {
        if (start == null || son == null) {
            return null;
        }

        if (start.getLeft() == son || start.getRight() == son) {
            return start;
        }

        BNode<E> r;
        if ((r = getParent(start.getLeft(), son)) != null) {
            return r;
        } else {
            return getParent(start.getRight(), son);
        }
    }

    /**
     * 删除结点
     * 普通二叉树删除结点逻辑：
     * 0.如果该结点时根结点，则清空该树
     * 1.如果该结点是叶子结点，则直接删除
     * 2.如果该结点时非叶子结点，则删除该结点下的树
     * @param node
     */
    public void deleteNode(int node){
        if(root.getWeight() == node){
            root = null;
            return;
        }
        deleteNode(root, node);
    }

    /**
     * 删除结点
     * @param currentNode
     * @param node
     */
    private void deleteNode(BNode<E> currentNode, int node){
        if(currentNode.getLeft() != null && currentNode.getLeft().getWeight() == node){
            currentNode.setLeft(null);
            return;
        }

        if(currentNode.getRight() != null && currentNode.getRight().getWeight() == node){
            currentNode.setRight(null);
            return;
        }

        if(currentNode.getLeft() != null){
            deleteNode(currentNode.getLeft(), node);
        }

        if(currentNode.getRight() != null){
            deleteNode(currentNode.getRight(), node);
        }
    }

    /**
     * 递归形式-前序遍历
     *
     * @param root
     * @return
     */
    public void prefixListRecursion(BNode<E> root, List<E> list) {
        if (root == null) {
            return;
        }
        list.add(root.getE());
        if (root.getLeft() != null) {
            prefixListRecursion(root.getLeft(), list);
        }
        if (root.getRight() != null) {
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
     *
     * @param root
     * @return
     */
    public void infixListRecursion(BNode<E> root, List<E> list) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            infixListRecursion(root.getLeft(), list);
        }
        list.add(root.getE());
        if (root.getRight() != null) {
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
     *
     * @param root
     * @return
     */
    public void sufixListRecursion(BNode<E> root, List<E> list) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            sufixListRecursion(root.getLeft(), list);
        }
        if (root.getRight() != null) {
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


    private Map<String, List<E>> treePathMap = new HashMap<>();// 各个叶子结点路径

    public Map<String, List<E>> binaryTreePath(BNode<E> root) {
        binaryTreePath(root, new ArrayList());
        return treePathMap;
    }

    private void binaryTreePath(BNode<E> root, List<E> pathList) {
        if (root == null) {
            return;
        }

        if (pathList == null) {
            pathList = new ArrayList();
        }

        ArrayList arrayList = new ArrayList();
        arrayList.addAll(pathList);
        arrayList.add(root.getE());

        if (root.getLeft() == null && root.getRight() == null) {
            treePathMap.put(root.getE().toString(), arrayList);
        }

        binaryTreePath(root.getLeft(), arrayList);
        binaryTreePath(root.getRight(), arrayList);
    }

    public BNode<E> getRoot() {
        return root;
    }

    public void setRoot(BNode<E> root) {
        this.root = root;
    }
}
