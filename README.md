# Taller 04: Sockets TCP, UDP e Hilos en Java

Aplicación cliente-servidor desarrollada en Java para comprender el funcionamiento de los protocolos TCP y UDP, así como el uso de hilos para ejecución concurrente.

El proyecto implementa:

- Cliente UDP
- Servidor UDP
- Cliente TCP
- Servidor TCP
- Ejemplos de ejecución secuencial y concurrente con hilos

Desarrollado como parte del curso de Redes y Comunicación en la Pontificia Universidad Javeriana.



# Objetivos

## Objetivo General

Implementar y analizar una aplicación cliente-servidor en Java usando sockets TCP y UDP, comparando su funcionamiento y comprendiendo el uso de hilos.

## Objetivos Específicos

- Implementar un servidor y un cliente usando UDP.
- Implementar un servidor y un cliente usando TCP.
- Comparar las diferencias principales entre TCP y UDP.
- Comprender el funcionamiento de los hilos en Java.
- Realizar pruebas de envío y recepción de mensajes.
- Documentar y organizar el proyecto para repositorio.

---

# Tecnologías Utilizadas

- Java
- Sockets TCP
- Sockets UDP
- Hilos (`Thread` y `Runnable`)
- Programación Cliente-Servidor

---

# Estructura del Proyecto

```bash
├── udp/
│   ├── ServidorUDP.java
│   └── ClienteUDP.java
│
├── tcp/
│   ├── ServidorTCP.java
│   └── ClienteTCP.java
│
├── hilos/
│   ├── MiHilo.java
│   ├── MiTarea.java
│   └── EjemploConcurrente.java
│
└── README.md
```

---

# Funcionamiento

## UDP

UDP (User Datagram Protocol) permite enviar mensajes sin establecer conexión previa entre cliente y servidor.

### Características

- No orientado a conexión
- Mayor velocidad
- No garantiza entrega ni orden
- Utiliza datagramas

### Puerto utilizado

```text
6000
```

### Flujo

1. El servidor UDP escucha mensajes.
2. El cliente envía mensajes desde teclado.
3. Los mensajes se convierten en bytes.
4. El servidor recibe e imprime el contenido.
5. La comunicación termina al enviar `fin`.

---

## TCP

TCP (Transmission Control Protocol) establece una conexión antes de transmitir datos.

### Características

- Orientado a conexión
- Garantiza entrega y orden
- Mayor confiabilidad
- Comunicación continua entre cliente y servidor

### Puerto utilizado

```text
6001
```

### Flujo

1. El servidor TCP espera conexiones.
2. El cliente se conecta al servidor.
3. Los mensajes se envían mediante flujos de datos.
4. El servidor recibe e imprime cada mensaje.
5. La conexión termina al enviar `fin`.

---

# Diferencias entre TCP y UDP

| Característica | UDP | TCP |
|---|---|---|
| Conexión previa | No | Sí |
| Confiabilidad | No garantizada | Garantizada |
| Orden de mensajes | No garantizado | Garantizado |
| Velocidad | Mayor | Menor |
| Pérdida de paquetes | Posible | Retransmisión automática |
| Clases Java | `DatagramSocket`, `DatagramPacket` | `Socket`, `ServerSocket` |
| Puerto usado | 6000 | 6001 |

---

# Hilos en Java

Los hilos permiten ejecutar tareas concurrentes dentro de una aplicación.

En aplicaciones cliente-servidor son importantes para:

- Atender múltiples clientes simultáneamente
- Evitar bloqueos
- Mejorar el rendimiento

## Implementación con `Thread`

```java
public class MiHilo extends Thread {

    @Override
    public void run() {
        System.out.println("Ejecutando hilo");
    }
}
```

## Implementación con `Runnable`

```java
public class MiTarea implements Runnable {

    @Override
    public void run() {
        System.out.println("Ejecutando tarea con Runnable");
    }
}
```

---

# Resultados de las Pruebas

## Comparativa TCP vs UDP

| Métrica | UDP | TCP |
|---|---|---|
| Mensajes esperados | 10000 | 10000 |
| Mensajes recibidos | 9397 | 10000 |
| Mensajes perdidos | 603 | 0 |
| Fuera de orden | 12 | 0 |
| Tasa de entrega | 94 % | 100 % |
| Tiempo de recepción | 0.2 s | 0.1 s |
| Throughput | 54917.8 msg/s | 163769.6 msg/s |

## Resultados

- TCP entregó todos los mensajes correctamente.
- UDP perdió paquetes y presentó mensajes fuera de orden.
- La integridad de datos fue correcta en ambos protocolos.
- TCP obtuvo mejor throughput en la prueba realizada.

---

# Ejecución Secuencial vs Concurrente

| Tipo de ejecución | Tiempo total |
|---|---|
| Secuencial | 26 segundos |
| Concurrente con hilos | 15 segundos |

La ejecución concurrente demostró una reducción importante en el tiempo total gracias al uso de hilos.

---

# Ejecución del Proyecto

## Compilar

```bash
javac *.java
```

## Ejecutar Servidor UDP

```bash
java ServidorUDP
```

## Ejecutar Cliente UDP

```bash
java ClienteUDP localhost
```

## Ejecutar Servidor TCP

```bash
java ServidorTCP
```

## Ejecutar Cliente TCP

```bash
java ClienteTCP localhost
```

---

# Observaciones

- UDP es más simple y rápido, pero no garantiza confiabilidad.
- TCP garantiza entrega y orden de mensajes.
- Los hilos permiten aprovechar mejor el tiempo de ejecución.
- Runnable ofrece mayor flexibilidad que extender Thread.
- La palabra `fin` se utilizó para finalizar la comunicación.

---

# Conclusiones

La implementación permitió comprender el funcionamiento de los sockets en Java usando los protocolos TCP y UDP.

UDP proporciona comunicación rápida y ligera, aunque sin garantías de entrega. TCP, por otro lado, garantiza confiabilidad y orden en la transmisión de datos.

También se evidenció la importancia de los hilos en aplicaciones concurrentes, reduciendo significativamente el tiempo de ejecución frente a una implementación secuencial.

Finalmente, el proyecto permitió fortalecer conceptos de:

- Redes cliente-servidor
- Comunicación mediante sockets
- Protocolos TCP y UDP
- Concurrencia en Java
- Programación multihilo

