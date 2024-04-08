package clasesDeRestaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nombreDeRestaurante;
    private List<Mesa> mesas;


    public Restaurante(String nombreDelRestaurante){
        this.nombreDeRestaurante = nombreDelRestaurante;
        this.mesas = new ArrayList<>();
    }

    public void agregarMesa (Mesa unaMesa){
        if (this.mesas.size() > 10){
            System.out.print("Se ha alcanzado el limite maximo de mesas en el restaurante\n");
        }else{
            this.mesas.add(unaMesa);
        }
    }

}
