package com.victor.board.common.member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.victor.board.common.member.dto.MemberDto;
import com.victor.board.common.member.service.MemberService;
import com.victor.board.common.util.AJaxResVO;
import com.victor.board.common.util.SessionManager;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/login/init.do")
	public ModelAndView login(HttpServletRequest request, Locale locale, Model model) throws IOException{
		
		ModelAndView result =  new ModelAndView();
		result.setViewName("/index");
		
		return result;
	}
	
	@RequestMapping(value = "/memberInsert")
	public ModelAndView memberInsert(HttpServletRequest request, Locale locale, Model model){
	
		ModelAndView result = new ModelAndView();
		result.setViewName("/member/memberInsert");

		return result;
	}
	
	@RequestMapping(value = "/memberUpdate")
	public ModelAndView memberUpdate(HttpServletRequest request, Locale locale, Model model, HttpSession session){
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		
		if (memberInfo != null) {
			request.setAttribute("userInfo", memberInfo);
			
			ModelAndView result = new ModelAndView();
			result.setViewName("/member/memberUpdate");

			return result;
		}else{
			RedirectView rv = new RedirectView(request.getContextPath() + "/");
			rv.setExposeModelAttributes(false);

			return new ModelAndView(rv);
		}
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, Locale locale, HttpSession session){

		session.invalidate();
		RedirectView rv = new RedirectView(request.getContextPath()+"/");

		rv.setExposeModelAttributes(false);

		return new ModelAndView(rv);

	}
	
	/* �꽭�뀡 �쑀吏� */
	@RequestMapping(value = "/sessionExtension.do")
	public @ResponseBody AJaxResVO sessionExtension(HttpServletRequest request, Locale locale, HttpSession session){
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		AJaxResVO jRes = new AJaxResVO();

		// �꽭�뀡�뿉 �떞湲� �궡�슜�씠 �뾾�쑝硫�
		if(memberInfo == null) {

		} else {
			memberInfo.setUserFirstName(memberInfo.getUserFirstName());
			memberInfo.setUserLastName(memberInfo.getUserLastName());
			memberInfo.setUserGender(memberInfo.getUserGender());
			memberInfo.setUserBirth(memberInfo.getUserBirth());
			memberInfo.setUserEmail(memberInfo.getUserEmail());
			memberInfo.setUserAuth(memberInfo.getUserAuth());

			request.setAttribute("userInfo", memberInfo);
		}

		return jRes;
	}
	
	@RequestMapping(value = "/login/loginChk.do")
	public @ResponseBody AJaxResVO loginChk(HttpServletRequest request, HttpServletResponse response, Locale locale, HttpSession session) throws ServletException, IOException, ParseException {
		AJaxResVO jRes = new AJaxResVO();
		
		try {
			
			MemberDto memberDto = new MemberDto();
			
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			String rememberId = request.getParameter("rememberId");
				
			memberDto.setUserId(userId);
			memberDto.setUserPw(userPw);
			
			if(rememberId != null && rememberId.equals("on")){
				Cookie cookie;
				
				cookie = new Cookie("userId", userId.toString());
				cookie.setMaxAge(86400*30);
				cookie.setPath("/");
				response.addCookie(cookie);
				
				cookie = new Cookie("rememberId", rememberId.toString());
				cookie.setMaxAge(86400*30);
				cookie.setPath("/");
				response.addCookie(cookie);
			}else{
				Cookie cookie;
				
				cookie = new Cookie("userId", userId.toString());
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				
				cookie = new Cookie("rememberId", rememberId.toString());
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			
			MemberDto memberInfo = memberService.selectUserInfo(memberDto);
			
			if(memberInfo == null){
				// 怨꾩젙 �뜲�씠�꽣媛� �뾾�쑝硫�
				jRes.setResult("0");
				jRes.setSuccess(AJaxResVO.SUCCESS_N);
			}else{
				memberInfo.setUserFirstName(memberInfo.getUserFirstName());
				memberInfo.setUserLastName(memberInfo.getUserLastName());
				memberInfo.setUserGender(memberInfo.getUserGender());
				memberInfo.setUserBirth(memberInfo.getUserBirth());
				memberInfo.setUserEmail(memberInfo.getUserEmail());
				memberInfo.setUserAuth(memberInfo.getUserAuth());

				//SessionManager.setAttribute(request, "SES_KEY_USER_INFO", memberInfo);
				session.setAttribute("memberInfo", memberInfo);
				
				jRes.setResult("1");
				jRes.addAttribute("mainPath", "/boardMain");
				jRes.setSuccess(AJaxResVO.SUCCESS_Y);
			}
			
		} catch (Exception e) {
			logger.error("", e);
			jRes.setSuccess(AJaxResVO.SUCCESS_N);
		}
		
		return jRes;
	}
	
	@RequestMapping(value = "/insertMember")
	public @ResponseBody AJaxResVO insertMember(HttpServletRequest request) {
		AJaxResVO jRes = new AJaxResVO();
		
		MemberDto newMemberInfo = new MemberDto();
		
		try {
			if(request.getParameter("userId") != null && !request.getParameter("userId").isEmpty()){
				newMemberInfo.setUserId(request.getParameter("userId"));
			}
			if(request.getParameter("userPw") != null && !request.getParameter("userPw").isEmpty()){
				newMemberInfo.setUserPw(request.getParameter("userPw"));
			}
			if(request.getParameter("userFirstName") != null && !request.getParameter("userFirstName").isEmpty()){
				newMemberInfo.setUserFirstName(request.getParameter("userFirstName"));
			}
			if(request.getParameter("userLastName") != null && !request.getParameter("userLastName").isEmpty()){
				newMemberInfo.setUserLastName(request.getParameter("userLastName"));
			}
			if(request.getParameter("userGender") != null && !request.getParameter("userGender").isEmpty()){
				newMemberInfo.setUserGender(request.getParameter("userGender"));
			}
			if(request.getParameter("userBirth") != null && !request.getParameter("userBirth").isEmpty()){
				newMemberInfo.setUserBirth(request.getParameter("userBirth"));
			}
			if(request.getParameter("userEmail") != null && !request.getParameter("userEmail").isEmpty()){
				newMemberInfo.setUserEmail(request.getParameter("userEmail"));
			}
			Integer check = memberService.checkUserInfo(newMemberInfo);
			if(check == null){
				check = 0;
			}
			if(check > 0){
				jRes.setResult("MemberDuplicate");
				jRes.setSuccess(AJaxResVO.SUCCESS_N);
			}else{
				Integer iRes = memberService.insertUserInfo(newMemberInfo);
				
				if(iRes>0){
					jRes.setResult("1");
					jRes.setSuccess(AJaxResVO.SUCCESS_Y);
				}else{
					jRes.setResult("NOTHING");
					jRes.setSuccess(AJaxResVO.SUCCESS_N);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jRes.setResult("ERROR");
			jRes.setSuccess(AJaxResVO.SUCCESS_N);
		}
		
		return jRes;
	}
	
	@RequestMapping(value = "/updateMember")
	public @ResponseBody AJaxResVO updateMember(HttpServletRequest request, HttpSession session) {
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		AJaxResVO jRes = new AJaxResVO();
		
		MemberDto newMemberInfo = new MemberDto();
		
		try {
			if(memberInfo != null){
				if(request.getParameter("userId") != null && !request.getParameter("userId").isEmpty()){
					newMemberInfo.setUserId(request.getParameter("userId"));
				}
				if(request.getParameter("userPw") != null && !request.getParameter("userPw").isEmpty()){
					newMemberInfo.setUserPw(request.getParameter("userPw"));
				}
				if(request.getParameter("userAuth") != null && !request.getParameter("userAuth").isEmpty()){
					newMemberInfo.setUserAuth(request.getParameter("userAuth"));
				}
				if(request.getParameter("userEmail") != null && !request.getParameter("userEmail").isEmpty()){
					newMemberInfo.setUserEmail(request.getParameter("userEmail"));
				}
				
				Integer iRes = memberService.updateUserInfo(newMemberInfo);
					
				if(iRes>0){
					jRes.setResult("Success");
					jRes.setSuccess(AJaxResVO.SUCCESS_Y);
				}else{
					jRes.setResult("NOTHING");
					jRes.setSuccess(AJaxResVO.SUCCESS_N);
				}
				
			}else{
				jRes.setResult("LOGINFAIL");
				jRes.setSuccess(AJaxResVO.SUCCESS_N);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jRes.setResult("ERROR");
			jRes.setSuccess(AJaxResVO.SUCCESS_N);
		}
		
		return jRes;
	}
	
	@RequestMapping(value = "/deleteMember")
	public @ResponseBody AJaxResVO deleteMember(HttpServletRequest request, HttpSession session) {
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		AJaxResVO jRes = new AJaxResVO();
		
		MemberDto newMemberInfo = new MemberDto();
		
		try {
			if(memberInfo != null){
				if(request.getParameter("userId") != null && !request.getParameter("userId").isEmpty()){
					newMemberInfo.setUserId(request.getParameter("userId"));
				}
				
				Integer iRes = memberService.deleteUserInfo(newMemberInfo);
				
				if(iRes>0){
					jRes.setResult("Success");
					jRes.setSuccess(AJaxResVO.SUCCESS_Y);
				}else{
					jRes.setResult("NOTHING");
					jRes.setSuccess(AJaxResVO.SUCCESS_N);
				}
				
			}else{
				jRes.setResult("LOGINFAIL");
				jRes.setSuccess(AJaxResVO.SUCCESS_N);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jRes.setResult("ERROR");
			jRes.setSuccess(AJaxResVO.SUCCESS_N);
		}
		
		return jRes;
	}
}
