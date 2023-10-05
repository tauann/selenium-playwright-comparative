package commitquality.practice

import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DragAndDropTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-drag-and-drop")
    }

    @Test
    fun testDragAndDropElements() {
        page.locator("[data-testid=small-box]").dragTo(page.locator("[data-testid=large-box]"))
        assertThat(page.locator("[data-testid=large-box]")).hasText("Success!")
    }
}