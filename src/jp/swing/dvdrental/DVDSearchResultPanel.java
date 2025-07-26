package jp.swing.dvdrental;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DVDSearchResultPanel extends JPanel {
		
		public DVDSearchResultPanel (MainFrame frame) {
	        //レイアウト追加
	        setLayout(new BorderLayout());
	        
	        String[]title = {"DVDコード", "タイトル", "在庫", "貸出日", "返却予定日", "返却日"};
	        List<String> dvds = DB.searchDVD2(DVDSearchPanel.code, DVDSearchPanel.title);
	        //二次元配列に変換
	        String[][] list = new String[dvds.size()][];  
	        for(int i=0; i < dvds.size();i++) {
	        	list[i] = dvds.get(i).split(",");
	        }
	        //表示フィールド追加
	        JTable table = new JTable(list, title);
	        
	        //管理に戻るボタン
	        JButton backBtn = new JButton("DVD検索画面へ戻る");
	        backBtn.addActionListener(e -> frame.showPanel("DVD_SEARCH"));
	        
	        //パネルに部品の追加
	        add(new JScrollPane(table), BorderLayout.CENTER);
	        add(backBtn,BorderLayout.SOUTH);
	        
		}
}
