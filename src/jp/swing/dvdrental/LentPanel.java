package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LentPanel extends JPanel{
	 public LentPanel(MainFrame frame) {
		 setLayout(new GridLayout(3,2));
	    	JTextField memberldField = new JTextField();
	    	JTextField dvdCodeField = new JTextField();
	    	 JButton lendBtn = new JButton("貸出");
	    	 
	    JButton backBtn = new JButton("TOPへ戻る");
	 	lendBtn.addActionListener(e ->{
	    DB.lendDVD1(Integer.parseInt(memberldField.getText()),dvdCodeField.getText());
	    DB.lendDVD2(Integer.parseInt(memberldField.getText()),dvdCodeField.getText());
	    JOptionPane.showMessageDialog(this, "貸出しました。");
	    memberldField.setText("");
	    dvdCodeField.setText("");
	    });
	 	backBtn.addActionListener(e ->
        frame.showPanel("TOP"));
	 	
	 	add(new JLabel("会員ID"));
    	add(memberldField);
    	add(new JLabel("タイトルコード"));
    	add(dvdCodeField);
    	add(lendBtn);
    	add(backBtn);
	}

}
