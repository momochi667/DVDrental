package jp.swing.dvdrental;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

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
    		//入力チェック
    		if (idField.getText().isEmpty() && nameField.getText().isEmpty()) {
    			JOptionPane.showMessageDialog(this, "会員ID又は氏名を入力してください。");
    			return;
    		}
    		
    		//会員ID欄に数値が打ち込まれてるかチェック
    		if(idField.getText().length() != 0) {
    			boolean isDigit = true;
    			try {
    				Integer.parseInt(idField.getText());
    			} catch (Exception err) {
    				isDigit = false;
    			}
    			
    			if(isDigit == false) {
    				JOptionPane.showMessageDialog(this, "会員ID欄に数字を入力してください。");
    				idField.setText("");
    				return;
    			}
            }
            
            //返り値判定
    		memberid = idField.getText().isEmpty() ? 0 : Integer.parseInt(idField.getText());
			membername = nameField.getText().isEmpty() ? "0" : nameField.getText();
    		List<String>list = DB.getMemberSearch(memberid, membername);
    		
    		if(list.isEmpty()) { 
    			JOptionPane.showMessageDialog(this, "一致する検索結果が見つかりませんでした。");
    			idField.setText("");
    			nameField.setText("");
    		} else {
    			//結果パネルに移動
    			frame.showPanel("MEMBER_SEARCHRESULT");
    			idField.setText("");
    			nameField.setText("");
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