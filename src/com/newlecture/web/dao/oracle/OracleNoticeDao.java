package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class OracleNoticeDao implements NoticeDao{
	
	@Override
	public List<Noticeview> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1,"title","");
	}
	@Override
	public List<Noticeview> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(page,"title","");
	}
	@Override
	public List<Noticeview> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Noticeview> list = new ArrayList<>();
		
		int start =(page-1)*10+1;
		int end =page+9;
		
		String sql ="SELECT * FROM NOTICE_VIEW " + 
				"WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�// ���� Ŭ���� �ε� (oracleDriver�̶�� Ŭ������ �ε��ϴ°�)
		
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,  "%"+query+"%");
		st.setInt(2,  start);
		st.setInt(3,  end);
		
		
		ResultSet rs = st.executeQuery();
		
		
		
		while(rs.next()) {
			Noticeview notice = new Noticeview(
					 rs.getInt("id")
					,rs.getString("title")
					,""
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit")
					,rs.getInt("comment_count"));
					list.add(notice);
		}
		
					
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	@Override
	public Notice get(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Notice notice = null;
		
		String sql=" select * from notice where id= "+id;
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�// ���� Ŭ���� �ε� (oracleDriver�̶�� Ŭ������ �ε��ϴ°�)

		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//db�� �����Ѵ�.
		Statement st = con.createStatement();//next�� �ǹ� : �о�ö� �������� ó������ �о���Ƿ� next�� ������ 
											 //�� �ο츦 �о���� �����ο�� ��������. next�ϸ� �������� �������鼭 
											 //�����͸� �������� �ϴ� ���� ������ ���� next�� ������ �ݺ��� ������.
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					 rs.getInt("id")
					,rs.getString("title")
					,rs.getString("content")
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	@Override
	public Notice getPrev(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Notice notice =null;
		String sql = " select * from notice_view "
				+ "	where regdate < (select regdate from notice where id=' "+id+" ') and rownum = 1 ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					 rs.getInt("id")
					,rs.getString("title")
					,""//rs.getString("content")
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	@Override
	public Notice getNext(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Notice notice =null;
		String sql =" select* from (select * from (select * from notice_view order by regdate) "
				+ " where regdate > (select regdate from notice where id ="+id+")) where  rownum=1 ";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					 rs.getInt("id")
					,rs.getString("title")
					,""//rs.getString("content")
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	
	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql =" insert into notice(id, title, content, writer_id) values(notice_seq.nextval,?,?,'jun') ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,  notice.getTitle());
		st.setString(2, notice.getContent());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result =0;
		
		String sql =" update notice set title=?, content=? where id=? ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,  notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3,  notice.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result =0;
		
		String sql =" delete from notice where id=? ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		                                                                                                                                 
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
