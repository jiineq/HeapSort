/**
 * 
 */

/**
 * Record class that contains the parameters and methods 
 * of the records within the block 
 * 
 * @author Joy Zhang (jjzhng)
 * @version Nov 6, 2017
 *
 */
public class Record {

    private int id; 
    private float key; 
    
    /**
     * Creates a Record with an ID and key  
     * @param f4 
     *      First 4 byte field that's a non-negative int value
     * @param s4
     *      Second 4 byte float value that represents the key 
     */
    public Record(int f4, float s4) {
        this.id = f4; 
        this.key = s4;
    }
    
    /**
     * Gets the value that represents the record's ID 
     * @return
     *      the record's ID 
     */
    public int getID() {
        return id;
    }
    
    /**
     * Gets the value that represents the record's key
     * @return
     *      the record's key 
     */
    public float getKey() {
        return key;
    }

}
