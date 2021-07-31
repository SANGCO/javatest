package performance;

public class StringBufferTest1 {

    final static int MAX = 5000 * 1000;

    public static void main(String[] args) {
        Util.printHeap(0);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < MAX; i++) {
            // sb.append('ㄱ');
            // 0 HEAP:1,208,760 bytes
            // 1 HEAP:21,385,904 bytes
            // 2 HEAP:21,385,904 bytes

            sb.append('a');
            // 0 HEAP:1,208,760 bytes
            // 1 HEAP:11,948,720 bytes
            // 2 HEAP:11,948,720 bytes
        }
        Util.printHeap(1);
        Util.printHeap(2);
    }

}
