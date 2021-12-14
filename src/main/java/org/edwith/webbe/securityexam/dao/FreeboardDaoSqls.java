package org.edwith.webbe.securityexam.dao;

public class FreeboardDaoSqls {
	//public static final String SELECT_ALL_FB_LIST_PAGING = "SELECT id, title, member_email, create_date FROM FREEBOARD ORDER BY id DESC LIMIT :start, :limit";
	public static final String SELECT_ALL_FB_LIST_PAGING = "select sub.number, sub.id, sub.title, sub.member_email, sub.create_date from " 
															+"(select @rownum:=@rownum+1 as number, f.* from freeboard f, "
															+"(select @rownum:=0) tmp order by create_date asc)sub order by sub.number desc LIMIT :start, :limit";
	public static final String GET_COUNT = "SELECT COUNT(*) FROM FREEBOARD";
	public static final String SELECT_FB_DETAIL = "SELECT id, title, content, member_email, create_date, modify_date FROM FREEBOARD WHERE id = :id and title = :title";
	public static final String UPDATE_FB_DETAIL = "UPDATE freeboard SET title = :title, content = :content, modify_date = :modifyDate WHERE id = :id ";
	public static final String DELETE_FB_DETAIL = "DELETE FROM freeboard where id = :id";
}
