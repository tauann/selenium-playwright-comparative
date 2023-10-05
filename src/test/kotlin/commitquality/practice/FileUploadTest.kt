package commitquality.practice

import commitquality.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class FileUploadTest : BaseTest() {
    @BeforeEach
    fun beforeEach() {
        page.navigate("$APP_URL/practice-file-upload")
    }

    @Test
    fun testFileUpload() {
        page.locator("[data-testid=file-input]").setInputFiles(Paths.get("pom.xml"))
        page.onDialog {
            assertEquals("File successfully uploaded!", it.message())
            it.accept()
        }
        page.locator(".file-upload button[type=submit]").click()
    }
}