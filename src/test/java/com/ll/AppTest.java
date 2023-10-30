package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class AppTest {

    @Test
    @DisplayName("종료를 입력하면 꺼진다.")
    void t1() {
        // Scanner를 직접 만들면(키보드로 입력받는) 안되고 우리가 만들어야 한다.
        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());

        // Scanner를 만들어서 집어넣는다.
        new App(scanner).run();

        scanner.close();

        System.out.println("프로그램이 종료되었습니다.");
    }

    @Test
    @DisplayName("등록을 입력하면 명언과 작가를 입력받는다.")
    void t2() {
        // Scanner를 직접 만들면(키보드로 입력받는) 안되고 우리가 만들어야 한다.
        Scanner scanner = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """.stripIndent());

        // Scanner를 만들어서 집어넣는다.
        new App(scanner).run();

        scanner.close();

        System.out.println("프로그램이 종료되었습니다.");
    }
}
