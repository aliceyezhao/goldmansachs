package resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pojo.Company;
import pojo.Stock;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class FileHelperTest {
    @Test
    public  void testReadCompanyList() throws IOException {
        List<Company> listOfCompanies = FileHelper.getCompanyList(CompanyResource.FILE_PATH);
        assertNotEquals(null,listOfCompanies);
    }

    @Test
    public  void testReadStockList() throws IOException {
        List<Stock> listOfCompanies = FileHelper.getStockList(StockResource.FILE_PATH);
        assertNotEquals(null,listOfCompanies);
    }
}
