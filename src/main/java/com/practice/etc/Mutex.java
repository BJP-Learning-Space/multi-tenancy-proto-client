package com.practice.etc;

public class Mutex {
    int lock = 1;

    public void mutex() {
        while (lock == 0);

        lock--;
        // 작업
        lock++;
    }
    public void Dekker() {

    }

    public void Peterson() {

    }

    public void Bakery() {

    }
}
