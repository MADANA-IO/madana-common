/*******************************************************************************
 * Copyright (C) 2018 MADANA
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @organization:MADANA
 * @author:Jean-Fabian Wenisch
 * @contact:dev@madana.io
 ******************************************************************************/
package de.madana.common.security.test;

//Copyright (C) Leejae Karinja 2016 

import java.net.Inet4Address;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

  /**
   * The main method.
   *
   * @param args the arguments
   */
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
