package com.eomcs.lang.book;

class Car {
  String color;
  String gearType;
  int door;

  Car () {
    this("white", "auto", 4);
  }
  Car (String color) {
    this(color, "auto", 4);
  }
  Car (String color, String gearType, int door) {
    this.color = color;
    this.gearType = gearType;
    this.door = door;
  }
}

public class p296 {

  public static void main(String[] args) {
    Car c1 = new Car();
    Car c2 = new Car("blue");

    System.out.printf("%d,%d,%s", c1.color, c1.door, c1.gearType);
    System.out.printf("%d,%d,%S", c2.color, c2.door, c2.gearType);

  }

}
