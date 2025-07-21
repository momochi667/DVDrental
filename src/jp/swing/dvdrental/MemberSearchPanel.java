package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberSearchPanel extends JPanel {
	
	static int memberid;
	static String membername;

	public MemberSearchPanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(4, 2));
        
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
    	
    	//検索ボタンリスナーで押されたらDBのインサート発動
    	seartchBtn.addActionListener(e->{ 	
    		//入力確認
    		if(idField.getText().length() == 0 && nameField.getText().length() == 0){ //入力確認
    			JOptionPane.showMessageDialog(this, "会員ID又は氏名を入力してください。");
    		} else {
    			DB.getMemberSearch(Integer.parseInt(idField.getText()), nameField.getText());
    			memberid = Integer.parseInt(idField.getText());
    			membername = nameField.getText();
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
        add(seartchBtn);
        add(backBtn);
        add(topbackBtn);

    }	
}
