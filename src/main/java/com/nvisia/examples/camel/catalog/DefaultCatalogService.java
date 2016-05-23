package com.nvisia.examples.camel.catalog;

import static com.nvisia.examples.camel.catalog.CatalogItemType.*;

import java.util.*;

import org.springframework.stereotype.*;

/**
 * Default implementation for catalog services.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@Service("catalogService")
public class DefaultCatalogService implements CatalogService {

   @Override
   public CatalogItem getCatalogItem(int id) {
      List<CatalogItemAttribute> attributes = new ArrayList<CatalogItemAttribute>();
      if (id == 1) {
         attributes.add(new CatalogItemAttribute("TITLE",
               "HOW TO BUILD A JAVASCRIPT FRAMEWORK IN JUST THREE EASY STEPS"));
         attributes.add(new CatalogItemAttribute("AUTHOR", "DEWEY, CHEATUM AND HOWE"));
         attributes.add(new CatalogItemAttribute("ISBN", "1234567891"));
         attributes.add(new CatalogItemAttribute("ISBN13", "9876543210123"));
         attributes.add(new CatalogItemAttribute("PUBLISHER", "PENGUIN BOOKS"));
         return new CatalogItem(1, 45.99, BOOK, attributes);
      } else if (id == 2) {
         attributes.add(new CatalogItemAttribute("TITLE", "SNOW MAKING"));
         attributes.add(new CatalogItemAttribute("AUTHOR", "ANNIE SALES"));
         attributes.add(new CatalogItemAttribute("ISBN", "1332577456"));
         attributes.add(new CatalogItemAttribute("ISBN13", "2346511110623"));
         attributes.add(new CatalogItemAttribute("PUBLISHER", "JAGUAR BOOKS"));
         return new CatalogItem(2, 15.50, BOOK, attributes);
      } else if (id == 3) {
         attributes.add(new CatalogItemAttribute("SKU", "222444"));
         attributes.add(new CatalogItemAttribute("TYPE", "TSHIRT"));
         attributes.add(new CatalogItemAttribute("BRAND", "HANES"));
         attributes.add(new CatalogItemAttribute("GENDER", "MEN"));
         attributes.add(new CatalogItemAttribute("SIZE", "LARGE"));
         return new CatalogItem(3, 12.95, CLOTHING, attributes);
      } else if (id == 4) {
         attributes.add(new CatalogItemAttribute("SKU", "231422"));
         attributes.add(new CatalogItemAttribute("TYPE", "COAT"));
         attributes.add(new CatalogItemAttribute("BRAND", "COLUMBIA"));
         attributes.add(new CatalogItemAttribute("GENDER", "WOMEN"));
         attributes.add(new CatalogItemAttribute("SIZE", "SMALL"));
         return new CatalogItem(4, 79.99, CLOTHING, attributes);
      } else if (id == 5) {
         attributes.add(new CatalogItemAttribute("SERIALNUMBER", "5552918348A"));
         attributes.add(new CatalogItemAttribute("MAKE", "DELL"));
         attributes.add(new CatalogItemAttribute("MODEL", "INSPIRION"));
         return new CatalogItem(5, 495.00, ELECTRONICS, attributes);
      } else if (id == 6) {
         attributes.add(new CatalogItemAttribute("SERIALNUMBER", "5552918DDD"));
         attributes.add(new CatalogItemAttribute("MAKE", "HP"));
         attributes.add(new CatalogItemAttribute("MODEL", "ENVY"));
         return new CatalogItem(6, 399.95, ELECTRONICS, attributes);
      } else {
         return null;
      }
   }

}
