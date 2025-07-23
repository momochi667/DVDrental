package jp.swing.dvdrental;

import java.awt.GridLayout;
import java.text.Normalizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnPanel extends JPanel{
	 public ReturnPanel(MainFrame frame) {
	       
	    	setLayout(new GridLayout(3, 2));
	    	JTextField dvdCodeField = new JTextField();
	    	JButton returnBtn = new JButton("返却");
	    	JButton backBtn = new JButton("TOPへ戻る");
	    	JButton DVDPanelbackBtn = new JButton("DVD管理画面へ戻る");
	    	 //貸出画面に行くボタン
	        JButton LentPanelbackBtn = new JButton("貸出画面へ行く");
	    	returnBtn.addActionListener(e->{
	    		//半角変換
	    		String code = Normalizer.normalize(dvdCodeField.getText(), Normalizer.Form.NFKC);
	    		
	    		if (dvdCodeField.getText().length() == 0) {//入力確認
	    			JOptionPane.showMessageDialog(this, "DVDコードを入力してください。");
	    		} else if (DB.searchDVDCode(code) == 0) {//DVDコード確認
		 			//DVDコードが存在するかチェック
		 			JOptionPane.showMessageDialog(this, "存在しないDVDコードです。");
		 			dvdCodeField.setText("");
	    		} else if (DB.returnDVD3(code) == 0) {//貸出処理確認
	    			JOptionPane.showMessageDialog(this, "貸出処理の行われていないDVDコードです。");
		 			dvdCodeField.setText("");
	    		} else {
	    			DB.returnDVD1(dvdCodeField.getText());
	    			DB.returnDVD2(dvdCodeField.getText());
	    			JOptionPane.showMessageDialog(this, "返却が完了しました");
	    			dvdCodeField.setText("");
	    		}
	    	});
	    	
	    	backBtn.addActionListener(e -> frame.showPanel("TOP")); 
		 	DVDPanelbackBtn.addActionListener(e -> frame.showPanel("DVD"));
	    	
	         add(new JLabel("DVDコード"));
	         add(dvdCodeField);
	         add(new JLabel(""));
	         add(returnBtn);
	         add(backBtn);
	         add(DVDPanelbackBtn);
	         
	    }
	}
