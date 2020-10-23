package com.learn.dataStructure.D1link;

/**
 * @author yds
 * @title: DoubleLinkedList
 * @description: TODO
 * @date 2020/9/28 15:27
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        UserNode userNode1 = new UserNode(1,"1");
        doubleLinkedList.add(userNode1);
        UserNode userNode2 = new UserNode(2,"2");
        doubleLinkedList.add(userNode2);
        UserNode userNode3 = new UserNode(3,"3");
        doubleLinkedList.add(userNode3);

        doubleLinkedList.del(3);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{
    UserNode head = new UserNode(0,"");

    public void add(UserNode userNode){
        boolean flag = true;
        UserNode temp = head;
        while (flag){
            if(temp.next == null){
                temp.next = userNode;
                userNode.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

//    a b c
    public void del(Integer userId){
        boolean flag = true;
        UserNode temp = head.next;
        while (flag){
            if(temp.userId == userId){
                temp.pre.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }

    }

    public void list(){
        boolean flag = true;
        UserNode temp = head.next;
        while (flag){
            if(temp == null){
                return;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}


class UserNode{
    public Integer userId;
    public String userName;
    public UserNode pre;
    public UserNode next;

    @Override
    public String toString() {
        return "UserNode{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public UserNode(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
