# Proyecto: ChatBot con Java Swing y API de Ollama

Este proyecto es parte del curso de **Algoritmia y Programación II** y tiene como objetivo crear un chatbot interactivo utilizando Java Swing para la interfaz gráfica y conectarse a la API de Ollama para generar respuestas automatizadas.

## Características Principales

- **Interfaz de Usuario (UI)**: Desarrollada con Java Swing, la interfaz permite al usuario interactuar con el chatbot mediante una ventana de diálogo, con opciones para enviar preguntas, limpiar el chat y ver el historial de conversaciones.
- **Conexión con API de Ollama**: El chatbot se conecta a la API de Ollama mediante solicitudes HTTP para obtener respuestas basadas en las preguntas del usuario.
- **Historial de Conversaciones**: Se implementa un sistema de historial que permite al usuario revisar las interacciones anteriores con el chatbot.
- **Manejo de Errores**: El sistema maneja errores comunes como fallos en la conexión a la API o tiempos de respuesta excesivos, proporcionando mensajes claros al usuario.

## Requerimientos

- **Java 8 o superior**.
- **Conexión a internet** para el acceso a la API de Ollama.
- Dependencias de Java para manejar las solicitudes HTTP:
  - Puedes utilizar `HttpURLConnection` o `HttpClient`.

## Instalación

1. **Clonar el repositorio**:

    ```bash
    git clone https://github.com/usuario/proyecto-chatbot-java.git
    ```

2. **Compilar y ejecutar** el proyecto:
    - Abre el proyecto en tu IDE favorito (Eclipse, IntelliJ, NetBeans, etc.).
    - Asegúrate de que las dependencias necesarias para manejar solicitudes HTTP estén correctamente incluidas.
    - Ejecuta la clase principal del proyecto para iniciar la aplicación.

## Uso

1. **Enviar preguntas**: Introduce tu pregunta en el campo de texto y presiona el botón "Enviar".
2. **Limpiar chat**: Para reiniciar la conversación, utiliza el botón "Limpiar Chat".
3. **Ver historial**: Si deseas revisar las conversaciones anteriores, utiliza el botón "Ver Historial".

## Estructura del Proyecto

El proyecto sigue las mejores prácticas en cuanto a la separación de lógica en métodos y el manejo adecuado de errores:

- **Enviar pregunta**: `enviarPregunta()`
- **Recibir respuesta**: `recibirRespuesta()`
- **Manejo de historial**: `manejarHistorial()`
- **Manejo de errores**: `manejarErrores()`

El historial de conversación se almacena en un **arreglo**, permitiendo la revisión y el almacenamiento de interacciones previas. Opcionalmente, se puede guardar el historial en archivos.

## Colaboración

Este proyecto está gestionado en **GitHub** para fomentar la colaboración entre los miembros del equipo. El flujo de trabajo es el siguiente:

1. Cada colaborador trabaja en su **rama**.
2. Se envían **pull requests** con una descripción clara de los cambios realizados.
3. Se realizan revisiones de código antes de fusionar cambios en la rama principal.

### Contribuir

1. **Fork** este repositorio.
2. Crea una **rama** para tu contribución:

   ```bash
   git checkout -b nombre-rama
   ```

3. Haz commit de tus cambios:

   ```bash
   git commit -m "Descripción de los cambios"
   ```

4. Envía tus cambios:

   ```bash
   git push origin nombre-rama
   ```

5. Abre un **pull request**.

## Manual de Usuario

Para más detalles sobre cómo utilizar el chatbot, consulta el [Manual de Usuario](docs/manual_usuario.md), donde se describe cada sección de la interfaz, cómo funciona la API, cómo manejar el historial, y cómo resolver errores comunes.

## Evaluación

El proyecto será evaluado de acuerdo a los siguientes criterios:

- **Interfaz gráfica** (20%).
- **Conexión con la API** (20%).
- **Uso adecuado de procedimientos y manejo del historial** (20%).
- **Manejo de errores** (10%).
- **Colaboración en GitHub** (20%).
- **Documentación** (10%).

## Licencia

Este proyecto es de uso académico y está licenciado bajo los términos del curso de **Algoritmia y Programación II**.

---

Este README proporciona una guía clara sobre cómo instalar, usar, colaborar y comprender el proyecto. También incluye instrucciones para la colaboración con GitHub y un esquema de evaluación para el proyecto.
