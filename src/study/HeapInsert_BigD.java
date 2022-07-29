package study;

import java.util.PriorityQueue;

/**
 * @ClassName study.HeapInsert_BigD
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/8 9:49
 * @Version 1.0
 */
public class HeapInsert_BigD {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 6, 2, 9, 10, 2};
//        getBig(a);
//        heapify(a, 0, a.length);
        heapSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    // 堆排序
    public static void heapSort(int[] a) {
        if(a == null || a.length < 2) {
            return;
        }
//        getBig(a);
        for (int i = a.length - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }
        int heapSize = a.length;
        swap(a, 0, --heapSize);

        while (heapSize > 0) {
            heapify(a, 0, heapSize);
            swap(a, 0, --heapSize);
        }
    }

    public static void getBig(int[] a) {
        for (int i = 0; i < a.length; i++) {
            heapInsert(a, i);
        }
    }

    // 大在下要往上
    private static void heapInsert(int[] a, int index) {
        while (index > 0 && a[index] > a[(index-1) >> 1]) {
            swap(a, index, (index-1) >> 1);
            index = (index-1) >> 1;
        }
    }

    private static void swap(int[] a, int index, int after) {
        a[index] = a[index] ^ a[after];
        a[after] = a[index] ^ a[after];
        a[index] = a[index] ^ a[after];
    }

    // 小在上，获得大根堆
    public static void heapify(int[] a, int index, int heapSize) {
        int left = (index << 1) + 1;    // 左孩子下表
        while (left < heapSize) {    // 下方还有孩子的时候，左孩子下标小于右孩子，如果没有左孩子，那么一定没有有孩子
            // 两个孩子中，谁的直达，把下标给谁，left + 1就是右孩子的下标
            int largest = left + 1 < heapSize && a[left + 1] > a[left] ? left + 1 : left;

            // 父亲和孩子之间，谁的值答，把下标给largest
            largest = a[largest] > a[index] ? largest : index;
            if(index == largest) {
                break;
            }
            swap(a, index, largest);
            index = largest;
            left = (index << 1) + 1;
        }
    }
}
