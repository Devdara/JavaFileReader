package com.study.excel.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() {
        String user = "system";
        String pw = "innerinfo";
        String url = "";
        Connection conn = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, user, pw);
            System.out.println("성공");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return conn;
    }
	
	static public void main ( String[] args ) {
        
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String sql;
        
        /*
        // truncate : 테이블 비우기
        sql = "delete from KAIDA.KAI_LAW_CODE";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        */
        
        /*
        // insert test
        sql = "INSERT INTO sys.board VALUES(?, ?, ?, ?, SYSDATE)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1);
        pstmt.setString(2, "작성자");
        pstmt.setString(3, "제목");
        pstmt.setString(4, "내용");
        pstmt.executeUpdate();
        */
        
        /*
        // select
        System.out.println("-- after insert");
        selectList(conn, pstmt, res);
        */

        /*
        // update test
        sql = "UPDATE sys.board SET subject = ? where idx = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "제목 수정");
        pstmt.setInt(2, 1);
        pstmt.executeUpdate();
        */
        
        /*
        // delete test
        sql = "DELETE FROM sys.board where idx = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1);
        pstmt.executeUpdate();
        */
    }
	
}
