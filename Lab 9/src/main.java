/**
 * Alexander Pham
 * November 19, 2019
 * Replaces user given coordinates and adjacent with points with numbers
 */

import java.awt.Point;

public class main {
    public static void main( String[] args){
        LinkedStack stack = new LinkedStack();
        /**
         * Create character array
         */
        char[][] characterArray = new char [5][5];
        for ( int a = 0 ; a < characterArray.length ; a++ ){
            for ( int b = 0 ; b < characterArray[0].length ; b++ ){
                characterArray[a][b] = '.';
            }
        }
        /**
         * User inputs
         */
        System.out.println( "Enter 5 points" );
        for ( int i = 1 ; i < 6 ; i++){
            /**
             * Get row
             */
            System.out.print( "x" + i + " : " );
            int userRow = CheckInput.getIntRange(0 , 4 );
            /**
             * Get column
             */
            System.out.print( "y" + i + " : " );
            int userColumn = CheckInput.getIntRange( 0 , 4 );
            /**
             * Create points
             */
            Point point = new Point( userRow , userColumn );
            stack.push( point );
        }
        /**
         * Replace characterArray points
         */
        int length = stack.size();
        for ( int j = 0; j < length ; j++ ){
            int count = 5 - j;
            Point remove = stack.pop();
            characterArray[remove.y][remove.x] = (char) ( count +'0' ) ;
            /**
             * Replace right
             */
            if ( remove.x < 4 ){
                characterArray[remove.y][remove.x+1] = (char) ( count + '0' ) ;
            }
            /**
             * Replace left
             */
            if ( remove.x > 0 ){
                characterArray[remove.y][remove.x-1] = (char) ( count + '0' ) ;
            }
            /**
             * Replace up
             */
            if ( remove.y > 0 ){
                characterArray[remove.y-1][remove.x] = (char) ( count + '0' ) ;
            }
            /**
             * Replace down
             */
            if ( remove.y < 4 ){
                characterArray[remove.y+1][remove.x] = (char) ( count + '0' ) ;
            }
        }
        /**
         * Display array
         */
        System.out.println();
        for ( int k = 0 ; k < characterArray.length ; k++ ){
            for ( int l = 0 ; l < characterArray[0].length ; l++ ){
                System.out.print( characterArray[k][l] + " " );
            }
            System.out.println();
        }
    }
}
