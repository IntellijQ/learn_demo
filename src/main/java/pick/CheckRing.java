package pick;

import java.util.LinkedList;

/**
 * @author yds
 * @title: pick.CheckRing
 * @description: TODO
 * @date 2021/4/19 19:52
 */
public class CheckRing {


    public static void main(String[] args) {
        Node head = new Node(0);
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // 构造一个环形
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = head;

        boolean result = isRing(head);
        System.out.println("链表是否环形：" + result);
    }

    private static boolean isRing(Node head) {
        // 空节点
        if(head == null){
            return false;
        }

        // 判断下一是否为空 只有一个节点
        if(head.next == null){
            return false;
        }

//        1-2-3-4-5-6-7

        // 使用快慢指针进行
        Node x1 = head.next;
        Node x2 = head.next.next;// 2倍速

        while (x2.next != null && x2.next.next != null){
            if(x1 == x2){
                return true;
            }
            x1 = x1.next;
            x2 = x2.next.next;
        }
        return false;
    }





   static class Node{
        int value;
        Node next;

       public Node(int value) {
           this.value = value;
       }
   }



   // 账户表 短时间内数据大 100+/s

    //大 //查 //id() 冗余信息 （姓名、身份证）// 索引  //  分表、分库
    // 1.insert --- mq （）,
    // 2.并发问题 -- synichiched  分布式锁 redis
    // setex key uniq nx 3000
    // del key
    //A KEY
    //B KEY X B误操作
    //C
    // 3.多线程 线程池
    // 数据库mysql 瓶颈
    // redis 读写缓存
    //
}
