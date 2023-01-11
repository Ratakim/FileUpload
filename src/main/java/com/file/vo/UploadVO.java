package com.file.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UploadVO {
	private String name;
	private MultipartFile file;
}