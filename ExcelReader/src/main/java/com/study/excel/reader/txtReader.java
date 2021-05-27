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
			
			// 파일 객체 생성
			File file = new File("D:\\test.txt");
			// 입력 스트림 생성니엘
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			// 입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(inputStreamReader);
			String line = "";
			
			// 컬럼의 갯수
			int columnCnt = 0;
			// 컬럼 인덱스
			int columnIndex = 0;
			// 읽어들인 줄의 인덱스
			int lineIndex = 0; 
			// 1줄씩 쪼갠 배열
			String[] totalStr;
			
			DBService dBService = new DBService();
			
			while ((line = bufReader.readLine()) != null) {

				System.out.println( "### 읽어들인 라인 인덱스 : " + lineIndex );
				//System.out.println( lineIndex + "줄의 내용 : " + line);
				
				// split을 이용한 문자열 분리
				// 컬럼값이 없을경우 @@@ 또는 @@형태를 가지게되는데
				// 이럴경우 split로 쪼개면 공백처리가 안되므로
				// 인위적으로 빈칸을 표시해준다
				String convertStr = line.replaceAll("@@@@","@공백@공백@공백@");
				convertStr = convertStr.replaceAll("@@@","@공백@공백@");
				convertStr = convertStr.replaceAll("@@","@공백@");
				//System.out.println("★★★ 공백처리된 문자열 : " + convertStr );
				// @를 구분자로 되어있는 컬럼을 쪼개어 배열에 넣는다
				String[] splitArr = convertStr.split("@");
				//System.out.println("### 컬럼의 갯수 : " + splitArr.length );
				

				// DB에 전달할 객체 생성
				KaiLawCodeVO dataVO = new KaiLawCodeVO();
				
				for (int i = 0; i < splitArr.length; i++) {
					
					//System.out.println( "### i : " + i + ", splitArr[i] : " + splitArr[i] );
					
					// 객체에 각 컬럼값 할당
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
				}// end of for문
				
				// DB에 inert 요청
				if( lineIndex > 0 ) {
					dBService.insert(  dataVO );
				}
				lineIndex++;

			}// end of while문
			
			// .readLine()은 끝에 개행문자를 읽지 않는다.
			bufReader.close();
			
			System.out.println("### 파일 읽기 완료 ###");
			getCurrentTime();
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	// 빈문자열 처리
	public static String convertEmptyStr( String originStr ) {
		
		String convertStr = originStr;
		//System.out.println("#######convertStr : " + convertStr );
		
		if( convertStr == "" || convertStr == null || convertStr.isEmpty() ) {
			convertStr = "-";
		}else if( convertStr.equals("공백")){
			convertStr = convertStr.replaceAll("공백", "");
		}
		
		return convertStr;
		
	}
	
	// 현재시간 구하기
	public static void getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("# 현재시간 : " + sdf.format( cal.getTime() ) );
	}
	
}
