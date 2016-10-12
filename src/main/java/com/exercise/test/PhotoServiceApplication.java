package com.exercise.test;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.exercise.test.resources.PhotoResource;
import javax.ws.rs.client.Client;
import io.dropwizard.client.JerseyClientBuilder;

/**
 * Created by sysdeva5 on 12/10/2016.
 *
 * This is the main entry class for this photo service.
 */
public class PhotoServiceApplication extends Application<PhotoConfiguration> {
    public static void main(String[] args) throws Exception {
        new PhotoServiceApplication().run(args);
    }

    /**
     *
     * @return - application name
     *
     * This method defines the name of the appliaction
     */
    @Override
    public String getName() {
        return "photo-service";
    }

    /**
     *
     * @param bootstrap - Bootstrap object
     *
     * This method bootstraps the appliaction
     */
    @Override
    public void initialize(Bootstrap<PhotoConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(new AssetsBundle());
    }

    /**
     *
     * @param configuration - Dropwizard configuration object
     * @param environment - Dropwizard environment object
     *
     * This method is run after Bundles are run. Ressource are registered here.
     */
    @Override
    public void run(PhotoConfiguration configuration, Environment environment) {

        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();

        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                .build(getName());
        environment.jersey().register(new PhotoResource(client));

    }
}