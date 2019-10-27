/*=============================================================================
 |       Author:  Ruben
 |       Course:  Spa
 |     Due Date:  10/18/2019
 |  Description:  ProductConsume 
 |                
 | Deficiencies:  Falta implementar metodos.
                  Listando funcionando

                http://localhost:8080/VerumRESTSpa/api/product
 *===========================================================================*/

package com.verum.spa.consume;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ProductConsume {

    public String addProduct(String proName, String proBrand, double proPrice) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/SpaSmartTech/api/product/add");
        String aux = String.valueOf(proPrice);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Map<String, String> valeurs = new HashMap<String, String>();
        valeurs.put("proName", proName);
        valeurs.put("proBrand", proBrand);
        valeurs.put("proPrice", aux);

        String json = gson.toJson(valeurs);
        String response = null;
        response = target.request()
                .post(Entity.entity(json, MediaType.APPLICATION_JSON),
                        String.class);
        return response;
    }

    public String listProduct() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/VerumRESTSpa/api/product/productList");
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public String listProduct2() {
           Client client = ClientBuilder.newClient();
        WebTarget target = client.
                  target("http://localhost:8080/VerumRESTSpa/api/product/productList");
        String s = target.request().get(String.class);
        return s;
    }

//    private static void postUsingRawJSON(WebTarget target) {
//        String customer = ClientUtil.createCustomerInJSON("Alyssa William",
//                 "1021 Hweitt Street",
//                 "343-343-3433");
//        String response = target.request()
//                .post(Entity.entity(customer, MediaType.APPLICATION_JSON),
//                         String.class);
//        System.out.println("customer created with id: " + response);
//
//        //get the new customer
//        getCustomerById(target, response);
//
//    }
}
