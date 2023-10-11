package at.fhhagenberg.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
