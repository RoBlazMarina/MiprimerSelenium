package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    //Añadimos el siguiente @ para que el editor no marque como nulos los campos, pues el selenium evita que lo sean.
@SuppressWarnings("null")
public class LoginPage {
    private WebDriver driver;

    // Localizadores
    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acciones
        //Ingreso de usuario.
    public void ingresarUsuario(String user){
        driver.findElement(userField).clear();
        driver.findElement(userField).sendKeys(user);
    }

        //Ingreso contrasena
    public void ingresarContrasena(String pass){
        driver.findElement(passField).clear();
        driver.findElement(passField).sendKeys(pass);

    }


    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass) {
        ingresarUsuario(user);
        ingresarContrasena(pass);
        clickLogin();
    }

    // Verificaciones
    public String obtenerTituloPagina() {
        return driver.getTitle();
    }

    public String obtenerUrlActual() {
        return driver.getCurrentUrl();
    }

    public boolean errorVisible() {
        return !driver.findElements(errorMessage).isEmpty();
    }

    public String obtenerTextoError() {
        if (errorVisible()) {
            return driver.findElement(errorMessage).getText();
        }
        return "";
    }
}