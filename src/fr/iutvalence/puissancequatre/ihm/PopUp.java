package fr.iutvalence.puissancequatre.ihm;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopUp extends JFrame {

	private String description;
	private JLabel text;
	
	public PopUp(String description){
		this.setSize(100, 100);
		this.setResizable(false);
		this.description = description;
		this.text = new JLabel(description);
		this.getContentPane().add(this.text);
		this.setVisible(true);
		
	}
	
	
}
