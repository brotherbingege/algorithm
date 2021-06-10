package com.yb.queue;

import java.util.Scanner;

/**
 * 〈功能概述〉<br>
 * 数组模拟基础的环形链表
 *
 * @author: yb
 * @date: 2020/8/8 9:14
 */
public class CycleQueue
{
    /**
     * 底层数组
     */
    private int[] data;
    /**
     * 队首指针
     * 指向队列的第一个元素
     * 初始化值为0
     */
    private int font;
    /**
     * 队尾指针
     * 指向队尾最后一个元素的后一个位置，空出一个位置不使用
     */
    private int rear;
    /**
     * 代表最大容量 -1
     */
    private int maxSize = 16;

    public CycleQueue()
    {
        data = new int[maxSize];
    }

    public CycleQueue(int capacity)
    {
        this.maxSize = capacity;
        data = new int[capacity];
    }

    /**
     * 是否满
     *
     * @return
     */
    public boolean isFull()
    {
        return (rear + 1) % maxSize == font;
    }

    /**
     * 是否空
     *
     * @return
     */
    public boolean isEmpty()
    {
        return font == rear;
    }

    /**
     * 添加队列
     *
     * @param da
     */
    public void addQueue(int da)
    {
        //添加到队列
        if (isFull())
        {
            throw new RuntimeException("队列已满，不能添加");
        }
        //添加队列，指针后移
        data[rear] = da;
        rear = (rear + 1) % maxSize;

    }

    /**
     * 出队
     *
     * @return
     */
    public int removeQueue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列为空，不能出队");
        }
        int rea =  data[font];
        font = (font + 1) % maxSize;
        return rea;
    }

    /**
     * 打印所有的
     */
    public void printAll(){
        //获取当前元素的有效个数
        int num =  (rear + maxSize - font) % maxSize;
        StringBuffer sb = new StringBuffer();
        for (int i = font; i < font + num; i++)
        {
            sb.append(data[i % maxSize]).append("-");
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CycleQueue cycleQueue = new CycleQueue(4);
        boolean flag = true;
        while(flag){
            System.out.println("请输入需要操作的数：");
            System.out.println("1、添加数据到队列");
            System.out.println("2、移除数据到队列");
            System.out.println("3、打印所有数据");
            System.out.println("-1、结束程序");
            int i = scanner.nextInt();
            switch(i){
                case 1:
                    try {
                        System.out.println("请输入需要添加到队列的整数");
                        int da = scanner.nextInt();
                        cycleQueue.addQueue(da);
                        System.out.println("添加="+da+"=到队列成功");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        int da2 = cycleQueue.removeQueue();
                        System.out.println("出队的数据===>"+da2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    cycleQueue.printAll();
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
