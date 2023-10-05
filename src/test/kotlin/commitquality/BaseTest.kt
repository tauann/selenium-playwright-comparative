package commitquality

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

open class BaseTest {
    protected lateinit var driver: WebDriver private set

    @BeforeEach
    fun baseBeforeEach() {
        driver = ChromeDriver(ChromeOptions().addArguments("--headless=new"))
    }

    @AfterEach
    fun baseAfterEach() {
        driver.quit()
    }

    companion object {
        const val APP_URL = "https://commitquality.com/"
    }
}