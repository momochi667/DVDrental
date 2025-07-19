package jp.swing.dvdrental;

import java.awt.GridLayout;
import java.text.Normalizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberRegisterPanel extends JPanel {
	public MemberRegisterPanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(4, 2));
        
        //生年月日のテキストフィールド
    	JTextField birthField = new JTextField();
    	
    	//名前のテキストフィールド
    	JTextField nameField = new JTextField();
    	
    	//登録ボタン
    	JButton registerBtn = new JButton("登録");
    	
    	//会員管理画面に戻るボタン
    	JButton backBtn = new JButton("会員管理画面へ戻る");
    	
        //TOPに戻るボタン
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	//登録ボタンリスナーで押されたらDBのインサート発動
    	registerBtn.addActionListener(e->{ 
    		if(nameField.getText().length() == 0 ) { //入力確認
    			JOptionPane.showMessageDialog(this, "氏名を入力してください。");
    		} else if(birthField.getText().length() == 0) {
    			JOptionPane.showMessageDialog(this, "生年月日を入力してください。");
    		}else {
    			//birthを半角に変換
    			String birth = Normalizer.normalize(birthField.getText(), Normalizer.Form.NFKC);
    			if ( DB.insertMember1(nameField.getText(), birth) == 0 ) {
    				DB.insertMember2(nameField.getText(), birth);
    				JOptionPane.showMessageDialog(this, "会員登録が完了しました。");
    				nameField.setText("");
    				birthField.setText("");
    			} else {
    				JOptionPane.showMessageDialog(this, "既に会員登録されています。");
    			}
    		}
        });
    	
        //会員管理画面に戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("MEMBER"));
    	
        //TOPに戻るボタン
        topbackBtn.addActionListener(e->frame.showPanel("TOP"));
        
        //カードに部品を追加
        add(new JLabel("氏名"));
        add(nameField);
        add(new JLabel("生年月日"));
        add(birthField);
        add(new JLabel(""));
        add(registerBtn);
        add(backBtn);
        add(topbackBtn);

    }
}
