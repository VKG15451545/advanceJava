package org.example.userDefineDSA.producerConsumer;

public class ProducerConsumerExample {

    static void main(String[] args) {
        Company company = new Company();
        ProducerThread p = new ProducerThread(company);
        ConsumerThread c = new ConsumerThread(company);
        Thread pt = new Thread(p);
        Thread ct = new Thread(c);
        pt.start();
        ct.start();
    }
}
