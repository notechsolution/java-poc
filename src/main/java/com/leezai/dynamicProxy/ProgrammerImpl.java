package com.leezai.dynamicProxy;

public class ProgrammerImpl implements Programmer {
    @Override
    public void code() {
        System.out.println("I am coding");
    }

    @Override
    public void debug() {
        System.out.println("I am debugging");
    }
}
