package controllers;

import play.*;
import play.mvc.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.json.*;
import views.html.*;
import java.util.Hashtable;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    /*
    * El siguiente método hace una multiplicación de enteros.
    * @param a el primer  entero.
    * @param b el segundo entero.
    * @return Resultado en formato Json.
    */
    public static Result getMultiplicacion(int a, int b){
        ObjectNode result = Json.newObject();
        result.put("resultado", a*b );
        return ok(result);
    }
    /*
    * El siguiente método verifica si una cadena es un palíndromo.
    * @param word la palabra a validar.
    * @return true o false en formato Json.
    */
    public static Result getPalindromo(String word){
        ObjectNode result = Json.newObject();
        String myWord = word.replaceAll("\\s+","");
        String reverse = new StringBuffer(myWord).reverse().toString();
        result.put("resultado", reverse.equalsIgnoreCase(myWord));
        return ok(result);
    }
    /*
    * El siguiente método convierte una cantidad dada en dolares a pesos.
    * @param dolar cantidad en dolares.
    * @return Resultado en formato Json.
    */
    public static Result getConversionAPesos(double dolar){
        ObjectNode result = Json.newObject();
        result.put("pesos", dolar*14.98);
        return ok(result);
    }
    /*
    * El siguiente método convierte grados en fahrenheit a centigrados.
    * @param fahrenheit grados en fahrenheit.
    * @return Resultado en formato Json.
    */
    public static Result getConversionACentigrados(int fahrenheit){
        ObjectNode result = Json.newObject();
        result.put("grados", (fahrenheit-32)/1.8);
        return ok(result);
    }
    public static Hashtable<String,String> capitales;
    public static Hashtable<String,String> embajadas;

    /*
    * El siguiente método regresa la capital del pais dado.
    * @param pais a regresar su capital.
    * @return capital en formato Json.
    */
    public static Result getCapital(String pais){
        ObjectNode result = Json.newObject();
        capitales=new Hashtable<String,String>();
        capitales.put("Alemania", "Berlin");
        capitales.put("Reino Unido", "Londres");
        capitales.put("Austria", "Vienna");
        capitales.put("España", "Madrid");
        capitales.put("Italia", "Roma");
        result.put("capital", capitales.get(pais));
        return ok(result);
    }
    /*
    * El siguiente método regresa la embajada del pais dado.
    * @param pais a regresar su embajada.
    * @return embajada en formato Json.
    */
    public static Result getEmbajada(String pais){
        ObjectNode result = Json.newObject();
        embajadas=new Hashtable<String,String>();
        embajadas.put("Alemania", "52.5077843,13.3517587");
        embajadas.put("Reino Unido", "51.513845,-0.1422097");
        embajadas.put("Austria", "38.7375761,-9.2019543");
        embajadas.put("España", "40.4160947,-3.6973632");
        embajadas.put("Italia", "41.9133032,12.5097257");
        result.put("embajada", embajadas.get(pais));
        return ok(result);
    }

}
