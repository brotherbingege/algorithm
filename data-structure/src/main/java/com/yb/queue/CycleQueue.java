package com.yb.queue;

/**
 * 〈功能概述〉<br>
 * 数组模拟环形对列
 *
 * @author: yb
 * @date: 2020/8/6 0006 21:47
 */
public class CycleQueue {
    /**
     * 队尾指针
     */
    int rear = -1;
    /**
     * 队首指针
     */
    int font = -1;
    /**
     * 对列最大容量
     */
    int maxSize = 4;
    /**
     * 底层数组
     */
    int[] data;

    /**
     * 入队
     *
     * @param da
     */
    public void addQueue(int da) {

    }

    /**
     * 判断是否是空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == font;
    }

    public boolean isFull() {
        return (font + maxSize) % maxSize == 0;
    }

}
