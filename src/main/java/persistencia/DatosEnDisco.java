package persistencia;

import clasesDeRestaurant.Mesa;
import clasesDeRestaurant.Tarjeta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DatosEnDisco implements PersistirDatos {
    public void guardar(double total){
        try {
            String costoTotal = ("El saldo total es de: "+total+"\n");
            Files.write(Paths.get("/home/tiagonardini/TP2/archivo-restaurante.txt"), costoTotal.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){
            throw new RuntimeException("No se pudo guardar", e);
        }
    }
}
