package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions

class AccordionsTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-accordions")
    }

    @Test
    fun testBasicClickButtonInsideAccordion() {
        driver.findElement(By.xpath("//button[text()='Accordion 1']")).click()
        driver.findElement(By.cssSelector("[data-testid=basic-click]")).click()
        assertEquals("Button clicked", driver.findElement(By.cssSelector("[data-testid=basic-click]+p")).text)
    }

    @Test
    fun testDoubleClickButtonInsideAccordion() {
        driver.findElement(By.xpath("//button[text()='Accordion 1']")).click()
        Actions(driver).doubleClick(driver.findElement(By.cssSelector("[data-testid=double-click]"))).perform()
        assertEquals(
            "Button double clicked",
            driver.findElement(By.cssSelector("[data-testid=double-click]+p")).text
        )
    }

    @Test
    fun testRightClickButtonInsideAccordion() {
        driver.findElement(By.xpath("//button[text()='Accordion 1']")).click()
        Actions(driver).contextClick(driver.findElement(By.cssSelector("[data-testid=right-click]"))).perform()
        assertEquals(
            "Button right mouse clicked",
            driver.findElement(By.cssSelector("[data-testid=right-click]+p")).text
        )
    }

    @Test
    fun testClickRadioButtonsInsideAccordion() {
        driver.findElement(By.xpath("//button[text()='Accordion 2']")).click()
        driver.findElement(By.cssSelector("[data-testid=option1]")).click()
        assertEquals("option1 clicked", driver.findElement(By.cssSelector(".component-container > p")).text)
        driver.findElement(By.cssSelector("[data-testid=option2]")).click()
        assertEquals("option2 clicked", driver.findElement(By.cssSelector(".component-container > p")).text)
    }

    @Test
    fun testClickCheckboxesInsideAccordion() {
        driver.findElement(By.xpath("//button[text()='Accordion 3']")).click()
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
}