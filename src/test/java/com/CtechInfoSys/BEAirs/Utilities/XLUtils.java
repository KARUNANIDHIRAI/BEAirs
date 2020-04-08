package com.CtechInfoSys.BEAirs.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class XLUtils {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wob;
	public static XSSFSheet wos;
	public static XSSFRow row;
	public static XSSFCell cel;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException{
		
		fis = new FileInputStream(xlfile) ;
		wob = new XSSFWorkbook(fis);
		wos=wob.getSheet(xlsheet);
		int rowCount =wos.getLastRowNum();
		wob.close();
		fis.close();
		return rowCount ;
	}
	
	public static int getCelCount(String xlfile, String xlsheet, int rownum) throws IOException{
		
		fis = new FileInputStream(xlfile) ;
		wob = new XSSFWorkbook(fis);
		wos=wob.getSheet(xlsheet);
		row= wos.getRow(rownum);
		int celCount=row.getLastCellNum();
		wob.close();
		fis.close();
		return celCount ;
	}

	public static String getCelData(String xlfile, String xlsheet, int rownum, int colNum) throws IOException{

		String celData="";
		try {
			fis = new FileInputStream(xlfile) ;
			wob = new XSSFWorkbook(fis);
			wos=wob.getSheet(xlsheet);
			row= wos.getRow(rownum);
			cel =row.getCell(colNum);
			DataFormatter formatter = new DataFormatter();
			celData= formatter.formatCellValue(cel);
			return celData;
		}
		catch (Exception e) {
			System.out.print(e);
		}
		finally {
			if(wob !=null) {
				wob.close();
			}
			if(fis !=null) {
				fis.close();
			}
		}
		return celData ;
	}

	public static void setCelData(String xlfile, String xlsheet, int rownum, int colNum, String data) throws IOException{

		try {
			fis = new FileInputStream(xlfile) ;
			wob = new XSSFWorkbook(fis);
			wos=wob.getSheet(xlsheet);
			row= wos.getRow(rownum);
			cel =row.createCell(colNum);
			cel.setCellValue(data);
			fos = new FileOutputStream(xlfile);
			wob.write(fos);
		}
		catch (Exception e) {
			System.out.print(e);
		}
		finally {
			if(wob !=null) {
				wob.close();
			}
			if(fis !=null) {
				fis.close();
			}
			if(fos !=null) {
				fos.close();
			}
		}
	}
	

	public String [][] getXLData(String XLSheetName){
		System.out.println("enter in XLutils: getXLData");
		try {
			//logger.info("String [][] getData() : getting data from excel sheet" );
			String dataFilePath=System.getProperty("user.dir")+"/src/test/java/com/CtechInfoSys/BEAirs/TestData/BEAirsTestData.xlsx";
			int rowCount=getRowCount(dataFilePath, XLSheetName);
			int colCount=getCelCount(dataFilePath, XLSheetName, 1);
			//logger.info("Total Row in Datasheet"+ rowCount +": Total Colom in Datasheet :" + colCount );
			System.out.println("Total No.of Col in AddCustomer File:" +colCount);
			String loginData [][] = new String[rowCount][colCount];
			for(int i=1;i<=rowCount;i++) {
				for(int j=0;j<colCount;j++) {
					loginData[i-1][j]=XLUtils.getCelData(dataFilePath, XLSheetName, i, j);
				}
			}
			System.out.println("String [][] getData() : Read Excel data Succesfull : " );
			return loginData;
		}
		catch (Exception e) {
			System.out.println("String [][] getData() : getting Excel data sheet Error : " + e);
			String dataLogin[][]= new String[0][0];
			return dataLogin;
			
		}
	}	
}
