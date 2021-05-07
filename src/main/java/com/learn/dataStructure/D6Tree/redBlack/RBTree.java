package com.learn.dataStructure.D6Tree.redBlack;

/**
 * @author yds
 * @title: RBTreeTest
 * @description: TODO
 * @date 2021/4/6 10:28
 */
public class RBTree {

    public RBTreeNode root;

    public void insertNode(int value){
        RBTreeNode newNode = new RBTreeNode(value);
        //1.root是否为空
        if(root == null){
            newNode.isRed = false;
            root = newNode;
            return;
        }

        // 查找插入位置
        RBTreeNode position = root;
        RBTreeNode parent = null;
        boolean isLeftChild = true;
        while (position != null){
            parent = position;
            if(value < parent.value){
                position = parent.left;
                isLeftChild = true;
            }else if(value > parent.value){
                position = parent.right;
                isLeftChild = false;
            }else {
                return;
            }
        }

        if(isLeftChild){
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        newNode.parent = parent;
        // 2.插入的位置的父结点是黑色
        if(!parent.isRed) return;

        // 3.插入的位置的父结点是红色，需要进行自平衡
        balanceInsert(newNode);

    }

    private void balanceInsert(RBTreeNode newNode) {
        // 父结点为红色，叔伯为红色

    }



    public static void main(String[] args) {

    }





    static class RBTreeNode {
        int value;
        boolean isRed;
        RBTreeNode left;;
        RBTreeNode right;
        RBTreeNode parent;

        public RBTreeNode(int value) {
            this.value = value;
        }

        public RBTreeNode(int value, boolean isRed) {
            this.value = value;
            this.isRed = isRed;
        }
    }

}
