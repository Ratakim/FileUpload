package com.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {

		String savedFileName = "";

		// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치(프로젝트 외부에 저장)
		String uploadPath = "C:/test/upload/";

		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();

		// 3. 파일 이름 중복되지 않게 이름 변경(서버에 저장할 이름) UUID 사용
		UUID uuid = UUID.randomUUID();
		savedFileName = uuid.toString() + "_" + originalFileName;

		// 4. 파일 생성
		File file1 = new File(uploadPath + savedFileName);

		// 5. 서버로 전송
		file.transferTo(file1);

		System.out.println(savedFileName);
		
		model.addAttribute("originalFileName", originalFileName);

		return "uploadResult";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String fileDownloadList(Model model) {

		// 폴더에 있는 전체 파일 목록 가져오기
		File path = new File("C:/test/upload");
		String[] fileList = path.list();

		model.addAttribute("fileList", fileList);

		return "download";
	}

	@RequestMapping("/download.do")
	public void fileDownload(String file, HttpServletResponse response) throws Exception {

		File f = new File("C:/test/upload", file);

		System.out.println("file = " + file);
		System.out.println("f = " + f);

		// file 다운로드 설정
		response.setContentType("application/download");
		response.setContentLength((int) f.length());
		response.setHeader("Content-disposition", "attachment;filename=\"" + f + "\"");

		// response 객체를 통해서 서버로부터 파일 다운로드
		OutputStream os = response.getOutputStream();

		// 파일 입력 객체 생성
		FileInputStream fis = new FileInputStream(f);
		FileCopyUtils.copy(fis, os);
		fis.close();
		os.close();

		/*
		 * int readCount = 0; byte[] buffer = new byte[1024];
		 * 
		 * while ((readCount = fis.read(buffer)) != -1) { os.write(buffer, 0,
		 * readCount);
		 */

		/*
		 * String ext = FilenameUtils.getExtension(savedFileName);
		 * System.out.println("extension : " + ext);
		 */

	}
}
