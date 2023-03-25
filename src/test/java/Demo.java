import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thestelco.com");
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
//		List <WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println(links.size());
//		for(WebElement e : links) {
//			String url = e.getAttribute("href");
//			checkBrokenLink(url);
//		}
		
	}
	
	public static void checkBrokenLink(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode()>=400) {
				System.out.println(linkUrl + " :: "+httpURLConnection.getResponseMessage() + " is a Broken Link");
			}else{
				System.out.println(linkUrl +"::"+ httpURLConnection.getResponseMessage());
			}
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}
}
