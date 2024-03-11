package com.dsagame.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    // intervals = [[1,3],[6,9]], newInterval = [2,5]

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 7}));

        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("person1", "25000", "54"));

        List<Employee> x = employee.stream().filter(e -> Integer.parseInt(e.getSalary()) >= 25000).collect(Collectors.toList());
    }

    public static List<List<Integer>> solution(int[][] arr, int[] newInterval) {
        if (arr.length == 0) {
            new ArrayList<>();
        }
        // intervals = [[1,3],[6,9]], newInterval = [2,7]
        List<List<Integer>> res = new ArrayList<>();
        int a = newInterval[0];
        int b = newInterval[1];
        if (b < arr[0][0]) {
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            res.add(list);
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(arr[i][0]);
                list1.add(arr[i][1]);
                res.add(list1);
            }
            return res;
        } else if (a > arr[arr.length - 1][1]) {
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(arr[i][0]);
                list1.add(arr[i][1]);
                res.add(list1);
            }
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            res.add(list);
            return res;
        }

        // intervals = [[1,3],[6,9]], newInterval = [2,7]


        /*intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]       3,8
                [[1,2],[3,10],[12,16]]
*/

        int start = 0;
        int end = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (!flag) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(arr[i][0]);
                list1.add(arr[i][1]);
                res.add(list1);
            }
            while (b <= arr[i][1] && b >= arr[i][0]) {
                start = Math.min(arr[i][0], a);
                end = Math.max(b, arr[i][1]);
                flag = true;
                i++;
            }
            List<Integer> list = new ArrayList<>();
            list.add(start, end);
            res.add(list);
            flag = !flag;
        }
        return res;
    }


}


class Employee {
    String name;
    String salary;
    String age;

    public Employee(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}