package jp.swing.dvdrental;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	 private CardLayout cardLayout;
	    private JPanel cardPanel;

	    public MainFrame() {
	        setTitle("レンタル管理");
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(600, 400);

	        cardLayout = new CardLayout();
	        cardPanel = new JPanel(cardLayout);

	        // すべての機能パネルを登録
	        cardPanel.add(new TopPanel(this), "TOP");
	        cardPanel.add(new MemberPanel(this), "MEMBER");
	        cardPanel.add(new MemberRegisterPanel(this), "MEMBER_REGISTER");
	        cardPanel.add(new MemberDeletePanel(this), "MEMBER_DELETE");
	        cardPanel.add(new MemberSearchPanel(this), "MEMBER_SEARCH");
	        //cardPanel.add(new MemberSearchResultPanel(this), "MEMBER_SEARCHRESULT");
	        cardPanel.add(new DVDPanel(this), "DVD");
	        cardPanel.add(new DVDRegisterPanel(this), "DVD_REGISTER");
	        cardPanel.add(new DVDDeletePanel(this), "DVD_DELETE");
	        //cardPanel.add(new DVDSearchPanel(this), "DVD_SEARCH");
	        //cardPanel.add(new DVDSearchResultPanel(this), "DVD_SEARCHRESULT");
	        cardPanel.add(new DVDListPanel(this), "DVD_LIST");
	        cardPanel.add(new LentPanel(this), "LENT");
	        cardPanel.add(new ReturnPanel(this), "RETURN");

	        add(cardPanel);
	        setVisible(true);
	    }

		public void showPanel(String name) {
	        cardLayout.show(cardPanel, name);
	    }
}
