package com.example.service;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.dao.BoardDao;
import com.example.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lombok.extern.slf4j.Slf4j;

@Service("boardService")
@Slf4j
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void create(HttpServletRequest request) {
		int limitSize = 1024 * 1024 * 10; // 10M
        String file = "";
        String originalFile = "";
        
        try {
            String path = ResourceUtils.getFile("classpath:upload/").toPath().toString();
            MultipartRequest multi = new MultipartRequest(request, path, limitSize,
                                    "utf-8", new DefaultFileRenamePolicy());
            Enumeration files = multi.getFileNames();
            String str = (String)files.nextElement();
            
            file = multi.getFilesystemName(str);
            originalFile = multi.getOriginalFileName(str);
            log.warn("filename = " + file);
            log.warn("originalFile = " + originalFile);
        } catch (Exception ex) {
        	log.error(ex.getMessage());
        }
	}

	@Override
	public void read(Map map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAll(Map map) {
		this.boardDao.selectAllBoard(map);
	}

	@Override
	public void update(BoardVO boardVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		
	}
	
}
