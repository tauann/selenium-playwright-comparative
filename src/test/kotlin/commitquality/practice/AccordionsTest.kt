package commitquality.practice

import com.microsoft.playwright.Locator.ClickOptions
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import com.microsoft.playwright.options.MouseButton.RIGHT
import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AccordionsTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-accordions")
    }

    @Test
    fun testBasicClickButtonInsideAccordion() {
        page.locator("button:text-is('Accordion 1')").click()
        page.locator("[data-testid=basic-click]").click()
        assertThat(page.locator("[data-testid=basic-click]+p")).hasText("Button clicked")
    }

    @Test
    fun testDoubleClickButtonInsideAccordion() {
        page.locator("button:text-is('Accordion 1')").click()
        page.locator("[data-testid=double-click]").dblclick()
        assertThat(page.locator("[data-testid=double-click]+p")).hasText("Button double clicked")
    }

    @Test
    fun testRightClickButtonInsideAccordion() {
        page.locator("button:text-is('Accordion 1')").click()
        page.locator("[data-testid=right-click]").click(ClickOptions().apply { button = RIGHT })
        assertThat(page.locator("[data-testid=right-click]+p")).hasText("Button right mouse clicked")
    }

    @Test
    fun testClickRadioButtonsInsideAccordion() {
        page.locator("button:text-is('Accordion 2')").click()
        page.locator("[data-testid=option1]").check()
        assertThat(page.locator(".component-container > p")).hasText("option1 clicked")
        page.locator("[data-testid=option2]").check()
        assertThat(page.locator(".component-container > p")).hasText("option2 clicked")
    }

    @Test
    fun testClickCheckboxesInsideAccordion() {
        page.locator("button:has-text('Accordion 3')").click()
        page.locator("[data-testid=checkbox1]").check()
        assertThat(page.locator(".checkbox-container:nth-child(1) p")).hasText("Checkbox 1 checked")
        page.locator("[data-testid=checkbox2]").check()
        assertThat(page.locator(".checkbox-container:nth-child(2) p")).hasText("Checkbox 2 checked")
        page.locator("[data-testid=checkbox3]").check()
        assertThat(page.locator(".checkbox-container:nth-child(3) p")).hasText("Checkbox 3 checked")
    }
}