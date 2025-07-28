package jp.swing.dvdrental;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.Normalizer;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DVDSearchPanel  extends JPanel {
	static String code;
	static String title;
	public DVDSearchPanel (MainFrame frame) {
		
		//レイアウト
		setLayout(new GridLayout(4, 2));
		
		//ボタンやテキスト
    	JTextField codeField = new JTextField();
    	JTextField titleField = new JTextField();
    	JButton searchBtn = new JButton("検索");
    	searchBtn.setBackground(Color.ORANGE);
    	JButton backBtn = new JButton("DVD管理画面へ戻る");
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	searchBtn.addActionListener(e ->{
        	//登録ボタンが押されたらIDとタイトル
    		if(codeField.getText().length() == 0 && titleField.getText().length() == 0){ //入力確認
    			JOptionPane.showMessageDialog(this, "DVDコード又はタイトルを入力してください。");
    			return;
    		} 
    		
    		code = codeField.getText().isEmpty() ? "a" : Normalizer.normalize(codeField.getText(), Normalizer.Form.NFKC);
			title = titleField.getText().isEmpty() ? "a" : titleField.getText();
    		List<String>list = DB.searchDVD2(code, title);
    		
    		if(list.isEmpty()) {
    			JOptionPane.showMessageDialog(this, "一致する検索結果が見つかりませんでした。");
    			codeField.setText("");
    			titleField.setText("");
    			return;
    		}else {
        		frame.showPanel("DVD_SEARCHRESULT");
        		codeField.setText("");
    			titleField.setText("");
    		}
        	});
    	
    	//DVD管理画面に戻るボタン
    	backBtn.addActionListener(e -> frame.showPanel("DVD"));
    	
    	//TOPに戻るボタン
    	topbackBtn.addActionListener(e -> frame.showPanel("TOP"));
    	
    	add(new JLabel("DVDコード"));
    	add(codeField);
    	add(new JLabel("タイトル"));
    	add(titleField);
    	add(new JLabel(""));
    	add(searchBtn);
    	add(backBtn);
    	add(topbackBtn);
	}

}
