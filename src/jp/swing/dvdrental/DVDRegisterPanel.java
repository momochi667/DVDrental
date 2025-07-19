package jp.swing.dvdrental;

import java.awt.GridLayout;
import java.text.Normalizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    	
    	registerBtn.addActionListener(e ->{
    		if(codeField.getText().length() == 0){ //入力確認
    			JOptionPane.showMessageDialog(this, "商品コードを入力してください。");
    		} else if(titleField.getText().length() == 0) {
    			JOptionPane.showMessageDialog(this, "タイトルを入力してください。");
    		} else {
    			//コードを半角に変換する
    			String code = Normalizer.normalize(codeField.getText(), Normalizer.Form.NFKC);
    			if(DB.searchDVDCode(code) == 0) {
    				//登録ボタンが押されたらIDとタイトル
    				DB. submitDVD1(code, titleField.getText());
    				DB. submitDVD2(code);
    				JOptionPane.showMessageDialog(this, "商品登録が完了しました。");
    				//同タイトルを複数回登録する場合を考えてテキストフィールドリセットはしない
    			} else {
    				JOptionPane.showMessageDialog(this, "既に商品登録されています。");
    			}
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
    	add(registerBtn);
    	add(backBtn);
    	add(topbackBtn);
	}
}
