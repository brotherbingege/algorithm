package com.yb.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能概述〉<br>
 * 约舍夫问题
 * @author: yb
 * @date: 2021/6/9 0009 22:12
 */
public class Josephu {

    public static Node constructJosephuLinked(int length){
        if(length < 1){
            throw new RuntimeException("约舍夫链长度错误");
        }
        Node head = new Node(1);
        head.next = head;
        Node curr = head;
        for (int i = 2; i <= length; i++) {
            Node node = new Node(i);
            curr.next = node;
            node.next = head;
            curr = node;
        }
        return head;
    }

    /**
     * 约舍夫问题求解
     * @param n 围圈圈的人数
     * @param k 第K个人开始报数
     * @param m 报数到m出列
     * @return 出列的顺序集合
     */
    public static List<Integer> josephu(int n, int k, int m){
        List<Integer> ls = new ArrayList<Integer>();
        Node head = constructJosephuLinked(n);
        while( k > 1 ){
            head = head.next;
            k--;
        }
        Node curr = head;
        while(curr.next != null){
            if(m != 2){
                curr = curr.next;
                m--;
            }else{
                ls.add(curr.next.data);
                //判断最后一个
                if(curr.next == curr.next.next){
                    curr.next = null;
                }else{
                    curr.next = curr.next.next;
                    curr = curr.next;
                }

            }
        }
        return ls;
    }

    public static void print(Node head){
        Node temp = head;
        do{
            System.out.println(temp);
            temp = temp.next;
        }while(temp != head);
    }

    public static void main(String[] args) {
//        print(constructJosephuLinked(5));
        System.out.println(josephu(5,1,2));

    }
}

class Node{
    int data;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public Node(int data){
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
