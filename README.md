# sistema-testing-backend

## Descripción:
Esta plataforma web es diseñada para facilitar la creación, gestión y realización de exámenes por parte de profesores y alumnos. La aplicación se ha desarrollado utilizando Spring Boot y ofrece una serie de características clave para mejorar la experiencia educativa.

## Características Principales:

* Registro de Usuarios:
Profesores y alumnos pueden registrarse en la plataforma, cada uno pertenece a un rol diferente dentro de la aplicacion.

* Creación de Exámenes:
Los profesores tienen permisos adicionales para crear, administrar exámenes y definir la estructura de las preguntas (opción múltiple) y asignar puntajes a cada pregunta.

* Categorias de Exámenes:
El sistema permite registrar a los profesores una categoria especifica para cada cierto tipo de examenes.

* Banco de Preguntas:
La aplicación permite a los profesores mantener un banco de preguntas con una amplia variedad de preguntas predefinidas que pueden reutilizarse en varios exámenes.

* Asignación de Exámenes:
Los profesores pueden asignar exámenes específicos a los alumnos. También pueden publicar y ocultar la realización de los exámenes.

* Realización de Exámenes:
Los alumnos pueden acceder a los exámenes asignados. La aplicación garantiza que los exámenes tengan un orden aleatorio en base a las preguntas creadas por el profesor.

* Seguridad:
Las ApiRest creadas en el sistema cuentan con la tecnologia de Tokens (JWT) para validar el acceso a la informacion a los usuarios correctos.

## Tecnologías Utilizadas:
* Spring Boot.
  * JPA
  * Validation
* Spring Security.
* Jwt
* Java 8.
* Base de datos.
  * Mysql
