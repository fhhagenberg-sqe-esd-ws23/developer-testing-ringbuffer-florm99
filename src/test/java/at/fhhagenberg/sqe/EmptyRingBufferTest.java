package at.fhhagenberg.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmptyRingBufferTest {

    @Test
    public void testDequeue() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        assertTrue(ringBuffer.isEmpty());

        Exception exc = assertThrows(RuntimeException.class, () -> ringBuffer.dequeue());
        assertEquals("Empty ring buffer.", exc.getMessage());
    }

    @Test
    public void testPeek() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        assertTrue(ringBuffer.isEmpty());

        Exception exc = assertThrows(RuntimeException.class, () -> ringBuffer.peek());
        assertEquals("Empty ring buffer.", exc.getMessage());
    }

    @Test
    public void testIteratorFullBuffer() {
        int capacity = 5;
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(capacity);

        Iterator<Integer> iter = ringBuffer.iterator();
        for (int i = 0; i < capacity; i++) {
            assertThrows(NoSuchElementException.class, () -> iter.next());
        }
    }
}
