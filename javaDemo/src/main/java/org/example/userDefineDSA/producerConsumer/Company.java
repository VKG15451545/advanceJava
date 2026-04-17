package org.example.userDefineDSA.producerConsumer;

public class Company {
    int n;
    boolean b=true;
    synchronized int produce(int n) throws InterruptedException {
        if(!b){
            wait();
        }
        System.out.println("producer produces: "+n);
        b = false;
        notify();
        return n;
    }
    synchronized void consume(int n) throws InterruptedException{
        if(b){
            wait();
        }
        System.out.println("consumer consumes: "+n);
        b = true;
        notify();
        StringBuilder sb = new StringBuilder();

    }

}
