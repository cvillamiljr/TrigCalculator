package edu.escuelaing.arep.fachada;

import edu.escuelaing.arep.servicio.TrigCalculator;
import edu.escuelaing.arep.servicio.Trigonometrica;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.port;

public class Facade {


    public static void main(String[] args) {

        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resulPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<title> Calculadora</title>"
                + "<body>"
                + "<h1>Calculadora Web</h1>"
                + "<form action=\"/results\">"
                + "<p>El angulo debe estar en radianes</p>"
                + "<p>La operación debe ser las abreviaciones de las funciones trigonometrias</p>"
                + "<p>Ejemplo :</p>"
                + "<p>Numero : 0.5 Función : sin</p>"
                + "<br></br>"
                + "<label for=\"fdata\">Ecribe el numero:</label><br>"
                + "<input type=\"text\" id=\"Datos\" name=\"Datos\"><br><br>"
                + "<label for=\"fdata\">Ecribe la función:</label><br>"
                + "<input type=\"text\" id=\"Funcion\" name=\"Funcion\"><br><br>"
                + "<input type=\"submit\" value=\"Calcular\">"
                + "<p>Si quieres saber el resultado de tu operación estará en la otra pagina.</p>"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    public static JSONObject resulPage(Request req, Response res) {
        String angulo = req.queryParams("Datos");
        String funcion = req.queryParams("Funcion");

        JSONObject respuesta= new TrigCalculator().resultsPage(angulo,funcion);
        return respuesta;
    }



        public static int getPort () {
            if (System.getenv("PORT") != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 46000; //returns default port if heroku-port isn't set (i.e. on localhost)
        }


}
