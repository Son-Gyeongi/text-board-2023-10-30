package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

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
    }

    @Test
    @DisplayName("등록을 완료하면 1번 명언이 등록되었습니다.")
    void t3() {
        // 앱을 실행하기 전에 TestUtil에서 setOutToByteArray 받아온다.
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

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

        // 출력된 거 rs안에 다 들어간다.
        String rs = byteArrayOutputStream.toString();

        assertThat(rs).contains("1번 명언이 등록되었습니다.");

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }
}
