# SalesTracker API

API REST para la gestión de equipos de ventas, desarrollada con Java y Spring Boot. El proyecto nació como ejercicio para aprender el stack backend Java en un contexto real de negocio — gestión de vendedores, registro de ventas y cálculo de KPIs en tiempo real.

---

## Estado del proyecto

En desarrollo activo. Funcionalidad core completa y operativa. Pendiente de implementar autenticación JWT y frontend.

---

## Funcionalidades

- CRUD completo de vendedores
- Registro de ventas vinculadas a cada vendedor
- Cálculo de KPIs por vendedor: total facturado, número de ventas y ticket medio
- Ranking de vendedores ordenado por facturación
- Filtros de ventas por periodo: hoy, semana en curso y mes en curso
- Documentación automática de la API con Swagger

---

## Stack tecnológico

| Categoría | Tecnología |
|---|---|
| Lenguaje | Java 17 |
| Framework | Spring Boot 3.5 |
| Persistencia | Spring Data JPA / Hibernate |
| Base de datos | PostgreSQL |
| Seguridad | Spring Security |
| Documentación | Springdoc OpenAPI (Swagger UI) |
| Build | Maven |

---

## Estructura del proyecto

```
src/main/java/com/jaime/salestracker/
├── controller/      # Endpoints REST
├── service/         # Lógica de negocio
├── repository/      # Acceso a datos
├── model/           # Entidades JPA
├── dto/             # Objetos de transferencia de datos
└── security/        # Configuración de seguridad
```

---

## Endpoints principales

```
GET    /api/vendedores              Listado de vendedores
POST   /api/vendedores              Crear vendedor
PUT    /api/vendedores/{id}         Actualizar vendedor
DELETE /api/vendedores/{id}         Desactivar vendedor

POST   /api/ventas/vendedor/{id}    Registrar venta
GET    /api/ventas/kpis/{id}        KPIs de un vendedor
GET    /api/ventas/ranking          Ranking general
GET    /api/ventas/hoy              Ventas de hoy
GET    /api/ventas/semana           Ventas de esta semana
GET    /api/ventas/mes              Ventas de este mes
```

La documentación completa está disponible en `/swagger-ui/index.html` con el servidor en marcha.

---

## Configuración

Copia `application.properties.example` como `application.properties` y rellena tus datos:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/salestracker
spring.datasource.username=postgres
spring.datasource.password=TU_CONTRASEÑA
```

Crea la base de datos en PostgreSQL:

```sql
CREATE DATABASE salestracker;
```

Arranca el servidor:

```
mvn spring-boot:run
```

---

## Próximos pasos

- Autenticación y autorización con JWT y roles (ADMIN / VENDEDOR)
- Frontend para visualización de KPIs y ranking
- Despliegue en Railway

---

## Autor

**Jaime Fontán García**
[LinkedIn](https://www.linkedin.com/in/jaimefontang/) · [GitHub](https://github.com/Jaimefontang)
