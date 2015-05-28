package fr.iutvalence.puissancequatre.ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class IHMP4 extends JFrame implements ActionListener{
	
	private Button[] column;
	private JButton[] colorCase;
	private JPanel buttonPanel;
	private JPanel gameZone;
	private JSplitPane gameBoard;
	private Game currentGame;
	private JSplitPane window;
	private JLabel console;
	private int lastColumnChoosen;
	
	public IHMP4() {
		
		this.currentGame = new Game();
		this.lastColumnChoosen = 0;
		
		this.setTitle("Puissance 4");
		this.setSize(350, 450);
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
	    	this.column[numberOfButton].addActionListener(this);
	    }
	    
	    this.gameBoard.setTopComponent(this.buttonPanel);
	    
	    
	    
	    this.gameZone = new JPanel();
	    
	    this.gameZone.setLayout(new GridLayout(6,7));
	    
	    this.colorCase = new JButton[42];
	    
	    for(int numberOfCase = 0; numberOfCase < 42; numberOfCase++){
	    	colorCase[numberOfCase] = new JButton();
	    	this.gameZone.add(this.colorCase[numberOfCase]);
	    	colorCase[numberOfCase].setEnabled(false);
	    }
	    
	    this.changeColor();
	    this.gameBoard.setBottomComponent(this.gameZone);
	    
	    this.window = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    this.console = new JLabel("Yellow player's turn");
	    
	    this.window.setDividerSize(0);
	    this.window.setBottomComponent(console);
	    this.window.setTopComponent(this.gameBoard);
	    this.window.setDividerLocation(350);
	    
	    
	    this.getContentPane().add(this.window);
		this.setVisible(true);
		
	}
	
	private void changeColor(){
		int numberOfCase = 0;
		for(int abscisse = 0; abscisse < 6; abscisse++){
			for(int ordonnee = 0; ordonnee < 7; ordonnee++){
				if(this.currentGame.getGrid().getGrid()[abscisse][ordonnee] == Piece.EMPTYSQUARE){
					this.colorCase[numberOfCase].setBackground(new Color(125,125, 125));
				}
				if(this.currentGame.getGrid().getGrid()[abscisse][ordonnee] == Piece.REDPIECE){
					this.colorCase[numberOfCase].setBackground(new Color(165,0, 0));
					//this.colorCase[numberOfCase].setIcon(new ImageIcon("./img/circle-red.png"));
				}
				if(this.currentGame.getGrid().getGrid()[abscisse][ordonnee] == Piece.YELLOWPIECE){
					this.colorCase[numberOfCase].setBackground(new Color(200, 200, 0));
				}
				numberOfCase++;
			}
		}
	}
	
	private String changeConsole(){
		return this.currentGame.getCurrentPlayer()+"'turn";
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Button source =(Button) arg0.getSource();
		if(!this.currentGame.play(source.getColumnNumber()+1)){
			this.console.setText("The column is full !   " + this.changeConsole());
		}else{
			this.changeColor();
			this.console.setText(this.changeConsole());
		}
		
		//System.out.println(source.getColumnNumber());
		
		
	}
}