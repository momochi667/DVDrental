package jp.swing.dvdrental;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemberSearchResultPanel extends JPanel {
	public MemberSearchResultPanel(MainFrame frame) {
        //レイアウト追加
        setLayout(new BorderLayout());
        
        //表示フィールド追加
        JTextArea area = new JTextArea();
        area.setEditable(false);
        
        //Listを作成string型
        List<String>member = MemberSearchPanel.search;
        for (String mem : member) {
        	area.append( mem + "\n");
        }
        JButton backBtn = new JButton("TOPへ戻る");
        
        //TOP戻るボタン
        backBtn.addActionListener(e->frame.showPanel("TOP"));

        //パネルに部品の追加
        add(new JScrollPane(area),BorderLayout.CENTER);
        add(backBtn,BorderLayout.SOUTH);

    }

}
