package com.yb.list;

/**
 * 〈功能概述〉<br>
 * 链表反转
 * @author: yb
 * @date: 2021/2/25 0025 21:29
 */
public class LinkedReverse {

    public DataNode reverse(DataNode head){
       if(head==null || head.next==null){
           return head;
       }
       DataNode newHead = new DataNode(null,null);
       while(head.next != null){
           //摘下当前节点，插入到newHead第一个
           DataNode curr = head.next;
           head.next = head.next.next;

           DataNode newCurr = newHead.next;
           curr.next = newCurr;
           newHead.next = curr;
       }

       head.next = newHead.next;
       return head;
    }

    public void print(DataNode head){
        DataNode curr = head.next;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedReverse reverse = new LinkedReverse();

        DataNode data5 = new DataNode(null,5);
        DataNode data4 = new DataNode(data5,4);
        DataNode data3 = new DataNode(data4,3);
        DataNode data2 = new DataNode(data3,2);
        DataNode data1 = new DataNode(data2,1);
        DataNode head = new DataNode(data1,null);

        System.out.println("翻转前");
        reverse.print(head);
        System.out.println("翻转");
        reverse.reverse(head);
        System.out.println("翻转后");
        reverse.print(head);
    }
}
class DataNode{
    DataNode next;
    Integer data;

    public DataNode(DataNode next, Integer data) {
        this.next = next;
        this.data = data;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
