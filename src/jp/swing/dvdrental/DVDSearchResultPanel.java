package jp.swing.dvdrental;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DVDSearchResultPanel extends JPanel {
		
		public DVDSearchResultPanel (MainFrame frame) {
	        //レイアウト追加
	        setLayout(new BorderLayout());
	        
	        //表示フィールド追加
	        JTextArea area = new JTextArea();
	        area.setEditable(false);
	        
	        //Listを作成string型
	        if(DVDSearchPanel.code != null ) {
	        	List<String> searchs = DB.searchDVD(DVDSearchPanel.code); 
	        	for(String search : searchs){ 
	        		area.append(search + "\n");
	        	}
	        }else if(DVDSearchPanel.title != null ) {
		        List<String> searchs = DB.searchDVD(DVDSearchPanel.title); 
		        for(String search : searchs){ 
		        	area.append(search + "\n");
		        }
	        }
	        
	        //CENTERに入れるためのパネル作成
	        JPanel centerPanel = new JPanel();
	        centerPanel.setLayout(new BorderLayout());
	        centerPanel.add(new JScrollPane(area), BorderLayout.CENTER);
	        
	        //DVD管理画面に戻るボタン
	        JButton centerBtn = new JButton("DVD管理画面に戻る");
	        centerPanel.add(centerBtn, BorderLayout.SOUTH);
	        centerBtn.addActionListener(e -> frame.showPanel("DVD"));
	        
	        //TOP戻るボタン
	        JButton backBtn = new JButton("TOPへ戻る");
	        backBtn.addActionListener(e -> frame.showPanel("TOP"));
	        
	        //パネルに部品の追加
	        add(centerPanel, BorderLayout.CENTER);
	        add(backBtn,BorderLayout.SOUTH);
	        
		}
}
