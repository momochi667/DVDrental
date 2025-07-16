package jp.swing.dvdrental;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DVDPanel  extends JPanel {
	public DVDPanel(MainFrame frame) {
	       setLayout(new GridLayout(6, 1, 10, 10));

	       //DVDの登録　インスタンス名 dvdBtn
	       JButton dvdBtn = new JButton("DVD登録");
	       dvdBtn.addActionListener(e -> frame.showPanel("DVD_REGISTER"));
	       
	       //DVDの検索　インスタンス名 searchBtn
	       JButton searchBtn = new JButton("DVD検索");
	       searchBtn.addActionListener(e -> frame.showPanel("DVD_SEARCHRESULT"));
	       
	       //DVDの削除　インスタンス名 searchBtn
	       JButton deleteBtn = new JButton("DVD削除");
	       deleteBtn.addActionListener(e -> frame.showPanel("DVD_DELETE"));
	       
	       //DVDの一覧表示　インスタンス名 listBtn
	       JButton listBtn = new JButton("DVD一覧");
	       listBtn.addActionListener(e -> frame.showPanel("DVD_LIST"));
	       
	       //TOPに戻るボタン　インスタンス名 topbackBtn
	       JButton topbackBtn = new JButton("TOPへ戻る");
	       topbackBtn.addActionListener(e -> frame.showPanel("TOP"));
	       
	       add(dvdBtn);
	       add(searchBtn);
	       add(deleteBtn);
	       add(listBtn);
	       add(topbackBtn);
	}
}
