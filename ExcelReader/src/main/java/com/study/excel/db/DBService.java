package com.study.excel.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.excel.config.DBConnection;
import com.study.excel.model.KaiLawCodeVO;
import com.study.excel.model.RoadVO;

@Service
public class DBService {

	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    
	// 데이터 입력
	public void insert( KaiLawCodeVO dataVO ) throws SQLException {
		
		/*
		System.out.println("### call() DBService insert");
		System.out.println( dataVO.toString() );
		*/
		
		try {
	        String sql = null;
	        
	        	sql = "INSERT INTO KAIDA.KAI_LAW_CODE\r\n"
		        		+ "VALUES( KAIDA.KAI_LAW_CODE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?\r\n"
		        		+ ",?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        pstmt = conn.prepareStatement( sql );
	        pstmt.setString( 1, convertEmptyStr( dataVO.getZipNo()) );
	        pstmt.setString( 2, convertEmptyStr(dataVO.getSidoNm()) );
	        pstmt.setString( 3, convertEmptyStr(dataVO.getEngSidoNm()) );
	        pstmt.setString( 4, convertEmptyStr(dataVO.getSsgNm()) );
	        pstmt.setString( 5, convertEmptyStr(dataVO.getEngSsgNm()) );
	        pstmt.setString( 6, convertEmptyStr(dataVO.getEubNm()) );
	        pstmt.setString( 7, convertEmptyStr(dataVO.getEngEubNm()) );
	        pstmt.setString( 8, convertEmptyStr(dataVO.getRoadNmCode()) );
	        pstmt.setString( 9, convertEmptyStr(dataVO.getRoadNm()) );
	        pstmt.setString( 10, convertEmptyStr(dataVO.getEngRoadNm()) );
	        pstmt.setString( 11, convertEmptyStr(dataVO.getUdrtYn()) );
	        pstmt.setString( 12, convertEmptyStr(dataVO.getBuildMno()) );
	        pstmt.setString( 13, convertEmptyStr(dataVO.getBuildSno()) );
	        pstmt.setString( 14, convertEmptyStr(dataVO.getBuildMgNo()) );
	        pstmt.setString( 15, convertEmptyStr(dataVO.getMuchDeliveryNm()) );
	        pstmt.setString( 16, convertEmptyStr(dataVO.getBuildPulbicNm()) );
	        pstmt.setString( 17, convertEmptyStr(dataVO.getLawDongCode()) );
	        pstmt.setString( 18, convertEmptyStr(dataVO.getLawDongNm()) );
	        pstmt.setString( 19, convertEmptyStr(dataVO.getLiNm()) );
	        pstmt.setString( 20, convertEmptyStr(dataVO.getAdmDongNm()) );
	        pstmt.setString( 21, convertEmptyStr(dataVO.getMoutainYn()) );
	        pstmt.setString( 22, convertEmptyStr(dataVO.getLnbrMno()) );
	        pstmt.setString( 23, convertEmptyStr(dataVO.getEmdNo()) );
	        pstmt.setString( 24, convertEmptyStr(dataVO.getLnbrSno()) );
	        pstmt.setString( 25, convertEmptyStr(dataVO.getBeforeZipNo()) );
	        pstmt.setString( 26, convertEmptyStr(dataVO.getZipNoSerial()) );
	        pstmt.executeUpdate();
			
		}catch( Exception e ) {
			e.printStackTrace();
		}finally {
			try { if ( pstmt != null) pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	// 데이터 삭제
	public void delete() {
		
		try{
			
		}catch(Exception e) {
			
		}finally {
			try { if ( pstmt != null) pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	// 데이터 조회
	public List<RoadVO> getRoadNames(){
		
		List<RoadVO> roadList = new ArrayList<RoadVO>();
		int rowIdx = 0;
		
    	try {
    		
    		String sql = null;
        	sql = "SELECT ROAD_NM FROM KAIDA.KAI_LAW_CODE";
			pstmt = conn.prepareStatement( sql );
			rs = pstmt.executeQuery();
			
			
			while( rs.next() ) {
				
				if( rowIdx == 0 ) {
					System.out.println( "도로명 : " + rs.getString("ROAD_NM") );
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return roadList;
		
	}
	
	public static String convertEmptyStr( String originStr ) {
		
		String convertStr = originStr;
		
		if( convertStr == "" || convertStr == null || convertStr.isEmpty() ) {
			convertStr = "-";
		}else if( convertStr.equals("공백")){
			convertStr = convertStr.replaceAll("공백", "");
		}
		
		return convertStr;
		
	}
	
}