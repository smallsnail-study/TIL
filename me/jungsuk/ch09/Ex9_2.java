package me.jungsuk.ch09;

class Person {
    long id;

    public boolean equals(Object obj) {
        if (obj instanceof Person)
            return id == ((Person)obj).id;  // obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환이 필요하다.
        else
            return false;                   // 타입이 Person이 아니면 값을 비교할 필요도 없다.
    }

    Person(long id) {
        this.id = id;
    }
}

public class Ex9_2 {
    public static void main(String[] args) {
        Person p1 = new Person(8011081111222L);
        Person p2 = new Person(8011081111222L);

        if (p1==p2)         // 주소값이 서로 다르므로 false
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");
        if (p1.equals(p2))      // id의 값을 비교하도록 위에서 오버라이딩했다.
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");
    }
}

// 실행결과
//p1과 p2는 다른 사람입니다.
//p1과 p2는 같은 사람입니다.