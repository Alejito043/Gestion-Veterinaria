package modelo;

public class ConsultaMedica extends ServicioVeterinario {

    private String motivoConsulta;
    private int medicamentosFormulados;

    // CONSTRUCTOR

    public ConsultaMedica(String codigoServicio,
                          Mascota mascota,
                          double valorBase,
                          String motivoConsulta,
                          int medicamentosFormulados) {

        super(codigoServicio, mascota, valorBase);

        this.motivoConsulta = motivoConsulta;
        this.medicamentosFormulados = medicamentosFormulados;
    }

    // GETTERS Y SETTERS

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public int getMedicamentosFormulados() {
        return medicamentosFormulados;
    }

    public void setMedicamentosFormulados(int medicamentosFormulados) {
        this.medicamentosFormulados = medicamentosFormulados;
    }

    // MÉTODO SOBRESCRITO

    @Override
    public double calcularValorFinal() {

        if (estado.equalsIgnoreCase("Cancelado")) {

            System.out.println("No se puede calcular un servicio cancelado.");
            return 0;
        }

        return valorBase + (medicamentosFormulados * 12000);
    }

    // MÉTODO SOBRESCRITO

    @Override
    public void mostrarDetalle() {

        System.out.println("===== CONSULTA MEDICA =====");
        System.out.println("Codigo servicio: " + codigoServicio);
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Motivo: " + motivoConsulta);
        System.out.println("Medicamentos: " + medicamentosFormulados);
        System.out.println("Estado: " + estado);
        System.out.println("Valor final: " + calcularValorFinal());
    }
}