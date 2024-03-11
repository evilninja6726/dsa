package com.dsagame.gfgselfpaced.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfAllSubArrayOfSizeK {
    public static void main(String[] args) {

    }


    //[1,3,-1,-3,5,3,6,7], k = 3
    public static int[] max(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i=0;i<k;i++){
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int x=0;
        for (int i=k;i<nums.length;i++){
            res[x++]=nums[deque.peek()];
            while (!deque.isEmpty()&&deque.peek()<=i-k){
                deque.pollFirst();
            }
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res[x++]=nums[deque.peek()];
        return res;
    }
}
