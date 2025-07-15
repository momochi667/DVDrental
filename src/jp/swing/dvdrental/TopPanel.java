package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	   public TopPanel(MainFrame frame) {
	       setLayout(new GridLayout(6, 1, 10, 10));
	       
	       //会員パネルに移動　インスタンス名 memberButton
	       JButton memberButton = new JButton("会員管理");
	       memberButton.addActionListener(e -> frame.showPanel("MEMBER"));
	       
	       //DVDパネルに移動　インスタンス名 dvdButton
	       JButton dvdButton = new JButton("DVD管理");
	       dvdButton.addActionListener(e -> frame.showPanel("DVD"));
	      
	       //貸出画面に移動　インスタンス名 lentButton
	       JButton lentButton = new JButton("貸出");
	       lentButton.addActionListener(e -> frame.showPanel("LENT"));
 
	       //返却画面に移動　インスタンス名 returnButton
	       JButton returnButton = new JButton("返却");
	       returnButton.addActionListener(e -> frame.showPanel("RETURN"));

	        add(memberButton);
	        add(dvdButton);
	        add(lentButton);
	        add(returnButton);
	   
	   }
}
