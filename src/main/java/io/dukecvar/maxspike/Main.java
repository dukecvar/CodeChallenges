package io.dukecvar.maxspike;

public class Main {

    public static void main(String[] args) {
        int maxcond = 100000000;
        for(int size = 10; size <= maxcond ;  size *= 10) {
            for(int maxRange = 10; maxRange <= maxcond ; maxRange *= 10) {
                runForConfig(new TestConfig(size, 0, maxRange, false));
            }
        }

    }

    public static void runForConfig(TestConfig config) {
        int[] testCase = genArray(config);
        if(config.getGenOutput()) {
            printArray(testCase);
        }
        long arrayDuration = runtest(new MaxSpikeByArray(testCase), config);
        long pqDuration = runtest(new MaxSpikeByPriorityQueue(testCase), config);
        System.out.println(config.getSize() + "," + config.getMinRange() + "," + config.getMaxRange() + "," + arrayDuration + "," + pqDuration);

    }

    public static long runtest(MaxSpike maxSpike, TestConfig config) {
        if(config.getGenOutput()) {
            maxSpike.setGenOutput();
        }
        long startTime = System.nanoTime();
        int max = maxSpike.getMaxSpike();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
        return duration;
    }

    public static int[] genArray(TestConfig config) {
        int[] array = new int[config.getSize()];
        for(int i = 0; i < config.getSize(); i++) {
            array[i] = getRandomNumber(config);
        }
        return array;
    }

    public static int getRandomNumber(TestConfig config) {
        return (int) ((Math.random() * (config.getMaxRange() - config.getMinRange())) + config.getMinRange());
    }

    private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++ ) {
            sb.append((i==0?"":",") + array[i]);
        }
        System.out.println(sb.toString());
    }
}
