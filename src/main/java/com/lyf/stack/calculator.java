package com.lyf.stack;

import java.util.Stack;

/**
 * @ClassName calculator
 * @Author Kurisu
 * @Description
 * @Date 2021-3-25 10:53
 * @Version 1.0
 **/
public class calculator {
    private static Stack<Integer> intStack = new Stack<>();
    private static Stack<String> symbolStack = new Stack<>();

    static int calculate(String exp){
        int result = 0;
        String[] strings = exp.split(" ");
        for (String s : strings) {
            switch (s){
                case "+":
                case "-":
                case "*":
                case "/":
                    if(needCalcu(s)){
                        Integer b = intStack.pop();
                        intStack.push(calcu(intStack.pop(),symbolStack.pop(),b));
                    }
                    symbolStack.push(s);
                    break;
                default:
                    intStack.push(Integer.parseInt(s));
            }
        }
        while (!symbolStack.empty()){
            Integer b = intStack.pop();
            intStack.push(calcu(intStack.pop(),symbolStack.pop(),b));
        }

        return intStack.pop();
    }

    static int calcu(int a , String symbol ,int b){
        if("+".equals(symbol)){
            return a + b;
        }else if("-".equals(symbol)){
            return a - b;
        }else if("*".equals(symbol)){
            return a * b;
        }else{
            return a / b;
        }
    }

    static boolean needCalcu(String symbol){
        if(!symbolStack.empty()){
            if(getPriority(symbolStack.peek())>=getPriority(symbol)){
                return true;
            }
        }
        return false;
    }

    static int getPriority(String symbol){
        if("*".equals(symbol) || "/".equals(symbol)){
            return 2;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
        String exp = "2 * 2 + 3 - 5 + 3 * 5 + 1";
        System.out.println(calculate(exp));

    }
}
