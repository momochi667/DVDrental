package jp.swing.dvdrental;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.Normalizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DVDDeletePanel extends JPanel {
	public DVDDeletePanel(MainFrame frame) {
		//レイアウト
		setLayout(new GridLayout(3, 2));
		
		//ボタンやテキスト
    	JTextField codeField = new JTextField();
    	JButton registerBtn = new JButton("削除");
    	registerBtn.setBackground(Color.ORANGE);
    	JButton backBtn = new JButton("DVD管理画面へ戻る");
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	registerBtn.addActionListener(e ->{
    		String code = Normalizer.normalize(codeField.getText(), Normalizer.Form.NFKC);
    		if(codeField.getText().length() == 0 ) { //入力確認
    			JOptionPane.showMessageDialog(this, "DVDコードを入力してください。");
    		} else if(DB.searchDVDCode(code) == 1) {
        	//削除ボタンが押されたらIDとタイトル
        		DB. deleteDVD(codeField.getText());
        		JOptionPane.showMessageDialog(this, "削除が完了しました。");
        		codeField.setText("");
    		} else {
    			JOptionPane.showMessageDialog(this, "存在しないDVDコードです。");
    			codeField.setText("");
    		}
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
