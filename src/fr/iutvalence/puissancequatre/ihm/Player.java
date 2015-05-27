	package fr.iutvalence.puissancequatre.ihm;

import java.util.Scanner;

/**
 * Player: name and piece.
 *
 * @author ricos
 * @version 1.0.0
 */
public class Player {
    /** Player's name. */
    private final String name;
    
	/** Piece's color. */
    private final Piece  piece;

    /**
     * Constructor of Player.
     *
     * @param n the name of player
     * @param s the color of piece of player
     */
    public Player( Piece s) {
    	
    	Scanner scan = new Scanner(System.in);
		System.out.println("Choose a name for player : ");
		String namePlayer = scan.nextLine();
        this.name = namePlayer;
        this.piece = s;
        
    }
    /**
     * 
     * @return piece
     */
    public Piece getPiece() {
		return piece;
	}
     
    /**
     *  Return a string with the name eand the color of player
     */
	@Override
    public String toString() {
		String nameOfColor ="Yellow";
		if (this.getPiece().equals(Piece.REDPIECE))
			nameOfColor = "Red";
        return "Name of Gamer : " + name + "  color : " + nameOfColor; 
    }
	
}
