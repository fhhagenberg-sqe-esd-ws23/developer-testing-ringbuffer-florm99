package at.fhhagenberg.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RingBufferPartitionsTest {
    @Test
    public void testNegativeCapacityUpperBound() {
        assertThrows(NegativeArraySizeException.class, () -> new RingBuffer<>(-1));
    }

    @Test
    public void testNegativeCapacityLowerBound() {
        assertThrows(NegativeArraySizeException.class, () -> new RingBuffer<>(Integer.MIN_VALUE));
    }

    @Test
    public void testCapacityZero() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(0);

        assertTrue(ringBuffer.isFull());
        assertTrue(ringBuffer.isEmpty());

        assertThrows(IndexOutOfBoundsException.class, () -> ringBuffer.enqueue(1));
        assertThrows(RuntimeException.class, () -> ringBuffer.dequeue());
        assertThrows(RuntimeException.class, () -> ringBuffer.peek());
    }

    @Test
    public void testCapacityOneEmptyAfterInit() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1);

        assertTrue(ringBuffer.isEmpty());
    }

    @Test
    public void testCapacityOneFullAfterEnqueue() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1);

        ringBuffer.enqueue(1);
        assertTrue(ringBuffer.isFull());
    }

    @Test
    public void testCapacityOneEnqueueDequeue() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1);

        ringBuffer.enqueue(1);
        int elem = ringBuffer.dequeue();
        assertEquals(1, elem);

        assertTrue(ringBuffer.isEmpty());
    }

    @Test
    public void testCapacityOneEnqueuePeek() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1);

        ringBuffer.enqueue(1);
        assertEquals(1, ringBuffer.peek());
        
        assertTrue(ringBuffer.isFull());
    }

    /*
     * Hier kommen jetzt zwei spaghetti Tests, weil die zwei Punkte die Zeit nicht 
     * wert sind da jetzt zehn Tests zu schreiben.
     */
    @Test
    public void testCapacityMultipleElementsLowerBound() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(2);

        assertTrue(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(1);
        assertEquals(1, ringBuffer.peek());

        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(2);
        assertEquals(1, ringBuffer.peek());

        assertFalse(ringBuffer.isEmpty());
        assertTrue(ringBuffer.isFull());

        int elem1 = ringBuffer.dequeue();
        int elem2 = ringBuffer.dequeue();
        assertEquals(1, elem1);
        assertEquals(2, elem2);

        assertTrue(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());
    }

    @Test
    public void testCapacityMultipleElementsUpperBound() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1000000000);

        assertTrue(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(1);
        assertEquals(1, ringBuffer.peek());

        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(2);
        assertEquals(1, ringBuffer.peek());

        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        int elem1 = ringBuffer.dequeue();
        int elem2 = ringBuffer.dequeue();
        assertEquals(1, elem1);
        assertEquals(2, elem2);

        assertTrue(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());
    }
}
