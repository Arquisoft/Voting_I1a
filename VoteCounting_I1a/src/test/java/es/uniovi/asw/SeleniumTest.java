package es.uniovi.asw;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {

    private char[] charNumber= {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String BASE_URL = "http://localhost:8080";
    WebDriver driver;

    @Before
    public void run() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @After
    public void end() {
        driver.quit();
    }

    @Test
    public void t01_loadMainPage(){
        assertTextInBody("Voting");
        assertTextInBody("Admin");
        assertTextInBody("Vote counting");
        assertTextInBody("Vote counting results");
    }

    @Test
    public void t02_viewResultsWithoutSeedingDatabase() throws InterruptedException {
        assertTextInBody("Political party");
        assertTextInBody("Total votes");
        assertTextInBody("Pie chart");
        assertTextNotInBody("Trump");
    }

    @Test
    public void t03_viewResultsWithSeedingAndWithoutCounting() throws InterruptedException {
        seedDatabase();

        assertTextInBody("Political party");
        assertTextInBody("Total votes");
        assertTextInBody("Results chart");

        //check there is no votes
        for(char character : charNumber) {
            assertTextInBody("0");
        }
    }

    @Test
    public void t04_countVotes() throws InterruptedException {
        seedDatabase();

        driver.findElement(By.id("admin")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("count")).click();

        driver.navigate().to(BASE_URL);
        Thread.sleep(1000);

        assertTextInBody("Vote counting results");
    }

    @Test
    public void t05_viewResultsWithSeedingAndCounting() throws InterruptedException {
        seedDatabase();

        t04_countVotes();

        assertTextInBody("Political party");
        assertTextInBody("Total votes");
        assertTextInBody("Results chart");

        //Check there exist at least one vote
        boolean someVote = false;
        for(char character : charNumber) {
            List<WebElement> list =
                    driver.findElements(By.xpath("//body//*[contains(text(),'" + String.valueOf(character) + "')]"));
            if(list.size() !=0)
                someVote = true;
        }
        assert someVote;
    }

    private void seedDatabase() throws InterruptedException {
        driver.navigate().to(BASE_URL + "/seed");
        Thread.sleep(1000);
    }


    private void assertTextInBody(String texto) {
        List<WebElement> list = driver.findElements(By.xpath("//body//*[contains(text(),'" + texto + "')]"));
        assertTrue("Texto " + texto + " no localizado!", list.size() > 0);
    }

    private void assertTextNotInBody(String texto) {
        List<WebElement> list = driver.findElements(By.xpath("//body//*[contains(text(),'" + texto + "')]"));
        assertTrue("Texto " + texto + " aun presente !", list.size() == 0);
    }
}
