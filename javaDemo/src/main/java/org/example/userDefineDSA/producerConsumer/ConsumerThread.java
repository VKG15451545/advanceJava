package org.example.userDefineDSA.producerConsumer;

public class ConsumerThread implements Runnable{

     Company cp;
     ConsumerThread(Company c){
         this.cp = c;
     }
    @Override
    public void run() {
         int i=1;
        while (true){
            try {
                cp.consume(i);i++;
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }
}
