
# 🔗 Acortador de URLs

Este proyecto es una API REST para acortar URLs. Permite convertir URLs largas en URLs cortas y recuperarlas fácilmente. Utiliza **Spring Boot** para la lógica de negocio y **Swagger** para la documentación de la API.

## 📚 Tabla de Contenidos

- [Características](#características)
- [Tecnologías Usadas](#tecnologías-usadas)
- [Instalación](#instalación)
- [Uso](#uso)
- [Documentación de la API](#documentación-de-la-api)
- [Contribución](#contribución)

## 🌟 Características

- 🔗 **Acortar URL**: Convierte una URL larga en una URL corta única.
- 🔍 **Recuperación de URL**: Obtiene la URL original a partir de la URL acortada.
- 📋 **Persistencia de datos**: Almacena URLs en una base de datos para consultas futuras.
- 📖 **Documentación interactiva**: Documentación de la API generada con Swagger.

## 🛠️ Tecnologías Usadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para construir la API REST.
- **Swagger**: Herramienta para la documentación de la API.
- **JPA**: Para interactuar con la base de datos.

## 📦 Instalación

Sigue estos pasos para instalar y configurar el proyecto en tu máquina local.

```bash
# Clona el repositorio
git clone https://github.com/usuario/acortador-url.git

# Cambia al directorio del proyecto
cd acortador-url

# Ejecuta el proyecto con Maven
mvn spring-boot:run
```

### Configuración de la Base de Datos

Asegúrate de crear la siguiente tabla en tu base de datos antes de ejecutar la aplicación:

```sql
CREATE TABLE urls (
    Id SERIAL PRIMARY KEY,
    longUrl TEXT NOT NULL,
    shortUrl TEXT NOT NULL
);

### Variables de Entorno

Asegúrate de configurar las variables de entorno necesarias, como los detalles de la conexión a la base de datos, en `application.properties`.

## 🚀 Uso

Ejecuta el proyecto y accede a la API en `http://localhost:8080/api`.

### Endpoints

- `POST /api/url/`: Crea una URL corta a partir de una URL larga.
- `GET /api/url/original?shortURL={shortURL}`: Recupera la URL original a partir de la URL corta.
- `GET /api/url/short?originalURL={originalURL}`: Recupera una URL corta a partir de la URL original.

## 📄 Documentación de la API

Accede a la documentación completa y prueba los endpoints en la interfaz de Swagger en `http://localhost:8080/api-urlshortener-meli/swagger-ui/index.html`.

## ✨ Ejemplo de Uso

**1. Acortar una URL**

```
POST /api/url/
Body: "https://kimetsu-no-yaiba.fandom.com/es/wiki/Kyojuro_Rengoku"
```

**Respuesta**:
```json
{
  "shortURL": "http://localhost:8080/meli/0q1s"
}
```

**2. Obtener URL original**

```
GET /api/url/original?shortURL=http://localhost:8080/meli/0q1s
```

**Respuesta**:
```json
{
  "longURL": "https://kimetsu-no-yaiba.fandom.com/es/wiki/Kyojuro_Rengoku"
}
```

## 🤝 Contribución

¡Las contribuciones son bienvenidas! Si deseas contribuir, realiza un fork del repositorio y abre un pull request con tus mejoras.

