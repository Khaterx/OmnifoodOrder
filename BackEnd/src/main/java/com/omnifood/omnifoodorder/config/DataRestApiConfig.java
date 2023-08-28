package com.omnifood.omnifoodorder.config;

import com.omnifood.omnifoodorder.model.Category;
import com.omnifood.omnifoodorder.model.Order;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestApiConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] preventMethod = {HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        disableHttpMethod(Category.class, config, preventMethod);
        disableHttpMethod(Order.class, config, preventMethod);

        /* config.getExposureConfiguration()
                .forDomainType(Category.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod));

        config.getExposureConfiguration()
                .forDomainType(Order.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod));
        */
    }

    public void disableHttpMethod(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedMethod) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedMethod));
    }
}
