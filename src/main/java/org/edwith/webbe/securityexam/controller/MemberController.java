package org.edwith.webbe.securityexam.controller;

import org.edwith.webbe.securityexam.dto.Member;
import org.edwith.webbe.securityexam.service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(path = "/members")
public class MemberController {
    // 스프링 컨테이너가 생성자를 통해 자동으로 주입한다.
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    @GetMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }

    @GetMapping("/joinform")
    public String joinform(){
        return "members/joinform";
    }
    
    @GetMapping("/joinadminform")
    public String joinAdminForm() {
    	return "members/joinadminform";
    }

    // 사용자가 입력한 name, email, password가 member에 저장된다.
    @PostMapping("/join")
    public String join(@ModelAttribute Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.addMember(member, false);
        return "redirect:/";
    }
    
    @PostMapping("joinadmin")
    public String joinAdmin(@ModelAttribute Member member) {
    	member.setPassword(passwordEncoder.encode(member.getPassword()));
    	memberService.addMember(member, true);
    	return "redirect:/";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "members/welcome";
    }

    @GetMapping("/memberinfo")
    public String memberInfo(Principal principal, ModelMap modelMap){
        String loginId = principal.getName();
        Member member = memberService.getMemberByEmail(loginId);
        modelMap.addAttribute("member", member);
        modelMap.addAttribute("loginId", loginId);

        return "members/memberinfo";
    }
}