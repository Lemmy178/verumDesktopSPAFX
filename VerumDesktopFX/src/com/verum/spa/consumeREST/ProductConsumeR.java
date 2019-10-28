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
package com.verum.spa.consumeREST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.verum.spa.model.Product;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ProductConsumeR {

    //global variables
    private Client client = ClientBuilder.newClient();
    private WebTarget target;
    private String values = "";
    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.create();
    private Product pro = new Product();

    //ADD
    public String addPro(String proNam, String proBra, double proPri) {
        pro.setProName(proNam);
        pro.setProBrand(proBra);
        pro.setProPrice(proPri);

        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/add");
        values = target.request()
                .post(Entity.entity(pro, MediaType.APPLICATION_JSON),
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
