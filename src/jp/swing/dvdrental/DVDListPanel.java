package jp.swing.dvdrental;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DVDListPanel  extends JPanel {
	
	public DVDListPanel (MainFrame frame) {
        //レイアウト追加
        setLayout(new BorderLayout());
        
        //表示フィールド追加
        JTextArea area = new JTextArea();
        area.setEditable(false);
        
        //Listを作成string型
       /* List<String> dvds = DB.();
        for(String dvd : dvds){ 
        	area.append(dvd + "\n");
        }
        */
        //TOP戻るボタン
        JButton backBtn = new JButton("TOPへ戻る");
        backBtn.addActionListener(e -> frame.showPanel("TOP"));
        
        //パネルに部品の追加
        add(new JScrollPane(area),BorderLayout.CENTER);
        add(backBtn,BorderLayout.SOUTH);
	}
}
