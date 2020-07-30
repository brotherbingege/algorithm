package com.yb.list;

/**
 * 〈功能概述〉<br>
 * LinkedList 底层双向链表的基本实现
 * @author: yb
 * @date: 2020/7/30 0030 14:14
 */
public class LinkedListDoubleLinked {
    /**
     * 根节点
     */
    private Node root;
    /**
     * 尾结点
     */
    private Node footer;

    /**
     * 添加
     * @param i
     */
    public void add(int i)
    {
        Node node = new Node(i);
        if(root==null){
            root = node;
            footer = node;
        }else{
            footer.next = node;
            node.pre = footer;
            //尾结点后移
            footer = node;
        }
    }

    /**
     * 删除
     * @param i
     */
    public void remove(int i)
    {
        Node temp = root;
        if(temp == null){
            throw new NullPointerException("双向链表为空，删除失败");
        }
        while(temp != null){
            if(temp.data == i){
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
            //指针后移
            temp = temp.next;
        }
    }

    /**
     * 打印
     */
    public void printList(){
        StringBuffer sb = new StringBuffer();
        sb.append("doubleLinkedList=>[");
        Node temp = root;
        while(temp != null){
            sb.append(temp.data).append(",");
            temp = temp.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * 双向链表数据结构
     */
    static class Node{
        int data;
        Node pre;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args)
    {
        LinkedListDoubleLinked linkedListDoubleLinked  = new LinkedListDoubleLinked();
        for (int i = 1; i < 6; i++) {
            linkedListDoubleLinked.add(i);
        }
        linkedListDoubleLinked.remove(3);
        linkedListDoubleLinked.printList();
    }
}
