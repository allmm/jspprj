package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.dao.oracle.Noticeview;
import com.newlecture.web.entity.Notice;

public interface NoticeDao {

	List<Noticeview> getList() throws ClassNotFoundException, SQLException;//��� �ε�ɶ�
	List<Noticeview> getList(int page) throws ClassNotFoundException, SQLException;//����¡�ҋ�
	List<Noticeview> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;//�˻��Ҷ�
	
	Notice get(int id) throws SQLException, ClassNotFoundException;//���� �ε�ɶ�
	Notice getPrev(int id) throws ClassNotFoundException, SQLException;
	Notice getNext(int id) throws ClassNotFoundException, SQLException;
	
	int insert(Notice notice) throws ClassNotFoundException, SQLException;
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
}
