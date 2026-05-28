package servicio;

import java.util.ArrayList;

import modelo.BanoPeluqueria;
import modelo.ConsultaMedica;
import modelo.Hospitalizacion;
import modelo.Mascota;
import modelo.Propietario;
import modelo.ServicioVeterinario;
import modelo.Vacunacion;

public class ClinicaVeterinaria {

    private ArrayList<Propietario> propietarios;
    private ArrayList<Mascota> mascotas;
    private ArrayList<ServicioVeterinario> servicios;

    public ClinicaVeterinaria() {

        propietarios = new ArrayList<>();
        mascotas = new ArrayList<>();
        servicios = new ArrayList<>();
    }

   
    // REGISTRAR PROPIETARIO
    
    public void registrarPropietario(String documento,
                                     String nombre,
                                     String telefono) {

        if (documento.isEmpty()
                || nombre.isEmpty()
                || telefono.isEmpty()) {

            System.out.println("Datos inválidos.");
            return;
        }

        for (Propietario p : propietarios) {

            if (p.getDocumento().equals(documento)) {

                System.out.println("El propietario ya existe.");
                return;
            }
        }

        Propietario propietario =
                new Propietario(documento, nombre, telefono);

        propietarios.add(propietario);

        System.out.println("Propietario registrado correctamente.");
    }

    
    // BUSCAR PROPIETARIO
    
    public Propietario buscarPropietario(String documento) {

        for (Propietario p : propietarios) {

            if (p.getDocumento().equals(documento)) {

                return p;
            }
        }

        return null;
    }

    
    // REGISTRAR MASCOTA
    
    public void registrarMascota(String codigo,
                                 String nombre,
                                 String especie,
                                 int edad,
                                 String documentoPropietario) {

        if (codigo.isEmpty()
                || nombre.isEmpty()
                || especie.isEmpty()
                || edad < 0) {

            System.out.println("Datos inválidos.");
            return;
        }

        if (buscarMascota(codigo) != null) {

            System.out.println("La mascota ya existe.");
            return;
        }

        Propietario propietario =
                buscarPropietario(documentoPropietario);

        if (propietario == null) {

            System.out.println("El propietario no existe.");
            return;
        }

        Mascota mascota =
                new Mascota(codigo,
                            nombre,
                            especie,
                            edad,
                            propietario);

        mascotas.add(mascota);

        System.out.println("Mascota registrada correctamente.");
    }

    
    // BUSCAR MASCOTA POR CODIGO
    
    public Mascota buscarMascota(String codigo) {

        for (Mascota m : mascotas) {

            if (m.getCodigo().equalsIgnoreCase(codigo)) {

                return m;
            }
        }

        return null;
    }

    
    // BUSCAR MASCOTA POR NOMBRE
    
    public void buscarMascotaPorNombre(String nombre) {

        boolean encontrada = false;

        for (Mascota m : mascotas) {

            if (m.getNombre().equalsIgnoreCase(nombre)) {

                m.mostrarInformacion();
                encontrada = true;
            }
        }

        if (!encontrada) {

            System.out.println("No se encontraron mascotas.");
        }
    }

    
    // BUSCAR SERVICIO
    
    public ServicioVeterinario buscarServicio(String codigoServicio) {

        for (ServicioVeterinario s : servicios) {

            if (s.getCodigoServicio()
                    .equalsIgnoreCase(codigoServicio)) {

                return s;
            }
        }

        return null;
    }

   
    // REGISTRAR CONSULTA
    
    public void registrarConsultaMedica(String codigoServicio,
                                        String codigoMascota,
                                        double valorBase,
                                        String motivo,
                                        int medicamentos) {

        if (buscarServicio(codigoServicio) != null) {

            System.out.println("El servicio ya existe.");
            return;
        }

        Mascota mascota = buscarMascota(codigoMascota);

        if (mascota == null) {

            System.out.println("La mascota no existe.");
            return;
        }

        if (valorBase <= 0
                || motivo.isEmpty()
                || medicamentos < 0) {

            System.out.println("Datos inválidos.");
            return;
        }

        ConsultaMedica consulta =
                new ConsultaMedica(codigoServicio,
                                   mascota,
                                   valorBase,
                                   motivo,
                                   medicamentos);

        servicios.add(consulta);

        System.out.println("Consulta registrada correctamente.");
    }

    
    // REGISTRAR VACUNACION
    
