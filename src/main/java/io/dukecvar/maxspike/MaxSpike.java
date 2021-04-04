package io.dukecvar.maxspike;

import java.util.ArrayList;

abstract class MaxSpike {
    private ArrayList<Integer> output = null;

    protected abstract int getMax();
    protected abstract boolean isEmpty();
    public abstract String getName();

    public void setGenOutput() {
        output = new ArrayList<Integer>();
    }

    public String getOutput() {
        if(output == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < output.size(); i++ ) {
            sb.append((i==0?"":",") + output.get(i));
        }
        return sb.toString();
    }

    public int getMaxSpike()  {
        int spikeCount = 1;
        int max = getMax();

        int current[] = new int[2];
        current[0] = max;
        current[1] = max;

        int bigger = 0;
        int smaller = 1;

        spikeOut(smaller, max);

        while(!isEmpty()) {
            max = getMax();
            bigger = current[0] >= current[1] ? 0 : 1;
            smaller = bigger == 0 ? 1 : 0;
            if(current[bigger] > max) {
                current[bigger] = max;
                spikeCount++;
                spikeOut(bigger, max);
            } else if (current[smaller] > max) {
                current[smaller] = max;
                spikeCount++;
                spikeOut(smaller, max);
            //} else {
                // throw it out
            }
        }
        return spikeCount;
    }

    private void spikeOut(int side, int value) {
        if(output != null) {
            if(side == 0) {
                output.add(0, value);
            } else {
                output.add(value);
            }
        }
    }
}
