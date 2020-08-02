package com.yb.stack;

/**
 * 〈功能概述〉<br>
 * 数组模拟实现简单的栈
 *
 * @author: yb
 * @date: 2020/8/2 0002 16:03
 */
public class ArrayStack {
    /**
     * 底层数组
     */
    private int[] data;
    /**
     * 数组的长度
     */
    private int size = 0;
    /**
     * 当前的索引
     */
    private int currIndex = -1;
    /**
     * 默认的栈的容量
     */
    private static final int CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    public ArrayStack()
    {
        this.size = CAPACITY;
        this.data = new int[CAPACITY];
    }

    public ArrayStack(int capacity)
    {
        this.size = capacity;
        this.data = new int[capacity];
    }

    /**
     * 入栈
     *
     * @param i
     */
    public void push(int i)
    {
        if ((currIndex + 1) >= (this.size * LOAD_FACTOR)) {
            //扩容
            int[] data2 = new int[size * 2];
            System.arraycopy(data, 0, data2, 0, data.length);
            data = data2;
            this.size = data2.length;
            System.out.println("====扩容====");
        }
        //入栈
        data[++currIndex] = i;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Integer pop()
    {
        if (currIndex == -1) {
            throw new NullPointerException("栈已经为空，没有能出栈的对象啦");
        }
        int datum = data[currIndex];
        data[currIndex] = 0;
        currIndex--;
        return datum;
    }

    public static void main(String[] args)
    {
        try {
            ArrayStack stack = new ArrayStack();
            for (int i = 0; i < 14; i++) {
                stack.push(i);
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(stack.pop());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
