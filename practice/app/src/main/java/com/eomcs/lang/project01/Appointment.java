package com.eomcs.lang.project01;

import java.util.Date;
import java.util.Scanner;

public class Appointment extends MemberHandler{
	static Scanner keyScan = new Scanner(System.in);
	
	public void viewAppointment() {
		DBbase();
		try {
			msg = "select * from appointment";
			
			RS = ST.executeQuery(msg);
			
			System.out.printf("%5s %10s %10s %10s %10s %10s %14s %4s%n"
					, "번호", "제목", "장소", "시간", "날짜", "ID", "정원", "조회");
			System.out.println();
			while(RS.next() == true) {
				int num = RS.getInt("num");
				String title = RS.getString("title");
				String location = RS.getString("location");
				String time = RS.getString("time");
				Date date = RS.getDate("written");
				String id = RS.getString("id");
				int numLimit = RS.getInt("numlimit");
				int viewCount = RS.getInt("viewCount");
				
				System.out.printf("%5s %10s %10s %10s %10s %10s %14s %4s%n"
						, num, title, location, time, date, id, numLimit, viewCount);
			}
		}catch(Exception e) {
			System.out.println("잘못 된 입력입니다.");
		}
		System.out.println();
	}//viewAppointment

	public void insertAppointment() {
		System.out.println("스터디원 모집 게시판");
		DBbase();
		try {
			ST = CN.createStatement();
			System.out.println("\n제목 : ");
			String title = keyScan.nextLine();
			System.out.println("장소 : ");
			String location = keyScan.nextLine();
			System.out.println("시간 : ");
			String time = keyScan.nextLine();
			System.out.println("정원 : ");
			int numLimit = Integer.parseInt(keyScan.nextLine());
			
			msg = "insert into appointment(num, title, location, time, date, id,numLimit, viewCount)" 
					+ "values(seq.nextval, ?, ?, ?, sysdate, '"+id+"', ?,0)";
			PST = CN.prepareStatement(msg);
			PST.setString(1, title);
			PST.setString(2, location);
			PST.setString(3, time);
			PST.setInt(4, numLimit);
			
			int condition = PST.executeUpdate();
			if (condition > 0) {
				System.out.println(title + "게시글이 등록되었습니다.");
			}else {
				System.out.println(title + "게시글 등록에 실패했습니다.");
			}
		}catch (Exception e) {System.out.println("잘못된 입력입니다.");}
		System.out.println();
	}
	
	public void deleteAppointment() {
		DBbase();
		try {
			System.out.println("\n삭제할 게시글 번호 입력 : ");
			int num = Integer.parseInt(keyScan.nextLine());
			System.out.println("삭제할 게시글 제목 입력 : ");
			String title = keyScan.nextLine();
			System.out.println("정말 삭제하시겠습니까? y/N");
			
			if (!keyScan.nextLine().equals("y")) {
				System.out.println("게시글삭제 취소했습니다.");
			}else {
				msg = "delete from appointment where num = ? and title = ?";
				PST = CN.prepareStatement(msg);
				PST.setInt(1, num);
				PST.setString(2, title);
				
				int condition = PST.executeUpdate();
				if (condition > 0) {
					System.out.println("게시글 삭제 완료");
				} else {
					System.out.println("게시글 삭제 실패");
				}
			}
			
		}catch (Exception e) {}
	}// delete END
	
	public void updateAppointment() {
		DBbase();
		try {
			System.out.print("수정할 게시글 제목 입력 : ");
			String updatetitle = keyScan.nextLine();
			System.out.print("장소 수정내역 입력 : ");
			String location = keyScan.nextLine();
			System.out.print("시간 수정내역 입력 : ");
			String time = keyScan.nextLine();
			System.out.print("총 인원 수정내역 입력 : ");
			int numLimit = Integer.parseInt(keyScan.nextLine());
			
			msg = "update appointment set location = ?, time = ?, numLimit = ? where title = ?";
			System.out.println(msg);
			PST = CN.prepareStatement(msg);
			PST.setString(1,location);
			PST.setString(2, time);
			PST.setInt(3, numLimit);
			PST.setString(4, updatetitle);
			
			int condition = PST.executeUpdate();
			if (condition > 0) {
				System.out.println("게시글 수정 성공");
			}else {
				System.out.println("게시글 수정 실패");
			}
		}catch (Exception e) {}
	}
	
	public void joinStudy() {
		DBbase();
		try {
			System.out.print("참여할 스터디 게시판 번호 선택 : ");
			String number = keyScan.nextLine();
			
			msg = "select title, location, time, numLimit from appointment where num = '" + number +"' ";
			
			RS = ST.executeQuery(msg);
			while (RS.next()==true) {
				String location = RS.getString("location");
				String time = RS.getString("time");
				int numLimit = RS.getInt("numLimit");
				
				int request = keyScan.nextInt();
				final int architecture = request | 0x01;
				final int documentize = request | 0x02;
				final int coder1 = request | 0x04;
				final int coder2 = request | 0x08;
				
				System.out.println(" 스터디 게시판 ");
				System.out.println();
				System.out.printf("'%s'에서 '%s'까지 '%d'명 모집n" , location, time, numLimit);
				
			}
		}catch(Exception e) {}
	}
}
