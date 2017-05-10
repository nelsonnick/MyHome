package com.wts.controller.run;

import static com.wts.util.Food.sendBreakfast;

public class Breakfast implements Runnable {

  public void run() {
    sendBreakfast("");
  }
}