package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ApisTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        driver.navigate().to("$APP_URL/practice-api")
    }

    @Disabled("Not supported by Selenium")
    @Test
    fun testCaptureAPIResponse() {
    }
}