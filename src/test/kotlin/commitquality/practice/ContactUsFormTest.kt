package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select

class ContactUsFormTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-contact-form")
    }

    @Test
    fun testSuccessfulSubmitForm() {
        driver.findElement(By.cssSelector("[data-testid=name]")).sendKeys("User Test")
        driver.findElement(By.cssSelector("[data-testid=email]")).sendKeys("user@test.com")
        Select(driver.findElement(By.cssSelector("[data-testid=query-type]"))).selectByVisibleText("Technical")
        driver.findElement(By.cssSelector("[data-testid=dob]")).sendKeys("01/01/2000")
        driver.findElement(By.cssSelector("[data-testid=practice-checkbox]")).click()
        driver.findElement(By.cssSelector("[data-testid=submit-button]")).click()
        assertEquals(
            "Thanks for contacting us, we will never respond!",
            driver.findElement(By.cssSelector(".success-message")).text
        )
    }
}