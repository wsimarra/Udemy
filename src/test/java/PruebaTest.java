
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;

public class PruebaTest {
    private WebDriver firefoxDriver;

 @Before
 public  void abrirDriver(){
     System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
     // crear opciones de nuestro driver
     FirefoxOptions options=new FirefoxOptions();
     //options.setCapability("marionette",false);
     options.setCapability("marionette", true);
     // nueva instancia de firefox
     firefoxDriver=new FirefoxDriver(options);
     //definir el tiempó de espera
     firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 }

@Test
    public  void hacer_una_busqueda(){

// encontrar chromedriver
        // abrir url
        firefoxDriver.get("https://www.google.com/");
        // ingresar texto en el buscador

        // Presiona tecla  Enter

        firefoxDriver.findElement(By.xpath( "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("el universal");
        firefoxDriver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(Keys.ENTER);

        // hacer clic en en enlace

        firefoxDriver.findElement(By.xpath( "//h3[contains(text(),'El Universal - Cartagena')]")).click();
        ///home

    firefoxDriver.findElement(By.xpath("//header/div[1]/div[1]/div[6]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();

     //sacar el xpath https://coink.com/donde-estamos/
       WebElement letter= firefoxDriver.findElement(By.xpath("//*[@id='titulo-news']/div[4]/div/div/div/p"));

      Assert.assertTrue(letter.getText().contains("Cartagena"));
    // Cerrar ventana, a pagar driver

}

    public  void cerrarDriver()
    {
    firefoxDriver.quit();

    }
    // Cerrar la ventana , pagar driver



}