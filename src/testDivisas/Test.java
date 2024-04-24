package testDivisas;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import divisas.ConsultaDivisas;
import divisas.Divisa;
import divisas.TiposDeDivisas;
import generadorArchivo.Generador;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        String intro =
                """
                /************************************************/
                Divisas Disponibles: MXN, USD, EUR, GBP
                /************************************************/
                """;

        System.out.println("Ingresa tu divisa: ");
        Scanner reader = new Scanner(System.in);
        String divisa = reader.nextLine();

        System.out.println("Ingresa la divisa deseada: ");
        reader = new Scanner(System.in);
        String divisaDeseada = reader.nextLine();

        System.out.println("Ingresa el monto a convertir:");
        reader = new Scanner(System.in);
        String monto = reader.nextLine();

        ConsultaDivisas consulta = new ConsultaDivisas(divisa, divisaDeseada, monto);
        Divisa myDivisa = consulta.buscarDivisa();
        System.out.println("El resultado es: " + myDivisa);

        System.out.println("Otra cosa");




//        ConsultaDivisas consultas = new ConsultaDivisas("MXN");
//        TiposDeDivisas tiposDeDivisas = consulta.buscardorDivisas();
//
//
//
//        System.out.println();
//
//        //Generando el JSON (Serialización)
//        Gson gson = new Gson();
//        String json = gson.toJson(tiposDeDivisas);
//        System.out.println(json);
//
//        JsonReader reader = new JsonReader(json);
//
//        Map<String, TiposDeDivisas> map = new LinkedHashMap<>();
//        map.get("MXN");
//
//        json = gson.toJson(map);
//        System.out.println(json);























//        ConsultaDivisas consulta = new ConsultaDivisas("USD", "MXN", "2.0");
//
//        Divisa divisa = consulta.buscarDivisa();
//
//        System.out.println(divisa);









    }
}
