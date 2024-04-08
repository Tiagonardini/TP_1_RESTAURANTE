package clasesDeRestaurant;

import java.time.LocalDate;

public class Visa extends Tarjeta {

    private static final double DESCUENTO = 0.97;

    public Visa(Integer nroDeTarjeta, LocalDate fechaDeVencimiento, double limite, Comensal duenio) {
        super(nroDeTarjeta, fechaDeVencimiento, limite, duenio);
    }

    @Override
    double descuento(double costoBebida, double costoPlato, double costoPropina) {
        if (!superaLimite(costoBebida, costoPlato, costoPropina) && (activa())) {
            double totalAPagar = (costoBebida * DESCUENTO) + costoPlato + costoPropina;
            limite -= totalAPagar;
            return totalAPagar;
        }
        throw new RuntimeException("El total supera el limite...");
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
