

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.CompanyResource;
import resources.StockResource;

public class StarterApp extends Application<Configuration> {


    private static final Logger LOGGER = LoggerFactory.getLogger(StarterApp.class);

    public StarterApp() {
    }

    @Override
    public void initialize(Bootstrap<Configuration> b) {
//        CompanyResource.initialize();
//        StockResource.initialize();
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new CompanyResource());
        e.jersey().register(new StockResource());
        LOGGER.info("Successfully started REST Service.");
    }


    public static void main(String[] args) throws Exception {
        StarterApp restServer = new StarterApp();
        restServer.run(args);
    }

}