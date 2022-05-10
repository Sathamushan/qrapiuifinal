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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
		String filePath = null;
		String fileName = null;
		Map<String, String> statusMap = new HashMap<String, String>();
		try {
			mRequest = (MultipartHttpServletRequest) request;
			Iterator itr = mRequest.getFileNames();
			String rootPath ="";
			while (itr.hasNext()) {
				String value = (String) itr.next();
				MultipartFile mFile = mRequest.getFile(value);
				fileName = mFile.getOriginalFilename();
				System.out.println(fileName);
				if(source.equalsIgnoreCase("staff")) {
					rootPath = "C:\\Users\\satham00553\\Documents\\smj_uploads\\staff\\";
				}else if(source.equalsIgnoreCase("leave")) {
					rootPath = "C:\\Users\\satham00553\\Documents\\smj_uploads\\leave\\";
				}
				else if(source.equalsIgnoreCase("student")) {
					rootPath = "C:\\Users\\satham00553\\Documents\\smj_uploads\\student\\";
				}else if(source.equalsIgnoreCase("import")) {
					rootPath = "C:\\Users\\satham00553\\Documents\\smj_uploads\\fileuploads\\";
				}
				String[] fileNameSplit = fileName.split("\\.");
				java.nio.file.Path path=null;
				if(fileNameSplit[1].equalsIgnoreCase("xlsx") || fileNameSplit[1].equalsIgnoreCase("csv")) {
					path = Paths.get(rootPath + fileNameSplit[0]+"." + fileNameSplit[1]);
				}else {
					path = Paths.get(rootPath +id+"." + fileNameSplit[1]);
				}
				Files.deleteIfExists(path);
				InputStream in = mFile.getInputStream();
				//resizeImage(in,path);
				Files.copy(in, path);
				//absoluteFileName=rootPath +id+"."+ fileNameSplit[1];
				filePath = path.toString();
				if(source.equalsIgnoreCase("import")) {
					bulkImport(fileName,fileNameSplit[1]);
				}
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
	
	
	
	
	
	

	private void bulkImport(String OrgfileName, String fileNameSplit) {
		
		String headerColumns= " `rollno`,`studentnameinenglish`,`studentnameintamil`, `classforwhich`,`section`,`fathernameinenglish`,`fathersoccupation`, `fathereducationlevel`  ,`mothernameinenglish`,"
				+ "  `mothersoccupation`,mothereducationlevel,`guardiannameinenglish`,`guardianoccupation`,`aadharnumber` , `mobilenumber`, `dateofbirth` ,`gender`,`dateofjoining`,"
				+ " `streetnameareaname`, `pincode`,`bloodgroup`,`religion`,`mediumofinstruction` ,`admissionnumber`, `classe`,`disabilitygroupname`,`groupcode`,`mothertongue`,`photourl`";
		
		if(fileNameSplit.equalsIgnoreCase("xlsx")) {
			try {
				String fileName ="C:\\Users\\satham00553\\Documents\\smj_uploads\\fileuploads\\"+OrgfileName;
				OPCPackage fis = OPCPackage.open(new File(fileName));
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				//XSSFSheet sheet = wb.getSheetAt(0);
				 Sheet sheet=  wb.getSheetAt(0);
				boolean headerFlag = false;
				StringBuilder columnHeader = new StringBuilder();
				StringBuilder insertQuery = new StringBuilder();
				StringBuilder insertValue = new StringBuilder();
				StringBuilder insertQueryInitial = new StringBuilder();
				int headerCount = 0;
				FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
				
				for (Row row : sheet) // iteration over row using for each loop
				{
					int count=0;
					for (Cell cell : row) // iteration over cell using for each loop
					{
						headerFlag = false;
						if (row.getRowNum() == 0) {
							columnHeader.append(cell.getStringCellValue()).append(",");
							headerFlag = true;
							headerCount = row.getLastCellNum();
						} else {
							if (cell != null ) {
								//System.out.print(cell.getStringCellValue());
								switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
								case Cell.CELL_TYPE_NUMERIC: // field that represents numeric cell type
									insertValue.append("'" + String.valueOf((long) cell.getNumericCellValue()));
									insertValue.append("',");
									headerFlag = false;
									break;
								case Cell.CELL_TYPE_STRING: 
								 	//System.out.print(cell.getStringCellValue());
								 	count++;
										String cellValue = cell.getStringCellValue().replaceAll("\\'", "\\\\'");
										insertValue.append("'" + cellValue).append("',");
										headerFlag = false;
										break;
								case Cell.CELL_TYPE_BLANK:
									insertValue.append("'"+null).append("',");
									// System.out.print("Row Column value is empty");
	                                  break;
								}

							} 
						}
					}
					
					if (headerFlag == true) {
						columnHeader.deleteCharAt(columnHeader.length() - 1);
						insertQueryInitial.append("insert into studentdetail(" + headerColumns
								+ ") values(");
					}
					else if (headerFlag == false) {
						insertQuery.append(insertQueryInitial.toString());
						
						insertQuery.append(insertValue.toString());
						insertQuery.append("null").append(")");
						try (Connection con = getOtherSchemaConnection(); PreparedStatement stmt4 = con.prepareStatement(insertQuery.toString());) {
							stmt4.executeUpdate();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
					System.out.println(insertQuery.toString());
					// System.out.println(insertQuery.toString());
					insertQuery = new StringBuilder();
					insertValue = new StringBuilder();
				}
				
			} catch (Exception e) {
				System.err.print(e.getMessage());
			}
			
		}else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			int currentBatchSize = 0;
			try (BufferedReader bf = new BufferedReader(new FileReader(new File(OrgfileName)));Connection con = getOtherSchemaConnection();) {
				String line = null;
				System.out.println("Insert Start Time:" + formatter.format(date));
				String columnHeader = bf.readLine();
				System.out.println("Header :" + columnHeader);
				String[] rowHeader = columnHeader.split(",", -1);
				StringBuilder insertQueryInitial = new StringBuilder();
				insertQueryInitial.append("insert into studentdetail(" + headerColumns
						+ ") values(");
				for (int i = 0; i < rowHeader.length; i++) {
					insertQueryInitial.append("?,");
				}
				insertQueryInitial.append("?)");
				try (PreparedStatement preparedStatement = con.prepareStatement(insertQueryInitial.toString())) {
					while ((line = bf.readLine()) != null) {
						int columnCount = 1;
						line = line.replaceAll("\\'", "\\\\'");
						String[] row = line.split(",", -1);
						if (rowHeader.length == row.length) {
							for (String column : row) {
								if (column.trim() != null && !column.trim().isEmpty()) {

									preparedStatement.setString(columnCount, column);
								} 
							}
						}
						preparedStatement.setString(columnCount++, "null");
						preparedStatement.addBatch();
						int batchSize =100;
						if (++currentBatchSize == batchSize ) {// 1000
							con.setAutoCommit(false);
							preparedStatement.executeBatch();
							con.setAutoCommit(true);
							currentBatchSize = 0;

						}
					}
					if (currentBatchSize > 0) {
						con.setAutoCommit(false);
						preparedStatement.executeBatch();
						con.setAutoCommit(true);
						System.out.println("Batch End Time:" + formatter.format(date));
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		

	} 
	
	
	

	public Connection getOtherSchemaConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/smjsys_qa?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=TRUE&characterEncoding=utf-8";
			String username = "smjsys_qa";
			String password = "smjsys_qa";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
		return connection;

	}
		
	}