package com.eomcs.lang.project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectPractice01 {
  Connection CN=null; //DB서버연결정보 서버ip주소 계정id,pwd
  Statement ST=null;  //ST=CN.createStatement()명령어생성 삭제,신규등록,조회하라
  String msg = "";

  public void dbConnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
      System.out.println("07-09-금요일 오라클 드라이브및 서버연결성공 ");     
      ST = CN.createStatement(); //반드시필수 
    }catch(Exception ex){System.out.println("DB접속에러 error =" + ex);}
  }//dbConnect END

  public void dbSelectall() {
    try {
      System.out.println("전체데이터 출력중입니다. ");
      ST = CN.createStatement();
      msg = "select * from test order by code ";
      ResultSet rs = ST.executeQuery(msg);
    }catch(Exception ex) {}
  }

}//class END
