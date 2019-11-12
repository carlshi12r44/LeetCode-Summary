package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class maxHeap {
    /*
    * Get K smallest elements from an array
    * Using maxHeap and visualize the numbers sitting inside Heap
    * */

    public int getKSmallest(int[] arr, int k) {
        // construct max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));

        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }


        return heap.poll();
    }

    public int getKLargestMinHeap(int[] arr, int k) {
        // construct min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9 ,11, 18, 20, 25};

        int k = 3;

        maxHeap test = new maxHeap();

        System.out.print(test.getKLargestMinHeap(array, k));
    }
}
