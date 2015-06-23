package com.java.rayed;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Rayed on 23-Jun-15.
 */

public class ProducerConsumer {

    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int SIZE = 5;
    private Object lock = new Object();
    private Random random = new Random();

    public void produce() throws InterruptedException {
        int item = 1;
        while (true) {
            synchronized (lock) {
                while (buffer.size() == SIZE) {
                    System.err.println("Buffer Full! Producer waiting for Consumer to consume ... ");
                    lock.wait();
                }
                System.out.print("Producer produced: " + item);
                buffer.add(item++);
                System.out.println("; Buffer Size: " + buffer.size());
                lock.notify();
            }
            Thread.sleep(random.nextInt(2000));
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (buffer.size() == 0) {
                    System.err.println("Buffer Empty! Consumer waiting for Producer to produce ... ");
                    lock.wait();
                }
                System.out.println("Consumer consumed: " + buffer.removeLast() + "; Buffer Size: " + buffer.size());
                lock.notify();
            }
            Thread.sleep(random.nextInt(2000));
        }
    }
}
