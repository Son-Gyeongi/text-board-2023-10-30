package com.ll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class TestUtilTest {

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

        Assertions.assertThat(cmd).isEqualTo("등록");
        Assertions.assertThat(content).isEqualTo("현재를 사랑하라");
        Assertions.assertThat(authorName).isEqualTo("작자미상");
    }
}
