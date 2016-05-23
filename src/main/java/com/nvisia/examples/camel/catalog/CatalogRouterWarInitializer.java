package com.nvisia.examples.camel.catalog;

import org.apache.camel.spring.boot.*;

/**
 * Extends Spring Boot's SpringBootServletInitializer for initializing the web
 * application, providing the ability to initialize the Camel router for catalog services.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public class CatalogRouterWarInitializer extends FatWarInitializer {

   @Override
   protected Class<? extends FatJarRouter> routerClass() {
      return CatalogRouter.class;
   }

}
