

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import jdk.nashorn.internal.runtime.linker.Bootstrap;
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
        e.jersey().register(new CompanyResource());
        e.jersey().register(new StockResource());
    }


    public static void main(String[] args) throws Exception {
        StarterApp restServer = new StarterApp();
        restServer.run(args);
    }

}