package com.learn.dataStructure;

import lombok.Data;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yds
 * @title: AddTest
 * @description: TODO
 * @date 2020/12/15 18:35
 */
public class AddTest {

    public static void main(String[] args) {
        //2 -> 4 -> 3
        ListNode listNode = new ListNode();
        listNode.setVal(3);

        ListNode listNode1 = new ListNode();
        listNode1.setVal(4);
        listNode1.setNext(listNode);

        ListNode listNode2 = new ListNode();
        listNode2.setVal(2);
        listNode2.setNext(listNode1);
        addTwoNumbers(listNode2, null);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        Stack<Integer> stack1 = new Stack<>();
        do {
            stack1.push(l1.getVal());
            a++;
        } while ((l1 = l1.getNext()) != null);

        int i = 0;
        int aint[] = new int[a];
        ListNode listNode = new ListNode();
        while (!stack1.isEmpty()) {
            aint[i] = stack1.pop();
            i++;
        }

        System.out.println(Arrays.toString(aint));
        System.out.println(getNum(aint));
        return null;
    }

    private static int getNum(int[] aint) {
        int a = aint.length;
        int result  = 0;
        for (int i = 0; i <= a-1; i++) {
            int base = (int) Math.pow(10,a-1-i);
            result += aint[i]*base;
        }
        return result;


    }

    @Data
    public static class ListNode {
        int val;
        ListNode next;


        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
