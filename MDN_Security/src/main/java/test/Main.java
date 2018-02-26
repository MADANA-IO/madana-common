package test;

//Copyright (C) Leejae Karinja 2016 

import java.net.Inet4Address;

public class Main {

  public static void main(String[] args) {
      new Thread() {

          public void run() {
              Server s = new Server(13579);
              s.start();
              s.sendData("Hello, World!".getBytes());
              s.stop();
          }
      }.start();
      new Thread() {

          public void run() {
              try {
                  Client c = new Client(Inet4Address.getLocalHost().getHostAddress(), 13579);
                  c.start();
                  System.out.println(new String(c.receiveData()));
                  c.stop();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      }.start();
      return;
  }
}