package com.dsagame.gfgselfpaced.linkedlist;

import java.util.HashSet;

public class IntersectionPoint {
    public static void main(String[] args) {
        SLNode list1 = new SLNode(10);
        list1.next = new SLNode(20);
        list1.next.next = new SLNode(30);
        SLNode list2 = new SLNode(40);
        list2.next = new SLNode(50);
        list2.next.next = list1;
        list1 = intersect(list1, list2);
        while (list1 != null) {
            System.out.println(list1.data + " ");
            list1 = list1.next;
        }
    }

    public static SLNode intersect(SLNode list1, SLNode list2) {
        HashSet<SLNode> hashSet = new HashSet<>();
        while (list1 != null) {
            hashSet.add(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            if (hashSet.contains(list2)) {
                return list2;
            }
            list2 = list2.next;
        }
        return null;
    }

    public static SLNode intersectEff(SLNode list1, SLNode list2) {
        int l1 = 0;
        int l2 = 0;
        SLNode curr1 = list1;
        SLNode curr2 = list2;
        while (curr1 != null) {
            l1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            l2++;
            curr2 = curr2.next;
        }
        curr1 = list1;
        curr2 = list2;
        int diff = Math.abs(l1 - l2);
        if (l1 > l2) {
            for (int i = 0; i < diff; i++) {
                curr1 = curr1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                curr2 = curr2.next;
            }
        }
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }
}
