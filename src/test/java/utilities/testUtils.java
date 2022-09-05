/*
 * This class has the screenshot method which will be called by ListenerTest class.
 * This class extends the TestCLass which has the WebDriver static instance. 
 * Author: Gaurav Punj
 */
package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testPackage.TestClass;

public class testUtils extends TestClass {

	public void getScreenshot() throws IOException {

		Date currentdate = new Date();
		System.out.println(currentdate);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		try {
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File(".//screenshot//" + screenshotfilename + ".png"));
		} catch (NullPointerException t) {
			t.printStackTrace();
		}

	}
}
