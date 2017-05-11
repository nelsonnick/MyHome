package com.wts.controller.run;

import java.util.Date;


public class Test implements Runnable {

    public void run() {
        System.out.println(new Date());
    }
}
