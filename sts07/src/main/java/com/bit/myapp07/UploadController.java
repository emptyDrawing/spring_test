package com.bit.myapp07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.MultipartStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	String filepath ="C:\\spring\\spring2018\\upload\\";
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(Model model,@RequestParam(value="note") String note, 
			@RequestParam(value="upfile") MultipartFile file) {
		String filename = file.getOriginalFilename();
		System.out.println(file.getName()); // 파라미터 네임 >> upfile
		System.out.println(file.getOriginalFilename()); // pagelist.txt
		
		File saveFile = new File(filepath+filename);
		// 중복검사해야됨
		
		try {
			file.transferTo(saveFile); // file upload...
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("note",note);
		model.addAttribute("filename",filename);
		return "upload";
	}
	
	
	@RequestMapping(value="/download/{filename}")
	public void download(@PathVariable String filename, HttpServletResponse resp) {
		System.out.println(filename);
		File orginFile = new File(filepath+filename); // 확장자 이상함 고쳐야됨.
		try {
			FileCopyUtils.copy(new FileInputStream(orginFile), resp.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
