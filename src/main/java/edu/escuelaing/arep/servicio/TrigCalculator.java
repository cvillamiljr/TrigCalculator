package edu.escuelaing.arep.servicio;

import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class TrigCalculator {

    public  JSONObject resultsPage(String angulo,String funcion) {

        Trigonometrica t=new Trigonometrica();
        JSONObject json= new JSONObject();
        if (funcion.equals("sin")){
            double resSeno= t.getSeno(Double.parseDouble(angulo));
            json.put("sin",resSeno);
        }
        else if (funcion.equals("cos")){
            double resCoseno=t.getCoseno(Double.parseDouble(angulo));
            json.put("cos",resCoseno);
        }
        else if (funcion.equals("tan")){
            double restTangente=t.getTangete(Double.parseDouble(angulo));
            json.put("tan",restTangente);
        }
        return json;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 46000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
