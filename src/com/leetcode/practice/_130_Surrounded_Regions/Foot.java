package com.leetcode.practice._130_Surrounded_Regions;

public class Foot implements Runnable {
    private final String name;

    private final String lock = "lock";
    private static int leg = 0;

    public Foot(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                step();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void step() throws InterruptedException {
        synchronized (lock) {
            while(true) {
                Thread.sleep(3000);
                if (leg == 0 && this.name.equals("left") || leg == 1 && this.name.equals("right")) {
                    System.out.println("Step by " + name);
                    leg = (leg + 1) % 2;
                    lock.notify();
                    return;
                } else {
                    lock.wait();
                }
            }

        }
    }
}

class Robot {
    public static void main(String[] args) {
        new Thread(new Foot("left")).start();
        new Thread(new Foot("right")).start();
    }
}
