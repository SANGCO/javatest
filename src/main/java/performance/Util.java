package performance;

public class Util {

    private static Runtime runtime = Runtime.getRuntime();

    public static long printHeap(int index) {
        runtime.gc();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long memoryInUse = totalMemory - freeMemory;
        System.out.printf("%d HEAP:%,d bytes%n", index, memoryInUse);
        return memoryInUse;
    }

}
