# Web-profile-app-back
Apliacion para registar usuarios

## Descripción

La aplicación desarrollada en Spring boot para crear un CRUD conectado a una base de datos de MYQSL, en este podra hacer peticiones http de manera simple y se ejecuta por medio de un contenedor.

## Requisitos
- Docker y Docker-compose instalado (Docker desktop tambien funciona)
- Git instalado

## Instalación y Uso

1. **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/Juanpabloxv/web-profile-app-back.git

    luego de tener clonado el repositorio ingresar a la ruta donde se clono 
    cd ..\GitHub\web-profile-app-back
    ```
2. **Levantar la Aplicación con Docker:**
    Para esto primero es importante tener docker instalado y corriendo,
    luego:
    ```bash
    docker-compose up -d
    ```
    Importante: correr este comando donde se encuentra la carpeta "docker-compose.yml"

3.  **Acceder a la Aplicación:**
    - Pricipalmente deberas ejecutar el front con "ng serve"

    - Una vez se corra el back end con el contenedor y front puedes ingresar al navegador y usar la app

    - Abre tu navegador web y visita [http://localhost:4200](http://localhost:4200)

4. **Detener la Aplicación:**
    ```bash
    docker-compose down
    ```
    Importante: correr este comando donde se encuentra la carpeta "docker-compose.yml"

## Contribuciones
- Siéntete libre de contribuir o informar problemas (issues) en el [repositorio de GitHub](https://github.com/Juanpabloxv/web-profile-app-back.git).

## Licencia
Creado por: Juan Pablo Herrera Herrera