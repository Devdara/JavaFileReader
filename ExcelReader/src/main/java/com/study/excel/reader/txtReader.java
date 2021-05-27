package com.study.excel.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.study.excel.db.DBService;
import com.study.excel.model.KaiLawCodeVO;

public class txtReader {

	public static void main(String[] args) {
		try {
			
			// ���� ��ü ����
			File file = new File("D:\\test.txt");
			// �Է� ��Ʈ�� �����Ͽ�
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			// �Է� ���� ����
			BufferedReader bufReader = new BufferedReader(inputStreamReader);
			String line = "";
			
			// �÷��� ����
			int columnCnt = 0;
			// �÷� �ε���
			int columnIndex = 0;
			// �о���� ���� �ε���
			int lineIndex = 0; 
			// 1�پ� �ɰ� �迭
			String[] totalStr;
			
			DBService dBService = new DBService();
			
			while ((line = bufReader.readLine()) != null) {

				System.out.println( "### �о���� ���� �ε��� : " + lineIndex );
				//System.out.println( lineIndex + "���� ���� : " + line);
				
				// split�� �̿��� ���ڿ� �и�
				// �÷����� ������� @@@ �Ǵ� @@���¸� �����ԵǴµ�
				// �̷���� split�� �ɰ��� ����ó���� �ȵǹǷ�
				// ���������� ��ĭ�� ǥ�����ش�
				String convertStr = line.replaceAll("@@@@","@����@����@����@");
				convertStr = convertStr.replaceAll("@@@","@����@����@");
				convertStr = convertStr.replaceAll("@@","@����@");
				//System.out.println("�ڡڡ� ����ó���� ���ڿ� : " + convertStr );
				// @�� �����ڷ� �Ǿ��ִ� �÷��� �ɰ��� �迭�� �ִ´�
				String[] splitArr = convertStr.split("@");
				//System.out.println("### �÷��� ���� : " + splitArr.length );
				

				// DB�� ������ ��ü ����
				KaiLawCodeVO dataVO = new KaiLawCodeVO();
				
				for (int i = 0; i < splitArr.length; i++) {
					
					//System.out.println( "### i : " + i + ", splitArr[i] : " + splitArr[i] );
					
					// ��ü�� �� �÷��� �Ҵ�
					if( i == 0 ) {
						dataVO.setZipNo( convertEmptyStr( splitArr[i] ) );
					}else if( i == 1){
						dataVO.setSidoNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 2){
						dataVO.setEngSidoNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 3){
						dataVO.setSsgNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 4){
						dataVO.setEngSsgNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 5){
						dataVO.setEubNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 6){
						dataVO.setEngEubNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 7){
						dataVO.setRoadNmCode(convertEmptyStr( splitArr[i] ));
					}else if( i == 8){
						dataVO.setRoadNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 9){
						dataVO.setEngRoadNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 10){
						dataVO.setUdrtYn(convertEmptyStr( splitArr[i] ));
					}else if( i == 11){
						dataVO.setBuildMno(convertEmptyStr( splitArr[i] ));
					}else if( i == 12){
						dataVO.setBuildSno(convertEmptyStr( splitArr[i] ));
					}else if( i == 13){
						dataVO.setBuildMgNo(convertEmptyStr( splitArr[i] ));
					}else if( i == 14){
						dataVO.setMuchDeliveryNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 15){
						dataVO.setBuildPulbicNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 16){
						dataVO.setLawDongCode(convertEmptyStr( splitArr[i] ));
					}else if( i == 17){
						dataVO.setLawDongNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 18){
						dataVO.setLiNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 19){
						dataVO.setAdmDongNm(convertEmptyStr( splitArr[i] ));
					}else if( i == 20){
						dataVO.setMoutainYn(convertEmptyStr( splitArr[i] ));
					}else if( i == 21){
						dataVO.setLnbrMno(convertEmptyStr( splitArr[i] ));
					}else if( i == 22){
						dataVO.setEmdNo(convertEmptyStr( splitArr[i] ));
					}else if( i == 23){
						dataVO.setLnbrSno(convertEmptyStr( splitArr[i] ));
					}else if( i == 24){
						dataVO.setBeforeZipNo(convertEmptyStr( splitArr[i] ));
					}else if( i == 25){
						dataVO.setZipNoSerial( convertEmptyStr( splitArr[i] ) );
					}
				}// end of for��
				
				// DB�� inert ��û
				if( lineIndex > 0 ) {
					dBService.insert(  dataVO );
				}
				lineIndex++;

			}// end of while��
			
			// .readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.
			bufReader.close();
			
			System.out.println("### ���� �б� �Ϸ� ###");
			getCurrentTime();
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	// ���ڿ� ó��
	public static String convertEmptyStr( String originStr ) {
		
		String convertStr = originStr;
		//System.out.println("#######convertStr : " + convertStr );
		
		if( convertStr == "" || convertStr == null || convertStr.isEmpty() ) {
			convertStr = "-";
		}else if( convertStr.equals("����")){
			convertStr = convertStr.replaceAll("����", "");
		}
		
		return convertStr;
		
	}
	
	// ����ð� ���ϱ�
	public static void getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("# ����ð� : " + sdf.format( cal.getTime() ) );
	}
	
}
