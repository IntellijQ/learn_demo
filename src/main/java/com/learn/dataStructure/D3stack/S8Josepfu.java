package com.learn.dataStructure.D3stack;

import lombok.Data;

/**
 * @author yds
 * @title: S8Josepfu
 * @description: TODO
 * @date 2020/10/21 15:58
 */
public class S8Josepfu {

    public static void main(String[] args) {
        CricleSingleLinkedList cricleSingleLinkedList = new CricleSingleLinkedList(10);
        Node currentNode = cricleSingleLinkedList.getRootNode();
//        System.out.println(currentNode);
//        while (true){
//            System.out.println(currentNode.getI());
//            if(!cricleSingleLinkedList.hasNext(currentNode)){
//                break;
//            }
//            currentNode = currentNode.getNext();
//
//        }
        cricleSingleLinkedList.playGame(1, 5);
    }
}

@Data
class CricleSingleLinkedList {
    private static final int MIN = 2;
    private static final int MAX = Integer.MAX_VALUE;

    private Node rootNode = null;
    private int initialCapacity = MIN;

    public CricleSingleLinkedList() {
        initializeCricle(initialCapacity);
    }

    public CricleSingleLinkedList(int capacity) {
        initialCapacity = capacity;
        if (capacity < MIN) {
            capacity = MIN;
        }
        if (capacity > MAX) {
            capacity = MAX;
        }
        initializeCricle(capacity);
    }


    /**
     * 初始化环形单列表
     *
     * @param initialCapacity
     */
    public void initializeCricle(int initialCapacity) {
        Node lastNode = null;
        for (int i = 0; i < initialCapacity; i++) {
            Node node = new Node(i);
            if (i == 0) {
                rootNode = node;
                rootNode.setNext(node);
            } else {
                lastNode.setNext(node);
            }
            node.setNext(rootNode);
            lastNode = node;
        }
    }

    public void playGame(int beginNum, int killNum) {
        // 初始化设置上一个节点
        Node lastNode = rootNode;
        while (true) {
            if (lastNode.getNext() == rootNode) {
                break;
            }
            lastNode = lastNode.getNext();
        }
        // 初始化开始报数节点
        Node currentNode = rootNode;


        // 选择开始报数节点
        for (int i = 0; i < beginNum - 1; i++) {
            lastNode = lastNode.getNext();
            currentNode = currentNode.getNext();
        }


        // 删除节点
        while (true) {
            if (lastNode == currentNode) {
                break;
            }

            System.out.println("上一节点：" + lastNode.getI() + ",开始报数节点：" + currentNode.getI());
            for (int i = 0; i < killNum - 1; i++) {
                lastNode = lastNode.getNext();
                currentNode = currentNode.getNext();
                System.out.println("当前节点：" + currentNode.getI());
            }
            System.out.println("删除节点-----------" + currentNode.getI());
            currentNode = currentNode.getNext();
            lastNode.setNext(currentNode);
        }

        System.out.println("幸运儿：" + currentNode);
    }
}


@Data
class Node {
    private int i;
    private Node next;

    public Node(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Node{" +
                "i=" + i +
                '}';
    }
}
