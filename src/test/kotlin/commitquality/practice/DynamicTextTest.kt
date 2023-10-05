package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions.not
import org.openqa.selenium.support.ui.ExpectedConditions.textToBe
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class DynamicTextTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-dyanmic-text")
    }

    @Test
    fun testWaitButtonChangeItsText() {
        val elementBy = By.cssSelector("[data-testid=dynamic-button1]")
        driver.findElement(elementBy).click()
        assertEquals("loading", driver.findElement(elementBy).text)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(not(textToBe(elementBy, "loading")))
        assertEquals(
            "I am visible after 5 seconds", driver.findElement(elementBy).text
        )
    }
}