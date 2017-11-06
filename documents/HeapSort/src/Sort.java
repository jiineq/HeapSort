
/**
 * The sort class sorts the records in each block using replacement selection
 * to create runs 
 * 
 * @author Joy Zhang (jjzhng)
 * @author Stephen Seong (smseong) 
 * @version Nov 6, 2017
 *
 */

public class Sort {

    /**
     * Start time of sort  
     */
    private long startTime;
    
    /**
     * Finish time of sort 
     */
    private long stopTime;
        
    /**
     * 
     */
    public Sort() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * this is a heapsort from notes 
     * 
     * public static void heapSort(Integer[] List, int Sz) {
     *  BinaryHeap<Integer> toSort = new BinaryHeap<Integer>(List,Sz);
     *  
     *  int Index = Sz - 1; 
     *  while (!toSort.isEmpty()) {
     *      List[Index] = toSort.deleteMax();
     *      Index--;
     *   }
     * }
     * 
     */
    

    /**
     * starts the beginning of the sort time 
     */
    public void startSort() {
        this.startTime = System.currentTimeMillis();
    }
    
    /**
     * starts the end of the sort time
     */
    public void endSort() {
        this.stopTime = System.currentTimeMillis();
    }

    /**
     * gets the execution time of the sort 
     * @return
     *      the runtime of sort
     */
    public long getExecutionTime() {
        return stopTime - startTime;
    }
    
}
