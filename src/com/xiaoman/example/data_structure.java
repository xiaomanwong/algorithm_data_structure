package com.xiaoman.example;

import org.w3c.dom.NodeList;

import java.util.*;

public class data_structure {


    public static void main(String[] args) {
        data_structure data = new data_structure();
//        int k = 2;
//        ListNode head = new ListNode();
//        for (int i = 0; i < 5; i++) {
//            head.data = 0;
//            head.next = new ListNode(i);
//        }
//        ListNode listNode = data.reverseKGroup(head, k);
//        System.out.println("ssssssssssssssss");
        data.charCompare();
    }


    private void charCompare() {
        String s = "[";
        Stack<Character> characters = new Stack<>();

        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map;
        map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    System.out.println(false);
                }
            } else {
                stack.push(c);
            }
        }

        System.out.println(stack.isEmpty());
    }



    /**
     * 链表的测试
     *
     * @param head
     * @param k
     */
    private ListNode reverseKGroup(ListNode head, int k) {

//        NodeList
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            // 递归调用
            if (next != null) {
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup(next, k);
            }
            // prev 为链表翻转后的头结点
            return prev;
        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
        }
    }


}
