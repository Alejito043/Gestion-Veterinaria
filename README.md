# 🐾 Sistema de Gestión Veterinaria

Proyecto de consola desarrollado en Java para la materia de **Programación Orientada a Objetos (POO)**. Simula la gestión de una clínica veterinaria: registro de propietarios, mascotas y distintos tipos de servicios.

---

## 📌 Conceptos de POO aplicados

- **Herencia** — `ServicioVeterinario` es una clase abstracta base de la que heredan `ConsultaMedica`, `Vacunacion`, `BanoPeluqueria` y `Hospitalizacion`.
- **Polimorfismo** — Cada subclase sobreescribe `calcularValorFinal()` y `mostrarDetalle()` con su propia lógica.
- **Encapsulamiento** — Todos los atributos son privados/protegidos y se acceden mediante getters y setters.
- **Abstracción** — `ServicioVeterinario` define el contrato que deben cumplir todos los servicios.

---

## 🗂️ Estructura del proyecto

```
Veterinaria/
├── src/
│   ├── modelo/
│   │   ├── Propietario.java
│   │   ├── Mascota.java
│   │   ├── ServicioVeterinario.java   ← clase abstracta
│   │   ├── ConsultaMedica.java
│   │   ├── Vacunacion.java
│   │   ├── BanoPeluqueria.java
│   │   └── Hospitalizacion.java
│   ├── servicio/
│   │   └── ClinicaVeterinaria.java    ← lógica principal del sistema
│   └── principal/
│       └── GestionVeterinaria.java    ← menú de consola (main)
```

---

## ⚙️ Requisitos

- Java JDK 8 o superior
- Cualquier IDE o terminal con `javac`

---

## ▶️ Cómo ejecutar

### Opción 1 — VS Code
1. Instala la extensión **Extension Pack for Java** (Microsoft).
2. Abre la carpeta raíz del proyecto en VS Code.
3. Abre `src/principal/GestionVeterinaria.java` y haz clic en **Run** (▶️) en la parte superior derecha.

### Opción 2 — Terminal
```bash
# Desde la carpeta raíz del proyecto
javac -d out src/modelo/*.java src/servicio/*.java src/principal/*.java
java -cp out principal.GestionVeterinaria
```

### Opción 3 — NetBeans
Abre el proyecto directamente; al ser un proyecto NetBeans, se cargará sin configuración adicional.

---

## 🧾 Funcionalidades del menú

| Opción | Descripción |
|--------|-------------|
| 1 | Registrar propietario |
| 2 | Registrar mascota |
| 3 | Buscar mascota por nombre |
| 4 | Registrar consulta médica |
| 5 | Registrar vacunación |
| 6 | Registrar baño y peluquería |
| 7 | Registrar hospitalización |
| 8 | Mostrar todos los servicios |
| 9 | Calcular valor final de un servicio |
| 10 | Consultar servicios por mascota |
| 11 | Cambiar estado de un servicio |
| 12 | Salir |

---

## 💰 Cálculo de valores

| Servicio | Fórmula |
|----------|---------|
| Consulta médica | `valorBase + (medicamentos × $12.000)` |
| Vacunación | `valorBase + (dosis × $35.000)` |
| Baño y peluquería | `valorBase + recargo por tamaño + $15.000 si hay servicio adicional` |
| Hospitalización | `valorBase + (días × $50.000) + $40.000 si requiere medicamentos` |

---

## 🔄 Estados de un servicio

Los servicios siguen este flujo de estados:

```
Registrado → En proceso → Finalizado
           ↘
            Cancelado (estado final, no modificable)
```

---

## 👤 Autor

Proyecto académico — Materia: Programación Orientada a Objetos
