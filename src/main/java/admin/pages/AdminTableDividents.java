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

    public List<WebElement> getAllCell() {
        List<WebElement> cells = driver.findElements(By.xpath("//tbody//td"));
        return cells;
    }

    public float getSumCellsInColumns(int numberColumn, int allColumns) {
        List<WebElement> cells = getAllCell();
        float sumCellsOfTwelfthColumns = 0.0f;

        for (int i = 0; i < getRows().size(); i++) {
            float valueCell = Float.parseFloat(cells.get(numberColumn - 1).getText());
            sumCellsOfTwelfthColumns += valueCell;
            numberColumn += allColumns;
        }

        return sumCellsOfTwelfthColumns;
    }

    /*public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for(WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath("//tbody//td"));
            rowsWithColumns.add(rowWithColumns);
        }

        return rowsWithColumns;
    }

    public String getValueCell(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }*/



}
