### Integración con RabbitMQ

En este proyecto, hemos configurado RabbitMQ para manejar la mensajería entre los diferentes servicios. A continuación, se detallan los pasos principales que hemos seguido:

1. **Configuración de RabbitMQ**: Hemos definido las configuraciones necesarias en el archivo `application.properties` para conectarnos a un servidor RabbitMQ.

2. **Creación de colas, intercambios y enlaces**: Utilizando anotaciones de Spring Boot, hemos creado colas, intercambios y enlaces para dirigir los mensajes correctamente.

3. **Productores y consumidores**: Hemos implementado productores que envían mensajes a RabbitMQ y consumidores que los reciben y procesan.

4. **Manejo de errores**: Se han añadido mecanismos para manejar errores y reintentos en caso de fallos en la entrega de mensajes.

Esta integración permite que los diferentes componentes de la aplicación se comuniquen de manera eficiente y escalable, mejorando la resiliencia y la capacidad de respuesta del sistema.

---

<sub>Cesar </sub>