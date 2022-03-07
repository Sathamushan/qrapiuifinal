package io.github.anantharajuc.sbmwa.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestBulk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bulkImport();
	}

	private static void bulkImport() {

		try {
			String fileName ="E:\\APIQRFINALUI\\FinalApiforUI\\src\\main\\resources\\path\\StudentListData.xlsx";
			OPCPackage fis = OPCPackage.open(new File(fileName));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			boolean headerFlag = false;
			StringBuilder columnHeader = new StringBuilder();
			StringBuilder insertQuery = new StringBuilder();
			StringBuilder insertValue = new StringBuilder();
			StringBuilder insertQueryInitial = new StringBuilder();
			int headerCount = 0;
			String headerColumns= " `rollno`,`studentnameinenglish`,`studentnameintamil`, `section`,`classforwhich`,`fathernameinenglish`,`fathersoccupation`, `mothernameinenglish`,"
					+ "  `mothersoccupation`,`guardiannameinenglish`,`guardianoccupation`,`aadharnumber` , `mobilenumber`, `dateofbirth` ,`gender`,`dateofjoining`,"
					+ " `streetnameareaname`, `pincode`,`bloodgroup`,`religion`,`mediumofinstruction` ,`admissionnumber`, `classe`,`disabilitygroupname`,`mothertongue`,`photourl`";
			FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
			String value=null;  
			Row row=sheet.getRow(vRow); //returns the logical row  
			Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
			value=cell.getStringCellValue();    //getting cell value  
			
			//   Iterator<Row> rowIterator = sheet.iterator();
			/* Row header = sheet.getRow(0);
		        int n = header.getLastCellNum();
		        String header1 = header.getCell(0).getStringCellValue();
		        String header2 = header.getCell(1).getStringCellValue();*/
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
							 	System.out.print(cell.getStringCellValue());
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
				//	System.out.println("insertQueryInitial"+insertQuery);
				/*	try (Connection con = getOtherSchemaConnection(); PreparedStatement stmt4 = con.prepareStatement(insertQuery.toString());) {
						stmt4.executeUpdate();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}*/

				}
				System.out.println(insertQuery.toString());
				// System.out.println(insertQuery.toString());
				insertQuery = new StringBuilder();
				insertValue = new StringBuilder();
			}
			
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}

	
		
		
		
		
		
		/*
		
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
	*/}
	
	
	public static Connection getOtherSchemaConnection() {
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
