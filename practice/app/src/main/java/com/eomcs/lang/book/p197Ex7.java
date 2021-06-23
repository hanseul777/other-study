package com.eomcs.lang.book;

public class p197Ex7 {

  public static void main(String[] args) {

    int [] numArr = new int [10];

    for (int i = 0; i <numArr.length; i++) {
      numArr [i] = i;
      System.out.println(numArr[i]);
    }
    System.out.println();

    for (int i = 0; i < 100; i++) {
      int n = (int)(Math.random() * 10);
    }
  }

}
