package modelo;

public class BanoPeluqueria extends ServicioVeterinario {

    private String tamanoMascota;
    private boolean servicioAdicional;

    public BanoPeluqueria(String codigoServicio,
                          Mascota mascota,
                          double valorBase,
                          String tamanoMascota,
                          boolean servicioAdicional) {

        super(codigoServicio, mascota, valorBase);

        this.tamanoMascota = tamanoMascota;
        this.servicioAdicional = servicioAdicional;
    }

    public String getTamanoMascota() {
        return tamanoMascota;
    }

    public void setTamanoMascota(String tamanoMascota) {
        this.tamanoMascota = tamanoMascota;
    }

    public boolean isServicioAdicional() {
        return servicioAdicional;
    }

    public void setServicioAdicional(boolean servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }

    @Override
    public double calcularValorFinal() {

        if (estado.equalsIgnoreCase("Cancelado")) {

            System.out.println("No se puede calcular un servicio cancelado.");
            return 0;
        }

        double total = valorBase;

        switch (tamanoMascota.toLowerCase()) {

            case "pequeño":
            case "pequeno":
                total += 10000;
                break;

            case "mediano":
                total += 20000;
                break;

            case "grande":
                total += 30000;
                break;
        }

        if (servicioAdicional) {
            total += 15000;
        }

        return total;
    }

    @Override
    public void mostrarDetalle() {

        System.out.println("===== BAÑO Y PELUQUERIA =====");
        System.out.println("Codigo servicio: " + codigoServicio);
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Tamaño: " + tamanoMascota);
        System.out.println("Servicio adicional: " + servicioAdicional);
        System.out.println("Estado: " + estado);
        System.out.println("Valor final: " + calcularValorFinal());
    }
}