package performance;

public class StringBufferTest2 {

    final static int MAX = 5000 * 1000;

    public static void main(String[] args) {
        Util.printHeap(0);
        StringBuffer sb = new StringBuffer(MAX);

        for (int i = 0; i < MAX; i++) {
            sb.append('a');
        }
        Util.printHeap(1);
        Util.printHeap(2);
    }

}
