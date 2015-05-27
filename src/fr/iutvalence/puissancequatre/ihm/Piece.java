package fr.iutvalence.puissancequatre.ihm;

/**
 * The three available pieces.
 *
 * @author ricos
 * @version 1.0.0
 */
public enum Piece {
    /** Empty square. */
    EMPTYSQUARE(" "),
    /** Red piece. */
    REDPIECE("R"),
    /** Yellow piece. */
    YELLOWPIECE("Y");

    /**String representation of Piece*/
    private final String display;

    /**Constructor
     * 
     * @param disp String representation of Piece
     */
    Piece(final String disp) {
        display = disp;
    }

    @Override
    public String toString() {
        return display;
    }
    

}
