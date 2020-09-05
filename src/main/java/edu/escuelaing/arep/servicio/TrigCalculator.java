package edu.escuelaing.arep.servicio;

import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class TrigCalculator {

    public static void main(String[] args) {
        port(getPort());
        get("/calculate",(req,res)->{
            String operation = req.queryParams("operation");
            String number = req.queryParams("number");
            JSONObject jsonObject = new JSONObject();
            double valorARetornar = Trigonometrica.calculo(operation,number);
            jsonObject.put("Funcion",operation);
            jsonObject.put("Resultado",valorARetornar);
            return jsonObject;

        });


    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 46000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
