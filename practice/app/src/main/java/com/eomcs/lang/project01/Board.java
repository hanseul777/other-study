package com.eomcs.lang.project01;

import java.util.*;

public class Board extends MemberHandler{
	static Scanner keyScan = new Scanner(System.in);
	
	public void board() {
		
		Appointment appointment = new Appointment();
		BoardHandler boardhandler = new BoardHandler();
		DBbase();
		System.out.println("자유 게시판");
		boardHandler.viewBoard("freeboard");
		System.out.println("질문답변 게시판");
		boardHandler.viewBoard("board");
		System.out.println("수업진도 게시판");
		boardHandler.viewBoard("review");
		System.out.println("스터디모집 게시판");
		appointment.viewAppointment();
		
		System.out.println("[게시판 목록] : freeBoard / board / review / appointment");
		System.out.println("[단축어] : [f]자유게시판 [b]질문답변게시판 [r]수업진도게시판 [a]스터디모집게시판 [c]취소");
		System.out.println();
		System.out.println("입장할 게시판을 입력해주세요.");
		String input = keyScan.nextLine();
		
		try {
			if (input.equals("a")) {
				input = "appointment";
				appointment.viewAppointment();
				
				loop : while (true) {
					String text = "select grade from id where id = '"+id+"'";
					RS = ST.executeQuery(text);
					
					while(RS.next() == true) {
						int grade = RS.getInt("grade");
						System.out.println(id + "님의 회원 등급은 " + grade + "번 입니다.");
						
						switch (grade) {
							case 4:
								System.out.println("[d]게시글 삭제\t");
							case 3:
								System.out.println("[u]게시글 수정\t");
							case 2:
								System.out.println("[i]게시글 작성\t");
							case 1:
								System.out.println("[v]게시판 조회\t");
								System.out.println("[j]스터디 참여\t");
								System.out.println("[s]게시글 검색\t");
								System.out.println("[b]뒤로 가기\t");
							default: break;
						}
						System.out.print("[명령어]를 입력 : ");
						String select = keyScan.nextLine();
					}
				}
			}
		}catch(Exception e) {}
		
	}

}
