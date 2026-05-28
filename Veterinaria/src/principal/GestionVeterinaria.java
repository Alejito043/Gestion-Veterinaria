package principal;

import java.util.Scanner;
import servicio.ClinicaVeterinaria;

public class GestionVeterinaria {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClinicaVeterinaria clinica = new ClinicaVeterinaria();

        int opcion = 0;

        do {

            System.out.println("\n===== CLINICA VETERINARIA =====");

            System.out.println("1. Registrar propietario");
            System.out.println("2. Registrar mascota");
            System.out.println("3. Buscar mascota");
            System.out.println("4. Registrar consulta médica");
            System.out.println("5. Registrar vacunación");
            System.out.println("6. Registrar baño y peluquería");
            System.out.println("7. Registrar hospitalización");
            System.out.println("8. Mostrar servicios");
            System.out.println("9. Calcular valor servicio");
            System.out.println("10. Consultar servicios por mascota");
            System.out.println("11. Cambiar estado servicio");
            System.out.println("12. Salir");

            try {

                System.out.print("Seleccione una opción: ");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:

                        System.out.print("Documento: ");
                        String documento = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Telefono: ");
                        String telefono = sc.nextLine();

                        clinica.registrarPropietario(
                                documento,
                                nombre,
                                telefono
                        );

                        break;

                    case 2:

                        System.out.print("Codigo mascota: ");
                        String codigoMascota = sc.nextLine();

                        System.out.print("Nombre mascota: ");
                        String nombreMascota = sc.nextLine();

                        System.out.print("Especie: ");
                        String especie = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Documento propietario: ");
                        String documentoPropietario = sc.nextLine();

                        clinica.registrarMascota(
                                codigoMascota,
                                nombreMascota,
                                especie,
                                edad,
                                documentoPropietario
                        );

                        break;

                    case 3:

                        System.out.print(
                                "Ingrese nombre de la mascota: "
                        );

                        String nombreBusqueda =
                                sc.nextLine();

                        clinica.buscarMascotaPorNombre(
                                nombreBusqueda
                        );

                        break;

                    case 4:

                        System.out.print("Codigo servicio: ");
                        String codigoConsulta = sc.nextLine();

                        System.out.print("Codigo mascota: ");
                        String codigoMascotaConsulta =
                                sc.nextLine();

                        System.out.print("Valor base: ");
                        double valorConsulta =
                                sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Motivo consulta: ");
                        String motivo = sc.nextLine();

                        System.out.print(
                                "Medicamentos formulados: "
                        );

                        int medicamentos =
                                sc.nextInt();
                        sc.nextLine();

                        clinica.registrarConsultaMedica(
                                codigoConsulta,
                                codigoMascotaConsulta,
                                valorConsulta,
                                motivo,
                                medicamentos
                        );

                        break;

                    case 5:

                        System.out.print("Codigo servicio: ");
                        String codigoVacuna = sc.nextLine();

                        System.out.print("Codigo mascota: ");
                        String codigoMascotaVacuna =
                                sc.nextLine();

                        System.out.print("Valor base: ");
                        double valorVacuna =
                                sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Nombre vacuna: ");
                        String vacuna = sc.nextLine();

                        System.out.print("Numero dosis: ");
                        int dosis = sc.nextInt();
                        sc.nextLine();

                        clinica.registrarVacunacion(
                                codigoVacuna,
                                codigoMascotaVacuna,
                                valorVacuna,
                                vacuna,
                                dosis
                        );

                        break;

                    case 6:

                        System.out.print("Codigo servicio: ");
                        String codigoBano = sc.nextLine();

                        System.out.print("Codigo mascota: ");
                        String codigoMascotaBano =
                                sc.nextLine();

                        System.out.print("Valor base: ");
                        double valorBano =
                                sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Tamaño mascota: ");
                        String tamano = sc.nextLine();

                        System.out.print(
                                "Servicio adicional (si/no): "
                        );

                        String respuesta =
                                sc.nextLine();

                        boolean adicional =
                                respuesta.equalsIgnoreCase("si");

                        clinica.registrarBano(
                                codigoBano,
                                codigoMascotaBano,
                                valorBano,
                                tamano,
                                adicional
                        );

                        break;

                    case 7:

                        System.out.print("Codigo servicio: ");
                        String codigoHospital =
                                sc.nextLine();

                        System.out.print("Codigo mascota: ");
                        String codigoMascotaHospital =
                                sc.nextLine();

                        System.out.print("Valor base: ");
                        double valorHospital =
                                sc.nextDouble();

                        System.out.print("Numero dias: ");
                        int dias = sc.nextInt();
                        sc.nextLine();

                        System.out.print(
                                "Requiere medicamentos (si/no): "
                        );

                        String respuestaMedicamentos =
                                sc.nextLine();

                        boolean medicamentosHospital =
                                respuestaMedicamentos
                                        .equalsIgnoreCase("si");

                        clinica.registrarHospitalizacion(
                                codigoHospital,
                                codigoMascotaHospital,
                                valorHospital,
                                dias,
                                medicamentosHospital
                        );

                        break;

                    case 8:

                        clinica.mostrarServicios();

                        break;

                    case 9:

                        System.out.print(
                                "Codigo servicio: "
                        );

                        String codigoServicio =
                                sc.nextLine();

                        clinica.calcularValorServicio(
                                codigoServicio
                        );

                        break;

                    case 10:

                        System.out.print(
                                "Codigo mascota: "
                        );

                        String codigoBusqueda =
                                sc.nextLine();

                        clinica.consultarServiciosMascota(
                                codigoBusqueda
                        );

                        break;

                    case 11:

                        System.out.print(
                                "Codigo servicio: "
                        );

                        String codigoEstado =
                                sc.nextLine();

                        System.out.print(
                                "Nuevo estado: "
                        );

                        String nuevoEstado =
                                sc.nextLine();

                        clinica.cambiarEstadoServicio(
                                codigoEstado,
                                nuevoEstado
                        );

                        break;

                    case 12:

                        System.out.println(
                                "Saliendo del sistema..."
                        );

                        break;

                    default:

                        System.out.println(
                                "Opción inválida."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: ingresaste un dato inválido."
                );

                sc.nextLine();
            }

        } while (opcion != 12);

        sc.close();
    }
}