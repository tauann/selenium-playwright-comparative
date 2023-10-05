package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class IframesTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-iframe")
    }

    @Test
    fun testClickOnElementInsideAnIFrame() {
        assertEquals(("IFrame"), driver.findElement(By.cssSelector("h2")).text)
        val frame = driver.switchTo().frame(driver.findElement(By.cssSelector("[data-testid=iframe]")))
        frame.findElement(By.cssSelector("[data-testid=navbar-addproduct]")).click()
        assertEquals(frame.findElement(By.cssSelector("h1")).text, "Add Product")
        driver.switchTo().defaultContent()
        assertEquals(driver.findElement(By.cssSelector("h2")).text, "IFrame")
    }
}