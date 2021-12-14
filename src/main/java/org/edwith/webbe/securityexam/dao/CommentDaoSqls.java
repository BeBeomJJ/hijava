package org.edwith.webbe.securityexam.dao;

public class CommentDaoSqls {
	public static final String SELECT_ALL_COMMENT = "SELECT id, member_email, freeboard_no, comment, create_date FROM ADDCOMMENT WHERE freeboard_no = :freeboardNo ORDER BY create_date desc";
}
