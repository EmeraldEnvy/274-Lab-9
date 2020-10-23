import java.awt.Point;

public class LinkedStack {
    private static class Node {
        /**
         * Initialize data
         */
        private Point data;
        /**
         * Initialize next
         */
        private Node next;

        /**
         * Node constructor
         * @param d point
         * @param n node
         */
        public Node( Point d, Node n ) {
            data = d;
            next = n;
        }
    }

    /**
     * Initialize top
     */
    private Node top;
    public LinkedStack( ) {
        top = null;
    }

    /**
     * Checks if stack is empty
     * @return
     */
    public boolean isEmpty( ) {
        return top == null;
    }

    /**
     * Add node to stack
     * @param s point
     */
    public void push( Point s ) {
        top = new Node( s, top );
    }

    /**
     * remove node from top
     * @return removed value
     */
    public Point pop( ) {
        Point retVal = new Point();
        if( !isEmpty( ) ) {
            retVal = top.data;
            top = top.next;
        }
        return retVal;
    }

    /**
     * Look at top of stack
     * @return point at top of stack
     */
    public Point peek( ) {
        Point retVal = new Point();
        if( !isEmpty( ) ) {
            retVal = top.data;
        }
        return retVal;
    }

    /**
     * Stack to string
     * @return string form of point
     */
    @Override
    public String toString( ) {
        String s = "";
        Node n = top;
        while( n != null ) {
            s = s + n.data + " ";
            n = n.next;
        }
        return s;
    }

    /**
     * Find size of stack
     * @return size of stack
     */
    public int size( ) {
        int count = 0;
        Node n = top;
        while( n != null ) {
            count++;
            n = n.next;
        }
        return count;
    }
}
