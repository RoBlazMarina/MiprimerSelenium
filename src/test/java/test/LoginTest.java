package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

        private WebDriver driver;
        private LoginPage loginPage;

        // Abre el navegador
        @BeforeEach
        void setUp() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();

                driver.get("https://www.saucedemo.com/");

                loginPage = new LoginPage(driver);
                
        }

        // Cierra el navegador
        @AfterEach
        void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }

        // Test de login correcto
        @Test
        void loginCorrecto() throws InterruptedException {

                // Primero introducimos usuario válido
                loginPage.ingresarUsuario("standard_user");
                // Añadimos pausas entre acciones, razón por la cual ponemos un throw
                Thread.sleep(2000);

                // Contraseña válida
                loginPage.ingresarContrasena("secret_sauce");
                Thread.sleep(2000);

                // Pulsar login
                loginPage.clickLogin();
                Thread.sleep(2000);

                        //Para que no salga una advertencia creamos este string del cual partirá el assert que antes del login verifica que la URL no sea nula.
                String urlActual = driver.getCurrentUrl();
                                
                        assertNotNull(urlActual, "La URL no debería ser nula");
                        assertTrue(urlActual.contains("inventory"),
                                "El usuario debería entrar a la página de inventario tras un login correcto");

        }

        @Test
        void loginIncorrecto() throws InterruptedException {
                // Primero introducimos usuario válido
                loginPage.ingresarUsuario("standard_user");
                // Añadimos pausas entre acciones, razón por la cual ponemos un throw
                Thread.sleep(2000);

                // Contraseña inválida
                loginPage.ingresarContrasena("malcontrasena");
                Thread.sleep(2000);

                // Pulsar login
                loginPage.clickLogin();
                Thread.sleep(2000);

                // Verifica el error
                assertTrue(loginPage.errorVisible(),
                                "Debería mostrarse un mensaje de error al fallar el login");

                assertTrue(loginPage.obtenerTextoError().contains("Username and password do not match"),
                                "El mensaje de error no es el esperado");
        }

        @Test
void loginCorrecto2() throws InterruptedException {

        // Usamos el método simplificado
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);

        String urlActual = driver.getCurrentUrl();
                assertNotNull(urlActual);
                assertTrue(urlActual.contains("inventory"));
}

@Test
void loginIncorrecto2() throws InterruptedException {

        loginPage.login("standard_user", "malcontrasena");
        Thread.sleep(2000);

        assertTrue(loginPage.errorVisible());
        assertTrue(loginPage.obtenerTextoError().contains("Username and password do not match"));
}


}