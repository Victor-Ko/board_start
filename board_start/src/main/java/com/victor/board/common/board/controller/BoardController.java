package com.victor.board.common.board.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.victor.board.common.board.dto.BoardDto;
import com.victor.board.common.board.service.BoardService;
import com.victor.board.common.member.dto.MemberDto;
import com.victor.board.common.util.AJaxResVO;
import com.victor.board.common.util.SessionManager;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value ="/boardMain")
	public ModelAndView boardMain(HttpServletRequest request, Locale locale, Model model){
		MemberDto memberInfo = SessionManager.getUserInfo(request);
		
		if (memberInfo != null) {
			request.setAttribute("userInfo", memberInfo);
			
			ModelAndView result = new ModelAndView();
			result.setViewName("/boardMain");

			return result;
		}else{
			RedirectView rv = new RedirectView(request.getContextPath() + "/");
			rv.setExposeModelAttributes(false);

			return new ModelAndView(rv);
		}
	}
	
	@RequestMapping(value = "/boardInsert")
	public ModelAndView boardInsert(HttpServletRequest request, Locale locale, Model model){
		MemberDto memberInfo = SessionManager.getUserInfo(request);
		
		if (memberInfo != null) {
			request.setAttribute("userInfo", memberInfo);
			
			ModelAndView result = new ModelAndView();
			result.setViewName("/board/newBoard");

			return result;
		}else{
			RedirectView rv = new RedirectView(request.getContextPath() + "/");
			rv.setExposeModelAttributes(false);

			return new ModelAndView(rv);
		}
	}
	
	@RequestMapping(value = "/boardSelect")
	public ModelAndView boardSelect(HttpServletRequest request, Locale locale, Model model){
		MemberDto memberInfo = SessionManager.getUserInfo(request);
		
		if (memberInfo != null) {
			request.setAttribute("userInfo", memberInfo);
			
			ModelAndView result = new ModelAndView();
			result.setViewName("/board/readBoard");

			return result;
		}else{
			RedirectView rv = new RedirectView(request.getContextPath() + "/");
			rv.setExposeModelAttributes(false);

			return new ModelAndView(rv);
		}
	}
	
	@RequestMapping(value = "/insertBoard")
	public @ResponseBody AJaxResVO insertBoard(HttpServletRequest request) {
		MemberDto memberInfo = SessionManager.getUserInfo(request);
		AJaxResVO jRes = new AJaxResVO();
		
		BoardDto boardDto = new BoardDto();
		
		try {
			if(memberInfo != null){
				String userId = memberInfo.getUserId();
				
				boardDto.setUserId(userId);
				if(request.getParameter("boardTitle") != null && !request.getParameter("boardTitle").equals("")){
					boardDto.setBoardTitle(request.getParameter("boardTitle"));
				}
				if(request.getParameter("boardViews") != null && !request.getParameter("boardTitle").equals("")){
					boardDto.setBoardViews(Integer.parseInt(request.getParameter("boardViews")));
				}
				if(request.getParameter("boardContents") != null && !request.getParameter("boardTitle").equals("")){
					boardDto.setBoardContents(request.getParameter("boardContents"));
				}
				
				Integer iRes = boardService.insertBoard(boardDto);
				
				if(iRes>0){
					jRes.setResult(request.getParameter("cReceptNum"));
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
	
	@RequestMapping(value = "/selectBoard")
	public @ResponseBody AJaxResVO selectBoard(HttpServletRequest request) {
		MemberDto memberInfo = SessionManager.getUserInfo(request);
		AJaxResVO jRes = new AJaxResVO();
		
		BoardDto boardDto = new BoardDto();
		
		try {
			if(memberInfo != null){
				BoardDto boardInfo = boardService.selectBoard(boardDto);
				
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
