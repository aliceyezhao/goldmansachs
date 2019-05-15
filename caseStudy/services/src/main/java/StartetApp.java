import resources.CompanyResource;
import resources.StockResource;

public class StartetApp {

    @Override
    public void initialize() {
        CompanyResource.initialize();
        StockResource.initialize();

    }
}
