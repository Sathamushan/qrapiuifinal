package io.github.anantharajuc.sbmwa.controller;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
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

import io.github.anantharajuc.sbmwa.model.AttenceRecordCountEntity;
import io.github.anantharajuc.sbmwa.model.StaffsEntity;
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
	
	@GetMapping("/totalAttendanceReport/{id}")
	public List<AttenceRecordCountEntity> totalAttendanceReport(@PathVariable("id") String id) {	
		log.info("-----> totalAttendanceReport controller");
		return commonService.attendanceReport(id);
	}
	
	
	/*@GetMapping("/getClassByStudId/{classe}/{section}")
	public  Object getClassByStudId(@PathVariable("classe") String classe,@PathVariable("section") String section) {	
		log.info("-----> getClassByStudId controller");
		return commonService.getClassByStudId(classe,section);
	}*/

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
				}else if(source.equalsIgnoreCase("leave")) {
					rootPath = "E:\\StudentUIFinal\\angularUI-main\\angularUI-main\\src\\main\\webapp\\resources\\js\\app\\images\\leave\\";
				}
				else {
					rootPath = "E:\\angularUI-main\\angularUI-main\\src\\main\\webapp\\resources\\js\\app\\images\\student\\";
				}
				String[] fileNameSplit = fileName.split("\\.");
				java.nio.file.Path path = Paths.get(rootPath +id+"." + fileNameSplit[1]);
				Files.deleteIfExists(path);
				InputStream in = mFile.getInputStream();
				//resizeImage(in,path);
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

	private void resizeImage(InputStream is, Path path) {
		try {

	        Image image = ImageIO.read(is);

	        BufferedImage bi = this.createResizedCopy(image, 180, 180, true);
	        //ImageIO.write(bi, "jpg", path);

	    } catch (IOException e) {
	        System.out.println("Error");
	    }

	
		
	}
	
	
	BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
	    int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
	    BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
	    Graphics2D g = scaledBI.createGraphics();
	    if (preserveAlpha) {
	        g.setComposite(AlphaComposite.Src);
	    }
	    g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
	    g.dispose();
	    return scaledBI;
	}
	
	
	
	
	@PostMapping("/bulkUpload/{id}/{source}")
	public Object bulkUpload(HttpServletRequest request, HttpServletResponse response,
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
				}else if(source.equalsIgnoreCase("leave")) {
					rootPath = "E:\\StudentUIFinal\\angularUI-main\\angularUI-main\\src\\main\\webapp\\resources\\js\\app\\images\\leave\\";
				}
				else if(source.equalsIgnoreCase("import")) {
					rootPath = "E:\\angularUI-main\\angularUI-main\\src\\main\\webapp\\resources\\js\\app\\images\\import\\";
				}
				String[] fileNameSplit = fileName.split("\\.");
				java.nio.file.Path path = Paths.get(rootPath +id+"." + fileNameSplit[1]);
				Files.deleteIfExists(path);
				InputStream in = mFile.getInputStream();
				//resizeImage(in,path);
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
		
		bulkImport();
		
		
		
		String osname = System.getProperty("os.name");
		System.out.println("osname.................................");
		System.out.println(osname);
		String json = null;

		if (osname.indexOf("Win") >= 0) {
			filePath = filePath.replaceAll("\\\\", "/");
			json = "{\"filePath\":" + "\"" + filePath + "\", \"fileName\":" + "\"" + fileName + "\"}";
		} else {

			json = "{\"filePath\":" + "\"" + filePath + "\", \"fileName\":" + "\"" + fileName + "\"}";
		}
		return new ResponseEntity<Object>(json, HttpStatus.OK);
	}
	

	private void bulkImport() {
		String fileName ="E:\\APIQRFINALUI\\FinalApiforUI\\src\\main\\resources\\path\\SCHOOLTESTDATA.xlsx";
		try (BufferedReader bf = new BufferedReader(new FileReader(new File(fileName))); Connection con = getOtherSchemaConnection();){
			String line = null;
			String columnHeader = bf.readLine();
			System.out.println("Header :" + columnHeader);
			String[] rowHeader = columnHeader.split(",", -1);
			StringBuilder insertQuery;
			StringBuilder insertQueryInitial = new StringBuilder();
			insertQueryInitial.append("insert into studentdetails(" + columnHeader
					+ ",CONTACT_STATUS,SMS_SOURCE_ID,SMS_SOURCE_TYPE,TEMPLATEID,SMS_GATEWAY,SMS_CREATE_DATE) values(");
			while ((line = bf.readLine()) != null) {
				line = line.replaceAll("\\'", "\\\\'");
				String[] row = line.split(",", -1);
				insertQuery = new StringBuilder();
				insertQuery.append(insertQueryInitial.toString());
				//	insertQuery.append("'NEW',").append(smsfileId).append(",'FILE',").append(templateId).append(",'VF','").append(new Timestamp(new Date().getTime())).append("')");
				System.out.println(insertQuery.toString());
				try (PreparedStatement ppt = con.prepareStatement(insertQuery.toString())) {
					ppt.executeUpdate();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				insertQuery = null;

			}

		}
		catch (Exception e) {

			System.out.println(e.getMessage());
		}


	} 
	
	
	

	public Connection getOtherSchemaConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/smjsys_qa";
			String username = "smjsys_qa";
			String password = "smjsys_qa";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
		return connection;

	}
		
	}