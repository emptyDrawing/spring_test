package com.bit.myapp08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	String filepath = "C:\\spring\\spring2018\\upload\\";
	
	@RequestMapping("/add")
	public String goform() {
		return "uploadForm";
	}

	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public String upload( String name,MultipartFile file, Model model) throws IllegalStateException, IOException{
		System.out.println(name);
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
	
		String reFileName = file.getOriginalFilename()+"@@@"+System.currentTimeMillis();
		File target = new File(filepath+reFileName);
		
		file.transferTo(target);

		model.addAttribute("name",name);
		model.addAttribute("orginName", file.getOriginalFilename());
		model.addAttribute("reName", reFileName);
		
		return "result";
		
//		InputStream is = null;
//		BufferedInputStream buffIs = null;
//		
//		FileOutputStream fos = null;
//		BufferedOutputStream buffOs = null;
//		try {
//			is = file.getInputStream();
//			buffIs = new BufferedInputStream(is);
//			
//			fos = new FileOutputStream(target);
//			buffOs = new BufferedOutputStream(fos);
//			
//			byte[] buff = new byte[256];
//			int su = 0;
//			while((su = buffIs.read(buff))>0) {
//				buffOs.write(buff,0,su);
//			}
//			buffOs.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				is.close();
//				fos.close();
//				model.addAttribute("name", name);
//				model.addAttribute("file", file.getOriginalFilename());
//				model.addAttribute("filesize", file.getSize());
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}// upload() end
	
	@RequestMapping("/download")
	public void download2(String file, String orgin, HttpServletResponse resp) {
		
		// download.. setting ver.1
		resp.setContentType("application/octet-stream; charset=UTF-8");
		resp.setHeader("Content-Disposition", "attachment; filename=\""+orgin+"\"");
		
		
		File source = new File(filepath+file);
		FileInputStream fis = null;
		BufferedInputStream buffIs = null;
		
		ServletOutputStream os = null;
		BufferedOutputStream buffOs = null;
		
		byte[] buff = new byte[128];
		
		try {
			fis = new FileInputStream(source);
			buffIs = new BufferedInputStream(fis);
			
			os = resp.getOutputStream();
			buffOs = new BufferedOutputStream(os);

			int su = 0 ;
			while((su=buffIs.read(buff))>0) {
				buffOs.write(buff, 0, su);
			}
			buffOs.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				buffOs.close();
				os.close();

				buffIs.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// try-catch-finally

	
	}

		
	@RequestMapping("/down/{orgin}")
	public void download(String file, @PathVariable String orgin, HttpServletResponse resp) {

		// download.. setting ver2
		resp.setContentType("application/octet-stream; charset=UTF-8");
		File source = new File(filepath+file);
		
		FileInputStream fis = null;
		ServletOutputStream os = null;
		
		try {
			fis = new FileInputStream(source);
			os = resp.getOutputStream();
			FileCopyUtils.copy(fis, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// try-catch-finally
		
	}// download()

	
}
