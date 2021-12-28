package io.github.anantharajuc.sbmwa.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.github.anantharajuc.sbmwa.model.StudentCountEntity;
import io.github.anantharajuc.sbmwa.service.CommonService;
import lombok.extern.log4j.Log4j2;


@RequestMapping("/smjh/common")
@Log4j2
@RestController
@CrossOrigin
public class CommonController 
{
	@Autowired
	public CommonService commonService;
	
	@GetMapping("/studentDisplay")
	public List<StudentCountEntity> studentDisplayDetails()
	{	
		log.info("-----> studentDisplayDetails controller");
		return commonService.studentDisplayDetails();
	}
	
	
	
	
	@PostMapping("/smsfileupload/{id}/{source}")
	public Object fileUpload(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") String id,@PathVariable("source") String source)
	{
		MultipartHttpServletRequest mRequest;
		String absoluteFileName=null;
		String filePath = null;
		String fileName = null;
		Map<String, String> statusMap = new HashMap<String, String>();
		try {
			mRequest = (MultipartHttpServletRequest) request;
			Object test = request.getCharacterEncoding();
			Object test1 = request.getHeaderNames();
			Iterator itr = mRequest.getFileNames();
			String rootPath ="";
			while (itr.hasNext()) {
				String value = (String) itr.next();
				MultipartFile mFile = mRequest.getFile(value);
				fileName = mFile.getOriginalFilename();
				System.out.println(fileName);
				if(source.equalsIgnoreCase("staff")) {
					 rootPath = "E:\\angularUI-main\\angularUI-main\\src\\main\\webapp\\resources\\js\\app\\images\\staff\\";
				}else {
					 rootPath = "E:\\angularUI-main\\angularUI-main\\src\\main\\webapp\\resources\\js\\app\\images\\student\\";
				}
				String[] fileNameSplit = fileName.split("\\.");
				java.nio.file.Path path = Paths.get(rootPath +id+"." + fileNameSplit[1]);
				Files.deleteIfExists(path);
				InputStream in = mFile.getInputStream();
				Files.copy(in, path);
				absoluteFileName=rootPath +id+"."+ fileNameSplit[1];
				filePath = path.toString();
			}
			statusMap.put("sucess", "sucess");
			statusMap.put("failure", null);
		}

		catch (NoSuchFileException fileExp) {
			statusMap.put("failure", "Please check the file upload path");
			return new ResponseEntity<Object>(statusMap, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			statusMap.put("failure", e.getCause().toString());
			return new ResponseEntity<Object>(statusMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String osname = System.getProperty("os.name");
		System.out.println("osname.................................");
		System.out.println(osname);
		// if(osname.matches("Windows 7")){
		String json = null;

		if (osname.indexOf("Win") >= 0) {
			filePath = filePath.replaceAll("\\\\", "/");
			json = "{\"filePath\":" + "\"" + filePath + "\", \"fileName\":" + "\"" + fileName + "\"}";
		} else {

			json = "{\"filePath\":" + "\"" + filePath + "\", \"fileName\":" + "\"" + fileName + "\"}";
		}

		return new ResponseEntity<Object>(json, HttpStatus.OK);
		
		}
	
	
}
