package divisas;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConsultaDivisas {

    //Atributos
    private String url,
            base_code,
            target_code,
            conversion_rate,
            amount;

    private URI direccion;

    public static int contador = 0;

    //Constructores

    public ConsultaDivisas () {

    }
    public ConsultaDivisas (String base_code) {
        this.contador ++; //Contador de divisas consultadas
        this.base_code = base_code;
    }

    public ConsultaDivisas (String base_code, String target_code, String amount) {
        this.contador ++; //Contador de divisas consultadas
        this.base_code = base_code;
        this.target_code = target_code;
        this.amount = amount;

    }

    public TiposDeDivisas buscardorDivisas() throws IOException, InterruptedException, URISyntaxException {

        //Generando la URL de la API para realizar la consulta de divisas
        this.direccion = new URI("https://v6.exchangerate-api.com/v6/11401cc35d2c328b184a9975/latest/"
                +this.base_code);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client //Respuesta de la API.
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), TiposDeDivisas.class);

    }

    //Método para realizar la consulta de divisas
    public Divisa buscarDivisa()
            throws IOException, InterruptedException, URISyntaxException {

        this.direccion = new URI("https://v6.exchangerate-api.com/v6/11401cc35d2c328b184a9975/pair/"
                +this.getBase_code()+"/"
                +this.getTarget_code()+"/"
                +this.getAmount());

//Otra manera de realizar la consulta
//        this.url = "https://v6.exchangerate-api.com/v6/11401cc35d2c328b184a9975/pair/";
//        URI direccion =
//                URI.create(this.url
//                        + this.getBase_code() + "/"
//                        + this.getTarget_code() + "/"
//                        + this.getAmount());

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), Divisa.class);

    }



    //Getters y Setters


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }


}

