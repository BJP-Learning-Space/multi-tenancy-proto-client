package com.practice.etc;

public class Semaphore {
    int lock = 5;

    public void semaphore() {
        lock -= 1;

        while (lock <= 0);

        // 코드
        lock++;
    }
}
