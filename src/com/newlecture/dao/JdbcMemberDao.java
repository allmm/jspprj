package com.newlecture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JdbcMemberDao implements MemberDao{

	String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
	
	@Override
	public Member get(String id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		List<Member> list = new ArrayList<>();
		String sql = "select * from member";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Member member = new Member(
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name"),
						rs.getInt("gender"),
						rs.getInt("age"),
						rs.getString("birthday"),
						rs.getString("phone"),
						rs.getDate("regdate")
						);
				list.add(member);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //드라이버 로드
	
		return list;
	}

	@Override
	public List<Member> getList(String query) {
		List<Member> list = new ArrayList<>();
		Member member =null;
		String sql = "select * from member where id like'%"+query+"%'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
					member = new Member(
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name"),
						rs.getInt("gender"),
						rs.getInt("age"),
						rs.getString("birthday"),
						rs.getString("phone"),
						rs.getDate("regdate")
						);
				list.add(member);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //드라이버 로드
		return list;
	}

	
}
