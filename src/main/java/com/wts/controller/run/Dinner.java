package com.wts.controller.run;

import static com.wts.util.Food.sendDinner;

public class Dinner implements Runnable {

    public void run() {
        sendDinner("");
    }
}
