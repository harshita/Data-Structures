/**
 * Created with IntelliJ IDEA.
 * User: Harshita Karande
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

    private static final int QUEUE_SIZE = 5;
    private static final int PRODPOOL_SIZE = 5;
    private static final int CONSPOOL_SIZE = 5;
    private static final AtomicInteger messagesConsumed = new AtomicInteger(0);

    //Create thread pool for producer and consumer using Executor Service
    private static final ExecutorService producerThreadPool = Executors.newFixedThreadPool(PRODPOOL_SIZE);
    private static final ExecutorService consumerThreadPool = Executors.newFixedThreadPool(CONSPOOL_SIZE);

    public static void main(String args[]) {
        BlockingQueue<String> newQueue = new ArrayBlockingQueue<String>(QUEUE_SIZE);
        ProducerConsumer pc = new ProducerConsumer();

        //Add n unique messages using producer thread pool
        //The number of messages to add is passed as a program argument
        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            producerThreadPool.execute(pc.new ProducerHandler(newQueue, "message "+i));
        }
        producerThreadPool.shutdown();

        for (int i = 0; i < CONSPOOL_SIZE; i++) {
            consumerThreadPool.execute(pc.new ConsumerHandler(newQueue, messagesConsumed));
        }
        consumerThreadPool.shutdown();
        try{
            consumerThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }

        System.out.println(" total messages consumed so far: "+messagesConsumed);

    }

    public class ProducerHandler implements Runnable {

        private final BlockingQueue<String> queue;
        private String message;

        public ProducerHandler(BlockingQueue<String> queue, String message) {
            this.queue = queue;
            this.message = message;
        }

        // Producer thread adds a message to the queue
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " Adding message :" + message);
                queue.put(message);
            }
            catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }

        }

    }

    public class ConsumerHandler implements Runnable {
        private final BlockingQueue<String> queue;
        private final AtomicInteger messagesConsumed;

        public ConsumerHandler(BlockingQueue<String> queue, AtomicInteger messagesConsumed) {
            this.queue = queue;
            this.messagesConsumed = messagesConsumed;
        }

        //Consumer thread reads a message from the queue and increments the messageConsumed counter
        public void run() {
            try {
                while (!queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName()+" Taking out message: "+ queue.poll());
                    messagesConsumed.getAndIncrement();
                }
            }
            catch (Exception ie) {
                System.err.println(ie.getMessage());
            }

        }
    }
}


