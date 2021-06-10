package com.yb.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2021/6/10 0010 22:45
 */
public class SuffixExpress {

    /**
     * 中缀表达式字符串转后缀表达式
     * @param infixString
     * @return 后缀表达式的String 集合
     */
    public static List<String> toSuffixExpress(String infixString){
         ArrayList<String> strings = new ArrayList<String>();
        if(infixString == null || infixString.trim().length() == 0 ){
            return strings;
        }
        Stack<Character> opStack = new Stack<Character>();
        for (int i = 0; i < infixString.length(); i++) {
             char c = infixString.charAt(i);
            if(isNumber(c)){
                strings.add(Character.toString(c));
            }else{
                //1）如果堆栈是空的，直接将操作符存储到堆栈中（push it）
                if(opStack.isEmpty()){
                    opStack.push(c);
                }else{
                    final Character peek = opStack.peek();
                    //2）如果该操作符的优先级大于堆栈出口的操作符，就直接将操作符存储到堆栈中（push it）
                    if(isGreeter(c,peek)){
                        opStack.push(c);
                    }else{
                        //如果该操作符的优先级低于堆栈出口的操作符，就将堆栈出口的操作符导出（pop it）, 直到该操作符的优先级大于堆栈顶端的操作符。将扫描到的操作符导入到堆栈中（push）。
                        Character peek1 = opStack.peek();
                        while(!isGreeter(c,peek1) && !opStack.isEmpty()){
                                strings.add(Character.toString(opStack.pop()));
                                if(!opStack.isEmpty()){
                                    peek1 = opStack.peek();
                                }
                        }
                        opStack.push(c);
                    }
                }
            }
        }
        while(!opStack.isEmpty()){
            strings.add(Character.toString(opStack.pop()));
        }
        return strings;
    }
    //假设只有加减乘除
    //判断a是否大于b
    public static boolean isGreeter(char a ,char b){
        switch (a){
            case '*':
            case '/':
                return b == '-' || b == '+';
            default:
                return false;
        }
    }

    public static boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }

    //======================================================
    //== 后缀表达式求值
    //======================================================
    //计算后缀表达式
    public static double compute(List<String> ls){
        Stack<Double> d = new Stack<Double>();
        for (String s:ls) {
            if(isNumber(s)){
                d.push(Double.parseDouble(s));
            }else{
                 Double pop2 = d.pop();
                 Double pop1 = d.pop();
                 d.push(compute(pop1,pop2,s));
            }
        }
        return d.pop();
    }

    public static double compute(double d1,double d2,String op){
        if ("+".equals(op)) {
            return d1 + d2;
        } else if ("-".equals(op)) {
            return d1 - d2;
        }else if ("*".equals(op)) {
            return d1 * d2;
        }else if ("/".equals(op)) {
            return d1 / d2;
        }else{
            throw new RuntimeException("未知的计算符号");
        }
    }

    public static boolean isNumber(String s){
        for (int i = 0; i < s.length(); i++) {
            // 判断每一个字符是否为数字，如果其中有一个字符不满足，则返回false
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(compute(toSuffixExpress("1+2*3/4-5")));
    }
}
