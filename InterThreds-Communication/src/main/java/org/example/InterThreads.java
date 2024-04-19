package org.example;
class Q{//pass wena num eka store krganna
    int num;
    boolean valueSeted = false;
    //IllegalMonitorStateException error ekak enwa syncronized dmme nththn mna state ekad kiyla hoyagnna ba
    public synchronized void put(int num) {//set krnwa
        while (valueSeted){
            try {//wait eka nththn gththda kh,d kiyla idea ekk na ohe print wenwa
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //wait eka ththn hri order ekta run wen na
        System.out.println("Put : " +num);
        this.num = num;
        valueSeted = true;
        notify();
    }
    public synchronized void get() {
        while (!valueSeted){//put ekedi true krla thiyenne
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Get : " +num);
        valueSeted = false;
        notify();   //return num;
    }

}
class Producer implements Runnable{
    Q q;//num ekata access krnna one nisa eken objet ekak gnnwa
    public Producer (Q q){
        this.q = q;
        Thread t = new Thread(this,"Producer");
        t.start();//constructor eke hduwama object eka create weddima start wenwa
    }
    @Override
    public void run() {
        int i = 0;
        while (true){
            q.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Consumer implements Runnable{
    Q q;
    public Consumer (Q q){
        this.q = q;
        Thread t = new Thread(this,"Consumer");
        t.start();//constructor eke hduwama object eka create weddima start wenwa
    }
    @Override
    public void run() {
        int i = 0;
        while (true){
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class InterThreads {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
