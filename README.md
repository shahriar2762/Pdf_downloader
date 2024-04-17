## Description

The provided code demonstrates how to automate the download of a PDF file from a web page using Selenium WebDriver in Java. It includes the following functionalities:

- Opening a web page.
- Clicking on a link to open a PDF file.
- Verifying if the PDF file has been downloaded.

## Requirements

- Java Development Kit (JDK)
- Selenium WebDriver Java bindings
- WebDriver executable (e.g., ChromeDriver for Chrome)

## Usage

1. Clone or download the repository to your local machine.
2. Import the project into your preferred Java IDE.
3. Run the test class (`pdfDownloadTest`) to execute the automated test.

## Files

- `PdfDownloaderPage.java`: Contains the implementation of page interactions using Selenium WebDriver.
- `pdfDownloadTest.java`: Contains the TestNG test class for executing the automated test.
- `config.properties`: Configuration file containing the URL of the web page.
- `README.md`: This file has the information about the project.

## Notes

- Ensure that the WebDriver executable is compatible with the version of the browser installed on your system.
- I used Selenium WebDriver along with JavaScript execution to modify the behavior of the download link. By setting the download attribute of the link, it instructs the browser to download the linked PDF file instead of opening it in the browser.
`String script = "arguments[0].setAttribute('download','');";
        ((JavascriptExecutor)driver).executeScript(script, download_link);`


