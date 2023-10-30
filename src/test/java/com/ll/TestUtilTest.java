package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TDD(테스트 주도 개발, Test Driven Development)
 * 테스트 자동화 힌트 - 입력, 출력
 */
public class TestUtilTest {
    // 입력
    @Test
    @DisplayName("TestUtil.getScanner()테스트")
    void t1() {
        // 기계가 우리 대신에 키보드 입력 가능
        // "등록"이 선입력 된거다.
        Scanner scanner = TestUtil.genScanner("""
                등록
                현재를 사랑하라
                작자미상
                """.stripIndent());
        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String authorName = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("현재를 사랑하라");
        assertThat(authorName).isEqualTo("작자미상");
    }

    // 출력
    @Test
    @DisplayName("TestUtil.setOutToByteArray()테스트")
    void t2() {
        // 저장한다, 모니터에 대한 출력을 끈다.
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        System.out.println("2 / 작자미상 / 현재를 사랑하라");
//        System.out.println("1 / 홍길동 / 현재를 사랑하라");

        // 꺼낸다.
        String out = byteArrayOutputStream.toString().trim();

        assertThat(out).isEqualTo("2 / 작자미상 / 현재를 사랑하라");

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
        System.out.println(out);
        // 출력, 모니터에 대한 출력을 켠다.
        System.out.println("이제는 화면에 출력됩니다.");
    }
}
