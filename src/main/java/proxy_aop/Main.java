package proxy_aop;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Multiply twice = new MultiplyImpl();
        Class<? extends Multiply> twiceClass = twice.getClass();
        Multiply proxyInstance = (Multiply) Proxy.newProxyInstance(
            twiceClass.getClassLoader(),
            twiceClass.getInterfaces(),
            new JavaProxyHandler(twice)
        );
        System.out.println(proxyInstance.twice(5));
        System.out.println(proxyInstance.treble(5));
    }

}
