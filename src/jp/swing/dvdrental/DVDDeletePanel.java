package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DVDDeletePanel extends JPanel {
	public DVDDeletePanel(MainFrame frame) {
		//レイアウト
		setLayout(new GridLayout(4, 2));
		
		//ボタンやテキスト
    	JTextField codeField = new JTextField();
    	JButton registerBtn = new JButton("削除");
    	JButton backBtn = new JButton("DVD管理画面へ戻る");
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	registerBtn.addActionListener(e ->{
        	//削除ボタンが押されたらIDとタイトル
        		DB. deleteDVD1(codeField.getText());
        		DB. deleteDVD2(codeField.getText());
        		JOptionPane.showMessageDialog(this, "削除しました。");
        });
    	
    	//DVD管理画面に戻るボタン
    	backBtn.addActionListener(e -> frame.showPanel("DVD"));
    	
    	//TOPに戻るボタン
    	topbackBtn.addActionListener(e -> frame.showPanel("TOP"));
    	
    	add(new JLabel("DVDコード"));
    	add(codeField);
    	add(new JLabel(""));
    	add(registerBtn);
    	add(backBtn);
    	add(topbackBtn);
	}
}
