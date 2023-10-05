package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import java.nio.file.Paths

class FileUploadTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-file-upload")
    }

    @Test
    fun testFileUpload() {
        driver.findElement(By.cssSelector("[data-testid=file-input]"))
            .sendKeys("${Paths.get("").toAbsolutePath()}/pom.xml")
        driver.findElement(By.cssSelector(".file-upload button[type=submit]")).click()
        val alert = driver.switchTo().alert()
        assertEquals("File successfully uploaded!", alert.text)
        alert.accept()
    }
}