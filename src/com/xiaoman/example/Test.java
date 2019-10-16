package com.xiaoman.example;

import java.util.Arrays;
import java.util.Stack;

import static com.xiaoman.example.util.MathUtil.rangInt;

public class Test {

    public static void main(String[] args) {
        // write your code here
        Test test = new Test();
//        main.maoPao();
//        main.xuanZe();
//        main.insert();
//        main.stack();
//        test.stackStrus();
//        main.changeChart();
//        test.heterotopicWord();
        test.sort(2, 1, 7, 9, 5, 8);
    }


    private void sort(int... nums) {
//        System.out.println(Arrays.toString(nums));
        boolean changed = true;
        // 每轮遍历开始，将 changed 设置为 false
        // 冒泡
//        for (int i = 0; i < nums.length - 1 && changed; i++) {
//            changed = false;
//            for (int j = 0; j < nums.length - 1 - i; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    swap(nums, j, j + 1);
//                    changed = true;
//                }
//            }
//        }

        // 插入


//        for (int i = 1, k, current; i < nums.length; i++) {
//            current = nums[i];
//            for (k = i - 1; k >= 0 && nums[k] > current; k--) {
//                nums[k + 1] = nums[k];
//            }
//            nums[k + 1] = current;
//        }

        // 归并
        int low = 0, high = nums.length - 1;
//        System.out.println(Arrays.toString(nums));
//        sort(nums, low, high);
        sortQuick(nums, low, high);
        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(hebing()));
    }


    // 选择排序
    // 遍历，选择一个最小值的索引，并将数据插入到最前
    private void xuanze(int[] nums) {

        // 外循环处理数据的交换
        for (int i = 0; i < nums.length; i++) {
            // 设定第一个值为最小值，获取其索引
            int minIndex = i;
            // 内循环处理寻找最小值索引的过程,默认第一个值为最小值，内部循环直接从数组的第二个值开始做
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (nums[i] > nums[minIndex]) {
                swap(nums, i, minIndex);
            }
        }

        System.out.println(Arrays.toString(nums));

    }


    public int[] hebing() {
        int[] A = new int[]{6, 1, 2, 5};
        int[] B = new int[]{3, 7, 4, 9, 8};
        int[] retValue = new int[A.length + B.length];


        // 两个有序数组的排序
        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;

        for (int i = 0, j = 0, k = 0; i < retValue.length; i++) {
            if (j >= A.length) {
                retValue[i] = B[k++];
            } else if (k >= B.length) {
                retValue[i] = A[j++];
            } else if (A[j] < B[k]) {
                retValue[i] = A[j++];
            } else {
                retValue[i] = B[k++];
            }
            count++;
        }
        System.out.println(count);
        return retValue;
    }

    private void sortQuick(int[] nums, int low, int high) {

        // 只剩下一个元素
        if (low >= high) return;


        int basePoint = basePoint(nums, low, high);
        System.out.println(basePoint);
        sortQuick(nums, low, basePoint - 1);
        sortQuick(nums, basePoint + 1, high);

        System.out.println(Arrays.toString(nums));

    }

    private int basePoint(int[] nums, int low, int high) {

        //  test.sort(6, 2, 1, 7, 9, 5, 8);
        // 随机选择一个中间值，遍历数组，将比中间值小的数，放在左边，大的数放在右边
        swap(nums, rangInt(high, low), high); // 将 high 替换为基准值
        int i = low, j = low;
        for (; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, j);
        return i;
    }


    // 需要用到递归思想
    // 使用递归，需要注意终止值的判断
    private void sort(int[] nums, int low, int high) {
        // 判断是否是最后一个元素（数组中，只有一个元素）
        if (low >= high) return;
        // 从中间将数组分为两个部分
        int mid = (low + high) / 2;
        // 分别递归将左右两半排序好
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        // 将排序好的左右两半合并
        merge(nums, low, high, mid);
    }

    private void merge(int[] nums, int start, int length, int mid) {
        // 复制一份原来的数组,用来处理数据交换，否则会出现错误
        int[] copy = nums.clone();
        // 定义一个 index 指针，表示从什么位置开始修改原来的数组，
        // left 指针表示左半边的起始位置，right 表示右半边的起始位置
        int index = start, left = start, right = mid + 1;

        while (index <= length) {
            if (left > mid) { // 左侧已经合并完成， 将右侧数据直接写入到后续数组中，并自加索引
                nums[index++] = copy[right++];
            } else if (right > length) { // 左侧合并完成，将右侧数据直接写入到后续数组中
                nums[index++] = copy[left++];
            } else if (copy[right] < copy[left]) { // 右侧起始值比左侧数值小，将右侧数值交换到左侧顺序位置
                nums[index++] = copy[right++];
            } else {// 左侧值比右侧值小，写入对应顺序中
                nums[index++] = copy[left++];
            }
        }
    }


    public void swap(int[] nums, int src, int des) {
        int temp = nums[src];
        nums[src] = nums[des];
        nums[des] = temp;
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
                    int pre = stack.peek();
                    System.out.println(pre);
                    if (array[cur] > array[pre]) {
                        day[pre] = cur - pre;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(cur);
            }

        }
        System.out.println(Arrays.toString(day));
    }


}
