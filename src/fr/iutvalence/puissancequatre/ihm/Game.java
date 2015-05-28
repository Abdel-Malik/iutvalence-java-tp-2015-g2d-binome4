package fr.iutvalence.puissancequatre.ihm;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; 

/**
 * TODO JAVADOC.
 *
 * @author ricos
 * @version 1.0.0
 */
public class Game {
	/**
	 * The turn of player
	 */
	private Piece playerTurn;
	
	/**
	 * The 2 players
	 */
	private ArrayList<Player> players;
	
	/**
	 * The grid of the game
	 */
	private Grid grid ;
	
	/**
	 * boolean for know if the game is end. 
	 */
	private boolean win;
	
	/**
	 * Contructor of game
	 */
	public Game()
	{
		/**
		 * Random number give the first player 
		 */
		Random rand = new Random();
        int firstPlayerIndice = rand.nextInt(1);
        this.win = false;
        this.playerTurn = Piece.REDPIECE;
		if (firstPlayerIndice == 0)
			this.playerTurn = Piece.YELLOWPIECE;
		
		/**
		 * Create collection of player
		 */
		this.players = new ArrayList<Player>();
		System.out.print("For the red piece ");
		this.players.add(new Player(Piece.REDPIECE));
		System.out.print("For the yellow piece ");
		this.players.add(new Player(Piece.YELLOWPIECE));
		
		this.grid = new Grid();
	}
	
	/**
	 *  Give the players
	 * @return player list
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Change the player turn
	 */
	public void changeTurn()
	{
		if (playerTurn == Piece.REDPIECE)
		{
			this.playerTurn = Piece.YELLOWPIECE;
			System.out.println("It's a Yellow piece's turn");
		}
		else
			{
			this.playerTurn = Piece.REDPIECE;
			System.out.println("It's a Red piece's turn");
			}
	}
	
	public String getCurrentPlayer(){
		if(this.playerTurn == Piece.REDPIECE){
			return "Red player";
		}else{
			return "Yellow player";
		}
	}
	
	
	public Grid getGrid(){
		return this.grid;
	}
	
	/**
	 * Play the game
	 * @return the winner color or emptysquare for draw 
	 * 
	 */
	public Piece play()
	
	{
		int turnCounter = 0;
		int line = 0;
		boolean inGrid = false;

		System.out.println(this.grid);
		Scanner columnChoice = new Scanner(System.in);
		boolean win = false;
		while(!win && turnCounter != 42)
		{
			changeTurn();
			System.out.println(" choose the column : ");
			
			int column = columnChoice.nextInt();
			
			/**
			 * verify the colum choice, if it is in the grid
			 */
			do
			{
				try
				{
				if (column-1 < 0 ||  column-1 > 6)
					throw new IllegalGridPositionException();
				else
					inGrid = true;
				line = this.grid.stack(column-1,playerTurn);
				}
				catch(IllegalGridPositionException | FullColumnException e)
			{
					inGrid = false;
				System.out.println(" Illegal column Choice, try again! ");
				column = columnChoice.nextInt();
			}
			}
			while ( inGrid == false);
			
			
			System.out.println(this.grid);
			win = this.grid.search4Piece(line,column-1);
		}
		columnChoice.close();
		
		if (win)
			return this.playerTurn;
		return Piece.EMPTYSQUARE;
			
		
	}
	
	public boolean play(int columnNumber){
		
		int turnCounter = 0;
		int line = 0;
		boolean inGrid = false;
		
		if(!win && turnCounter != 42)
		{
			
			//System.out.println(" choose the column : ");
			
			int column = columnNumber;
			
			/**
			 * verify the colum choice, if it is in the grid
			 */
			try
			{
				inGrid = true;
				line = this.grid.stack(column-1,playerTurn);
			}catch(FullColumnException e){
				inGrid = false;
				//new PopUp("Illegal column Choice, try again!");
				return false;
			}
			win = this.grid.search4Piece(line,column-1);
			
			if (win){
				new PopUp( this.playerTurn + " win");
			}
			this.changeTurn();
		}
		
		
		return true;
			
		
	}

}
