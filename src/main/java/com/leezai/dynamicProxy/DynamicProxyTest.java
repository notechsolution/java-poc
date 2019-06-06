package com.leezai.dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        Programmer programmer = new ProgrammerImpl();
        LoggerInvocationHandler invocationHandler = new LoggerInvocationHandler(programmer);

        Programmer proxyProgrammer =
            (Programmer) Proxy.newProxyInstance(Programmer.class.getClassLoader(), programmer.getClass().getInterfaces(),
                invocationHandler);

        proxyProgrammer.code();

        proxyProgrammer.debug();
    }
}
