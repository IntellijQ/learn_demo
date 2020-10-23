package com.learn.dataStructure.D2queen;

import java.util.Scanner;

/**
 * @author yds
 * @title: ArrayQueen
 * @description: 队列实现方式---数组
 * @date 2020/9/27 10:17
 */
public class ArrayQueen {
    private int queenSize;
    private int[] queen;
    private int front = -1;//队列头
    private int rear = -1;//队列尾



    public static void main(String[] args) {

        ArrayQueen arrayQueen = new ArrayQueen(5);
        boolean doFlag = true;
        while (doFlag){
            System.out.println("欢迎来到数组队列测试案列");
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



//4   1 rear
//3   2
//2   3
//1   5
//0   0 
//-1  / front
    //增加数据
    public void add(int value){
        if(rear == (queenSize - 1)){
            System.out.printf("队列已到达最大值%s\n", queenSize);
            return;
        }
        rear++;
        queen[rear] = value;
    }

    //获取数据
    public int get(){
        if(rear == front){
            System.out.printf("队列中已无数据\n");
            return 0;
        }
        front++;
        int i = queen[front];
        System.out.printf("%s\n", i);
        return i;
    }

    //展示队列所有数据
    public void show(){
        if(rear == front){
            System.out.println("队列中已无数据");
        }
        for(int i = (front + 1); i <= rear; i++){
            System.out.printf("queen[%s]=%s\n", i, queen[i]);
        }
    }

    //获取当前队列数量
    public int currentSize(){
        int currentSize = rear - headIndx() + 1;
        System.out.printf("当前队列数据个数%s\n", currentSize);
        return currentSize;
    }

    
    //获取当前队列开始位置
    public int headIndx(){
        if(rear == front){
            System.out.println("队列中已无数据");
        }

        int headIndex = front + 1;
        System.out.printf("当前队列头位置%s\n", headIndex);
        return headIndex;
    }


    public ArrayQueen(int queenSize){
        this.queenSize = queenSize;
        queen = new int[queenSize];
    }




}
