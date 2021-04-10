package com.lyf.linkedlist;

import java.util.Iterator;

/**
 * @ClassName DoubleLinkedList
 * @Author Kurisu
 * @Description
 * @Date 2021-3-25 00:15
 * @Version 1.0
 **/
public class DoubleLinkedList implements Iterable {
    Node head = new Node(0);
    Node tail = new Node(0);
    int total = 0;

    //add
    void add(Node n){
        Node tmp = head;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        n.pre = tmp;
        tmp.next = n;
        total++;
    }
    //getAll
    void getAll(){
        Node tmp = head.next;
        while (tmp!=null){
            System.out.println(tmp.no);
            tmp = tmp.next;
        }
    }
    //delete
    void delete(Node n){
        Node tmp = head.next;
        while (tmp!=null){
            if(tmp.no == n.no){
                if(tmp.next!=null){
                    tmp.pre.next = tmp.next;
                    tmp.next.pre = tmp.pre;
                }else{
                    tmp.pre.next = null;
                }
                total--;
                break;
            }
            tmp = tmp.next;
        }
    }
    //size
    int size(){
        return total;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        System.out.println(list.size());
        System.out.println("-------------");
//        list.delete(node2);
//        list.getAll();

        Iterator iter = list.iterator();
        while (iter.hasNext()){
            Node n = (Node)iter.next();
            System.out.println(n.no);
        }
    }

    @Override
    public Iterator iterator() {
        return new myIter();
    }

    public class myIter implements Iterator<Node>{
        Node tmp = head.next;
        Node last = null;
        @Override
        public boolean hasNext() {
            return tmp!=null;
        }

        @Override
        public Node next() {
            last = tmp;
            tmp = tmp.next;
            return last;
        }
    }
    static class Node {
        int no;
        Node pre;
        Node next;

        public Node(int no) {
            this.no = no;
        }
    }
}


