package fr.iutvalence.puissancequatre.ihm;

/**
 * Grid of the game.
 *
 * @author ricos
 * @version 1.0.0
 */

public class Grid {
    /**constant number of column and line*/
    private static final int NB_COLUMN = 7;
    private static final int NB_LINE = 6;

    /**constant direction to verify the piece alignment*/
    private static final int[][] VERIFY_DIRECTION = {{0,1},{0,-1},{-1,1},{1,-1},{1,1},{-1,-1},{1,0}};

    /** Grid of Game represented by a table of piece*/
    private Piece[][] grid;
    
    /**Constructor of Grid initialized with empty square*/
    public Grid() {
        this.grid = new Piece[NB_LINE][NB_COLUMN];
        for (int line = 0; line < NB_LINE; line++) {
            for (int column = 0; column < NB_COLUMN; column++) {
                grid[line][column] =  Piece.EMPTYSQUARE;
            }
        }
    }
    /** To stack the piece on the grid
     * 
     * @param column choice of the player
     * @param piece the color of the player
     */
    
    public int stack(int column, Piece piece) throws FullColumnException{
    	int line;
    	for ( line = NB_LINE-1; line >= 0; line--)
    	{
    		if(this.grid[line][column].equals(Piece.EMPTYSQUARE))
    			break;		
    	}
    	if (line < 0)
    		throw new FullColumnException();
    	this.grid[line][column] = piece;
    	return line;

    }

    /**
     * Verify the alignment 
     * @return True if 4 Piece are align , false else
     */
	public boolean search4Piece(int line, int column)
	{
		 int nbPieces = 0;
		 int verifyLine, verifyColumn;
		 for (int nTest = 0; nTest < 7 ;nTest++)
		 {
			 if (nTest% 2 == 0)
				 nbPieces = 0;
			 verifyLine = line;
			 verifyColumn =column;
			 
			while( nbPieces != 3)
			{
				
				if (winDirection(verifyLine, verifyColumn, nTest))
				{
					nbPieces++;
				}
				else 
					break;
				
				verifyLine += VERIFY_DIRECTION[nTest][0];
				verifyColumn += VERIFY_DIRECTION[nTest][1];
					
			}
			if (nbPieces ==3)
				return true;
		 }
		 return false;
		 
	}
	/**
	 * Verify the same color of next piece in the nDirection
	 * @param verifyLine  line of current piece
	 * @param verifyColumn  column of current piece
	 * @param nDirection  number direction to verify
	 * @return  True if the next piece is the same color of current piece
	 */
	public boolean winDirection (int verifyLine, int verifyColumn, int nDirection ) 
	{
		int verifyLineNext = verifyLine+VERIFY_DIRECTION[nDirection][0];
		int verifyColumnNext = verifyColumn+VERIFY_DIRECTION[nDirection][1];
		try 
		{
			if((verifyLineNext < 0 || verifyLineNext >=NB_LINE) || (verifyColumnNext < 0 || verifyColumnNext >= NB_COLUMN))
				 throw new IllegalGridPositionException();
		}
		catch (IllegalGridPositionException e)
		{
			return false;
		}
		
		return this.grid[verifyLine][verifyColumn].equals(this.grid[verifyLineNext][verifyColumnNext]);
	}
	

    @Override
    /**
     * return string to represent the grid in the console
     */
    public String toString(){
    	 String gridRepresentation ="";
    	 for (int line = 0; line < NB_LINE; line++) {
    		 gridRepresentation += "|";
             for (int column = 0; column < NB_COLUMN; column++) {
                 gridRepresentation += "|"+this.grid[line][column]+"|";
             }
             gridRepresentation += "|\n";
    }
    	 return gridRepresentation;
    }
}
