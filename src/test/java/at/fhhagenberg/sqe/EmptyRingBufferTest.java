package at.fhhagenberg.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmptyRingBufferTest {
    @Test
    public void testDequeue() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        assertTrue(ringBuffer.isEmpty());

        Exception exc = assertThrows(RuntimeException.class, () -> ringBuffer.dequeue());
        assertEquals("Empty ring buffer.", exc.getMessage());
    }
}
