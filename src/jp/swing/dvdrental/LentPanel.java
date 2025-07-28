package jp.swing.dvdrental;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.Normalizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LentPanel extends JPanel{
	 public LentPanel(MainFrame frame) {
		 setLayout(new GridLayout(4,2));
	    	JTextField memberIdField = new JTextField();
	    	JTextField dvdCodeField = new JTextField();
	    	 JButton lendBtn = new JButton("貸出");
	    	 lendBtn.setBackground(Color.ORANGE);
	    JButton backBtn = new JButton("TOPへ戻る");
	    //返却画面に行くボタン
	    //JButton ReturnPanebackBtn = new JButton("返却画面へ行く");
	    //dvd管理に行くボタン
	    JButton DVDPanelbackBtn = new JButton("DVD管理画面へ行く");
	    
	 	lendBtn.addActionListener(e ->{ 
	 		//半角変換
	 		String code = Normalizer.normalize(dvdCodeField.getText(), Normalizer.Form.NFKC);
	 		
	 		if(memberIdField.getText().length() == 0){ //入力確認
    			JOptionPane.showMessageDialog(this, "会員IDを入力してください。");
    		} else if(dvdCodeField.getText().length() == 0) {
    			JOptionPane.showMessageDialog(this, "DVDコードを入力してください。");
    		} else if(DB.deleteMember1(Integer.parseInt(memberIdField.getText())) == 0) {
    			//会員IDが存在するかチェック
	 			JOptionPane.showMessageDialog(this, "存在しない会員IDです。");
	 			memberIdField.setText("");
	 		} else if (DB.searchDVDCode(code) == 0) {
	 			//DVDコードが存在するかチェック
	 			JOptionPane.showMessageDialog(this, "存在しないDVDコードです。");
	 			dvdCodeField.setText("");
	 		} else {
	 			DB.lendDVD1(Integer.parseInt(memberIdField.getText()),code);
	 			DB.lendDVD2(Integer.parseInt(memberIdField.getText()),code);
	 			JOptionPane.showMessageDialog(this, "貸出が完了しました。");
	 			memberIdField.setText("");
	 			dvdCodeField.setText("");
	 		}
	    });
	 	backBtn.addActionListener(e -> frame.showPanel("TOP")); 
	 	DVDPanelbackBtn.addActionListener(e -> frame.showPanel("DVD"));
	 	
	 	add(new JLabel("会員ID"));
    	add(memberIdField);
    	add(new JLabel("DVDコード"));
    	add(dvdCodeField);
    	add(new JLabel(""));
    	add(lendBtn);
    	add(DVDPanelbackBtn);
    	add(backBtn);
	}

}
