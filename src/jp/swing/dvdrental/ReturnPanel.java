package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReturnPanel extends JFrame{
	 public ReturnPanel(MainFrame frame) {
	       
	    	setLayout(new GridLayout(2,2));
	    	JTextField dvdCodeField = new JTextField();
	    	JButton returnBtn = new JButton("返却");
	    	JButton backBtn = new JButton("TOPへ戻る");
	  
	    	returnBtn.addActionListener(e->{
	    		DB.returnDVD1(dvdCodeField.getText());
	    		DB.returnDVD2(dvdCodeField.getText());
	    		JOptionPane.showMessageDialog(this, "返却しました");
	    	});
	    	
	         backBtn.addActionListener(e -> frame.showPanel("TOP"));
	    	
	         add(new JLabel("タイトルコード"));
	         add(dvdCodeField);
	         add(returnBtn);
	         add(backBtn);
	    }
	}
