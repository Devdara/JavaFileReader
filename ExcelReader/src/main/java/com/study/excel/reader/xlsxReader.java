package com.study.excel.reader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class xlsxReader {

	public void getContetns() {
		
		try {
            FileInputStream file = new FileInputStream("D:/zipcode_DB/test.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            int rowindex=0;
            int columnindex=0;
            //��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
            //���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
            XSSFSheet sheet=workbook.getSheetAt(0);
            //���� ��
            int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex=0;rowindex<rows;rowindex++){
                //�����д´�
                XSSFRow row=sheet.getRow(rowindex);
                if(row !=null){
                    //���� ��
                    int cells=row.getPhysicalNumberOfCells();
                    for(columnindex=0; columnindex<=cells; columnindex++){
                        //������ �д´�
                        XSSFCell cell=row.getCell(columnindex);
                        String value="";
                        //���� ���ϰ�츦 ���� ��üũ
                        if(cell==null){
                            continue;
                        }else{
                        	value=cell.getStringCellValue()+"";
                        }
                        System.out.println(rowindex+"�� �� : "+columnindex+"�� �� ����: "+value);
                    }
 
                }
            }
 
        }catch(Exception e) {
            e.printStackTrace();
        }
		
	}
	
}