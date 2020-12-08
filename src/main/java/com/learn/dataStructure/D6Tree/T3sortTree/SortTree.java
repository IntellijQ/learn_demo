package com.learn.dataStructure.D6Tree.T3sortTree;

import com.learn.dataStructure.D6Tree.T1binaryTree.BNode;
import com.learn.dataStructure.D6Tree.T1binaryTree.BinaryTree;

/**
 * @author yds
 * @title: Test
 * @description: 二叉排序树
 * 左子树的值小于 根节点
 * 右子树的值大于 根节点
 * 新增和查询速度很快 logn
 * @date 2020/11/12 14:26
 */
public class SortTree<E> extends BinaryTree<E> {

    /**
     * 新增结点
     *
     * @param node
     */
    public void add(BNode<E> node) {
        if (root == null) {
            if (node.getE() == null) {
                node.setE((E) node.getWeight());
            }
            this.root = node;
            return;
        }

        add(root, node);
    }

    /**
     * 新增结点
     *
     * @param root 当前结点
     * @param node 待插入结点
     */
    private void add(BNode<E> root, BNode<E> node) {
        if (root == null || node == null) {
            return;
        }

        BNode<E> currentNode = root;
        BNode<E> preRoot = null;
        while (currentNode != null) {
            preRoot = currentNode;
            // 根节点大于插入值，放左边
            if (currentNode.getWeight() > node.getWeight()) {
                currentNode = currentNode.getLeft();
            } else {
                // 根节点大于或等于插入值，放右边
                currentNode = currentNode.getRight();
            }
        }

        if (node.getE() == null) {
            node.setE((E) node.getWeight());
        }
        if (preRoot.getWeight() > node.getWeight()) {
            preRoot.setLeft(node);
        } else {
            preRoot.setRight(node);
        }
    }


    /**
     * 删除 二叉排序树 结点
     * 0.为叶子节点，该父节点子节点=null
     * 1.为非叶子节点，该父节点子节点=该节点的右节点
     *
     * @param node
     */
    @Override
    public void deleteNode(int node) {
        deleteNode(root, node);
    }

    private void deleteNode(BNode<E> currentNode, int node) {
        BNode<E> preNode = null;
        while (currentNode != null) {
            if (currentNode.getWeight() == node) {
                break;
            }

            preNode = currentNode;
            // 待删除的节点 在左边
            if (currentNode.getWeight() > node) {
                currentNode = currentNode.getLeft();
            } else { //待删除的节点 在右边
                currentNode = currentNode.getRight();
            }
        }

        // 未查询到对应的节点
        if(currentNode == null){
            return;
        }

        // 待删除结点的左结点
        Integer weight = currentNode.getWeight();
        BNode left = currentNode.getLeft();
        // 待删除结点的右结点
        BNode right = currentNode.getRight();
        // 删除后该位置的新节点
        BNode newNode = null;


        // 删除类型
        if (left != null && right != null) {//0.待删除结点有两个子结点
            // 从待删除结点查找右子树最小值
            newNode = getRightTreeMinNode(currentNode);
            // 删除最小值
            deleteNode(newNode.getWeight());

            newNode.setLeft(left);
            newNode.setRight(right);
        }else if ((left != null && right == null)) {//1. 待删除结点只有一个左子结点
            newNode = left;
        }else if ((left == null && right != null)) { //2. 待删除结点只有一个右子结点
            newNode = right;
        }

        if(preNode == null){
            root = newNode;
            return;
        }
        // 待删除的节点在左边
        if (preNode.getWeight() > weight) {
            preNode.setLeft(newNode);
        } else {
            preNode.setRight(newNode);
        }
    }

    /**
     * 获取指点结点 最小右子树结点
     * @param currentNode
     * @return
     */
    private BNode<E> getRightTreeMinNode(BNode<E> currentNode) {
        BNode<E> node = currentNode.getRight();
        BNode<E> min = null;

        while (node != null){
            min = node;
            node = node.getLeft();
        }
        return min;
    }


}
