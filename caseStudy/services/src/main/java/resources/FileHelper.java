package resources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import pojo.Company;
import pojo.Stock;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//Done
public class FileHelper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Company> getCompanyList(String filename) throws FileNotFoundException, IOException {
        InputStream inputStream = new FileInputStream(filename);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>(){

        });
    }

    public static List<Stock> getStockList (String filename) throws FileNotFoundException, IOException {
        InputStream inputStream = new FileInputStream(filename);
        //Process

        //Goal: process inputStream to create a List of Stocks.
        //Each stock has a name and a list of Daily Stocks

        return mapper.readValue(inputStream, new TypeReference<List<Stock>>(){

        });
    }


}
