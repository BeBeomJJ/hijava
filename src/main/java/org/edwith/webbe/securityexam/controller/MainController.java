package org.edwith.webbe.securityexam.controller;

import java.security.Principal;

import org.edwith.webbe.securityexam.dto.Member;
import org.edwith.webbe.securityexam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@Autowired
	private MemberService memberService;
	
	
    @RequestMapping("/main")
    public String main(Principal principal, ModelMap modelMap){
    	
    	try {
			
    		System.out.println(principal.getName());
    		String loginid = principal.getName();
    		
    		Member member =  memberService.getMemberByEmail(loginid);
    		modelMap.addAttribute("mem", member);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "main";
    }

    @RequestMapping("/securepage")
    @ResponseBody
    public String securitypage(){
        return "secure page";
    }
}