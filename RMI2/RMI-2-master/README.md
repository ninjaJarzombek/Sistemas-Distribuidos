# Java RMI Sesión 2
>Java RMI (Remote Method Invocation), es una tecnología desarrollada por Java para invocar métodos remotos. Proporciona un mecanismo simple para la comunicación de servidores y clientes en aplicaciones distribuidas basadas en Java.
>La construcción de una aplicación distribuída con RMI incluye:  
1. Serialización (**Marshalling**) de parámetros y objetos en Java en el cliente para enviar al servidor.
2. Invocación desde el cliente, del **Método Remoto**  (RMI)  a ejecutar en el servidor.
3. Serialización (**Marshalling**) en el servidor para enviar respuesta al **Cliente**.
4. Recepción de la respuesta por parte del **Cliente** y ejecución local.  

La segunda sesión de RMI consiste en comprender mejor el Marshalling (Serialización de objetos) con RMI, **es muy importante** haber concluído la primera actividad antes de continuar.

# Contenido
- **[Antes de comenzar](#antesde)**
- [Herramientas sugeridas](#herramientas)
- [Instalación en Eclipse](#instalacion)
- **[Actividad 1 - Análisis](#analisis)**
- **[Actividad 2 - Desarrollo](#desarrollo)**
- **[Actividad 3 - Limpieza](#limpieza)**
- **[Actividad 4 - Preguntas](#preguntas)**

#### <a name="herramientas"></a>Herramientas sugeridas:
- Eclipse
- Java 1.6 ó superior.
- Conocimientos intermedios de Programación Orientada a Objetos.

#### <a name="instalacion"></a>Instalación en Eclipse:
1. Clonar el repositorio.
2. Crear en Eclipse crear nuevos proyectos sobre los proyectos clonados del repositorio, de preferencia con el mismo nombre.
- Client
- Interface
- Server  
3. Agregar el Path: Sobre el proyecto **Server** hacer click derecho y seleccionar "**Build Path > Configure Build Path**", en "**Projects**" seleccionamos agregar y escogemos el proyecto "Interface".

# <a name="analisis"></a>Actividad 1 - Análisis  

El presente repositorio contiene un proyecto que **simula la administración de la pista aérea de un Aeropuerto por una torre de control**. Los aviones, ó autos de servicio (**Clientes**) se suscriben a la torre de control (**Servidor**) que contiene un mapa de pista **[Matriz 4x8 Objetos]** en donde los vehículos se desplazan cada "x" segundos; cada vehículo (aéreo o terrestre) informa a la torre de control hacia a dónde se ha desplazado, la torre de control actualiza su **mapa de pista**, el **cliente interfaz de usuario** imprime cada segundo el **mapa aéreo** en la consola.

- Ejecutar **Server**: Click derecho sobre el proyecto, "**Run As** > **Java Application**".
- Ejecutar **Client**: Click derecho sobre el proyecto, "**Run As** > **Java Application**".
- Analizar el diagrama que muestra la arquitectura de la aplicación distribuída:
<img src="http://www.innova4d.mx/wp-content/uploads/2015/02/classRMI2.png" width="75%" height="75%"/>

- Observar el comportamiento de la aplicación.
- Analizar la clase **RemoteInterface.java** y **ControlTower.java**.
- Analizar las clases **Avion.java** y **Auto.java**
- Explicar en el **reporte** la funcionalidad de la interfaz y cómo se implementa en el servidor.
- Explicar en el **reporte** el método **moverAvion(Avion a, int c)** que se encuentra en **ControlTower.java**
- Analizar el Cliente **ClientLauncher.java**.
- Explicar la funcionalidad del método **main**.
- Explicar los métodos **guiClient()** y **avionClient()**.

Nota: Inicialmente en la consola debería imprimirse un resultado de la siguiente forma:
<img src="http://www.innova4d.mx/wp-content/uploads/2015/02/rmi21.png" width="50%" height="50%"/>


# <a name="desarrollo"></a>Actividad 2 - Desarrollo

En ésta actividad deberás modificar el **workspace** en Eclipse que se te ha entregado. Como habrás analizado las clases **Avion** y **Auto** son objetos que se agregan a una **matriz 4x8** que repesenta una pista aérea, los métodos en el **servidor** permiten informar el desplazamiento de estos vehículos en la **matriz**. Los objetos son creados en el **cliente** y envíados al **servidor** en donde se actualiza su ubiación. El objetivo de ésta actividad es **definir** e **implementar** la lógica de dos nuevos objetos en el **servidor**, que se crearán, enviarán y controlarán desde el **Cliente**.


- Implementar 2 nuevas clases de vehículos (e.g, UFO, Boeing), para agregarlos a la pista (Matriz 4x8).
- Implementar los **2 nuevos objetos** en los **2 últimos carriles** disponibles de la matriz.
- Implementar en el servidor la lógica necesaria para las nuevas clases.
- Implementar en el cliente los vehículos, deben ejecutarse en su propio hilo cada "x" segundos.
- Documentar las nuevas clases agregadas y los nuevos métodos implementados.
- Utilizar las guías de JavaDocs.
- Es importante analizar el código, revisar atentamente el diagrama de clases podría ser útil.

Nota: La consola debería imprimir algo así:

<img src="http://www.innova4d.mx/wp-content/uploads/2015/02/rmi2.png" width="50%" height="50%"/>

# <a name="limpieza"></a>Actividad 3 - Limpieza

Ahora deberás limpiar el código, permitirá comprender de mejor manera la estructura del RMI.

- Identifica las clases **Client** y **Server**.
- Agrega la documentación a las clases con tu **nombre**, **correo** y **ID**.
- Agrega la documentación a las **variables** y **métodos** de cada **Interfaz/Clase**.
Nota:  La documentación debe ser siguiendo las guías de [Javadocs](http://en.wikipedia.org/wiki/Javadoc)

# <a name="preguntas"></a>Actividad 4 - Preguntas

En el reporte de ésta práctica, además de mostrar y explicar el desarrollo de las activiadaes deberás responder a las siguientes preguntas:

- ¿Cómo se definen nuevas clases para usarlas con **Server**?
- ¿Cuáles son los pasos necesarios para crear una nueva clase y utilizar el objeto en el Servidor?
- ¿Cuál es la utilidad de **Interface**?
- ¿Cuál es la utilidad de **Constant.java**?
- ¿Cómo se manejan los errores en el Servidor?
- ¿Cuál es la utilidad de la clase **RemoteException**?
- ¿Por qué es necesario utilizar **Serializable** en las nuevas clases?
- Dada la comunicación entre **Client** y **Server**
  - ¿Por qué es necesario que el método avionClient() y los objetos **RemoteInterface** y **Avion** sean de tipo **final**?
- ¿Por qué es necesario un método **getAvion(String id, int c)**?
- ¿Cómo se manejan los errores en el Cliente?
- ¿Qué significa y cuál es la utilidad de **NotBoundException**?

Notas:
- Explica ampliamente y justifica tus respuestas.
- La documentación debe ser siguiendo las guías de [Javadocs](http://en.wikipedia.org/wiki/Javadoc)


**Cualquier comentario o duda, discutir en la sección de [issues](https://github.com/Innova4DLab/RMI-2/issues).**
