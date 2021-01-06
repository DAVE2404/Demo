package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.BoardService;
import com.example.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public String list(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.boardService.readAll(map);
		List<BoardVO> list = (List<BoardVO>)map.get("results");
		log.warn("size = " + list.size());
		model.addAttribute("boardlist", list);
		return "list";     //  /templates/list.html
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";     // /templates/write.html
	}
	
//	@PostMapping("/write")
//	public String write() {
//		return "redirect:/list";
//	}
}
