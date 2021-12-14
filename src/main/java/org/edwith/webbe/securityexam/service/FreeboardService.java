package org.edwith.webbe.securityexam.service;

import java.util.List;
import java.util.Map;

import org.edwith.webbe.securityexam.dto.Freeboard;

public interface FreeboardService {
	public static final Integer LIMIT = 5;
	public List<Freeboard> getFreeboards(Integer start);
	public Freeboard insertFreeboard(Freeboard freeboard, String email);
	public Freeboard getFreeboardDetail(Integer id, String title);
	public int updateFreeboardDetail(Freeboard freeboard, Integer id);
	public int deleteFreeboardDetail(Integer id);
	public int getCount();
}
