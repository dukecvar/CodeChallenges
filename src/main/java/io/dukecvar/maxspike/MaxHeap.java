package io.dukecvar.maxspike;

/**
 * Limited functionality max heap
 * Only constructor takes an array which is assumed to be
 * initially unsorted, modifiable (it is not copied), and zero based.
 * No insert method; initial array is fixed to keep processing fast.
 *
 * @author duke
 */
public class MaxHeap {
    int[] heap;
    int size = 0;

    public MaxHeap(int[] array) {
        heap = array;
        size = heap.length;
        heapify();
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    // This does not have array out of bounds safety;
    // use in conjunction with isEmpty
    public int popMax() {
        int max = heap[0];
        size--;
        swap(0, size);
        heapify(0);
        return max;
    }

    //
    // private helpers
    //

    private int parent(int node) {
        return (node > 0 ? (node-1)/2 : 0);
    }

    private int leftChild(int node) {
        // for array starting at index=1: return node * 2;
        return ( (node+1) * 2) - 1;
    }

    private int rightChild(int node) {
        // for array starting at index=1: return node * 2 + 1;
        return (node + 1) * 2;
    }

    private boolean isLeaf(int node) {
        int leafStart = (size + 1) / 2;
        boolean isleaf = (node >= leafStart);
        return isleaf;
    }

    private void swap(int node1, int node2) {
        int tmp = heap[node1];
        heap[node1] = heap[node2];
        heap[node2] = tmp;
    }

    private void heapify() {
        //iterate down
        for(int i = 1; i < size; i++) {
            int idx = i;
            //bubble up
            while(idx > 0 && heap[idx] > heap[parent(idx)]) {
                swap(idx, parent(idx));
                idx = parent(idx);
            }
        }
    }

    private void heapify(int node) {
        if ( isLeaf(node) ) {
            return;
        }
        int leftPos = leftChild(node);
        int rightPos = rightChild(node);
        if( (leftPos < size && heap[leftPos] > heap[node])
                || (rightPos < size && heap[rightPos] > heap[node]) ) {
            if(rightPos < size && heap[leftPos] <= heap[rightPos]) {
                swap(node, rightPos);
                heapify(rightPos);
            } else {
                swap(node, leftPos);
                heapify(leftPos);
            }
        }
    }
}