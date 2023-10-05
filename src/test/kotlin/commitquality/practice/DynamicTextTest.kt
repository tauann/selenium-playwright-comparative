package commitquality.practice

import com.microsoft.playwright.assertions.LocatorAssertions.HasTextOptions
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DynamicTextTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-dyanmic-text")
    }

    @Test
    fun testWaitButtonChangeItsText() {
        page.locator("[data-testid=dynamic-button1]").click()
        assertThat(page.locator("[data-testid=dynamic-button1]")).hasText("loading")
        assertThat(page.locator("[data-testid=dynamic-button1]")).hasText(
            "I am visible after 5 seconds",
            HasTextOptions().apply { timeout = 10000.0 })
    }
}