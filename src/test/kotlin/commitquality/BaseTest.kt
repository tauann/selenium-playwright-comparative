package commitquality

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

open class BaseTest {
    protected lateinit var page: Page private set
    private lateinit var context: BrowserContext

    @BeforeEach
    fun baseBeforeEach() {
        context = browser.newContext()
        page = context.newPage()
    }

    @AfterEach
    fun baseAfterEach() {
        page.close()
        context.close()
    }

    companion object {
        const val APP_URL = "https://commitquality.com"
        private lateinit var playwright: Playwright
        private lateinit var browser: Browser

        @JvmStatic
        @BeforeAll
        fun baseBeforeAll() {
            playwright = Playwright.create()
            browser = playwright.chromium().launch(LaunchOptions().apply {
                channel = "chrome"
                headless = true
            })
        }

        @JvmStatic
        @AfterAll
        fun baseAfterAll() {
            browser.close()
            playwright.close()
        }
    }
}