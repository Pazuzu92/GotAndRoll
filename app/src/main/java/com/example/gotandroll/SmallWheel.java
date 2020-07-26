package com.example.gotandroll;

import java.util.Random;

public class SmallWheel extends Wheel {
    public SmallWheel(WheelListener wheelListener, long frameDuration, long startIn) {
        super(wheelListener, frameDuration, startIn);
        this.wheelListener = wheelListener;
        this.frameDuration = frameDuration;
        this.startIn = startIn;
        currentIndex = 0;
        isStarted = true;;
    }
    private WheelListener wheelListener;
    private long frameDuration;
    private long startIn;
    private boolean isStarted;
    Random random = new Random();
    private static int[] drawables = {R.drawable.pic_1_small, R.drawable.pic_2_small, R.drawable.pic_3_small,
            R.drawable.pic_4_small, R.drawable.pic_5_small, R.drawable.pic_6_small};

    @Override
    public void run() {
        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
        }

        while (isStarted) {
            try {
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
            }

            nextImg();
            if (wheelListener != null) {
                wheelListener.newImage(drawables[random.nextInt(drawables.length)]);

            }
        }
    }

    public void stopWheel() {
        isStarted = false;
    }
}
