package me.jungsuk_basic.ch06;

public class Ex6_2 {
    public static void main(String[] args) {
        Tv t1 = new Tv(); // Tv t11; t1 = new Tv();를 한 문장으로 가능
        Tv t2 = new Tv();
        System.out.println("t1의 channel값은 " + t1.channel + "입니다");
        System.out.println("t2의 channel값은 " + t2.channel + "입니다");

        t1.channel = 7;  //channel 값을 7으로 한다.
        System.out.println("t1의 channel값을 7로 변경하였습니다.");

        System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channe2값은 " + t2.channel + "입니다.");
    }
}
//실행화면
//t1의 channel값은 0입니다
//t2의 channel값은 0입니다
//t1의 channel값을 7로 변경하였습니다.
//t1의 channel값은 7입니다.
//t2의 channe2값은 0입니다.