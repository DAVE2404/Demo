package com.example.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.vo.BoardVO;

public interface BoardService {
	void create(HttpServletRequest request);
	void read(Map map);
	void readAll(Map map);
	void update(BoardVO boardVo);
	void delete(int idx);
}
