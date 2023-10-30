package com.ll;

import java.io.*;
import java.util.Scanner;

// TestUtil 구현하여, 텍스트 입출력을 테스트케이스에서 쉽게 테스트 할 수 있도록, 1부, 입력 리다이렉팅 작업
// 실제 운영하는데 필요한 게 아니라 테스트 할때만 쓰는 Util
public class TestUtil {
    // gen == generate 생성하다.
    // 입력
    public static Scanner genScanner(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());

        return new Scanner(in);
    }

    // 출력
    public static ByteArrayOutputStream setOutToByteArray() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        return output;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream output) {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        try {
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
