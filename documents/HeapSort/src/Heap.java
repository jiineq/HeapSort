import java.util.NoSuchElementException;

/**
 * 
 */

/**
 * The heap class that sets up the heap with a block of records 
 * Heap represents working memory that is 8 blocks long 
 * 
 * @author Joy Zhang (jjzhng)
 * @author Stephen Seong (smseong)
 * @version Nov 6, 2017
 *
 */
public class Heap {
    
    private Record[] minHeap; 
    float[] keyValue;
    /**
     * the size of each block, each block contains 512 records
     */
    int size; 
    /**
     * the max size of the heap/block
     */
    private static final int MAX_SIZE = 512;
    
    /**
     * the number of children each node can have 
     */
    private static final int a = 2; 

    /**
     * Creates a new heap to fill with records      
     */
    public Heap(Record[] heap) {
        size = 0;        
        minHeap = heap; 
    }
    
    /**
     * checks if heap is empty 
     * @return
     *      true if size of heap is 0 
     */
    public boolean isEmpty() { 
        return size == 0; 
    }
    
    /**
     * checks if heap is full 
     * @return
     *      true if size of heap is MAX_SIZE
     */
    public boolean isFull() {
        return size == MAX_SIZE;
    }
    
    /**
     * Clears the heap 
     */
    public void clear() {
        size = 0;
    }
    
    /**
     * gets the parent of index i 
     * @param i
     *      the index of current node
     * @return
     *      the index of parent of the current node
     */
    private int getParent(int i) {
        return (i - 1)/a;
    }
    
    /**
     * gets the index of the nth child of the current index i 
     * @param i
     *      the index of the current node 
     * @param n
     *      the nth child of i 
     * @return
     *      the index of the nth child of i 
     */
    private int getNthChild(int i, int n) {
        return a * i + n; 
    }
    
    /**
     * inserts a Record into the heap 
     * @param r
     *      the record being inserted 
     */
    public void insert(Record r) {
        if (isFull()) {
            throw new NoSuchElementException("Heap overflow exception");   
        }
        minHeap[size++] = r;
        heapifyUp(size -1);
    }
    
    /**
     * Finds the min record 
     * @return
     */
    public Record findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap underflow exception");
        }
        return minHeap[0];
    }
    
    /**
     * deletes the min record 
     * @return
     *      the deleted record's value
     */
    public Record deleteMin() {
        Record min = minHeap[0];
        delete(0);
        return min;
    }
    
    /**
     * Deletes any record at given index 
     * @return
     *      the deleted record
     */
    public Record delete(int i) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap underflow exception");
        }
        Record r = minHeap[i];
        minHeap[i] = minHeap[size-1];
        size--;
        heapifyDown(i);
        return r;
    }
    
    /**
     * Swaps the new record and parent if new record has a smaller value 
     * @param i
     *      the index of the child 
     */
    private void heapifyUp(int i) {
        Record temp = minHeap[i];
        while (i > 0 && temp < minHeap[getParent(i)]) {
           minHeap[i] = minHeap[getParent(i)];
           i = getParent(i);
        }
        minHeap[i] = temp;
    }
    
    /**
     * Swaps the record that is out of place with the smallest child 
     * if the record has a larger priority has a higher priority than 
     * any other child
     * @param i
     *      the index of the out of place record 
     */
    private void heapifyDown(int i) {
        Record child; 
        Record temp = minHeap[i];
        while(getNthChild(i,1) < size) {
            child = getMinChild(i);
            if (minHeap[child] < temp) {
                minHeap[i] = minHeap[child];
            }
            else break;
            i = child; 
        }
        minHeap[i] = temp;
    }
    
    /**
     * gets the smallest child's value
     * @param i
     *      index of the smallest record
     * @return
     *      
     */
    private Record getMinChild(int i) {
        int c = getNthChild(i, 1);
        int k = 2; 
        int j = getNthChild(i, k);
        while ((k <= a) && (j < size)) {
            if (minHeap[j] < minHeap[c]) 
                c = j;
            j = getNthChild(i, k++);
        }
        return c;
    }
    
    /**
     * turns the heap into an array 
     * @return
     *      the heap as an array 
     */
    public Record[] toArray() {
        //TODO 
    }
    
    
    
}
