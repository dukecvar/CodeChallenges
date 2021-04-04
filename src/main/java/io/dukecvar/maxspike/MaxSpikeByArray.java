package io.dukecvar.maxspike;

import java.util.ArrayList;

public class MaxSpikeByArray extends MaxSpike {
    private final String NAME = "Max Spike by Array";
    private MaxHeap maxheap = null;
    private ArrayList<Integer> spikeOutput = null;


    public MaxSpikeByArray(int [] array) {
        super();
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        maxheap = new MaxHeap(copy);
    }

    public MaxSpikeByArray(int [] array, boolean dontcopy) {
        super();
        maxheap = new MaxHeap(array);
    }

    protected int getMax() {
        return maxheap.popMax();
    }

    protected boolean isEmpty() {
        return maxheap.isEmpty();
    }

    public String getName() {
        return NAME;
    }
}