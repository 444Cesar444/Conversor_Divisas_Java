package generadorArchivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import divisas.Divisa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Generador {


    //Método para generar el archivo tipo JSON

    public void generarArchivo(Divisa divisa) throws IOException {

        //Formato JSON de salida.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Nombrando al Archivo
        FileWriter nombreArchivo = new FileWriter("Divisas.json");

        /*Combierte un String a formato y tipo JSON*/
        nombreArchivo.write(gson.toJson(divisa));
        nombreArchivo.close();

    }




}
