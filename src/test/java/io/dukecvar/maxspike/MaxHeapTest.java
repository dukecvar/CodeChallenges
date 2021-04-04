package io.dukecvar.maxspike;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    int[] initHeap = new int[]{3, 9, 6, 8, 1, 2, 7, 4};

    @Test
    void heapTest() {
        int[] arr = getInitialArrayCopy();
        System.out.println(arrayToString(arr));
        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println(arrayToString(arr));

        int max = maxHeap.popMax();
        int next = 0;
        while(!maxHeap.isEmpty()) {
            next = maxHeap.popMax();
            Assertions.assertTrue(max > next);
            max = next;
        }
    }


    // test helpers

    int[] getInitialArrayCopy() {
        int[] copy = new int[initHeap.length];
        System.arraycopy(initHeap, 0, copy, 0, initHeap.length);
        return copy;
    }

    void popPrint(MaxHeap maxHeap) {
        System.out.print("max: " + maxHeap.popMax() + " --> ");
        print(maxHeap);
    }

    void print(MaxHeap maxHeap) {
        System.out.println(maxHeap.toString());
    }

    String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            sb.append((i==0?"":",") + array[i]);
        }
        return "[" + sb.toString() + "]";
    }

}