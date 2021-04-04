package io.dukecvar.maxspike;

public class TestConfig {
    private int size;
    private int minRange;
    private int maxRange;
    private boolean genOutput;

    public TestConfig(int size, int minRange, int maxRange, boolean genOutput) {
        this.size = size;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.genOutput = genOutput;
    }

    public int getSize() {
        return size;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public boolean getGenOutput() { return genOutput; }
}
