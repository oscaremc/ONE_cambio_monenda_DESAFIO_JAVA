# Convertidor de Moneda

## Descripción

Este proyecto es un convertidor de moneda desarrollado en Java. Participando en el proyecto de enseñanza con Oracle y Alura, fui retado a crear este convertidor utilizando los conocimientos adquiridos a través de la plataforma Alura de forma interactiva. El objetivo de este proyecto es demostrar habilidades en programación Java, manejo de APIs externas y procesamiento de datos.

## Características

- Convierte montos entre diferentes monedas utilizando la API de ExchangeRate-API.
- Solicita las monedas de origen y destino, así como el monto a convertir desde la consola.
- Valida que el monto ingresado sea un número positivo.

## Requisitos

- Java 11 o superior
- Gson (Google's JSON library) para deserializar la respuesta de la API

## Instalación

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tuusuario/convertidor-moneda.git

2. Navega al directorio del proyecto:
   ```bash
   cd convertidor-moneda

3. Asegúrate de tener configurado tu entorno Java correctamente.

   1. Compila el proyecto:
      ```bash
      javac -cp .:gson-2.8.6.jar Principal.java
      
   2. java -cp .:gson-2.8.6.jar Principal:
      ```bash
      java -cp .:gson-2.8.6.jar Principal


## Uso
Al ejecutar el programa, se te pedirá que ingreses la moneda de origen, la moneda de destino y el monto a convertir. Por ejemplo:

   ```bash
   Ingrese la moneda de origen: USD
   Ingrese la moneda de destino: EUR
   Ingrese el monto a convertir: 100
