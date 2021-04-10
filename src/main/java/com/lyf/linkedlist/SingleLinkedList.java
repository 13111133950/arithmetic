package com.lyf.linkedlist;

/**
 * @ClassName SingleLinkedList
 * @Author Kurisu
 * @Description
 * @Date 2021-3-24 23:17
 * @Version 1.0
 **/
public class SingleLinkedList {
    //不能移动  方便遍历使用
    Node head = new Node(0);
    int total = 0;

    //add
    void add(Node n){
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = n;
        total++;
    }
    //delete
    boolean delete(Node n){
        Node temp = head;
        boolean flag = false;
        while (temp.next!=null){
            if(temp.next.no == n.no){
                if(temp.next.next!=null){
                    temp.next = temp.next.next;
                }else{
                    temp.next = null;
                }
                flag = true;
                total--;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }
    //update

    //getAll
    void getAll(){
        Node temp = head.next;
        while (temp!=null){
            System.out.println(temp.no+">>>>");
            temp=temp.next;
        }
    }
    //size
    int size(){
        return total;
    }
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        System.out.println(list.size());
        System.out.println("-------------");
        list.delete(node2);
        list.getAll();

    }


    static class Node{
        int no;
        Node next;

        public Node(int no) {
            this.no = no;
        }
    }

}


