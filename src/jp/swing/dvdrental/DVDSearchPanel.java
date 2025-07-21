package jp.swing.dvdrental;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DVDSearchPanel  extends JPanel {
	public DVDSearchPanel (MainFrame frame) {
		
		//レイアウト
		setLayout(new GridLayout(3, 2));
		
		//ボタンやテキスト
    	JTextField codeField = new JTextField();
    	JTextField titleField = new JTextField();
    	JButton searchBtn = new JButton("検索");
    	JButton backBtn = new JButton("DVD管理画面へ戻る");
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	searchBtn.addActionListener(e ->{
        	//登録ボタンが押されたらIDとタイトル
    		if(codeField.getText().length() == 0 && titleField.getText().length() == 0){ //入力確認
    			JOptionPane.showMessageDialog(this, "DVDコード又はタイトルを入力してください。");
    		} else {
    			List<String> search = DB.searchDVD(Integer.parseInt(codetitleField.getText()));
        		JOptionPane.showMessageDialog(this, "検索結果を表示します。");
        		frame.showPanel("DVD_SEARCHRESULT");
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
    	add(searchBtn);
    	add(backBtn);
    	add(topbackBtn);
	}

}