    public void registrarVacunacion(String codigoServicio,
                                    String codigoMascota,
                                    double valorBase,
                                    String vacuna,
                                    int dosis) {

        if (buscarServicio(codigoServicio) != null) {

            System.out.println("El servicio ya existe.");
            return;
        }

        Mascota mascota = buscarMascota(codigoMascota);

        if (mascota == null) {

            System.out.println("La mascota no existe.");
            return;
        }

        if (valorBase <= 0
                || vacuna.isEmpty()
                || dosis <= 0) {

            System.out.println("Datos inválidos.");
            return;
        }

        Vacunacion vacunacion =
                new Vacunacion(codigoServicio,
                               mascota,
                               valorBase,
                               vacuna,
                               dosis);

        servicios.add(vacunacion);

        System.out.println("Vacunación registrada correctamente.");
    }

    
    // REGISTRAR BAÑO
    
    public void registrarBano(String codigoServicio,
                              String codigoMascota,
                              double valorBase,
                              String tamano,
                              boolean adicional) {

        if (buscarServicio(codigoServicio) != null) {

            System.out.println("El servicio ya existe.");
            return;
        }

        Mascota mascota = buscarMascota(codigoMascota);

        if (mascota == null) {

            System.out.println("La mascota no existe.");
            return;
        }

        if (valorBase <= 0) {

            System.out.println("Valor inválido.");
            return;
        }

        if (!tamano.equalsIgnoreCase("pequeño")
                && !tamano.equalsIgnoreCase("pequeno")
                && !tamano.equalsIgnoreCase("mediano")
                && !tamano.equalsIgnoreCase("grande")) {

            System.out.println("Tamaño inválido.");
            return;
        }

        BanoPeluqueria bano =
                new BanoPeluqueria(codigoServicio,
                                   mascota,
                                   valorBase,
                                   tamano,
                                   adicional);

        servicios.add(bano);

        System.out.println("Baño registrado correctamente.");
    }

    
    // REGISTRAR HOSPITALIZACION
    
    public void registrarHospitalizacion(String codigoServicio,
                                         String codigoMascota,
                                         double valorBase,
                                         int dias,
                                         boolean medicamentos) {

        if (buscarServicio(codigoServicio) != null) {

            System.out.println("El servicio ya existe.");
            return;
        }

        Mascota mascota = buscarMascota(codigoMascota);

        if (mascota == null) {

            System.out.println("La mascota no existe.");
            return;
        }

        if (valorBase <= 0 || dias <= 0) {

            System.out.println("Datos inválidos.");
            return;
        }

        Hospitalizacion hospitalizacion =
                new Hospitalizacion(codigoServicio,
                                    mascota,
                                    valorBase,
                                    dias,
                                    medicamentos);

        servicios.add(hospitalizacion);

        System.out.println("Hospitalización registrada correctamente.");
    }

    
    // MOSTRAR SERVICIOS
    
    public void mostrarServicios() {

        if (servicios.isEmpty()) {

            System.out.println("No hay servicios registrados.");
            return;
        }

        for (ServicioVeterinario s : servicios) {

            s.mostrarDetalle();

            System.out.println("-------------------");
        }
    }

    
    // CALCULAR VALOR SERVICIO
    
    public void calcularValorServicio(String codigoServicio) {

        ServicioVeterinario servicio =
                buscarServicio(codigoServicio);

        if (servicio == null) {

            System.out.println("Servicio no encontrado.");
            return;
        }

        if (servicio.getEstado()
                .equalsIgnoreCase("Cancelado")) {

            System.out.println("No se puede calcular un servicio cancelado.");
            return;
        }

        System.out.println("Valor final: "
                + servicio.calcularValorFinal());
    }

    
    // CONSULTAR SERVICIOS MASCOTA
    
    public void consultarServiciosMascota(String codigoMascota) {

        boolean encontrado = false;

        for (ServicioVeterinario s : servicios) {

            if (s.getMascota()
                    .getCodigo()
                    .equalsIgnoreCase(codigoMascota)) {

                s.mostrarDetalle();
                encontrado = true;
            }
        }

        if (!encontrado) {

            System.out.println("No hay servicios para esta mascota.");
        }
    }

    
    // CAMBIAR ESTADO
    
    public void cambiarEstadoServicio(String codigoServicio,
                                      String nuevoEstado) {

        ServicioVeterinario servicio =
                buscarServicio(codigoServicio);

        if (servicio == null) {

            System.out.println("Servicio no encontrado.");
            return;
        }

        String estadoActual = servicio.getEstado();

        if (estadoActual.equalsIgnoreCase("Cancelado")) {

            System.out.println("Un servicio cancelado no puede cambiar.");
            return;
        }

        if (nuevoEstado.equalsIgnoreCase("Finalizado")
                && !estadoActual.equalsIgnoreCase("En proceso")) {

            System.out.println(
                    "Solo se puede finalizar si está en proceso."
            );

            return;
        }

        servicio.cambiarEstado(nuevoEstado);

        System.out.println("Estado actualizado correctamente.");
    }
}