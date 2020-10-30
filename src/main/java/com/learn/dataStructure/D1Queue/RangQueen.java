package com.learn.dataStructure.D1Queue;

import java.util.Scanner;

/**
 * @author yds
 * @title: RangQueen
 * @description: 队列实现方式--环形
 * @date 2020/9/27 10:17
 */
public class RangQueen {
    private int queenSize;
    private int[] queen;
    private int front = 0;
    private int rear = 0;


    public static void main(String[] args) {

        RangQueen arrayQueen = new RangQueen(3);
        boolean doFlag = true;
        while (doFlag){
            System.out.println("欢迎来到环形队列测试案列");
            System.out.println("a-添加队列数据");
            System.out.println("g-获取队列数据");
            System.out.println("s-展示队列数据");
            System.out.println("c-展示队列个数");
            System.out.println("h-当前队列头位置");
            System.out.println("e-退出测试案例");

            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            switch (next){
                case "a":
                    System.out.println("请输入队列数据");
                    Scanner scanner2 = new Scanner(System.in);
                    String i = scanner2.nextLine();
                    arrayQueen.add(Integer.parseInt(i));
                    break;
                case "g":
                    arrayQueen.get();
                    break;
                case "s":
                    arrayQueen.show();
                    break;
                case "c":
                    arrayQueen.currentSize();
                    break;
                case "h":
                    arrayQueen.headIndx();
                    break;
                case "e":
                    scanner.close();
                    doFlag = false;
                    System.out.println("已退出测试案例");
                    break;
                default:
                    System.out.println("暂无此操作");
            }
        }
    }

    //增加数据
    public void add(int value){
        if(front == (rear + 1) % queenSize){//互补取值，相等表示队列满了
            System.out.printf("队列已到达最大值%s\n", queenSize);
            return;
        }
        queen[rear] = value;
        rear = (rear + 1) % queenSize;
    }

    //获取数据
    public int get(){
        if(rear == front){
            System.out.printf("队列中已无数据\n");
            return 0;
        }
        int i = queen[front];
        front = (front + 1) % queenSize;
        System.out.printf("%s\n", i);
        return i;
    }

    //展示队列所有数据
    public void show(){
        if(rear == front){
            System.out.println("队列中已无数据");
        }
        int currentSize = currentSize();
        for(int i = front; i < front + currentSize; i++){
            System.out.printf("queen[%s]=%s\n", i % queenSize, queen[i % queenSize]);
        }
    }

    //获取当前队列数量
    public int currentSize(){
        int currentSize =  (queenSize + rear - front) % queenSize;
        System.out.printf("当前队列数据个数%s\n", currentSize);
        return currentSize;
    }


    //获取当前队列开始位置
    public int headIndx(){
        if(rear == front){
            System.out.println("队列中已无数据");
        }

        System.out.printf("当前队列头位置%s\n", front);
        return front;
    }


    public RangQueen(int queenSize){
        this.queenSize = queenSize;
        queen = new int[queenSize];
    }




}
