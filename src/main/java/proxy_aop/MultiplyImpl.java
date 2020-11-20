package proxy_aop;

public class MultiplyImpl implements Multiply {

    @Override
    public int twice(int x) {
        return x * 2;
    }

    @Override
    public int treble(int x) {
        return x * 3;
    }
}
