package org.edwith.webbe.securityexam.service;

import java.util.Date;
import java.util.List;

import org.edwith.webbe.securityexam.dao.CommentDao;
import org.edwith.webbe.securityexam.dto.AddComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCommentServiceImpl implements AddCommentService {
	
	@Autowired
	CommentDao commentDao;
		
	@Override
	public AddComment insertAddComment(AddComment addComment, Integer freeboardNo, String memberEmail) {
		addComment.setCreateDate(new Date());
		addComment.setFreeboardNo(freeboardNo);
		addComment.setMemberEmail(memberEmail);
		
		int count = commentDao.insert(addComment);
		
		return addComment;
	}

	@Override
	public List<AddComment> getComments(Integer freeboardNo) {
		
		List<AddComment> list = commentDao.selectAllComment(freeboardNo);
		
		return list;
	}

}
