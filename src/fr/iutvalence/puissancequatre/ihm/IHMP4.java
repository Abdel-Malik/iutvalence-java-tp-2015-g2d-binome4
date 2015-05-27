package fr.iutvalence.puissancequatre.ihm;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class IHMP4 extends JFrame{
	
	private Button[] column;
	private JButton[] colorCase;
	private JPanel buttonPanel;
	private JPanel gameZone;
	private JSplitPane gameBoard;
	private Game currentGame;
	
	public IHMP4() {
		
		this.currentGame = new Game();
		
		this.setTitle("Puissance 4");
		this.setSize(350, 350);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.gameBoard = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    this.gameBoard.setDividerLocation(50);
	    this.gameBoard.setDividerSize(0);
	    this.gameBoard.setEnabled(false);
	    
	    
	    this.buttonPanel = new JPanel();
	    this.buttonPanel.setLayout(new GridLayout(1,7));
	    
	    column = new Button[7];
	    
	    for(int numberOfButton = 0; numberOfButton < 7; numberOfButton++){
	    	this.column[numberOfButton] = new Button(numberOfButton);
	    	this.column[numberOfButton].setText(""+(char)(numberOfButton+49));
	    	this.buttonPanel.add(column[numberOfButton]);
	    }
	    
	    this.gameBoard.setTopComponent(this.buttonPanel);
	    
	    
	    
	    this.gameZone = new JPanel();
	    
	    this.gameZone.setLayout(new GridLayout(6,7));
	    
	    this.colorCase = new JButton[42];
	    
	    for(int numberOfCase = 0; numberOfCase < 42; numberOfCase++){
	    	colorCase[numberOfCase] = new JButton();
	    	this.gameZone.add(this.colorCase[numberOfCase]);
	    	colorCase[numberOfCase].setBackground(new Color(75, 123, 12));
	    	colorCase[numberOfCase].setEnabled(false);
	    }
	    
	    this.changeColor();
	    this.gameBoard.setBottomComponent(this.gameZone);
	    
	    this.getContentPane().add(this.gameBoard);
		this.setVisible(true);
		
	}
	
	private void changeColor(){
		int numberOfCase = 0;
		for(int abscisse = 0; abscisse < 6; abscisse++){
			for(int ordonnee = 0; ordonnee < 7; ordonnee++){
				if(this.currentGame.getGrid().getGrid()[abscisse][ordonnee] == Piece.EMPTYSQUARE){
					this.colorCase[numberOfCase].setBackground(new Color(125, 125, 125));
					numberOfCase++;
				}
			}
		}
	}
}