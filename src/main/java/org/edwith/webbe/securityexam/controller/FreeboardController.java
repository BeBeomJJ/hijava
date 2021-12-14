package org.edwith.webbe.securityexam.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.edwith.webbe.securityexam.dto.AddComment;
import org.edwith.webbe.securityexam.dto.Freeboard;
import org.edwith.webbe.securityexam.service.AddCommentService;
import org.edwith.webbe.securityexam.service.FreeboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/freeboard")
public class FreeboardController {
	@Autowired
	FreeboardService freeboardService;
	
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
						Principal principal,
						ModelMap model) {
		String clientId = principal.getName();
		List<Freeboard> list = freeboardService.getFreeboards(start);
		
		int count = freeboardService.getCount();
		int pageCount = count / FreeboardService.LIMIT;
		if( count % FreeboardService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0 ; i < pageCount ; i++) {
			pageStartList.add( i * FreeboardService.LIMIT);
		}
		
		model.addAttribute("clientId", clientId);
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList );
		
		return "/freeboard/freeboardlist";
	}
	
	@GetMapping(path="/freeboardDetail")
	public String detail(@RequestParam(name="id", required=true) int id,
							@RequestParam(name="title", required=true) String title,
							ModelMap model,
							Principal principal) {

		String clientId = principal.getName();
		
		Freeboard freeboard = freeboardService.getFreeboardDetail(id, title);
		
		System.out.println();
		
		model.addAttribute("freeboard", freeboard);
		model.addAttribute("clientId", clientId);
		
		return "/freeboard/freeboarddetail";
	}
	
	
	
	@GetMapping(path="/updateForm")
	public String updateform(@RequestParam(name="id" ,required=true) int id,
							@RequestParam(name="title", required=true) String title ,
							Principal principal,
								ModelMap model) {
		String clientId = principal.getName();
		Freeboard freeboard =  freeboardService.getFreeboardDetail(id, title);
		
		System.out.println(freeboard.getContent());
		System.out.println(freeboard.getTitle());
		
		model.addAttribute("freeboard", freeboard);
		model.addAttribute("clientId", clientId);
		
		return "freeboard/updateform";
	}
	
	@PostMapping(path="/update")
	public String updateFbDetail(@ModelAttribute Freeboard freeboard) {
		
		freeboardService.updateFreeboardDetail(freeboard, freeboard.getId());
		
		return "redirect:/freeboard/list";
	}
	
	
	
	@GetMapping(path="/deleteFbDetail")
	public String deleteFbDetail(@RequestParam(name="id", required=true) int id) {
		freeboardService.deleteFreeboardDetail(id);
		return "redirect:/freeboard/list";
		
	}
	
		
	
	@GetMapping(path="/insertform")
	public String insertform() {
		return "/freeboard/insertform";
	}
	
	@PostMapping(path="/insert")
	public String insert(@ModelAttribute Freeboard freeboard,
							Principal principal) {
		
		String clientName = principal.getName();
		System.out.println("clientName :" + clientName);
		
		freeboard.setMemberEmail(clientName);
		
		freeboardService.insertFreeboard(freeboard, clientName);
		
		return "redirect:/freeboard/list";
		
	}
	
	
	@Autowired
	AddCommentService acs;

	@ResponseBody
	@PostMapping(path="/insertandlist")
	public List<AddComment> list(@ModelAttribute AddComment addComment,
								Principal principal,
								String memberEmail,
								String comment,
								Integer freeboardNo) {
		
		
		
		System.out.println(memberEmail);
		System.out.println(comment);
		System.out.println(freeboardNo);
		
		addComment.setComment(comment);
		
		
		acs.insertAddComment(addComment, freeboardNo, memberEmail);
		
		List<AddComment> list = acs.getComments(freeboardNo);
		
		
		
		return list;
	}

	@ResponseBody
	@PostMapping(path="/commentList")
	public List<AddComment> commentList(
								Integer freeboardNo) {
		
		
		List<AddComment> list = acs.getComments(freeboardNo);
		
		return list;
	}
		
}
