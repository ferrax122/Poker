/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpoker;
 
public class JCard {
 
 
    public static char estraiSEME() {
        char ch = ' ';
        switch ((int) (Math.round(Math.random() * 3) + 1)) {
 
            case 1:
                ch = 'f';//fiori
                break;
            case 2:
                ch = 'p';//picche
                break;
            case 3:
                ch = 'q';//quadri
                break;
            case 4:
                ch = 'c';//cuori
                break;
        }
        return ch;
    }
 
    public  static String estraicarta(String x, String t) {
        if (x.equals(t)) {
            return estraicarta(x, String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + estraiSEME());
        }
        return t;
    }
 
    public   static String estraicarta(String x, String y, String t) {
        if (x.equals(t) || y.equals(t)) {
            return estraicarta(x, y, String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + estraiSEME());
        }
        return t;
    }
 
    public  static String estraicarta(String x, String y, String z, String t) {
        if (x.equals(t) || y.equals(t) || z.equals(t)) {
            return estraicarta(x, y, z, String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + estraiSEME());
        }
        return t;
    }
 
    public  static String estraicarta(String x, String y, String z, String h, String t) {
        if (x.equals(t) || y.equals(t) || z.equals(t) || h.equals(t)) {
            return estraicarta(x, y, z, h, String.valueOf((int) (Math.round(Math.random() * 12) + 1)) + estraiSEME());
        }
        return t;
    }
}
