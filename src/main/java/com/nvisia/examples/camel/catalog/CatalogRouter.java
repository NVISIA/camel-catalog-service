package com.nvisia.examples.camel.catalog;

import java.util.*;

import org.apache.camel.component.servlet.*;
import org.apache.camel.model.rest.*;
import org.apache.camel.spring.boot.*;
import org.apache.camel.swagger.servlet.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.context.annotation.*;

/**
 * Spring boot application that defines the routes available for catalog
 * services
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@SpringBootApplication
public class CatalogRouter extends FatJarRouter {

   @Override
   public void configure() {
      initializeRestConfiguration();
      initializeCatalogItemRoute();
   }

   protected void initializeRestConfiguration() {
      // Start by building an instance of RestConfigurationDefinition. Need to
      // specify the component we are going to use for enabling REST endpoints,
      // specifically CamelServlet in this case. Set the binding mode to JSON.
      restConfiguration()
            // Leverage the CamelServlet component for the REST DSL
            .component("servlet")
            // Bind using JSON
            .bindingMode(RestBindingMode.json)
            // I like pretty things...
            .dataFormatProperty("prettyPrint", "true")
            // This is the context path to be used for Swagger API documentation
            .apiContextPath("api-doc")
            // Properties for Swagger
            // Title of the API
            .apiProperty("api.title", "NVISIA Catalog Service API")
            // Version of the API
            .apiProperty("api.version", "1.0.0")
            // CORS (resource sharing) enablement
            .apiProperty("cors", "true")
            // Use localhost for calls
            .apiProperty("host", "localhost:8080")
            // Set base path
            .apiProperty("base.path", "camel-catalog-service/api");
   }

   protected void initializeCatalogItemRoute() {
      // Definition of the get catalog item endpoint
      rest("/catalogItem")
            // This is a GET method call for getting a catalog item by ID.
            .get("{id}")
            // Description of what this method does
            .description("Retrieve a catalog item by ID")
            // Define the output type that will be returned from this method
            .outType(CatalogItem.class)
            // Define where the message is routed to as a URI. Here we use a
            // Spring Bean and define the bean method to invoke. Note that Camel
            // has converted the ID placeholder from the URL into a header
            // entry.
            .to("bean:catalogService?method=getCatalogItem(${header.id})");
   }

   @Bean
   public ServletRegistrationBean camelServletRegistrationBean() {
      ServletRegistrationBean registration = new ServletRegistrationBean(
            new CamelHttpTransportServlet(), "/api/*");
      registration.setName("CamelServlet");
      return registration;
   }

   @Bean
   public ServletRegistrationBean swaggerServletRegistrationBean() {
      ServletRegistrationBean registration = new ServletRegistrationBean(
            new RestSwaggerServlet(), "/api-docs/*");
      registration.setName("SwaggerServlet");
      return registration;
   }

   @Bean
   public FilterRegistrationBean filterRegistrationBean() {
      FilterRegistrationBean filterBean = new FilterRegistrationBean();
      filterBean.setFilter(new RestSwaggerCorsFilter());
      List<String> urlPatterns = new ArrayList<String>();
      urlPatterns.add("/camel-catalog-service/api-docs/*");
      urlPatterns.add("/camel-catalog-service/api/*");
      filterBean.setUrlPatterns(urlPatterns);
      return filterBean;
   }

}
