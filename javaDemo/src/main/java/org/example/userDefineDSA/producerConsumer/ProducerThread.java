package org.example.userDefineDSA.producerConsumer;

public class ProducerThread implements Runnable{

    Company n;
    ProducerThread(Company n){
        this.n = n;
    }
    @Override
    public void run() {
        int i=1;
        while (true){
            try {
                n.produce(i);i++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
