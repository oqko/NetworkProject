
import com.opencsv.CSVReader;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.FileReader;
import java.io.Reader;
import java.time.Duration;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Network_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Network sayfasına git
        driver.get("https://www.network.com.tr");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Network sayfasının geldiği kontrol edilir
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        // Cookies kabul edildi
        WebElement cookiePass = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiePass.click();
        //Arama space bar bulundu ve tıklandı
        WebElement spacebox = driver.findElement(By.xpath("//input[@id='search']"));
        spacebox.click();
        //ceket yazıldı
        spacebox.sendKeys("ceket");
        spacebox.submit();
        // ürün listeleme sayfası açıldı
        String pageCeket = driver.getCurrentUrl();

        //Daha fazla gözter butonuna tıklandı ve sayfa kontolu yapıldı
        WebElement stopScroll = driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(stopScroll);
        actions.perform();

        stopScroll.click();
        String pageTwo = driver.getCurrentUrl();
        Thread.sleep(100);
        //Assertions.assertTrue(Boolean.parseBoolean(pageTwo),pageCeket);

        //Hover ve ürün seçimi yapıldı
        driver.get(pageCeket);
        WebElement firstProduct = driver.findElement(By.xpath("//h3 [@class='product__title']"));
        actions.moveToElement(firstProduct);
        WebElement sizeMenu = driver.findElement(By.xpath("//label[@extcode='1081891006']"));

        actions.moveToElement(sizeMenu);
        actions.click().build().perform();

        // sepete Ekleme yapıldı
        WebElement goToCart = driver.findElement(By.xpath("//a[text()='Sepete Git']"));
        goToCart.click();

        //fiyat ve beden karşılaştırması
        //WebElement oldPrice = driver.findElement(By.xpath("//span [@class='cartItem__price -old -labelPrice']"));
        //WebElement newPrice = driver.findElement(By.xpath("//span [@class='cartItem__price -sale']"));

        //Devam et butonuna tıkla

        WebElement devamEt=driver.findElement(By.xpath("//button [@class='continueButton n-button large block text-center -primary'] "));
        devamEt.click();

        //Kullanıcı bilgileri CSV formatından çekilerek doldurulur
        //CSVReader csvReader=new CSVReader(Reader.nullReader());

        //Network Logosuna Tıklanır
       WebElement logo =driver.findElement(By.xpath("//a[@class='headerCheckout__logo']"));
        logo.click();
        //Ana sayfadaki çanta logosuna tıklanır
        WebElement cartRemoveButton=driver.findElement(By.xpath("//a [@class='header__basketMobile']"));
        cartRemoveButton.click();

    }


    }



