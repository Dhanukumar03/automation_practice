package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reportGenerator {
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static int i = 1;

	public void startReport() {
		extent = new ExtentReports("C:\\Users\\dhanush\\Desktop\\Sprint2\\automation_practice\\report\\Report.html",
				true);
	}

	public void startTest(String s) {
		logger = extent.startTest(s);
		logger.log(LogStatus.PASS, "Test is pass");
		i++;
	}

	public void endTest() {
		extent.flush();
		extent.endTest(logger);
	}

	public void endReport() {
		extent.close();
	}


}
