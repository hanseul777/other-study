package com.eomcs.lang.project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProjectPractice01 {
  Connection CN=null; //DB서버연결정보 서버ip주소 계정id,pwd
  Statement ST=null;  //ST=CN.createStatement()명령어생성 삭제,신규등록,조회하라
  String msg = "";
  Scanner sc = new Scanner(System.in);

  public void dbConnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
      System.out.println("07-09-금요일 오라클 드라이브및 서버연결성공 ");     
      ST = CN.createStatement(); //반드시필수 
    }catch(Exception ex){System.out.println("DB접속에러 error =" + ex);}
  }//dbConnect END

  public void dbSelectAll() {
    try {
      System.out.println("전체데이터 출력중입니다. ");
      ST = CN.createStatement();
      msg = "select * from test order by code ";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
    	  int a = rs.getInt("code");
    	  String b = rs.getString("name");
    	  String c = rs.getString("title");
    	  System.out.println(a+"\t"+b+"\t"+c);
      }
      rs.close();
    }catch(Exception ex) {}
  }//dbSelectall end
  
  public void dbDelete() {
	  try {
		  System.out.println("삭제이름 입력 : ");
		  String del = sc.nextLine();
		  msg = "delete from test where name = '" +del+"' ";
		  System.out.println(msg);
		  ST = CN.createStatement();
		  int OK = ST.executeUpdate(msg);
		  if (OK>0) {
			  System.out.println(del + "데이터 삭제성공");
			  dbSelectAll();
		  }else {
			  System.out.println(del + "데이터 삭제실패");
		  }
		  String msg1 = "insert into~~";
		  String msg2 = "delete from T where~~";
		  String msg3 = "update T set where~~";
		String msg4 = "select ~~";
		  
	  }catch (Exception ex) {}
  }

}//class END
