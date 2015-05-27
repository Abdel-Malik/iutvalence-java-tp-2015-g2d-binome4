package fr.iutvalence.puissancequatre.ihm;

import javax.swing.JButton;

public class Button extends JButton {

	private int columnNumber;
	
	public Button(int ColumnNumber){
		
		this.columnNumber = ColumnNumber;
		
	}
	
	public int getColumnNumber(){
		return this.columnNumber;		
	}
}
