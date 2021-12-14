package org.edwith.webbe.securityexam.service;

import java.util.List;

import org.edwith.webbe.securityexam.dto.AddComment;
import org.edwith.webbe.securityexam.dto.Freeboard;

public interface AddCommentService {
	public AddComment insertAddComment(AddComment addComment, Integer freeboardNo, String memberEmail);
	public List<AddComment> getComments(Integer freeboardNo);

}
