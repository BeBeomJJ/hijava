package org.edwith.webbe.securityexam.dao;

import static org.edwith.webbe.securityexam.dao.FreeboardDaoSqls.*;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.edwith.webbe.securityexam.dto.Freeboard;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class FreeboardDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Freeboard> rowMapper = BeanPropertyRowMapper.newInstance(Freeboard.class);
	
	public FreeboardDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("freeboard")
				.usingGeneratedKeyColumns("id");
	}
		
	public List<Freeboard> selectAllFbList(Integer start, Integer limit ){
		Map<String, Integer> param = new HashMap<>();
		param.put("start", start);
		param.put("limit", limit);
		
		
		return jdbc.query(SELECT_ALL_FB_LIST_PAGING, param, rowMapper);
	}
	
	public Freeboard selectFbDetail(Integer id, String title){
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("title", title);
		
		return jdbc.queryForObject(SELECT_FB_DETAIL, param, rowMapper);
	}
	
	
	public int insert(Freeboard freeboard) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(freeboard);
		
		return insertAction.executeAndReturnKey(params).intValue();
		
	}
	
	public int updateFbDetail(Freeboard freeboard, Integer id) {
		Map<String, Object> params = new HashMap<>();
		
		params.put("title", freeboard.getTitle());
		params.put("content", freeboard.getContent());
		params.put("modifyDate", new Date());
		params.put("id", id);
		
		return jdbc.update(UPDATE_FB_DETAIL, params);
	}
	
	public int deleteFbDetail(Integer id) {
		Map<String, ?> param = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_FB_DETAIL, param);
	}
	
	
	
	public int selectCount() {
		return jdbc.queryForObject(GET_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	
	
	
	
}
