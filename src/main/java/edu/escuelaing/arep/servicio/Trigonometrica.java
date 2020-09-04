package edu.escuelaing.arep.servicio;

public class Trigonometrica {


    public static double calculo(String operation,String number){
        double res = 0;

        switch (operation){
            case "sin":{
                res = Math.sin(Double.parseDouble(number));
                break;
            } case "cos":{
                res = Math.cos(Double.parseDouble(number));
                break;
            } case "tan":{
                res = Math.tan(Double.parseDouble(number));
                break;

            }
        }

        return res;


    }
}
