package at.fhhagenberg.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExtendedRingBufferStateTest {
    @Test
    public void testSetCapacityToSize(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());

        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.setCapacity(1);
        assertTrue(ringBuffer.isFull());
        assertEquals(1, ringBuffer.capacity());
    }

    @Test
    public void testSetCapacityGreaterThanSize(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());

        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.setCapacity(2);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());
        assertEquals(2, ringBuffer.capacity());
    }

    @Test
    public void testFullSetCapacityToSize(){
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

        ringBuffer.setCapacity(3);
        assertTrue(ringBuffer.isFull());
        assertEquals(3, ringBuffer.capacity());
    }

    @Test
    public void testFullSetCapacityGreaterThanSize(){
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

        ringBuffer.setCapacity(4);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());
        assertEquals(4, ringBuffer.capacity());
    }

    @Test
    public void testSetCapacitySmallerSize(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());

        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(2);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        assertThrows(RuntimeException.class, () -> ringBuffer.setCapacity(1));
        assertEquals(3, ringBuffer.capacity());
    }
    
    @Test
    public void testFullSetCapacitySmallerSize(){
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

        assertThrows(RuntimeException.class, () -> ringBuffer.setCapacity(2));
        assertEquals(3, ringBuffer.capacity());
    }

    @Test
    public void testEmptySetCapacityNegative(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());

        assertThrows(RuntimeException.class, () -> ringBuffer.setCapacity(-1));
        assertEquals(3, ringBuffer.capacity());
    }

    @Test
    public void testSetCapacityNegative(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);
        assertTrue(ringBuffer.isEmpty());

        ringBuffer.enqueue(1);
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        assertThrows(RuntimeException.class, () -> ringBuffer.setCapacity(-1));
        assertEquals(3, ringBuffer.capacity());
    }

    @Test
    public void testFullSetCapacityNegative(){
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(1);
        assertTrue(ringBuffer.isEmpty());

        ringBuffer.enqueue(1);
        assertTrue(ringBuffer.isFull());

        assertThrows(RuntimeException.class, () -> ringBuffer.setCapacity(-1));
        assertEquals(1, ringBuffer.capacity());
    } 
}
