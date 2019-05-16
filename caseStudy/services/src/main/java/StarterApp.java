

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resources.CompanyResource;
import resources.StockResource;

public class StarterApp extends Application<Configuration> {



    public StarterApp() {
    }

    @Override
    public void initialize(Bootstrap<Configuration> b) {
        CompanyResource.initialize();
        StockResource.initialize();
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {

    }


    public static void main(String[] args) throws Exception {

        StarterApp restServer = new StarterApp();
        restServer.run(args);

        System.out.println("Go to localhost:8080/hello/ok in your browser.");
    }

}