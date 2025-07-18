package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberDeletePanel extends JPanel {
	public MemberDeletePanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(2, 3));
        
        //IDのテキストフィールド
    	JTextField idField = new JTextField();
    	
    	//削除ボタン
    	JButton delBtn = new JButton("削除");
    	//会員管理画面に戻るボタン
    	JButton backBtn = new JButton("会員管理画面へ戻る");
    	
        //TOPに戻るボタン
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	//削除ボタンリスナーで押されたらDBのインサート発動
    	delBtn.addActionListener(e->{ 
    		DB.deleteMember(Integer.parseInt(idField.getText()));
            JOptionPane.showMessageDialog(this, "削除が完了しました。");
            idField.setText("");
        });
    	
    	//会員管理画面に戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("MEMBER"));
        
        //TOPに戻るボタン
        topbackBtn.addActionListener(e->frame.showPanel("TOP"));
        
        //カードに部品を追加
        add(new JLabel("ID"));
        add(idField);
        add(delBtn);
        add(new JLabel(""));
        add(backBtn);
        add(topbackBtn);

    }
}