package com.yb.stack;

/**
 * 〈功能概述〉<br>
 * 单链表实现简单的栈
 *
 * @author: yb
 * @date: 2020/8/2 0002 15:04
 */
public class OneLinkedStack {
    /**
     * 单链头结点
     */
    private Node head;
    /**
     * 单链当前节点
     */
    private Node curr;

    /**
     * 入栈
     *
     * @param i
     */
    public void push(Integer i)
    {
        //可判断当前的栈是否满，满则抛出异常或者返回
        Node node = new Node(i);
        if (head == null) {
            head = node;
        } else {
            curr.next = node;
        }
        curr = node;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Integer pop()
    {
        if (head == null) {
            throw new NullPointerException("栈已经为空啦");
        }
        //找出出栈的节点的前一个节点
        Node preCurr = head;
        Node temp = null;
        //只有一个节点
        if (preCurr.next == null) {
            temp = head;
            head = null;
            curr = null;
            return temp.data;
        }
        //多个节点
        while (preCurr.next != null) {
            if (preCurr.next == curr) {
                //断开链，返回值
                preCurr.next = null;
                temp = curr;
                curr = preCurr;
                break;
            }
            //指针后移
            preCurr = preCurr.next;
        }
        return temp.data;
    }

    /**
     * 单链节点
     */
    static class Node {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args)
    {
        OneLinkedStack stack = new OneLinkedStack();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(stack.pop());
        }
    }

}
