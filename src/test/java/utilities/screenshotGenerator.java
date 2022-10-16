package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class screenshotGenerator extends reportGenerator {
	static int i = 1;

	public void generateScreenshot(WebDriver driver) throws IOException {
		File scrFile;
		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile,
				new File("C:\\Users\\dhanush\\Desktop\\Sprint2\\automation_practice\\screenshots\\step" + i + ".jpeg"));
		i++;

	}
}
