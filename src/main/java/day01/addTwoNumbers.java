package day01;

import javax.lang.model.element.VariableElement;

/**
 * @ClassName addTwoNumbers
 * @Author Kurisu
 * @Description
 * @Date 2021-3-24 19:15
 * @Version 1.0
 **/
public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node3;
        addTwoNumbers(node1,node2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode cur = null;

        Boolean flag = false;
        int val1 = 0;
        int val2 = 0;
        int total = 0;
        while(l1!=null||l2!=null){
            if(l1==null){
                val1 = 0;
            }else{
                val1 = l1.val;
            }

            if(l2==null){
                val2 = 0;
            }else{
                val2 = l2.val;
            }

            if(flag){
                total = val1 + val2 + 1;
                flag = false;
            }else{
                total = val1 + val2;
            }

            if(total>=10){
                flag = true;
            }
            if(sum == null){
                sum = cur = new ListNode(total%10);
            }else{
                cur.next = new ListNode(total%10);
                cur = cur.next;
            }
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return sum;
    }

 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
