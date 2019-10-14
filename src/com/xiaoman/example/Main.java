package com.xiaoman.example;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
//        main.maoPao();
//        main.xuanZe();
//        main.insert();
//        main.stack();
//        main.stackStrus();
//        main.changeChart();
        main.heterotopicWord();
    }

    private void maoPao() {
        int[] srcValue = new int[]{1, 11, 1, 1, 1, 1, 1, 5, 1, 6, 1, 76, 1, 7, 81, 62, 8, 2, 9687, 235};
        int index = srcValue.length - 1;
        int count = 0;
        // 控制循环次数
        for (int j = 0; j < srcValue.length; j++) {
            // 比较大小
            // 后面的值，比前面的大，不交换，继续向前比较
            // 后面的值，比千面的小，交换数据，继续向前比较
            for (int i = index; i > 0; i--) {
                int indexValue = srcValue[i];
                if (indexValue < srcValue[i - 1]) {
                    int temp = srcValue[i - 1];
                    srcValue[i - 1] = indexValue;
                    srcValue[i] = temp;
                }
                count++;
            }
        }
        System.out.println("长度： " + srcValue.length + "  次数： " + count);
        System.out.println("冒泡排序：" + Arrays.toString(srcValue));
    }


    private void xuanZe() {
        int[] srcValue = new int[]{1, 11, 1, 1, 1, 1, 1, 5, 1, 6, 1, 76, 1, 7, 81, 62, 8, 2, 9687, 235};
        int arrayLength = srcValue.length;
        int count = 0;
        for (int i = 0; i < arrayLength; i++) {
            // 选择一个当前值，并与后面的值逐一比对大小，大，呼唤，小继续，知道找到后续数字中的最小值，并记录索引
            // 找到最小值后，将最小值与但前值互换位置
            int min = srcValue[i];
            int minIndex = i;
            for (int j = i; j < arrayLength; j++) {
                if (srcValue[j] < min) {
                    min = srcValue[j];
                    minIndex = j;
                }
                count++;
            }
            srcValue[minIndex] = srcValue[i];
            srcValue[i] = min;
        }
        System.out.println("次数： " + count);
        System.out.println("选择排序：" + Arrays.toString(srcValue));
    }

    private void insert() {
        int[] srcValue = new int[]{1, 11, 1, 1, 1, 1, 1, 5, 1, 6, 1, 76, 1, 7, 81, 62, 8, 2, 9687, 235};

        int count = 0;
        for (int j = 1; j < srcValue.length; j++) {

            for (int i = j; i > 0; i--) {
                count++;
                if (srcValue[i] < srcValue[i - 1]) {
                    int temp = srcValue[i];
                    srcValue[i] = srcValue[i - 1];
                    srcValue[i - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println("次数： " + count);
        System.out.println("插入排序：" + Arrays.toString(srcValue));
    }

    private void stack() {
        int[] srcValue = new int[]{1, 11, 1, 1, 1, 1, 1, 5, 1, 6, 1, 76, 1, 7, 81, 62, 8, 2, 9687, 235};

        System.out.println("原始排序：" + Arrays.toString(srcValue));
        int heapSize = srcValue.length - 1;

        // 先建立父节点
        // 分别获取左侧和右侧节点
        for (int i = 0; i < heapSize / 2; i++) {
            maxStack(srcValue, i);
        }
        System.out.println("大堆顶数：" + Arrays.toString(srcValue));

        for (int i = heapSize; i > 0; i--) {
            swrap(srcValue, 0, i);
            System.out.println("交换结果：" + Arrays.toString(srcValue));
            maxStack(srcValue, heapSize - i);
            System.out.println("重排结果：" + Arrays.toString(srcValue));
        }

        System.out.println("堆列排序：" + Arrays.toString(srcValue));

    }

    private void swrap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void maxStack(int[] srcValue, int i) {
        int father;
        int leftChild;
        int rightChild;
        father = srcValue[i];
        if (getLeft(i) > srcValue.length || getRight(i) >= srcValue.length) {
            return;
        }
        leftChild = srcValue[getLeft(i)];
        rightChild = srcValue[getRight(i)];
        if (Math.max(father, Math.max(rightChild, leftChild)) == leftChild) {
            srcValue[i] = leftChild;
            srcValue[getLeft(i)] = father;
            jiaohuan(srcValue, i);
        } else if (Math.max(father, Math.max(rightChild, leftChild)) == rightChild) {
            srcValue[i] = rightChild;
            srcValue[getRight(i)] = father;
            jiaohuan(srcValue, i);
        }

    }

    private void jiaohuan(int[] srcValue, int i) {
        if (i > 0) {
            if (i % 2 == 0) {
                maxStack(srcValue, i / 2 - 1);
            } else {
                maxStack(srcValue, i / 2);
            }
        }
    }

    private int getLeft(int i) {
        return i * 2 + 1;
    }

    private int getRight(int i) {
        return i * 2 + 2;
    }

    private void changeChart() {
        String str = "Hello World!哈";
        char[] c = str.toCharArray();
        int cur1 = 0;
        int cur2 = c.length - 1;
        do {
            char temp = c[cur1];
            c[cur1] = c[cur2];
            c[cur2] = temp;
            cur1++;
            cur2--;
        } while (cur1 < cur2);
        System.out.println(cur1);
        System.out.println(Arrays.toString(c));
    }

    private void heterotopicWord() {
        String s = "cawr";
        String t = "vrrr";
        int[] conut = new int[26];
        char a = 'a';
        for (char c : s.toCharArray()) {
            conut[c - a] += 1;
        }
        for (char c : t.toCharArray()) {
            conut[c - a] -= 1;
        }
        for (int i : conut) {
            if (i != 0) {
                System.out.println(false);
                break;
            }
        }
    }

    private void stackStrus() {
        int[] array = new int[]{23, 25, 21, 19, 22, 26, 23};

        Stack<Integer> stack = new Stack<>();

        int[] day = new int[array.length];

        for (int cur = 0; cur < array.length; cur++) {

            if (stack.size() == 0) {
                stack.push(cur);
            } else {
                int stackSize = stack.size();
                for (int i1 = 0; i1 < stackSize; i1++) {
                    int pre = stack.pop();
                    if (array[cur] > array[pre]) {
                        day[pre] = cur - pre;
                    } else {
                        stack.push(pre);
                        break;
                    }
                }
                stack.push(cur);
            }

        }
        System.out.println(Arrays.toString(day));
    }


}
