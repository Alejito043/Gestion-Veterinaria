package modelo;

public class Vacunacion extends ServicioVeterinario {

    private String nombreVacuna;
    private int numeroDosis;

    public Vacunacion(String codigoServicio,
                       Mascota mascota,
                       double valorBase,
                       String nombreVacuna,
                       int numeroDosis) {

        super(codigoServicio, mascota, valorBase);

        this.nombreVacuna = nombreVacuna;
        this.numeroDosis = numeroDosis;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public int getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(int numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    @Override
    public double calcularValorFinal() {

        if (estado.equalsIgnoreCase("Cancelado")) {

            System.out.println("No se puede calcular un servicio cancelado.");
            return 0;
        }

        return valorBase + (numeroDosis * 35000);
    }

    @Override
    public void mostrarDetalle() {

        System.out.println("===== VACUNACION =====");
        System.out.println("Codigo servicio: " + codigoServicio);
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Vacuna: " + nombreVacuna);
        System.out.println("Dosis: " + numeroDosis);
        System.out.println("Estado: " + estado);
        System.out.println("Valor final: " + calcularValorFinal());
    }
}