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
	        cardPanel.add(new MemberSearchResultPanel(this), "MEMBER_SEARCHRESULT");
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
			switch (name) {
				case "MEMBER_SEARCHRESULT":
					setContentPane(new MemberSearchResultPanel(this)); // ←★新しく作る
					break;
				case "MEMBER":
					setContentPane(new MemberPanel(this));
					break;
				case "TOP":
					setContentPane(new TopPanel(this));
					break;
				case "MEMBER_REGISTER":
					setContentPane(new MemberRegisterPanel(this));
					break;
				case "MEMBER_DELETE":
					setContentPane(new MemberDeletePanel(this));
					break;
				case "MEMBER_SEARCH":
					setContentPane(new MemberSearchPanel(this));
					break;
				case "DVD":
					setContentPane(new DVDPanel(this));
					break;
				case "DVD_REGISTER":
					setContentPane(new DVDRegisterPanel(this));
					break;
				case "DVD_DELETE":
					setContentPane(new DVDDeletePanel(this));
					break;
				case "DVD_SEARCH":
					setContentPane(new DVDSearchPanel(this));
					break;
				case "DVD_SEARCHRESULT":
					setContentPane(new DVDSearchResultPanel(this));
					break;
				case "DVD_LIST":
					setContentPane(new DVDListPanel(this));
					break;
				case "LENT":
					setContentPane(new LentPanel(this));
					break;
				case "RETURN":
					setContentPane(new ReturnPanel(this));
					break;
					
			}
			revalidate();
			repaint();
	    }
}
