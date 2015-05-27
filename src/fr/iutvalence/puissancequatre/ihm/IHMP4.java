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
	
	public IHMP4() {
		
		this.setTitle("Puissance 4");
		this.setSize(300, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.gameBoard = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    this.gameBoard.setDividerLocation(50);
	    this.gameBoard.setDividerSize(0);
	    this.gameBoard.enable(false);
	    
	    
	    this.buttonPanel = new JPanel();
	    this.buttonPanel.setLayout(new GridLayout(1,7));
	    
	    column = new Button[7];
	    
	    for(int numberOfButton = 0; numberOfButton < 7; numberOfButton++){
	    	this.column[numberOfButton] = new Button(numberOfButton);
	    	this.column[numberOfButton].setLabel(""+numberOfButton+1);
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
	  
	    this.gameBoard.setBottomComponent(this.gameZone);
	    
	    this.getContentPane().add(this.gameBoard);
		this.setVisible(true);
		
	}
}
