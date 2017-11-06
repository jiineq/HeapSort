import java.io.RandomAccessFile; 

/**
 * Buffer pool class that provides working memory  
 * and manages the binary input file  
 * is this even necessary? 
 * 
 * @author Joy Zhang (jjzhng)
 * @version Nov 6, 2017
 *
 */
public class BufferPool {

    /**
     * the max size of the buffer 
     */
    private static final int BLOCK = 4096;

    /**
     * A random access file behaves like a large array of bytes stored in the file system
     */
    private RandomAccessFile file; 
    
    /**
     * 
     */
    public BufferPool() {
        // TODO Auto-generated constructor stub
    }

}
