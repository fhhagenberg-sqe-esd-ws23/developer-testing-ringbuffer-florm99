package at.fhhagenberg.sqe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RingBufferMutationTest {
    @Test
    public void testSetCapacityDecreaseToSizeOfBuffer() {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(7);
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);

        ringBuffer.setCapacity(3);

        assertEquals(3, ringBuffer.capacity());
        assertEquals(1, ringBuffer.dequeue());
        assertEquals(2, ringBuffer.dequeue());
        assertEquals(3, ringBuffer.dequeue());
    }
}
