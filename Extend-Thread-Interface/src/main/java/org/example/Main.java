package org.example;

public class Main {
    public static void main(String[] args) {
        One obj1 = new One();
        Two obj2 = new Two();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //methna naththath aulk wen na
        t2.start();
    }
}