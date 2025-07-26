package jp.swing.dvdrental;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberSearchResultPanel extends JPanel {
	public MemberSearchResultPanel(MainFrame frame) {
		
        //レイアウト追加
        setLayout(new BorderLayout());
        
        String[]title = {"会員ID", "氏名", "生年月日"};
        List<String>member = DB.getMemberSearch(MemberSearchPanel.memberid, MemberSearchPanel.membername);
      //二次元配列に変換
        String[][] list = new String[member.size()][];  
        for(int i=0; i < member.size();i++) {
        	list[i] = member.get(i).split(",");
        }
        
      //表示フィールド追加
        JTable table = new JTable(list, title);
        
        //検索に戻るボタン
        JButton backBtn = new JButton("会員検索画面へ戻る");
        backBtn.addActionListener(e->frame.showPanel("MEMBER_SEARCH"));

        //パネルに部品の追加
        add(new JScrollPane(table),BorderLayout.CENTER);
        add(backBtn,BorderLayout.SOUTH);

    }
}
