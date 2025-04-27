package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author 佳叙
 * @date 2025/4/26
 * @description <a href=""/>
 */
public class _AQS {

    public static void main(String[] args) {

        new AbstractQueuedSynchronizer();

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>();
        queue.offer();
        queue.poll();

    }

}