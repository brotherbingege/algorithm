package com.yb.list;

/**
 * 〈功能概述〉<br>
 * 模拟数组实现list(ArrayList实现)
 *
 * @author: yb
 * @date: 2020/7/30 0030 00:08
 */
public class ArrayList {
    private int[] data;
    private int size = 16;
    private int currIndex = 0;

    public ArrayList(){
        data = new int[size];
    }
    public ArrayList(int size)
    {
        this.size = size;
        data = new int[size];
    }

    /**
     * 添加
     *
     * @param i
     */
    public void add(int i)
    {
        checkAddDataToDoubleSize();
        data[currIndex] = i;
        ++currIndex;
    }

    /**
     * 删除 返回null表示没有数据删除
     *
     * @param obj
     * @return
     */
    public Integer remove(int obj)
    {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == obj) {
                int temp = data[i];
                System.arraycopy(data, i + 1, data, i, data.length - i);
                return temp;
            }
        }
        return null;
    }

    /**
     * 如果list包含,则返回包含的索引
     * 否则返回null
     *
     * @param obj
     * @return
     */
    public Integer contains(int obj)
    {
        for (int i = 0; i < data.length; i++) {
            if (obj == data[i]) {
                return i;
            }
        }
        return null;
    }

    /**
     * 查找
     *
     * @param index
     * @return
     */
    public Integer find(int index)
    {
        if (index < data.length) {
            return data[index];
        }
        return null;
    }

    /**
     * 列表打印
     */
    public void printList()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("list =>[");
        for (int datum : data) {
            sb.append(datum).append(",");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * 如果容量不够则扩容
     * 扩容两倍
     */
    private void checkAddDataToDoubleSize()
    {
        if (currIndex == size - 1) {
            //扩展数组
            int[] temp = new int[data.length * 2];
            //改变维护的数组的长度字段
            size = data.length * 2;
            //拷贝数据到新数组
            System.arraycopy(data, 0, temp, 0, data.length);
            //临时引用切换到data
            data = temp;
        }
    }

    public static void main(String[] args)
    {
        ArrayList al = new ArrayList(4);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.printList();

    }
}
