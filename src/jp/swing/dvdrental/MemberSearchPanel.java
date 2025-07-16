package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberSearchPanel extends JPanel {
	public MemberSearchPanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(3, 2));
        
        //IDのテキストフィールド
    	JTextField idField = new JTextField();
    	
    	//名前のテキストフィールド
    	JTextField nameField = new JTextField();
    	
    	//検索ボタン
    	JButton seartchBtn = new JButton("検索");
    	
    	//会員管理画面に戻るボタン
    	JButton backBtn = new JButton("会員管理画面へ戻る");
    	
        //TOPに戻るボタン
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	//登録ボタンリスナーで押されたらDBのインサート発動
    	seartchBtn.addActionListener(e->{ 
    		DB.getMemberSearch(Integer.parseInt(idField.getText()), nameField.getText());
        });
    	
    	//会員管理画面に戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("MEMBER"));
        
        //TOPに戻るボタン
        topbackBtn.addActionListener(e->frame.showPanel("TOP"));
        
        //カードに部品を追加
        add(new JLabel("ID又は氏名を入力"));
        add(idField);
        add(nameField);
        add(seartchBtn);
        add(backBtn);
        add(topbackBtn);

    }	
}
