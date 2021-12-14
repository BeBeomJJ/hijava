package org.edwith.webbe.securityexam.dao;

import static org.edwith.webbe.securityexam.dao.CommentDaoSqls.SELECT_ALL_COMMENT;
import static org.edwith.webbe.securityexam.dao.FreeboardDaoSqls.SELECT_ALL_FB_LIST_PAGING;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.edwith.webbe.securityexam.dto.AddComment;
import org.edwith.webbe.securityexam.dto.Freeboard;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<AddComment> rowMapper = BeanPropertyRowMapper.newInstance(AddComment.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("AddComment")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<AddComment> selectAllComment(Integer freeboardNo){
		Map<String, Integer> param = new HashMap<>();
		param.put("freeboardNo", freeboardNo);
		
		
		return jdbc.query(SELECT_ALL_COMMENT, param, rowMapper);
	}
	
	public int insert(AddComment addComment) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(addComment);
		
		return insertAction.executeAndReturnKey(params).intValue();
		
	}

}
