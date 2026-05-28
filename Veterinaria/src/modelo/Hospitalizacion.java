package modelo;

public class Hospitalizacion extends ServicioVeterinario {

    private int numeroDias;
    private boolean requiereMedicamentos;

    public Hospitalizacion(String codigoServicio,
                           Mascota mascota,
                           double valorBase,
                           int numeroDias,
                           boolean requiereMedicamentos) {

        super(codigoServicio, mascota, valorBase);

        this.numeroDias = numeroDias;
        this.requiereMedicamentos = requiereMedicamentos;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public boolean isRequiereMedicamentos() {
        return requiereMedicamentos;
    }

    public void setRequiereMedicamentos(boolean requiereMedicamentos) {
        this.requiereMedicamentos = requiereMedicamentos;
    }

    @Override
    public double calcularValorFinal() {

        if (estado.equalsIgnoreCase("Cancelado")) {

            System.out.println("No se puede calcular un servicio cancelado.");
            return 0;
        }

        double total = valorBase + (numeroDias * 50000);

        if (requiereMedicamentos) {
            total += 40000;
        }

        return total;
    }

    @Override
    public void mostrarDetalle() {

        System.out.println("===== HOSPITALIZACION =====");
        System.out.println("Codigo servicio: " + codigoServicio);
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Dias hospitalizado: " + numeroDias);
        System.out.println("Requiere medicamentos: " + requiereMedicamentos);
        System.out.println("Estado: " + estado);
        System.out.println("Valor final: " + calcularValorFinal());
    }
}