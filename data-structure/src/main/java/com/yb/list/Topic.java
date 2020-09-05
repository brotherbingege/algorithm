package com.yb.list;

import java.util.Stack;

/**
 * 〈功能概述〉<br>
 * 面试题
 *
 * @author: yb
 * @date: 2020/8/10 23:59
 */
public class Topic
{
    /**
     * 获取链表有效节点的个数
     *
     * @param head
     * @return
     */
    public static int getLinkedLength(Node head)
    {
        if (head.next == null){
            return 0;
        }
        Node temp = head;
        int count=0;
        while (temp.next != null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    /**
     * 获取Node链表中倒数第index个节点
     * @param index
     * @param head
     * @return
     */
    public static Node getReciprocalIndexNode(int index,Node head){
        //遍历获取有效元素的个数
        int length = getLinkedLength(head);
        if(length < index){throw new RuntimeException("index异常");}
        //有效个数减去倒数个数，得到顺数的index
        int targetNum = length - index + 1;
        Node temp = head;
        int tNum = 0;
        while(temp.next != null){
            if(targetNum == tNum){
                return temp;
            }
            tNum++;
            temp = temp.next;
        }
        return null;
    }

    /**
     * 翻转单链表
     * 遍历元素，每次取下最后一个，挂载新链表上，最后把新链表挂载老链表的头上即可
     * @return
     */
    public static Node reverseNode(Node head){
        Node newHead = new Node(null);
//        Node currNode = newHead;
        Node temp = head;
        while(temp.next != null){
            //最后一个节点的前一个节点
            if(temp.next.next == null){
                //缓存最后一个节点
                Node takeNode = temp.next;
                //将取下的节点接在newHead 和newHead.next 之间
                takeNode.next = newHead.next;
                newHead.next = takeNode;
                //摘下最后一个节点
                temp.next = null;
            }else{
                //不是最后一个节点
                //摘下一个节点，接在newHead 和newHead.next 之间,指针后移
                //摘下节点
                Node takeNode = temp.next;
                temp.next = temp.next.next;
                //接入节点
                takeNode.next = newHead.next;
                newHead.next = takeNode;
            }
        }
        return newHead;
    }

    /**
     * 逆序打印单链表
     * 不破坏链表的结构可以使用栈
     *
     * @param head
     */
    public static void reversePrint(Node head){
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while(temp.next != null){
            stack.push(temp.next);
            temp = temp.next;
        }
        while(!stack.empty()){
            System.out.println(stack.pop().data);
        }
    }

    /**
     * 合并两个有序的单链表
     * @param first
     * @param second
     * @return
     */
    public static Node mergeTwoOrderedSingleLink(Node first,Node second){
        Node newNode = new Node(0);
        //1、先遍历两个链表，将最短的链表顺序插入到最长的链表中，这样比较的次数就比较少
        int firstSize = 0;
        int secondSize = 0;
        Node temp = first;
        while(temp.next != null){
            firstSize++;
            temp = temp.next;
        }
        temp = second;
        while(temp.next != null){
            secondSize++;
            temp = temp.next;
        }

        //比较大小并选择插入的对象
        if(firstSize > secondSize){
            temp = second;
            while(temp.next != null){
                insertNode(temp.next.data,first);
                temp = temp.next;
            }
            return first;
        }else{
            temp = first;
            while(temp.next != null){
                insertNode(temp.next.data,second);
                temp = temp.next;
            }
            return second;
        }
    }

    /**
     * 将data插入到有序单链表中
     * @param data
     * @param node
     */
    private static void insertNode(int data,Node node){
        Node temp = node;
        //单链表只有一个节点，且头结点为空
        if(temp.next == null){
            node.next = new Node(data);
        }else {
            while (temp.next != null) {
                int da = temp.next.data;
                if(data > da){
                    temp = temp.next;
                }else{
                    //插入到链表
                    Node newNode = new Node(data);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    break;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Node head = new Node(null);
        Node one = new Node(1);
        Node three = new Node(3);
        Node five = new Node(5);
        Node seven = new Node(7);
        Node nine = new Node(9);

        head.next = one;
        one.next = three;
        three.next = five;
        five.next = seven;
        seven.next = nine;

        Node head2 = new Node(null);
        Node two = new Node(2);
        Node four = new Node(4);
        Node six = new Node(6);

        head2.next = two;
        two.next = four;
        four.next = six;

        Node node = mergeTwoOrderedSingleLink(head, head2);

        while(node.next != null){
            System.out.println(node.next.data);
        }


//        Node reciprocalIndexNode = getReciprocalIndexNode(3, head);
//        if(reciprocalIndexNode != null){
//            System.out.println(reciprocalIndexNode.data);
//        }

//        Node node = reverseNode(head);
//        while(node.next != null){
//            System.out.println(node.next.data);
//            node.next = node.next.next;
//        }

//        reversePrint(head);

    }

    public static class Node
    {
        Node next;
        Integer data;

        public Node(Integer da)
        {
            this.data = da;
        }
    }
}
