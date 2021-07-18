package com.eomcs.lang.project01;

import java.util.Scanner;
import java.util.Date;

public class MemberHandler extends DB{

		String msg = "";
		static String id = null;
		static String password = null;
		Scanner sc = new Scanner(System.in);
		
	public void selectAll() {
		DBbase();
		try {
			msg = "select * from id";
			RS = ST.executeQuery(msg);
			
			System.out.printf("%10s %4s %20s %20s %18s %15s %10s %10s%n"
					, "ID", "등급", "이름", "이메일주소", "핸드폰번호", "가입날짜", "좋아요", "소속클래스");
			System.out.println();
			while(RS.next() == true) {
				String id = RS.getString("id");
				int grade = RS.getInt("grade");
				String name = RS.getString("name");
				String email = RS.getString("email");
				String mobile = RS.getString("moblie");
				Date date = RS.getDate("join_date");
				int recommended = RS.getInt("recommended");
				String belongs = RS.getString("belongs");
				
				System.out.printf("%10s %4s %20s %20s %18s %15s %10s %10s%n"
						, "id", "grade", "name", "email", "mobile", "date", "recommend", "belongs");
			}
		}catch(Exception e) {}

	System.out.println();
	}
	
	public void login() {
		DBbase();
		try {
			if(id == null && password == null) {
				System.out.println("id입력 : ");
				id = sc.nextLine();
				System.out.println("password입력 : ");
				password = sc.nextLine();
				
				String comparision = "select count(id) as cnt from id where id = '" + id + "' and pwd = '" +password+ "'";
				
				int condition  = RS.getInt("cnt");
				if (condition > 0) {
					String text = "select grade from id where id = '" + id +"' ";
					RS = ST.executeQuery(text);
					
					while(RS.next()==true) {
						int grad = RS.getInt("grade");
						System.out.println(id + "님의 등급은 <" + grade + "> 입니다.");
						
						System.out.println("게시글");
						switch (grade) {
							case 4:
								System.out.println("[삭제]");
							case 3:
								System.out.println("[수정]");
							case 2:
								System.out.println("[추가]");
							case 1:
								System.out.println("[조회] 가능");
							default : break;								
						}
					}
				}else {
					System.out.println("비밀번호가 맞지 않습니다.");
				}
			System.out.println();
			}else {
				System.out.println("이미 로그인 하였습니다.");
			}
		}catch (Exception e) {}
	}
	
	public void insertMember() {
		DBbase();
		try {
			ST = CN.createStatement();
			
			System.out.println("\nID입력 : ");
			String id = sc.nextLine();
			System.out.println("\n비밀번호입력 : ");
			String password = sc.nextLine();
			System.out.println("\nd이름입력 : ");
			String name = sc.nextLine();
			System.out.println("\n이메일입력 : ");
			String email = sc.nextLine();
			System.out.println("\n번호입력 : ");
			String mobile = sc.nextLine();
			System.out.println("\n소속입력 : ");
			String belongs = sc.nextLine();
			
			msg = "insert into id(id,pwd,name,email,mobile,join_date,belongs"
					+ "values(?,?,?,?,?,sysdate,?)";
			PST = CN.prepareStatement(msg);
			PST.setString(1, id);
			PST.setString(2, password);
			PST.setString(3, name);
			PST.setString(4, email);
			PST.setString(5, mobile);
			PST.setString(6, belongs);
			
			System.out.println(msg);
			
			int condition = PST.executeUpdate();
			if (condition > 0) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
		}catch (Exception e) {}
		System.out.println();
	}
	
	public void deleteMember() {
		DBbase();
		try {
			System.out.println("\n삭제할 ID 입력 : ");
			String id = sc.nextLine();
			System.out.println("\npassword 입력 : ");
			String password = sc.nextLine();
			System.out.println("정말 탈퇴하시겠습니까? [y / N]");
			
			if (!sc.next().equals("y")) {
				System.out.println("회원 탈퇴 취소");
			}else {
				msg = "delete from id where id = ? and pwd = ?";
				PST = CN.prepareStatement(msg);
				PST.setString(1, id);
				PST.setString(2, password);
				
				int condition = PST.executeUpdate();
				if (condition > 0) {
					System.out.println("회원탈퇴 성공");
				}else {
					System.out.println("회원정보를 다시 입력하시오.");
				}
			}
			
		}catch (Exception e) {}
	}
	
	public void Logout() {
		try {
			System.out.println("정말로 로그아웃 하시겠습니까? [y/N]");
			if (sc.nextLine().equals("y")) {
				if (id==null && password==null) {
					System.out.println("로그인 되어있지 않습니다.");
				}else {
					id = null;
					password = null;
					System.out.println("로그아웃 완료");
				}
				
			}else {
				System.out.println("로그아웃 취소");
			}
		}catch(Exception e) {}
	}
}

