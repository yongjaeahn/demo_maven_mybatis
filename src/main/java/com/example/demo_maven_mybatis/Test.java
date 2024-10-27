// Java 코드
package com.example.demo_maven_mybatis;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    // 일반 함수 정의
    public static int addTen(int number) {
        return number + 10;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 일반 함수 적용
        List<Integer> adds = numbers.stream()
                .map(Test::addTen)
                .collect(Collectors.toList());
        System.out.println(adds);

        // 람다 함수 적용 (이름없는 함수 정의)
        List<Integer> squares = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
        System.out.println(squares);
    }
}