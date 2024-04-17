import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pdf_downloader.PdfDownloaderPage;

import java.util.concurrent.TimeUnit;
//import pdf_downloader.PdfDownloaderPage;

public class pdfDownloadTest {
    private WebDriver driver;
    private pdf_downloader.PdfDownloaderPage pdfDownloaderPage;

    private WebDriverWait wait;


@BeforeClass
public void setup(){

//    System.setProperty("webdriver.chrome.driver", "chromedriver");
    driver = new ChromeDriver();

    pdfDownloaderPage = new PdfDownloaderPage(driver);
}


@Test(description = "Click on the Link and Download the PDF on the Local And verify the downloaded file location.")
public void testPdfDownload() throws InterruptedException {
    pdfDownloaderPage.openUrl();
//    Thread.sleep(2000);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    pdfDownloaderPage.clickPdf();
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


    Thread.sleep(2000);
    boolean isDownload = pdfDownloaderPage.pdfDownloaded("/Users/bs1004/Downloads/Selenium-Cheat-Sheet-2022.pdf");

    Thread.sleep(2000);
    Assert.assertTrue(isDownload, "PDF file download failed.");

}

@AfterClass
public void tearDown() {
    // Close the browser
    driver.quit();
}

}