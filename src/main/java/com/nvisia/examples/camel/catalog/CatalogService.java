package com.nvisia.examples.camel.catalog;

/**
 * Interface for services to process requests for catalog data. 
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public interface CatalogService {

   /**
    * Retrieves a catalog item by its unique identifier. 
    * 
    * @param id
    * @return CatalogItem
    */
   CatalogItem getCatalogItem(int id); 
}
