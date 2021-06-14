package com.eomcs.lang.ex04;

public class Test04 {
  public static void main(String[] args) {
    // 배열 메모리의 시작 주소를 저장할 레퍼런스 선언
    int[] a;

    // 레퍼런스 변수에 배열 메모리의 주소를 준다.
    a = new int[3];

    a[0] = 100;
    a[1] = 200;
    a[2] = 300;

    System.out.println(a[0]);
    System.out.println(a[1]);
    System.out.println(a[2]);
    //System.out.println(a[3]);  당연히 오류

    int[] b;
    b = a; //a에는 배열주소가 들어있음. b = 정수; 로 한다면 오류남. 당연함 배열에는 주소가 들어가야 함.
    System.out.println(b[1]);

  }
}
