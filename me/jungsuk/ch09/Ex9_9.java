package me.jungsuk.ch09;


class Circle implements Cloneable {
    Point2 p;    // 원점
    double r;   // 반지름

    Circle(Point2 p, double r) {
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() {   // 얕은 복사
        Object obj = null;

        try {
            obj = super.clone();    // Object클래스의 clone()은 원본 객체가 가지고 있는 값만 그대로 복사한다.
        }catch (CloneNotSupportedException e) {}
        return (Circle)obj;
    }

    public Circle deepCopy(){   // 깊은 복사
        Object obj = null;
        try {
            obj = super.clone();
        }catch (CloneNotSupportedException e){}

        // 복제된 객체가 새로운 Point인스턴스를 참조하도록 한다.
        // 원본이 참조하고 있는 객체까지 복사
        Circle c = (Circle) obj;
        c.p = new Point2(this.p.x, this.p.y);

        return c;
    }

    public String toString() {
        return "[p=" + p + ", r=" + r + "]";
    }
}

class Point2 {
    int x, y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Ex9_9 {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point2(1, 1), 2.0);
        Circle c2 = c1.shallowCopy();
        Circle c3 = c1.deepCopy();

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);

        c1.p.x = 9;
        c1.p.y = 9;
        System.out.println("= c1의 변경 후 =");
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
    }
    
}


//실행결과
//c1=[p=(1, 1), r=2.0]
//c2=[p=(1, 1), r=2.0]
//c3=[p=(1, 1), r=2.0]
//= c1의 변경 후 =
//c1=[p=(9, 9), r=2.0]
//c2=[p=(9, 9), r=2.0]
//c3=[p=(1, 1), r=2.0]