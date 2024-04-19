package org.example;

public class ImplemetMyRunable {
    public static void main(String[] args) {
        //create an instance o myrunable
        MyRunable myRunable = new MyRunable();
        //create thread object passing the instance of myrunnable to its constructor
        Thread thread = new Thread(myRunable);
        //start the thread
        thread.start();
    }
}
