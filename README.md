# PROYECTO MAVEN
## JPA_EJERCICIOS
Ejercicio JPA conexión a una base de datos local de prueba. Los setters y getter de las clases lo he llevado a cabo con una dependencia llamada **[LOMBOK](https://projectlombok.org/setup/maven)**, para ello no solo basta con la dependecia que viene dentro del siguiente proyecto en el archivo **POM**, si no que tenemos que descargarnos el siguiente programa **[Lombok Software](https://projectlombok.org/download).**

La JDK de java utilizada es la 1.8, la cual podemos cambiar en cualquier momento accediendo al archivo **POM**

 1. Tener instalado MYSQL WORKBENCH
 2. Tener instalado un IDE (Interface Development Enviroment) para la gestión del repositorio.
 3. Una vez instalado WORKBENCH, crear la base de datos *beca* y proceder a la creación de la tabla *Alumnos*:

    USE beca;
    CREATE TABLE alumnos( ID INT NOT NULL auto_increment, DNI VARCHAR(9),APELLIDOS VARCHAR(50),    PRIMARY KEY(ID) );
    
**

## PD: Recordar que esto es una prueba la primary key de la tabla alumnos deberia de haber sido DNI, pero para este ejercicio como era para probar las funciones de JPA, no se ha tenido en cuenta eso.

**
