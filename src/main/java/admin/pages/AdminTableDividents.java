package admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminTableDividents {

    private WebDriver driver;

    public AdminTableDividents(WebDriver driver) {
        this.driver = driver;
    }



    public List<WebElement> getRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        return rows;
    }

    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for(WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath("//tbody//td"));
            rowsWithColumns.add(rowWithColumns);
        }

        return rowsWithColumns;
    }

    public float getValueCell(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowWithColumns = getRowsWithColumns();
        WebElement cell = rowWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return Float.parseFloat(cell.getText());
    }

    public float totalEstQD() {
        float total = 0;
        for (int i = 1; i < 2; i++) {
            total +=  getValueCell(i,12);;
        }
        return total;
    }

}
