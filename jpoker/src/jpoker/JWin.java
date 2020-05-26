/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpoker;
 
public class JWin {
 
    private static int[] num = new int[5];
    private static char[] seme = new char[5];
 
 
    public static void setcard(String v[]) {
 
        int i = 0, t = 0;
        String c;
 
        for (i = 0; i < 5; i++) {
 
            if (v[i].length() == 3) {
 
                c = String.valueOf(v[i].charAt(0)) + String.valueOf(v[i].charAt(1));
 
                num[i] = Integer.valueOf(c);
                seme[i] = v[i].charAt(2);
 
            } else if (v[i].length() == 2){
 
                c = String.valueOf(v[i].charAt(0));
                num[i] = Integer.valueOf(c);
                seme[i] = v[i].charAt(1);
            }
        }
 
       for (int j = 0; j < v.length; j++) {
            for (int k = j; k < v.length; k++) {
                if (num[j] > num[k]) {
                    t = num[j];
                    num[j] = num[k];
                    num[k] = t;
                }//fine if
            }//fine for
        }//fine for
       
    }
 
    public static boolean poker() {
 
        if (num[0] == num[1] && num[0] == num[2] && num[0] == num[3]) {
            return true;
        } else if (num[4] == num[3] && num[4] == num[2] && num[4] == num[1]) {
            return true;
        } else {
            return false;
        }
    }
 
    public static boolean scalaR() {
 
        if ((num[0] == 1 && num[1] == 10 && num[2] == 11 && num[3] == 12 && num[4] == 13) && colore()) {
            return true;
        } else {
            return false;
        }
    }
 
    public static  boolean colore() {
 
        if (seme[0] == seme[1] && seme[0] == seme[2] && seme[0] == seme[3] && seme[0] == seme[4]) {
            return true;
        } else {
            return false;
        }
    }
 
    public static boolean full() {
 
        if ((num[0] == num[1] && num[0] == num[2] && (num[3] == num[4]))) {
            return true;
        } else if ((num[0] == num[1]) && (num[4] == num[3] && num[4] == num[2])) {
            return true;
        } else {
            return false;
        }
    }
 
    public static boolean scalaColore() {
 
        if ((num[0] == 1 && num[1] == 9 && num[2] == 10 && num[3] == 11 && num[4] == 12) && colore()) {
            return true;
        } else if ((num[0] == 1 && num[1] == 8 && num[2] == 9 && num[3] == 10 && num[4] == 11) && colore()) {
            return true;
        } else if ((num[0] == 1 && num[1] == 7 && num[2] == 8 && num[3] == 9 && num[4] == 10) && colore()) {
            return true;
        } else if ((num[0] == 1 && num[1] == 6 && num[2] == 7 && num[3] == 8 && num[4] == 9) && colore()) {
            return true;
        } else if ((num[0] == 1 && num[1] == 5 && num[2] == 6 && num[3] == 7 && num[4] == 8) && colore()) {
            return true;
        } else if ((num[0] == 1 && num[1] == 4 && num[2] == 5 && num[3] == 6 && num[4] == 7) && colore()) {
            return true;
        } else if ((num[0] == 1 && num[1] == 3 && num[2] == 4 && num[3] == 5 && num[4] == 6) && colore()) {
            return true;
        } else if ((num[0] == 1 && num[1] == 2 && num[2] == 3 && num[3] == 4 && num[4] == 5) && colore()) {
            return true;
        } else {
            return false;
        }
 
    }
 
    public static boolean tris() {
 
        if ((num[0] == num[1] && num[0] == num[2])) {
            return true;
        } else if (num[1] == num[2] && num[1] == num[3]) {
            return true;
        } else if (num[4] == num[3] && num[4] == num[2]) {
            return true;
        } else {
            return false;
        }
    }
 
    public static boolean coppia() {
 
        if (num[0] == num[1]) {
            return true;
        } else if (num[1] == num[2]) {
            return true;
        } else if (num[2] == num[3]) {
            return true;
        } else if (num[3] == num[4]) {
            return true;
        } else {
            return false;
        }
    }
 
    public static boolean doppiaCoppia() {
        if (num[0] == num[1] && num[2] == num[3]) {
            return true;
        } else if (num[1] == num[2] && num[4] == num[3]) {
            return true;
        } else if (num[0] == num[1] && num[4] == num[3]) {
            return true;
        } else {
            return false;
        }
    }
 
    public static boolean scala() {
 
        if ((num[0] == 1 && num[1] == 10 && num[2] == 11 && num[3] == 12 && num[4] == 13)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 9 && num[2] == 10 && num[3] == 11 && num[4] == 12)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 8 && num[2] == 9 && num[3] == 10 && num[4] == 11)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 7 && num[2] == 8 && num[3] == 9 && num[4] == 10)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 6 && num[2] == 7 && num[3] == 8 && num[4] == 9)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 5 && num[2] == 6 && num[3] == 7 && num[4] == 8)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 4 && num[2] == 5 && num[3] == 6 && num[4] == 7)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 3 && num[2] == 4 && num[3] == 5 && num[4] == 6)) {
            return true;
        } else if ((num[0] == 1 && num[1] == 2 && num[2] == 3 && num[3] == 4 && num[4] == 5)) {
            return true;
        } else {
            return false;
        }
    }
}//fine class
