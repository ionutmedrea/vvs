package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    @LocalServerPort
    private int localPort;

    private String serverUrl;
    private WebDriver driver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initServerUrl() {
        this.serverUrl = "http://localhost:" + localPort;
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void sel() throws InterruptedException {
        whenGetToRegistrationPage_registerWithValidCredentials_andThenLogin();
        addingExamsAndThenPressADD();

    }
    @Test
    public void whenGetToRegistrationPage_registerWithValidCredentials_andThenLogin() throws InterruptedException{

        String registrationURL = "http://localhost:" + localPort + "/registration";
        WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
        driver.get(registrationURL);

        assertEquals("User Registration", driver.getTitle());

        By username = By.id("username");
        wait.until(presenceOfElementLocated(username));
        driver.findElement(username).sendKeys("username123");

        By password = By.id("password");
        wait.until(presenceOfElementLocated(password));
        driver.findElement(password).sendKeys("passwordd123");

        By confirmPassword = By.id("confirmPassword");
        wait.until(presenceOfElementLocated(confirmPassword));
        driver.findElement(confirmPassword).sendKeys("passwordd123");

        By roles = By.id("roles");
        wait.until(presenceOfElementLocated(roles));
        driver.findElement(roles).sendKeys("profesor");
        Thread.sleep(1000);
        By pressRegister = By.id("register");
        wait.until(presenceOfElementLocated(pressRegister));
        driver.findElement(pressRegister).click();

        assertEquals("http://localhost:"+localPort+"/login", driver.getCurrentUrl());

        By login_username = By.id("username");
        wait.until(presenceOfElementLocated(login_username));
        driver.findElement(login_username).sendKeys("username123");

        By login_password = By.id("password");
        wait.until(presenceOfElementLocated(login_password));
        driver.findElement(login_password).sendKeys("passwordd123");
        Thread.sleep(1000);
        By loginLogin = By.id("login-submit");
        wait.until(presenceOfElementLocated(loginLogin));
        driver.findElement(loginLogin).click();

        assertEquals("http://localhost:"+localPort+"/welcome", driver.getCurrentUrl());
        Thread.sleep(1000);
        /*
        By logoutLogout = By.id("logout_index");
        wait.until(presenceOfElementLocated(logoutLogout));
        driver.findElement(logoutLogout).click();

        Thread.sleep(1000);
        assertEquals("http://localhost:"+localPort+"/login", driver.getCurrentUrl());
        */
    }

    @Test
    public void whenGetToRegistrationPage_registerWithEmptyFields() throws InterruptedException {

        String registrationURL = "http://localhost:" + localPort + "/registration";
        WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
        driver.get(registrationURL);

        assertEquals("User Registration", driver.getTitle());

        By username = By.id("username");
        wait.until(presenceOfElementLocated(username));
        driver.findElement(username).sendKeys("username123");

        By pressRegister = By.id("register");
        wait.until(presenceOfElementLocated(pressRegister));
        driver.findElement(pressRegister).click();
        Thread.sleep(10000);

        assertEquals("Please fill in this field.", driver.findElement(By.id("password")).getAttribute("validationMessage"));
    }
    @Test
    public void loginWithValidCredentialsButNotInDB() throws InterruptedException {

        String loginURL = "http://localhost:" + localPort + "/login";
        WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
        driver.get(loginURL);

        assertEquals("User Login", driver.getTitle());

        assertEquals("http://localhost:"+localPort+"/login", driver.getCurrentUrl());
        By usernamee = By.id("username");
        wait.until(presenceOfElementLocated(usernamee));
        driver.findElement(usernamee).sendKeys("username123");

        By passwordd = By.id("password");
        wait.until(presenceOfElementLocated(passwordd));
        driver.findElement(passwordd).sendKeys("passwordd123");

        By loginLogin = By.id("login-submit");
        wait.until(presenceOfElementLocated(loginLogin));
        driver.findElement(loginLogin).click();
        Thread.sleep(1000);

        assertEquals("http://localhost:"+localPort+"/login?error", driver.getCurrentUrl());
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {

        String loginURL = "http://localhost:" + localPort + "/login";
        WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
        driver.get(loginURL);

        assertEquals("User Login", driver.getTitle());

        By username = By.id("username");
        wait.until(presenceOfElementLocated(username));
        driver.findElement(username).sendKeys("asdasd");

        By password = By.id("password");
        wait.until(presenceOfElementLocated(password));
        driver.findElement(password).sendKeys("123123");

        By loginLogin = By.id("login-submit");
        wait.until(presenceOfElementLocated(loginLogin));
        driver.findElement(loginLogin).click();
        Thread.sleep(1000);
        assertEquals("http://localhost:"+localPort+"/login?error", driver.getCurrentUrl());

        wait.until(presenceOfElementLocated(By.id("alert_invalid_login")));
        assertEquals("Invalid username or password!", driver.findElement(By.id("alert_invalid_login")).getText());
    }

    @Test
    public void goToRegisterFromLogin() throws InterruptedException{

        String loginURL = "http://localhost:" + localPort + "/login";
        WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
        driver.get(loginURL);

        By loginRegister = By.id("login_register");
        wait.until(presenceOfElementLocated(loginRegister));
        driver.findElement(loginRegister).click();

        assertEquals("http://localhost:"+localPort+"/registration", driver.getCurrentUrl());
        assertEquals("User Registration", driver.getTitle());
        Thread.sleep(1000);
        assertEquals("Registration Page", driver.findElement(By.id("registration_page")).getText());
    }

    @Test
    public void addingExamsAndThenPressADD() throws InterruptedException {

        String registrationURL = "http://localhost:" + localPort + "/welcome";
        WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
        driver.get(registrationURL);

        By pressADD = By.id("welcome-add");
        wait.until(presenceOfElementLocated(pressADD));
        driver.findElement(pressADD).click();
        assertEquals("http://localhost:" + localPort + "/addExam", driver.getCurrentUrl());
        assertEquals("Adding Exams Page", driver.getTitle());

        By session = By.id("session");
        wait.until(presenceOfElementLocated(session));
        driver.findElement(session).sendKeys("Iarna");

        By yearOfStudy = By.id("yearOfStudy");
        wait.until(presenceOfElementLocated(yearOfStudy));
        driver.findElement(yearOfStudy).sendKeys("4");

        By faculty = By.id("faculty");
        wait.until(presenceOfElementLocated(faculty));
        driver.findElement(faculty).sendKeys("AC");

        By domain = By.id("domain");
        wait.until(presenceOfElementLocated(domain));
        driver.findElement(domain).sendKeys("CTI");

        By course = By.id("course");
        wait.until(presenceOfElementLocated(course));
        driver.findElement(course).sendKeys("VVS");

        By teacher = By.id("teacher");
        wait.until(presenceOfElementLocated(teacher));
        driver.findElement(teacher).sendKeys("Adina");

        By date = By.id("date");
        wait.until(presenceOfElementLocated(date));
        driver.findElement(date).sendKeys("11.01.2021");

        By pressAdd = By.id("add-submit");
        wait.until(presenceOfElementLocated(pressAdd));
        driver.findElement(pressAdd).click();

        //suntem pe URL-ul corect
        assertEquals("http://localhost:"+localPort+"/welcome", driver.getCurrentUrl());

        By pressShow = By.id("welcome-show");
        wait.until(presenceOfElementLocated(pressShow));
        driver.findElement(pressShow).click();

        assertEquals("http://localhost:"+localPort+"/showExams", driver.getCurrentUrl());

        Thread.sleep(5000);
        By showWelcome = By.id("show-welcome");
        wait.until(presenceOfElementLocated(showWelcome));
        driver.findElement(showWelcome).click();
        Thread.sleep(2000);
        assertEquals("http://localhost:"+localPort+"/welcome", driver.getCurrentUrl());

        By logoutLogout = By.id("logout_index");
        wait.until(presenceOfElementLocated(logoutLogout));
        driver.findElement(logoutLogout).click();

        assertEquals("http://localhost:"+localPort+"/login", driver.getCurrentUrl());
    }

}