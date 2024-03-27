package clasesDeRestaurant;

import java.time.LocalDate;

public class Visa extends Tarjeta {
    public Visa(Integer nroDeTarjeta, LocalDate fechaDeVencimiento, double limite, Comensal duenio) {
        super(nroDeTarjeta, fechaDeVencimiento, limite, duenio);
        descuento = 0.97;
    }

    @Override
    double descuento(double costoBebida, double costoPlato, double costoPropina) {
        if (!superaLimite(costoBebida, costoPlato, costoPropina) && (activa())) {
            double totalAPagar = (costoBebida * descuento) + costoPlato + costoPropina;
            System.out.print(+totalAPagar);
            limite -= totalAPagar;
            return totalAPagar;
        }
        return 0;
    }
    @Override
    boolean activa() {
        LocalDate hoy = LocalDate.now();
        return !hoy.isAfter(fechaDeVencimiento);
    }
    @Override
    boolean superaLimite(double costoBebida, double costoComida, double costoPropina) {
        return costoPropina + costoBebida + costoComida > limite;
    }
}
