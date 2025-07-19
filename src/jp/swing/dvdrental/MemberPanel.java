package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MemberPanel extends JPanel {
	public MemberPanel(MainFrame frame) {
		setLayout(new GridLayout(4, 1, 10, 10));

		// 「会員登録」ボタンの設定　インスタンス名memberBtn
		JButton memberBtn = new JButton("会員登録");
		memberBtn.addActionListener(e -> frame.showPanel("MEMBER_REGISTER"));

	    // 「会員削除」ボタンの設定　インスタンス名delBtn 
	    JButton delBtn = new JButton("会員削除");
	    delBtn.addActionListener(e -> frame.showPanel("MEMBER_DELETE"));
	    
	    // 「会員検索」ボタンの設定　インスタンス名searchBtn 
	    JButton searchBtn = new JButton("会員検索");
	    searchBtn.addActionListener(e -> frame.showPanel("MEMBER_SEARCH"));
	    
	    //TOPに戻るボタン  
	    JButton backBtn = new JButton("TOPへ戻る");
	    backBtn.addActionListener(e->frame.showPanel("TOP"));
	       
	    add(memberBtn);
	    add(delBtn);
	    add(searchBtn);
	    add(backBtn);
	
	}
}
