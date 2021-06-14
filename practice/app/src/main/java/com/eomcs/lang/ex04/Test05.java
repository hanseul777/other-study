package com.eomcs.lang.ex04;

public class Test05 {
  public static void main(String[] args) {
    // 배열 메모리의 시작 주소를 저장할 레퍼런스 선언
    int[] a = new int[3];

    a[0] = 100;
    a[1] = 200;
    a[2] = 300;

    a = new int[5]; // 새로정의하면서 이전에 있던 배열은 사용할 수 없어짐.
    //                 -> 메모리만 차지 : 쓰레기(Garbage)라고 함 
    //-> JVM종료 시 JVM이 사용한 모든 메모리는 OS에 반납. 
    //이 때 Garbage가 없어지는 것 처럼 보임 (사실상 반납하는 것.) 
    //또는 JVM실행 중 메모리 부족시 Garbage제거 후 그 메모리 공간을 재사용 함. 
    //=> 가비지수집기(Garbage Collector)가 수행
    
    System.out.println(a[0]);
        
  }
}
