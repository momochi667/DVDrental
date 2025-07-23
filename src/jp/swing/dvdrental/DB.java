package jp.swing.dvdrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {
	static final String URL = "jdbc:mysql://localhost/rentaldb";
	static final String USER = "root";
	static final String PASS = "";
	//DBアクセス＆ユーザー名とパスワード
	
	//会員の登録 重複チェック
		public static int insertMember1(String name, String birth) {
			int count = 0;
			try(Connection conn=DriverManager.getConnection(URL,USER,PASS);
					PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM customer WHERE name=? AND birth=?")){
				ps.setString(1, name);
				ps.setString(2, birth);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if (rs.getInt(1) != 0) {
						count = rs.getInt(1);
						break;
					}
				}
				ps.executeQuery();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return count;
		}

	//会員の登録
		public static void insertMember2(String name, String birth) {
			try(Connection conn=DriverManager.getConnection(URL,USER,PASS);
					PreparedStatement ps = conn.prepareStatement("INSERT INTO customer(name,birth) VALUES(?,?)")){
				ps.setString(1, name);
				ps.setString(2, birth);
				ps.executeUpdate();
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}
	
	//会員検索
		public static List<String>getMemberSearch(int id,String name){
			List<String>customers=new ArrayList<>();
			try(Connection conn=DriverManager.getConnection(URL,USER,PASS);
					PreparedStatement ps = conn.prepareStatement("SELECT id, name, birth FROM customer WHERE id = ? OR name LIKE ?")){
					ps.setInt(1, id);
					ps.setString(2, "%"+ name + "%");
					ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					customers.add(rs.getString("id")+  "-" + rs.getString("name")+  "-" + rs.getString("birth"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return customers;
		}
		
		//会員の削除 IDが存在するかチェック
				public static int deleteMember1(int id) {
					int count = 0;
					try(Connection conn=DriverManager.getConnection(URL,USER,PASS);
							PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM customer WHERE id=?")){
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							if (rs.getInt(1) != 0) {
								count = rs.getInt(1);
								break;
							}
						}
						ps.executeQuery();
					} catch (SQLException e) {
							e.printStackTrace();
					}
					return count;
				}
				
		//会員の削除
		public static void deleteMember2(int id) {
			try(Connection conn=DriverManager.getConnection(URL,USER,PASS);
					PreparedStatement ps=conn.prepareStatement("DELETE FROM customer WHERE id=?")){
				ps.setInt(1, id);
				ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
		//コードの重複チェック
		public static int searchDVDCode(String code) {
			int count = 0;
			try(Connection conn=DriverManager.getConnection(URL,USER,PASS);
					PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM dvd WHERE code=?")){
				ps.setString(1, code);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if (rs.getInt(1) != 0) {
						count = rs.getInt(1);
						break;
					}
				}
				ps.executeQuery();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return count;
		}
		
	// DVDの登録1 dvdテーブル
	public static void submitDVD1(String code, String title) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dvd(code, title, is_lent) VALUES(?, ?, true)")){
				
			ps.setString(1, code);
			ps.setString(2, title);
			ps.executeUpdate();
			//int result = ps.executeUpdate();
			//System.out.println("挿入件数:" + result);
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DVDの登録2 rentalテーブル
	public static void submitDVD2(String code) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO rental( dvd_code) VALUES(?)")){	
			ps.setString(1, code);
			ps.executeUpdate();
			//int result = ps.executeUpdate();
			//System.out.println("挿入件数:" + result);
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DVDの検索(変更)
	public static List<String> searchDVD(String code) {
		List<String> list = new ArrayList<>();
				
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("SELECT code, title, is_lent FROM dvd WHERE code LIKE '?'")){
			ps.setString(1, code + "%");

			ResultSet result = ps.executeQuery();
					
			while (result.next()) {
			    list.add(result.getString("code") + "-" + result.getString("title") + "-" + result.getString("is_lent"));
			}	
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
	}
	
	// DVD一覧
	public static List<String> listDVD() {
		List<String> list = new ArrayList<>();
			
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT d.code, d.title, d.is_lent, r.rented_day, r.due_day, r.returned_day "
					+ "FROM dvd AS d LEFT OUTER JOIN rental AS r ON d.code = r.dvd_code")){
				
				while (result.next()) {
					list.add(result.getString("d.code") + "-" + result.getString("d.title") + "-" + result.getString("d.is_lent") + "-" + result.getString("r.rented_day") + "-" + result.getString("r.due_day"));
				}	
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	
	// DVD削除 
	public static void deleteDVD(String code) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM dvd WHERE code = ?")){
				
			ps.setString(1, code);
			ps.executeUpdate();
			//int result = ps.executeUpdate();
			//System.out.println("削除件数:" + result);
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
		// DVDの検索2(変更)
		public static List<String> searchDVD2(String code, String title) {
			List<String> list = new ArrayList<>();
				
			try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = conn.prepareStatement("SELECT d.code, d.title, d.is_lent, r.rented_day, r.due_day, r.returned_day "
						+ "FROM dvd AS d LEFT OUTER JOIN rental AS r d.code = r.dvd_code WHERE d.code LIKE ? OR d.title = ?")){
				ps.setString(1, code + "%");
				ps.setString(2, "%" + title + "%");

				ResultSet result = ps.executeQuery();			

				while (result.next()) {
				    list.add(result.getString("code") + "-" + result.getString("title") + "-" + result.getString("is_lent"));
				}	
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			return list;
		}
	
	//貸出処理その1　dvdテーブルの更新
	public static void lendDVD1 (int memberID, String dvdCode) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
					PreparedStatement ps = conn.prepareStatement("UPDATE dvd SET is_lent = false WHERE code = ?")){
					ps.setString(1, dvdCode);
					ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	//貸出処理その2　rentalテーブルの更新
	public static void lendDVD2(int memberID, String dvdCode) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = conn.prepareStatement("UPDATE rental SET customer_id = ?, rented_day = CURRENT_DATE, due_day = CURRENT_DATE + INTERVAL 7 DAY, returned_day = NULL WHERE dvd_code = ?")){
				ps.setLong(1, memberID);
				ps.setString(2, dvdCode);
				ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//貸出後画面用　処理を行ったユーザーが他にレンタルしているdvdのコード,タイトル,返却予定日を取得する
	public static List<String> getLenDVD(int id) {
		List<String> DVD = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT d.code, d.title, r.due_day FROM rental AS r LEFT OUTER JOIN dvd AS d ON r.dvd_code = d.code WHERE r.customer_id = ? and d.is_lent = false ORDER BY r.due_day")){ //SQL実行
				while(rs.next()) { //DVD内に値がある限り続ける
					DVD.add(rs.getString("d.code") + "-" + rs.getString("d.title") + "-" + rs.getString("r.due_day")); 
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DVD;
	}
	
	//返却処理その1　dvdテーブル更新
	public static void returnDVD1(String code) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = conn.prepareStatement("UPDATE dvd SET is_lent = true WHERE code = ?")){
				ps.setString(1, code);
				ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//返却処理その2　rentalテーブル更新
	public static void returnDVD2(String code) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = conn.prepareStatement("UPDATE rental SET returned_day = CURRENT_DATE where dvd_code = ?")){
				ps.setString(1, code);
				ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//返却処理その3　既に貸し出し済みの物か確認
	public static int returnDVD3(String code) {
		int count = 0;
		try(Connection conn=DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM dvd WHERE is_lent = false AND code = ?")){
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt(1) != 0) {
					count = rs.getInt(1);
					break;
				}
			}
			ps.executeQuery();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return count;
	}
}
