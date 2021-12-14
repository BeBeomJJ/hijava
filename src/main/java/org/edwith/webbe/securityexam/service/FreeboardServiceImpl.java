package org.edwith.webbe.securityexam.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.edwith.webbe.securityexam.dao.FreeboardDao;
import org.edwith.webbe.securityexam.dto.Freeboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FreeboardServiceImpl implements FreeboardService {
	@Autowired
	FreeboardDao freeboardDao;
	
	
	
	@Override
	@Transactional
	public List<Freeboard> getFreeboards(Integer start) {
		List<Freeboard> list = freeboardDao.selectAllFbList(start, FreeboardService.LIMIT);
		return list;
	}

	@Override
	public int getCount() {
		
		return freeboardDao.selectCount();
	}

	@Override
	public Freeboard insertFreeboard(Freeboard freeboard, String email) {
		freeboard.setCreateDate(new Date());
		int id = freeboardDao.insert(freeboard);
		freeboard.setId(id);
		freeboard.setMemberEmail(email);
		return freeboard;
	}

	

	@Override
	public Freeboard getFreeboardDetail(Integer id, String title) {
		return freeboardDao.selectFbDetail(id, title);
	}

	@Override
	public int updateFreeboardDetail(Freeboard freeboard, Integer id) {
		
		
		return freeboardDao.updateFbDetail(freeboard, id);
	}

	@Override
	public int deleteFreeboardDetail(Integer id) {
		
		
		return freeboardDao.deleteFbDetail(id);
	}
		
		

}
