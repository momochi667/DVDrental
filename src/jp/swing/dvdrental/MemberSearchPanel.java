package jp.swing.dvdrental;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberSearchPanel extends JPanel {
	
	public static int memberid;
	public static String membername;
	public MemberSearchPanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(4, 2));
        
        //IDのテキストフィールド
    	JTextField idField = new JTextField();
    	
    	//名前のテキストフィールド
    	JTextField nameField = new JTextField();
    	
    	//検索ボタン
    	JButton searchBtn = new JButton("検索");
    	searchBtn.setBackground(Color.ORANGE);
    	//会員管理画面に戻るボタン
    	JButton backBtn = new JButton("会員管理画面へ戻る");
    	
        //TOPに戻るボタン
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	//検索ボタンリスナーで押されたらDBのインサート発動
    	searchBtn.addActionListener(e->{ 	
    		if (idField.getText().isEmpty() && nameField.getText().isEmpty()) {
    			JOptionPane.showMessageDialog(this, "会員ID又は氏名を入力してください。");
    			} else {
    			// IDが空欄なら 0 に
    			memberid = idField.getText().isEmpty() ? 0 : Integer.parseInt(idField.getText());

    			// nameが空なら "%%" を渡す（LIKEで全件ヒットさせる）
    			membername = nameField.getText().isEmpty() ? "0" : nameField.getText();

    			frame.showPanel("MEMBER_SEARCHRESULT");
    			}
        });
    	
    	//会員管理画面に戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("MEMBER"));
        
        //TOPに戻るボタン
        topbackBtn.addActionListener(e->frame.showPanel("TOP"));
        
        //カードに部品を追加
        add(new JLabel("会員IDを入力"));
        add(idField);
        add(new JLabel("氏名を入力"));
        add(nameField);
        add(new JLabel(""));
        add(searchBtn);
        add(backBtn);
        add(topbackBtn);

    }	
}