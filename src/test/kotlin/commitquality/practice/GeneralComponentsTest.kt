package commitquality.practice

import com.microsoft.playwright.Locator.ClickOptions
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import com.microsoft.playwright.options.MouseButton.RIGHT
import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GeneralComponentsTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-general-components")
    }

    @Test
    fun testBasicClickButton() {
        page.locator("[data-testid=basic-click]").click()
        assertThat(page.locator("[data-testid=basic-click]+p")).hasText("Button clicked")
    }

    @Test
    fun testDoubleClickButton() {
        page.locator("[data-testid=double-click]").dblclick()
        assertThat(page.locator("[data-testid=double-click]+p")).hasText("Button double clicked")
    }

    @Test
    fun testRightClickButton() {
        page.locator("[data-testid=right-click]").click(ClickOptions().apply { button = RIGHT })
        assertThat(page.locator("[data-testid=right-click]+p")).hasText("Button right mouse clicked")
    }

    @Test
    fun testClickRadioButtons() {
        page.locator("[data-testid=option1]").check()
        assertThat(page.locator(".radio-buttons-container p")).hasText("option1 clicked")
        page.locator("[data-testid=option2]").check()
        assertThat(page.locator(".radio-buttons-container p")).hasText("option2 clicked")
    }

    @Test
    fun testSelectOption() {
        page.locator("[data-testid=dropdown] > select").selectOption("Option 1")
        assertThat(page.locator("[data-testid=dropdown] > select")).hasValue("option1")
        page.locator("[data-testid=dropdown] > select").selectOption("Option 2")
        assertThat(page.locator("[data-testid=dropdown] > select")).hasValue("option2")
        page.locator("[data-testid=dropdown] > select").selectOption("Option 3")
        assertThat(page.locator("[data-testid=dropdown] > select")).hasValue("option3")
    }

    @Test
    fun testClickCheckboxes() {
        page.locator("[data-testid=checkbox1]").check()
        assertThat(page.locator(".checkbox-container:nth-child(1) p")).hasText("Checkbox 1 checked")
        page.locator("[data-testid=checkbox2]").check()
        assertThat(page.locator(".checkbox-container:nth-child(2) p")).hasText("Checkbox 2 checked")
        page.locator("[data-testid=checkbox3]").check()
        assertThat(page.locator(".checkbox-container:nth-child(3) p")).hasText("Checkbox 3 checked")
    }

    @Test
    fun testLinkNavigateToDiffentDomain() {
        page.locator("[data-testid=link-same-tab]").click()
        assertThat(page).hasURL("https://www.youtube.com/@commitquality")
    }

    @Test
    fun testLinkOpensPopupOnDifferentDomain() {
        val popup = page.waitForPopup { page.click("[data-testid=link-newtab]") }
        assertThat(popup).hasURL("https://www.youtube.com/@commitquality")
    }

    @Test
    fun testLinkOpensPopupOnSameDomain() {
        val popup = page.waitForPopup { page.click("[data-testid=link-newtab-practice]") }
        assertThat(popup).hasURL("$APP_URL/practice")
    }
}