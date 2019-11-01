/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
 |       Course:  Spa
 |     Due Date:  10/18/2019
 |  Description:  Product Model
 |                
 | Deficiencies:  Funcionado. Valores se repiten en BD despues de tiempo.
                  Solo basta con crear otra clase y todo se soluciona.
                  Preguntar si producto va a llevar cantidad.
 *===========================================================================*/
package com.verum.spa.consumeREST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.verum.spa.model.Product;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ProductConsumeREST {

    Client client = ClientBuilder.newClient();
    WebTarget target;
    String values = "";
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
//    Product pro = new Product();

    //ADD
    public String addProduct(Product pro) {
        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/add");
        values = target.request()
                .post(Entity.entity(pro, MediaType.APPLICATION_JSON),
                        String.class);
        return values;
    }

    public String modifyProduct(Product pro) {
        target = client.target("http://localhost:8080/VerumRESTSpa/api/product/modify");
        values = target.request().put(Entity.entity(pro, MediaType.APPLICATION_JSON), String.class);
        return values;
    }

    public String logicalDeleteProduct(Product pro) {
        target = client.target("http://localhost:8080/VerumRESTSpa/api/product/logDelete");
        values = target.request().put(Entity.entity(pro, MediaType.APPLICATION_JSON), String.class);
        return values;
    }

    public String listProduct() {
        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/productList");
        values = target.request().get(String.class);
        return values;
    }
}
