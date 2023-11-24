package at.fhhagenberg.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RingBufferStateTest {
    @Test
    public void testDeleteEmpty(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());
    }
    
    @Test
    public void testCapacityZeroEnqueue(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(0);
        assertTrue(ringBuffer.isEmpty());
        assertTrue(ringBuffer.isFull());

        assertThrows(IndexOutOfBoundsException.class, () -> ringBuffer.enqueue(1));
    }

    @Test
    public void testDequeueEmptyBuffer(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());

        assertThrows(RuntimeException.class, () -> ringBuffer.dequeue());
    }

    @Test
    public void testCapacityOneEnqueueTwice(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1);
        assertTrue(ringBuffer.isEmpty());
    
        ringBuffer.enqueue(1);
        assertTrue(ringBuffer.isFull());

        ringBuffer.enqueue(2);
        assertTrue(ringBuffer.isFull());
    }

    @Test
    public void testCapacityOneEnqueueDequeue(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1);
        assertTrue(ringBuffer.isEmpty());
    
        ringBuffer.enqueue(1);
        assertTrue(ringBuffer.isFull());

        int elem = ringBuffer.dequeue();
        assertTrue(ringBuffer.isEmpty());
        assertEquals(1, elem);
    }

    @Test
    public void testEnqueueDequeue(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());
    
        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        int elem = ringBuffer.dequeue();
        assertTrue(ringBuffer.isEmpty());
        assertEquals(1, elem);
    }

    @Test
    public void testEnqueueTillFullDequeue(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());
    
        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(2);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(3);
        assertTrue(ringBuffer.isFull());

        int elem = ringBuffer.dequeue();
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());
        assertEquals(1, elem);
    }

    @Test
    public void testEnqueueAtLeastTwiceButLessThanFull(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());
    
        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(2);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());
    }

    @Test
    public void testEnqueueAtLeastTwiceButLessThanFullDequeueOnce(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());
    
        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(2);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        int elem = ringBuffer.dequeue();
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());
        assertEquals(1, elem);
    }

}
