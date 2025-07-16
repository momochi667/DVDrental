package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberRegisterPanel extends JPanel {
	public MemberRegisterPanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(4, 2));
        
        //IDのテキストフィールド
    	JTextField idField = new JTextField();
    	
    	//名前のテキストフィールド
    	JTextField nameField = new JTextField();
    	
    	//登録ボタン
    	JButton registerBtn = new JButton("登録");
    	
    	//会員管理画面に戻るボタン
    	JButton backBtn = new JButton("会員管理画面へ戻る");
    	
        //TOPに戻るボタン
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	//登録ボタンリスナーで押されたらDBのインサート発動
    	/*registerBtn.addActionListener(e->{ 
    		return = DB.insertMember(idFieled.getText(), nameFiled.getText());
    		if ( return == 0 ) {
            JOptionPane.showMessageDialog(this, "会員登録が完了しました。");
            idField.setText("");
            } else {
            JOptionPane.showMessageDialog(this, "既に会員登録されています。");
            }
        });*/
    	
        //会員管理画面に戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("MEMBER"));
    	
        //TOPに戻るボタン
        topbackBtn.addActionListener(e->frame.showPanel("TOP"));
        
        //カードに部品を追加
        add(new JLabel("ID"));
        add(idField);
        add(new JLabel("氏名"));
        add(nameField);
        add(registerBtn);
        add(backBtn);
        add(topbackBtn);

    }
}
