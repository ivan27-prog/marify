# 🚀 proyecto "Marify" - Guía de Aprendizaje

## 🎯 ¿Cuál es el objetivo del proyecto?

**Marify** es una API REST (Backend) desarrollada en **Java 21** con el framework **Spring Boot 4**. Sirve como un catálogo para gestionar **Artistas Musicales** guardados en una base de datos **MySQL** (`marifych71`).

Permite realizar operaciones **CRUD**:
- **Create** (Crear artista con `POST`)
- **Read** (Leer/Consultar artistas con `GET`)
- **Update** (Actualizar artista con `PUT`)
- **Delete** (Eliminar artista con `DELETE`)

---

## 🗺️ Mapa de Arquitectura (¿Cómo fluye la información?)

Cuando un cliente (Postman o una app Frontend) hace una petición, la información viaja en este orden:

```text
  🌐 Cliente (Postman / App Web)
             │
             ▼ 1. Envía JSON (petición HTTP)
   [ ArtistController ] ──────► 2. Valida datos con [ ArtistRequest (DTO) ]
             │
             ▼ 3. Aplica lógica de negocio
      [ ArtistService ]  ──────► (Si falla, dispara [ ResourceNotFoundException ])
             │                                              │
             │                                              ▼
             │                              [ GlobalExceptionHandler ] (Devuelve 404)
             ▼ 4. Consulta / Guarda
    [ ArtistRepository ]
             │
             ▼ 5. Mapea la tabla
      [ Artist (Entity) ]
             │
             ▼ 6. Persiste en la BD
      💾 Base de Datos MySQL
