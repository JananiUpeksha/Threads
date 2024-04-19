package org.example;

public class One extends Thread {
    public void run(){
        for (int i = 1; i<=5; i++){
            System.out.println("One");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
