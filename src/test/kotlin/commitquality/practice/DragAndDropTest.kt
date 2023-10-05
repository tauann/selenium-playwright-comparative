package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions

class DragAndDropTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-drag-and-drop")
    }

    @Disabled("testDragAndDropElements Selenium fails to perform the action")
    @Test
    fun testDragAndDropElements() {
        Actions(driver).dragAndDrop(
            driver.findElement(By.cssSelector("[data-testid=small-box]")),
            driver.findElement(By.cssSelector("[data-testid=large-box]"))
        ).perform()
        assertEquals("Success!", driver.findElement(By.cssSelector("[data-testid=large-box]")).text)
    }
}