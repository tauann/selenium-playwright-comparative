package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.Select

class GeneralComponentsTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-general-components")
    }

    @Test
    fun testBasicClickButton() {
        driver.findElement(By.cssSelector("[data-testid=basic-click]")).click()
        assertEquals("Button clicked", driver.findElement(By.cssSelector("[data-testid=basic-click]+p")).text)
    }

    @Test
    fun testDoubleClickButton() {
        Actions(driver).doubleClick(driver.findElement(By.cssSelector("[data-testid=double-click]"))).perform()
        assertEquals(
            "Button double clicked",
            driver.findElement(By.cssSelector("[data-testid=double-click]+p")).text
        )
    }

    @Test
    fun testRightClickButton() {
        Actions(driver).contextClick(driver.findElement(By.cssSelector("[data-testid=right-click]"))).perform()
        assertEquals(
            "Button right mouse clicked",
            driver.findElement(By.cssSelector("[data-testid=right-click]+p")).text
        )
    }

    @Test
    fun testClickRadioButtons() {
        driver.findElement(By.cssSelector("[data-testid=option1]")).click()
        assertEquals("option1 clicked", driver.findElement(By.cssSelector(".radio-buttons-container p")).text)
        driver.findElement(By.cssSelector("[data-testid=option2]")).click()
        assertEquals("option2 clicked", driver.findElement(By.cssSelector(".radio-buttons-container p")).text)
    }

    @Test
    fun testSelectOption() {
        val dropdown = Select(driver.findElement(By.cssSelector("[data-testid=dropdown] > select")))
        dropdown.selectByVisibleText("Option 3")
        assertEquals("Option 3", dropdown.firstSelectedOption.text)
    }

    @Test
    fun testClickCheckboxes() {
        driver.findElement(By.cssSelector("[data-testid=checkbox1]")).click()
        assertEquals(
            "Checkbox 1 checked",
            driver.findElement(By.cssSelector(".checkbox-container:nth-child(1) p")).text
        )
        driver.findElement(By.cssSelector("[data-testid=checkbox2]")).click()
        assertEquals(
            "Checkbox 2 checked",
            driver.findElement(By.cssSelector(".checkbox-container:nth-child(2) p")).text
        )
        driver.findElement(By.cssSelector("[data-testid=checkbox3]")).click()
        assertEquals(
            "Checkbox 3 checked",
            driver.findElement(By.cssSelector(".checkbox-container:nth-child(3) p")).text
        )
    }

    @Test
    fun testLinkNavigateToDiffentDomain() {
        driver.findElement(By.cssSelector("[data-testid=link-same-tab]")).click()
        assertEquals("https://www.youtube.com/@commitquality", driver.currentUrl)
    }

    @Test
    fun testLinkOpensPopupOnDifferentDomain() {
        driver.findElement(By.cssSelector("[data-testid=link-newtab]")).click()
        driver.switchTo().window(driver.windowHandles.last())
        assertEquals("https://www.youtube.com/@commitquality", driver.currentUrl)
    }

    @Test
    fun testLinkOpensPopupOnSameDomain() {
        driver.findElement(By.cssSelector("[data-testid=link-newtab-practice]")).click()
        driver.switchTo().window(driver.windowHandles.last())
        assertTrue(driver.currentUrl.endsWith("/practice"))
    }
}