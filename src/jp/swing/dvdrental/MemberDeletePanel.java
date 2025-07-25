package jp.swing.dvdrental;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberDeletePanel extends JPanel {
	public MemberDeletePanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(3, 2));
        
        //IDのテキストフィールド
    	JTextField idField = new JTextField();
    	
    	//削除ボタン
    	JButton delBtn = new JButton("削除");
    	delBtn.setBackground(Color.ORANGE);
    	//会員管理画面に戻るボタン
    	JButton backBtn = new JButton("会員管理画面へ戻る");
    	
        //TOPに戻るボタン
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	//削除ボタンリスナーで押されたらDBのインサート発動
    	delBtn.addActionListener(e->{ 
    		if(idField.getText().length() == 0 ) { //入力確認
    			JOptionPane.showMessageDialog(this, "会員IDを入力してください。");
    		} else if ( DB.deleteMember1(Integer.parseInt(idField.getText())) == 0 ) {
    			JOptionPane.showMessageDialog(this, "存在しない会員IDです。");
    			idField.setText("");
    		} else {
    			DB.deleteMember2(Integer.parseInt(idField.getText()));
    			JOptionPane.showMessageDialog(this, "削除が完了しました。");
    			idField.setText("");
    		}
        });
    	
    	//会員管理画面に戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("MEMBER"));
        
        //TOPに戻るボタン
        topbackBtn.addActionListener(e->frame.showPanel("TOP"));
        
        //カードに部品を追加
        add(new JLabel("会員ID"));
        add(idField);
        add(new JLabel(""));
        add(delBtn);
        add(backBtn);
        add(topbackBtn);

    }
}