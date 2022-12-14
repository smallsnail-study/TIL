package me.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Code10799 {
    public static void main(String[] args) {
        //한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다.
        Scanner sc = new Scanner(System.in);
        //nextLine()메소드는 Enter를 치기 전까지 쓴 문자열을 모두 리턴한다(공백까지포함해서 리턴), next() 메소드는 스페이스 즉 공백 전까지 입력받은 문자열을 리턴한다
        String a = sc.nextLine().trim();   //trim은 공백제거
        int n = a.length();
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            char c = a.charAt(i);
            //스택의 크기 = 레이저에 잘린 쇠막대기 개수
            if (c == '(') {
                s.push(i);
            } else {
                //레이저()인 경우 스택의 크기만큼 더해준다.레이저는 (의 인덱스와 )인덱스가 1차이인경우
                if (s.peek()+1 == i) {  //Stack.Peek 메서드 : 이 메서드는 Pop 메서드와 유사하지만 Peek는 Stack를 수정하지 않습니다.
                    s.pop();
                    ans += s.size();
                } else { //레이저가 아닌 쇠막대기의 오른쪽 끝인 경우 : 레이저로 잘린 마지막 오른쪽 끝부분인 1개만 더해준다.
                    s.pop();
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
//Baekjoon 10799 쇠막대기
//문제
//여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
//쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
//각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
//레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
//이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
//레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반드시 레이저를 표현한다.
//쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.
//위 예의 괄호 표현은 그림 위에 주어져 있다.
//쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘려지고, 이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘려진다.
//쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
//입력
//한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
//출력
//잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.