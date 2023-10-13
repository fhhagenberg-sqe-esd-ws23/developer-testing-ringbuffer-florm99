package at.fhhagenberg.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class RingBufferTest {
    @Test
    public void testCapacity() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        assertEquals(5, ringBuffer.capacity());
    }

    @Test
    public void testEnqueueElement() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        ringBuffer.enqueue(2);
        int elem = ringBuffer.peek();

        assertEquals(2, elem);
        assertFalse(ringBuffer.isEmpty());
    }

    @Test
    public void testDequeueElement() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);

        ringBuffer.enqueue(2);
        assertFalse(ringBuffer.isEmpty());

        int elem = ringBuffer.dequeue();
        assertEquals(2, elem);
        assertTrue(ringBuffer.isEmpty());
    }

    @Test
    public void testEnqueueCapacityZero() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(0);
        assertThrows(IndexOutOfBoundsException.class, () -> ringBuffer.enqueue(1));
    }

    @Test
    public void testEnqueueFullBufferDequeueEmptyBuffer() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);

        ringBuffer.enqueue(1);        
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);

        assertTrue(ringBuffer.isFull());
        assertEquals(3, ringBuffer.size());


        int elem = ringBuffer.dequeue();
        assertEquals(1, elem);
        assertEquals(2, ringBuffer.size());

        elem = ringBuffer.dequeue();
        assertEquals(2, elem);
        assertEquals(1, ringBuffer.size());

        elem = ringBuffer.dequeue();
        assertEquals(3, elem);
        assertEquals(0, ringBuffer.size());
    }

    @Test
    public void testEnqueueFullBufferPlusOneDequeueEmptyBuffer() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);

        ringBuffer.enqueue(1);        
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);

        assertTrue(ringBuffer.isFull());
        assertEquals(3, ringBuffer.size());

        ringBuffer.enqueue(4);

        assertTrue(ringBuffer.isFull());
        assertEquals(3, ringBuffer.size());

        int elem = ringBuffer.dequeue();
        assertEquals(2, elem);
        assertEquals(2, ringBuffer.size());

        elem = ringBuffer.dequeue();
        assertEquals(3, elem);
        assertEquals(1, ringBuffer.size());

        elem = ringBuffer.dequeue();
        assertEquals(4, elem);
        assertEquals(0, ringBuffer.size());
    }

    @Test
    public void testIteratorFullBuffer() {
        int capacity = 5;
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(capacity);

        for (int i = 0; i < capacity; i++) {
            ringBuffer.enqueue(i);
        }

        Iterator<Integer> iter = ringBuffer.iterator();
        for (int i = 0; i < capacity; i++) {
            assertEquals(i, iter.next());
        }
    }

    @Test
    public void testIteratorFullBufferPlusOne() {
        int capacity = 5;
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(capacity);

        for (int i = 0; i < capacity + 1; i++) {
            ringBuffer.enqueue(i);
        }

        Iterator<Integer> iter = ringBuffer.iterator();
        for (int i = 1; i < capacity + 1; i++) {
            assertEquals(i, iter.next());
        }
    }

    @Test
    public void testIteratorRemove() {
        int capacity = 5;
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(capacity);

        for (int i = 0; i < capacity + 1; i++) {
            ringBuffer.enqueue(i);
        }

        Iterator<Integer> iter = ringBuffer.iterator();
        assertThrows(UnsupportedOperationException.class, () -> iter.remove());
    }

    @Test
    public void testSetCapacityIncrease() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(2);
        ringBuffer.enqueue(1);
        ringBuffer.setCapacity(5);

        assertEquals(5, ringBuffer.capacity());
        assertEquals(1, ringBuffer.peek());
    }

    @Test
    public void testSetCapacityIncreaseOfFullBufferPlusOne() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(2);
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);

        assertTrue(ringBuffer.isFull());

        ringBuffer.setCapacity(5);

        assertFalse(ringBuffer.isFull());
        assertEquals(5, ringBuffer.capacity());
        assertEquals(2, ringBuffer.dequeue());
        assertEquals(3, ringBuffer.dequeue());
    }

    @Test
    public void testSetCapacityIncreaseOfEmptyBuffer() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(2);
        ringBuffer.setCapacity(5);

        assertTrue(ringBuffer.isEmpty());
        assertEquals(5, ringBuffer.capacity());
    }

    @Test
    public void testSetCapacityDecrease() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(7);
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);

        ringBuffer.setCapacity(3);

        assertEquals(3, ringBuffer.capacity());
        assertEquals(1, ringBuffer.dequeue());
        assertEquals(2, ringBuffer.dequeue());
    }

    @Test
    public void testSetCapacityDecreaseOfFullBuffer() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);

        Exception exc = assertThrows(RuntimeException.class, () -> ringBuffer.setCapacity(2));
        assertEquals("Given capacity smaller than number of elements hold by the buffer currently.", exc.getMessage());
    }

    @Test
    public void testSetCapacityDecreaseOfEmptyBuffer() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        ringBuffer.setCapacity(2);
        
        assertTrue(ringBuffer.isEmpty());
        assertEquals(2, ringBuffer.capacity());
    }
}
