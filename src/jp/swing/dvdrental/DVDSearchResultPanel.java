package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DVDSearchResultPanel  extends JPanel {
	public DVDSearchResultPanel (MainFrame frame) {
		
		//レイアウト
		setLayout(new GridLayout(3, 2));
		
		//ボタンやテキスト
    	JTextField codetitleField = new JTextField();
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
    	
    	add(new JLabel("DVDコード又はタイトル"));
    	add(codetitleField);
    	add(registerBtn);
    	add(backBtn);
    	add(topbackBtn);
	}

}
