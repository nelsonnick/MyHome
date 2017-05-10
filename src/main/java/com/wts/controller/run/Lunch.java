package com.wts.controller.run;

import static com.wts.util.Food.sendLunch;

public class Lunch implements Runnable {

    public void run() {
        sendLunch("");
    }
}
