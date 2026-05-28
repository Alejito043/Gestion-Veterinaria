package modelo;

public abstract class ServicioVeterinario {

    protected String codigoServicio;
    protected Mascota mascota;
    protected double valorBase;
    protected String estado;

    // CONSTRUCTOR

    public ServicioVeterinario(String codigoServicio,
                               Mascota mascota,
                               double valorBase) {

        this.codigoServicio = codigoServicio;
        this.mascota = mascota;
        this.valorBase = valorBase;
        this.estado = "Registrado";
    }

    // GETTERS Y SETTERS

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public String getEstado() {
        return estado;
    }

    // MÉTODO PARA CAMBIAR ESTADO

    public void cambiarEstado(String nuevoEstado) {

        // Si está cancelado no puede cambiar
        if (estado.equalsIgnoreCase("Cancelado")) {

            System.out.println("Un servicio cancelado no puede modificarse.");
            return;
        }

        // Solo puede pasar a finalizado si está en proceso
        if (nuevoEstado.equalsIgnoreCase("Finalizado")
                && !estado.equalsIgnoreCase("En proceso")) {

            System.out.println("El servicio debe estar en proceso antes de finalizar.");
            return;
        }

        estado = nuevoEstado;

        System.out.println("Estado actualizado correctamente.");
    }

    // MÉTODOS ABSTRACTOS

    public abstract double calcularValorFinal();

    public abstract void mostrarDetalle();
}