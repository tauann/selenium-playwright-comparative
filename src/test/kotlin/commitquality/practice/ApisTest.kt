package commitquality.practice

import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ApisTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-api")
    }

    @Test
    fun testCaptureAPIResponse() {
        val response = page.waitForResponse("https://jsonplaceholder.typicode.com/todos/1") {
            page.locator("[data-testid=get-button]").click()
        }
        assertThat(page.locator(".api-container > p")).hasText("Status Code: ${response.status()}")
        assertThat(page.locator(".api-container > pre")).hasText(response.text())
    }
}