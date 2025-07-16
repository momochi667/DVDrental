package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import jp.ac.kcs.swing.library.DB;

public class DVDRegisterPanel  extends JPanel {
	public DVDRegisterPanel(MainFrame frame) {
		
		//レイアウト
		setLayout(new GridLayout(4, 2));
		
		//ボタンやテキスト
    	JTextField codeField = new JTextField();
    	JTextField titleField = new JTextField();
    	JButton registerBtn = new JButton("登録");
    	JButton backBtn = new JButton("DVD管理画面へ戻る");
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	/*registerBtn.addActionListener(e ->{
        	//登録ボタンが押されたらIDとタイトル
        		DB. dvd(codeField.getText(), titleField.getText());
        		JOptionPane.showMessageDialog(this, "登録しました。");
        	});*/
    	
    	//DVD管理画面に戻るボタン
    	backBtn.addActionListener(e -> frame.showPanel("DVD"));
    	
    	//TOPに戻るボタン
    	topbackBtn.addActionListener(e -> frame.showPanel("TOP"));
    	
    	add(new JLabel("DVDコード"));
    	add(codeField);
    	add(new JLabel("タイトル"));
    	add(titleField);
    	add(registerBtn);
    	add(backBtn);
    	add(topbackBtn);
	}
}
