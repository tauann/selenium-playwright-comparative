package commitquality.practice

import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContactUsFormTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-contact-form")
    }

    @Test
    fun testSuccessfulSubmitForm() {
        page.locator("[data-testid=name]").fill("User Test")
        page.locator("[data-testid=email]").fill("user@test.com")
        page.locator("[data-testid=query-type]").selectOption("Technical")
        page.locator("[data-testid=dob]").fill("2000-01-01")
        page.locator("[data-testid=practice-checkbox]").click()
        page.locator("[data-testid=submit-button]").click()
        assertThat(page.locator(".success-message")).hasText("Thanks for contacting us, we will never respond!")
    }
}