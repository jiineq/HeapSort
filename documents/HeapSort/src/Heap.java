import java.nio.ByteBuffer;
import java.util.NoSuchElementException;


/**
 * The heap class that sets up the heap with a block of records 
 * 
 * @author Joy Zhang (jjzhng)
 * @author Stephen Seong (smseong)
 * @version Nov 6, 2017
 *
 */
public class Heap {
    
    /**
     * creates a heap made of bytes  
     */
    private byte[] minHeap; 
    
    /**
     * max size of a block
     */
    private static final int MAX_SIZE = 32768;
    /**
     * size of the byte array 
     */
    private int size;
    
    /**
     * the number of positions we have access to in the heap  
     */
    private int access; //max would be 4096 

    public Heap(byte[] heap) {
        minHeap = heap;
        size = 0;
    }
    
    /**
     * gets the ID of a record as an int 
     * from a given location 
     * @param access
     *      the start of the record location 
     * @return
     *      record ID as an int 
     */
    public int getID(int access) {
        byte[] idArray = new byte[4];
        for (int i = 0; i < 4; i++) {
            idArray[i] = minHeap[access*8 + i];
        }
        int id = ByteBuffer.wrap(idArray).getInt();
        return id;
    }
    
    /**
     * gets the key of a record as a float 
     * @param access
     *      the start of the record location 
     * @return
     *      record key as a float 
     */
    public float getKey(int access) {
        byte[] keyArray = new byte[4];
        for (int i = 0; i < 4; i++) {
            keyArray[i] = minHeap[access*8 + 4 + i];
        }
        float key = ByteBuffer.wrap(keyArray).getFloat();
        return key;
    }
    
    /**
     * inserting 8 bytes 
     * 
     * 2) scenarios: inserting something larger/equal or smaller 
     *      case 1: swap 
     *      case 2: swap 
     * 
     * @param record 
     */
    //STILL WORKING ON THIS 
    public void insert(byte[] record) {    
        if (isFull()) {
            throw new NoSuchElementException("Heap overflow exception");
        }
        for (int i = 0; i < 8; i++) {
            minHeap[i] = record[i];
        }        
        size++;                
    }
    
    /**
     * always pop first then push
     * returns the record in the front of the array 
     * so we can push another record in  
     * 
     * @return record
     *      the record we are popping off the top of the heap 
     */
    public byte[] remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap underflow exception");
        }
        byte[] temp = new byte[8];
        for (int i = 0; i < 8; i++) {
            temp[i] = minHeap[i];
        }
        size--;
        return temp;
    }
    
    /**
     * checks if heap is empty
     * @return
     *      true if empty
     *      false if not empty
     */
    public boolean isEmpty() {
        return size == 0; 
    }
    
    /**
     * checks if heap is full
     * @return
     *      true if full 
     *      false if not full
     */
    public boolean isFull() {
        return size == MAX_SIZE;
    }
    
    public void fillBlock() {
        
    }
    
    public void clear() {
        size = 0; 
    }
    
    private void swap() {
        
    }
    
    
    
}
