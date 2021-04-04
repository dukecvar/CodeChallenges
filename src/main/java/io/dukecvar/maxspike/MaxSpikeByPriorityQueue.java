package io.dukecvar.maxspike;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxSpikeByPriorityQueue extends MaxSpike {
    private final String NAME = "Max Spike by Priority Queue";
    private PriorityQueue<Integer> maxheap = null;
    private ArrayList<Integer> spikeOutput = null;

    public MaxSpikeByPriorityQueue(int [] array) {
        super();

        maxheap = new PriorityQueue<>(
                array.length, (x, y) -> Integer.compare(y, x));
        for(int i : array) {
            maxheap.add(i);
        }
    }

    protected int getMax() {
        return maxheap.remove();
    }

    protected boolean isEmpty() {
        return maxheap.isEmpty();
    }

    public String getName() {
        return NAME;
    }
}
