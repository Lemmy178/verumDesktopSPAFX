/*=============================================================================
 |       Author:  Ruben
 |       Course:  Spa
 |     Due Date:  10/18/2019
 |  Description:  ProductConsume 
 |                
 | Deficiencies:  POST inserta datos pero con otros valores.
                  GET, funciona pero no parsea los objetos devueltos aun
                  solo JSON crudo.

                http://localhost:8080/VerumRESTSpa/api/product
 *===========================================================================*/
package com.verum.spa.consume;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.verum.spa.model.Product;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ProductConsume {

    //Global variables
    Client client = ClientBuilder.newClient();
    WebTarget target;
    String values = "";
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    Product producto;

    
    //POST
    public String addProduct(String proName, String proBrand, double proPrice) {
        
        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/add");
        
        producto = new Product(proName, proBrand, proPrice);

        values = target.request()
                .post(Entity.entity(producto, MediaType.APPLICATION_JSON),
                        String.class);
        
        return values;
    }

    //GET
    public String listProduct() {
        //Funcionando
        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/productList");
        
        values = target.request().get(String.class);
        
        return values;
    }

}
