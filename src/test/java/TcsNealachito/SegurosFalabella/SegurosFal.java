package TcsNealachito.SegurosFalabella;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SegurosFal {
	
	//Declaraciones
	static WebDriver driversito;
	private String nombrePagina2="";
	String url = "https://www.segurossura.com.co/paginas/movilidad/motos/inicio.aspx";
	
	
	@Before
	public void before() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driversito = new ChromeDriver();
		driversito.get(url);
		Thread.sleep(200);
		driversito.manage().window().maximize();
		System.out.println("Estoy en la pagina de Sura Seguros");
	}
	public void quieroCotizar() throws InterruptedException {
		WebElement coty = driversito.findElement(By.xpath("//a[contains(text(),'¡Quiero cotizar!')]"));
		JavascriptExecutor js = (JavascriptExecutor)driversito;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(5000);
		coty.click();
	}
	public void formInicial() throws InterruptedException {
		String placan = "CSV453";
		WebElement placa = driversito.findElement(By.xpath("//input[@name='placa']"));
		placa.click();
		placa.sendKeys(placan);
		Select tServicio = selectlist("//select[@name='tipoServicio']");
		tServicio.selectByVisibleText("PARTICULAR");
		WebElement btnCotizar = driversito.findElement(By.xpath("//span[contains(text(),'Cotizar seguro')]"));
		btnCotizar.click();
		Thread.sleep(8000);
		WebElement btnSoat = driversito.findElement(By.xpath("//a[contains(text(),'SOAT')]"));
		btnSoat.click();
		Thread.sleep(10000);
		WebElement placa2 = driversito.findElement(By.xpath("//input[@id='id-texto-placa']"));
		placa2.click();
		placa2.sendKeys(placan);
		WebElement cotizar2 = driversito.findElement(By.xpath("//button[@id='id-boton-cotizar']"));
		cotizar2.click();
		
	}
	public Select selectlist(String xpath) {
		return new Select(driversito.findElement(By.xpath(xpath)));
	}
	public void datos() {
		/*WebElement placa = driversito.findElement(By.xpath("//input[@id='id-texto-placa']"));
		placa.click();
		placa.sendKeys("DNR327");
		WebElement nombres = driversito.findElement(By.xpath("//input[@id='id-texto-nombres']"));
		nombres.click();
		nombres.sendKeys("NEAL DE ORO");
		WebElement email = driversito.findElement(By.xpath("//input[@id='id-texto-correo-electronico']"));
		email.click();
		email.sendKeys("nealdeoroing@hotmail.com");
		WebElement numerotel = driversito.findElement(By.xpath("//input[@id='id-texto-celular']"));
		numerotel.click();
		numerotel.sendKeys("3176091871");
		WebElement terminos = driversito.findElement(By.xpath("//input[@id='id-caja-terminos-y-condiciones']"));
		terminos.click();
		WebElement btcotizar = driversito.findElement(By.xpath("//button[@id='id-boton-cotizar']"));
		btcotizar.click();
		
		*/
	}
	@Test
	public void solicitar() throws InterruptedException {
		System.out.println("Probando");
		Thread.sleep(1000);
		quieroCotizar();
		Thread.sleep(1000);
		for(String window : driversito.getWindowHandles()) {
			if(driversito.getWindowHandle() !=window) {
				driversito.switchTo().window(window);
				nombrePagina2 = window;
			}
		}
		Thread.sleep(10000);
		formInicial();
		datos();
	}
}
