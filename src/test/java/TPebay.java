import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TPebay {
    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.fr/");
        driver.manage().window().maximize();

      //  By cookiesSelector = By.name("accept");
        // driver.findElement(cookiesSelector).click();
    }

    @AfterMethod
    public void fermerChrome() {
        driver.quit();
    }

    @Test
    public void testEbay() {
        // Arrange

        String resultatAttendu = "1";


        // Act
        By ExplorerParCatButtonSelector = By.id("gh-shop-a");
        driver.findElement(ExplorerParCatButtonSelector).click();

        By sportVacancesSelector = By.cssSelector(".scnd[_sp='m570.l3778']");
        driver.findElement(sportVacancesSelector).click();


        String xpathImage = "//*[@id=\"s0-27_3-9-0-1[0]-0-1\"]/ul/li[1]/div/div[2]/a/h3";
        WebElement imageMaillot = driver.findElement(By.xpath(xpathImage));
        imageMaillot.click();

        By nomArticleSelector = By.id("itemTitle");
        String nomArticleLabel = driver.findElement(nomArticleSelector).getText();

        By ajouterPanierButtonSelector = By.cssSelector("[_sp='p2047675.l1473']");
        driver.findElement(ajouterPanierButtonSelector).click();

        // Asserts

        By titre1ObjectSelector = By.cssSelector(".main-title");
        String titre1ObjectLabel = driver.findElement(titre1ObjectSelector).getText();

        By nomArticlePanierSelector = By.cssSelector(".BOLD");
        WebElement nomArticlePanierLabel = driver.findElement(nomArticlePanierSelector);



        //String bb = nomArticlePanierLabel.getText();
        Assert.assertTrue(titre1ObjectLabel.contains(resultatAttendu), "Le titre [" + titre1ObjectLabel + "] ne contient pas la chaine [" + resultatAttendu+ "].");
        Assert.assertEquals(nomArticleLabel, nomArticlePanierLabel.getText());
    }
}
