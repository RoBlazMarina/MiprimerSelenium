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

    -Verificar errores

    -Obtener título y URL


🧪 Parte 2 — Test de login correcto
Se completó el test verificando que:

    -Se introduce usuario válido

    -Se introduce contraseña válida

    -Se pulsa login

    -La URL contiene "inventory"



❌ Parte 3 — Test de login incorrecto
Se creó un test que:

Introduce contraseña incorrecta

Comprueba que aparece un mensaje de error

Verifica el texto del error

⏱️ Parte 4 — Pausas
Se añadieron pausas con Thread.sleep() para observar la ejecución.
Los métodos incluyen throws InterruptedException.

🧹 Parte 5 — Mejora del diseño. Método Login.
Este método agrupa los pasos del login y simplifica los tests.
Los métodos originales se mantienen para mostrar el desarrollo paso a paso.


❓ Cuestiones teóricas
        ¿Qué hace la anotación @BeforeEach?
            Ejecuta un método antes de cada test, preparando el entorno (abrir navegador, cargar la web, crear objetos).
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
