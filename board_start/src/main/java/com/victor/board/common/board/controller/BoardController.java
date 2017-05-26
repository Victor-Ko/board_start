package com.victor.board.common.board.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
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

import com.victor.board.common.board.dto.BoardDto;
import com.victor.board.common.board.service.BoardService;
import com.victor.board.common.member.dto.MemberDto;
import com.victor.board.common.util.AJaxResVO;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value ="/boardMain")
	public ModelAndView boardMain(HttpServletRequest request, Locale locale, Model model, HttpSession session){
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		
		BoardDto boardDto = new BoardDto();
		
		if (memberInfo != null) {
			request.setAttribute("memberInfo", memberInfo);
			
			List<BoardDto> board = boardService.selectBoard(boardDto);
			
			ModelAndView result = new ModelAndView();
			result.addObject("board", board);
			result.setViewName("/boardMain");

			return result;
		}else{
			RedirectView rv = new RedirectView(request.getContextPath() + "/");
			rv.setExposeModelAttributes(false);

			return new ModelAndView(rv);
		}
	}
	
	@RequestMapping(value = "/boardInsert")
	public ModelAndView boardInsert(HttpServletRequest request, Locale locale, Model model, HttpSession session){
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		
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
	public ModelAndView boardSelect(HttpServletRequest request, Locale locale, Model model, HttpSession session){
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		
		BoardDto boardDto = new BoardDto();
		
		if (memberInfo != null) {
			request.setAttribute("userInfo", memberInfo);
			
			if(request.getParameter("boardSeq") != null && !request.getParameter("boardSeq").isEmpty()){
				boardDto.setBoardSeq(Integer.parseInt(request.getParameter("boardSeq")));
			}
			List<BoardDto> board = boardService.selectBoardDetail(boardDto);
			boardService.updateViews(boardDto);
			
			ModelAndView result = new ModelAndView();
			result.addObject("board", board);
			result.setViewName("/board/readBoard");
			
			return result;
		}else{
			RedirectView rv = new RedirectView(request.getContextPath() + "/");
			rv.setExposeModelAttributes(false);

			return new ModelAndView(rv);
		}
	}
	
	@RequestMapping(value = "/insertBoard")
	public @ResponseBody AJaxResVO insertBoard(HttpServletRequest request, HttpSession session) {
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
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
	
	@RequestMapping(value = "/deleteBoard")
	public @ResponseBody AJaxResVO selectBoard(HttpServletRequest request, HttpSession session) {
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		AJaxResVO jRes = new AJaxResVO();
		
		BoardDto boardDto = new BoardDto();
		
		try {
			if(memberInfo != null){
				if(request.getParameter("boardSeq") != null && !request.getParameter("boardSeq").isEmpty()){
					boardDto.setBoardSeq(Integer.parseInt(request.getParameter("boardSeq")));
				}
				if(request.getParameter("userId") != null && !request.getParameter("userId").isEmpty()){
					boardDto.setUserId(request.getParameter("userId"));
				}
				
				Integer iRes = boardService.deleteBoard(boardDto);
				
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
