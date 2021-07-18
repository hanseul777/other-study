package com.eomcs.lang.project01;

public class MainScreen {
	static int selection = 0;
	Scanner = selectionFor = new Scanner(System.in);
	BoardHandler mainScreenBoard = new BoardHandler();
	Appointment mainScreenAppointment = new Appointment();
	
	void mainScreen() {
		top();
		quarter1Mid();
		quarter2Mid();
		quarter3Mid();
		quarter4Mid();
	}
	
	void top() {
		System.out.println("수강생들을 위한 교류공간");
	}
	void quarter1Mid() {
		System.out.println("자유 게시판");
	}
	void quarter2Mid() {
		System.out.println("질문답변 게시판");
	}
	void quarter3Mid() {
		System.out.println("수업진도 게시판");
	}
	void quarter4Mid() {
		System.out.println("스터디모집 게시판");
	}
	void bottom () {
		System.out.println("1.회원가입 2.로그인 3.회원탈퇴 4.로그아웃 5.로그아웃");
	}

}
