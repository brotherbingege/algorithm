package com.yb.queue;

import java.util.Scanner;

/**
 * 〈功能概述〉<br>
 * 数组模拟实现简单的对列
 *
 * @author: yb
 * @date: 2020/8/2 0002 17:41
 */
public class ArrayQueue {
    /**
     * 队尾指针
     */
    private int rear;
    /**
     * 队首指针
     */
    private int font;
    /**
     * 底层数组
     */
    private int[] data;
    /**
     * 对列的最大长度
     */
    private int size;

    public ArrayQueue(int capacity)
    {
        size = capacity;
        data = new int[capacity];
        font = -1;
        rear = -1;
    }

    /**
     * 是否满
     *
     * @return
     */
    public boolean isFull()
    {
        return rear == size - 1;
    }

    /**
     * 是否空
     *
     * @return
     */
    public boolean isEmpty()
    {
        return rear == font;
    }

    /**
     * 入队
     *
     * @param d
     */
    public void addQueue(int d)
    {
        if (isFull()) {
            System.out.println("队列已经满了，不能入队啦");
            return;
        }
        data[++rear] = d;
    }

    /**
     * 出队
     *
     * @return
     */
    public Integer getQueue()
    {
        if (isEmpty()) {
            System.out.println("对列为空，不能出队啦");
            return null;
        }
        return data[++font];
    }

    /**
     * 打印
     */
    public void printList()
    {
        if (isEmpty()) {
            throw new RuntimeException("对列为空");
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "]=>" + data[i]);
        }
    }

    public static void main(String[] args)
    {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        while(flag){
            System.out.println("请输入一个数：");
            System.out.println("1：入队");
            System.out.println("2：出队");
            System.out.println("3：打印对列");
            System.out.println("-1：结束程序");
            int i = scanner.nextInt();
            switch(i){
                case 1:
                    System.out.println("请输入入队的数");
                    int da = scanner.nextInt();
                    arrayQueue.addQueue(da);
                    break;
                case 2:
                    System.out.println("出队数=>"+arrayQueue.getQueue());
                    break;
                case 3:
                    try {
                        arrayQueue.printList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case -1:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

}
