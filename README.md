# Proyecto prueba Spring Boot

Prueba técnica para desarrollador backend

Se realiza prueba java spring boot donde se crea un crud para usuarios y tareas 
en el cual usuarios maneja toda lógica de dicha api, ya que un usuario puede
crear muchas tareas. Separo por paquetes cada una de las capas teniendo un mejor orden
y organización. Efectúo validaciones de posibles excepciones que pueda tener la aplicación controlándolas y enviando su mensaje al usuario. 
Por la parte del filtro se crea un controller para tareas y así poder filtrar una tarea 
por criterios (fecha ini,fecha fina, idUser) donde la consulta persiste las tareas con el idUsuario


## Pre-requisitos

1. Tener instalado GIT en su computadora
2. Contar con Java JDK 8 como minimo
3. Soportar H2

## Instalación

Para obtener una copia de este proyecto ejecute el siguiente comando.

```bash
git clone https://github.com/oscarospinag/prueba-backend.git
```
___
# Uso

Lo primero que debes conocer es el uso del archivo __application.yml__, el cual es usado para las configuraciones mas relevantes del proyecto.

> Ubicación del archivo: \src\main\resources\application.yml

## Sección Server

En esta sección podras ver la configuración del servidor, donde se le indica el puerto de salida __```port: 8081```__, al iniciar la aplicacion podra acceder a ella desde su navegador ingresando a la url __http://localhost:8080__ .

```yaml
server:
	port: 8081
```

### 1. Swagger

Para acceder a swagger desde el navegador debera ingresar al link (http://localhost:8081/swagger-ui/index.html) o a la url creada en el servidor donde es ejecutado el proyecto y deberas ver algo parecido a la siguiente imagen.

---
## Autor


* ***Oscar Ospina***


