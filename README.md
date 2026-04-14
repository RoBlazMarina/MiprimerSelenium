🧪 Automatización de Login con Selenium y JUnit 5
Este proyecto forma parte de un ejercicio práctico cuyo objetivo es aprender a:

Automatizar acciones en una página web

Interactuar con elementos HTML

Escribir pruebas automáticas con JUnit 5

Verificar el funcionamiento de una funcionalidad real

Aplicar el patrón Page Object Model (POM)

La web utilizada para las pruebas es:

👉 https://www.saucedemo.com/

📁 Estructura del proyecto

MIPRIMERSELENIUM/
 ├── src/
 │   └── test/java/
 │       ├── pages/
 │       │   └── LoginPage.java
 │       └── test/
 │           └── LoginTest.java
 ├── target/
 ├── pom.xml
 └── .gitignore

⚙️ Dependencias (pom.xml)
El proyecto utiliza:

Selenium 4.42.0

WebDriverManager 6.1.0

JUnit 5.10.1

Java 22

🧩 Parte 1 — Clase LoginPage
Se completaron los métodos para interactuar con la página de login:

   -Escribir usuario

   -Escribir contraseña

   -Pulsar el botón de login

<img width="1131" height="774" alt="image" src="https://github.com/user-attachments/assets/6201cbdc-8f63-4e31-8b93-a0b07a5923d1" />

   
   -Verificar errores y obtener título y URL

<img width="695" height="458" alt="image" src="https://github.com/user-attachments/assets/6e2034ce-746a-4237-8c67-4ee315ec0d50" />


🧪 Parte 2 — Test de login correcto
Se completó el test verificando que:

   -Se introduce usuario válido

   -Se introduce contraseña válida

   -Se pulsa login
   
   -La URL contiene "inventory"

<img width="1850" height="540" alt="Captura de pantalla 2026-04-14 211056" src="https://github.com/user-attachments/assets/90379ece-deb0-4c93-97ed-9909d5006dc6" />


❌ Parte 3 — Test de login incorrecto
Se creó un test que:

   -Introduce contraseña incorrecta

   -Comprueba que aparece un mensaje de error

   -Verifica el texto del error

   <img width="1556" height="514" alt="image" src="https://github.com/user-attachments/assets/a04b6cb2-790f-4033-9105-32c517c9b506" />


⏱️ Parte 4 — Pausas
Se añadieron pausas con Thread.sleep() para observar la ejecución.
Los métodos incluyen throws InterruptedException.
<img width="726" height="282" alt="image" src="https://github.com/user-attachments/assets/b1a8f900-b90b-4e8d-9502-4b7954c5f1a6" />


🧹 Parte 5 — Mejora del diseño. Método Login.
Este método agrupa los pasos del login y simplifica los tests.
Los métodos originales se mantienen para mostrar el desarrollo paso a paso.

<img width="575" height="130" alt="image" src="https://github.com/user-attachments/assets/bf4d3951-fcd0-4a58-b552-a4e30e0432dc" />
<img width="1078" height="490" alt="image" src="https://github.com/user-attachments/assets/3fb3cfc1-b658-462b-b2fd-d48dca87754a" />


 Cuestiones teóricas
     ¿Qué hace la anotación @BeforeEach?
        Ejecuta un método antes de cada test, preparando el entorno (abrir navegador, cargar la web, crear objetos)
        El @AfterEach por su parte, se ejecuta posteriormente asegurando que el navegador se cierre.
     ¿Para qué sirve assertTrue?
        Comprueba que una condición es verdadera. Si no lo es, el test falla.
     Diferencia entre findElement() y findElements()
       findElement() devuelve un solo elemento y, si no lo encuentra, lanza una excepción.
       findElements() por su parte devuelve una lista de elementos y si no la encuentran da una lista vacía.
    ¿Por qué usamos una clase LoginPage?
       Porque aplicamos el patrón Page Object Model, que:
            -Separa la lógica de la página del test
            -Hace el código más limpio
            -Facilita el mantenimiento (pues permite una modificación rápida y efectiva)
            -Evita duplicación de código
