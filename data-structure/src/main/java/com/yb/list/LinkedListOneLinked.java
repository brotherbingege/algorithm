package com.yb.list;

/**
 * 〈功能概述〉<br>
 * LinkedList 简单单链表的基础实现
 *
 * @author: yb
 * @date: 2020/7/30 0030 13:34
 */
public class LinkedListOneLinked {
    /**
     * 头结点
     */
    private Node root;
    /**
     * 当前的最新的节点
     */
    private Node curr;

    public LinkedListOneLinked()
    {
    }

    /**
     * 删除
     *
     * @param i
     */
    public void remove(int i)
    {
        Node temp = root;
        if (root == null) {
            throw new NullPointerException("LinkedList为空");
        }
        while (temp.next != null) {
            if (temp.next.data == i) {
                //移除并停止循环
                temp.next = temp.next.next;
                break;
            }
            //指针后移
            temp = temp.next;
        }
    }

    /**
     * 添加
     *
     * @param i
     */
    public void add(int i)
    {
        if (root == null || curr == null) {
            root = new Node(i);
            curr = root;
        } else {
            Node node = new Node(i);
            curr.next = node;
            curr = node;
        }
    }

    /**
     * 打印
     */
    public void printList()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("linkedList=>[");
        Node temp = root;
        while (temp != null) {
            sb.append(temp.data).append(",");
            temp = temp.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * 存储的节点
     */
    static class Node {
        //后继节点
        Node next;
        int data;

        public Node(int da)
        {
            data = da;
        }
    }

    public static void main(String[] args)
    {
        LinkedListOneLinked linkedList = new LinkedListOneLinked();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.remove(3);
        linkedList.printList();
    }
}
