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
    	JTextField idornameFieled = new JTextField();
    	
    	//検索ボタン
    	JButton seartchBtn = new JButton("検索");
    	
    	//会員管理画面に戻るボタン
    	JButton backBtn = new JButton("会員管理画面へ戻る");
    	
        //TOPに戻るボタン
    	JButton topbackBtn = new JButton("TOPへ戻る");
    	
    	//登録ボタンリスナーで押されたらDBのインサート発動
    	/*seartchBtn.addActionListener(e->{ 
    		DB.insertMember(idFieled.getText(), nameFiled.getText());
    		if (  == 0 ) {
            JOptionPane.showMessageDialog(this, "会員登録が完了しました。");
            } else {
            JOptionPane.showMessageDialog(this, "一致するものが見つかりませんでした。");
            }
        });*/
    	
    	//会員管理画面に戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("MEMBER"));
        
        //TOPに戻るボタン
        topbackBtn.addActionListener(e->frame.showPanel("TOP"));
        
        //カードに部品を追加
        add(new JLabel("ID又は氏名を入力"));
        add(idornameFieled);
        add(seartchBtn);
        add(backBtn);
        add(topbackBtn);

    }	
}
