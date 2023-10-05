package commitquality.practice

import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class IframesTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-iframe")
    }

    @Test
    fun testClickOnElementInsideAnIFrame() {
        assertThat(page.locator("h2")).hasText("IFrame")
        val frame = page.frameLocator("[data-testid=iframe]")
        frame.locator("[data-testid=navbar-addproduct]").click()
        assertThat(frame.locator("h1")).hasText("Add Product")
        assertThat(page.locator("h2")).hasText("IFrame")
    }
}