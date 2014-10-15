package testqueue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue.FifoQueue;

public class TestAppendFifoQueue {

    private FifoQueue<Integer> intQueue;
    private FifoQueue<Integer> appendIntQueue;

    @Before
    public void setUp() throws Exception {
        intQueue = new FifoQueue<Integer>();
        appendIntQueue = new FifoQueue<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        intQueue = null;
        appendIntQueue = null;
    }

    @Test
    public void testAppendEmptyQueues() {
        intQueue.append(appendIntQueue);
        assertEquals("Wrong size on intQueue", 0, intQueue.size());
        assertEquals("Wrong size on appending queue", 0, appendIntQueue.size());
    }

    @Test
    public void testAppendEmptyQueue(){
        for(int i = 1; i <= 10; i++){
            intQueue.offer(i);
        }
        intQueue.append(appendIntQueue);
        assertEquals("Wrong size on queue", 10, intQueue.size());
    }

    @Test
    public void testAppendNonEmptyQueue(){
        for(int i = 1; i <= 10; i++){
            appendIntQueue.offer(i);
        }
        intQueue.append(appendIntQueue);
        assertEquals("Wrong size on queue", 10, intQueue.size());
        assertEquals("Wrong size on queue", 0, appendIntQueue.size());
    }

    @Test
    public void testAppendNonEmptyQueues(){
        for(int i = 1; i <= 10; i++){
            intQueue.offer(i);
            appendIntQueue.offer(i);
        }
        intQueue.append(appendIntQueue);
        assertEquals("Wrong size on queue", 20, intQueue.size());
        assertEquals("Wrong size on queue", 0, appendIntQueue.size());
    }

}
