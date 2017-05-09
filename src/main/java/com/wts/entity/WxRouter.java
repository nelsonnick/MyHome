package com.wts.entity;

public class WxRouter {
  private volatile static WxRouter wxRouter;

  private WxRouter() {

  }

  public static WxRouter getMe() {
    if (wxRouter == null) {
      synchronized (WxRouter.class) {
        if (wxRouter == null) {
          wxRouter = new WxRouter();
        }
      }
    }
    return wxRouter;
  }
}
