package proxy_aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JavaProxyHandler implements InvocationHandler {

    private Object target;

    public JavaProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("메소드 시작");
        int result = (int) method.invoke(target, args);
        System.out.println("메소드 끝");
        return result;
    }
}
