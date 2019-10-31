/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verum.spa.consumeREST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.verum.spa.model.Product;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ruben
 */
public class ProductConsumeRT {

    static Client client = ClientBuilder.newClient();
    static WebTarget target;
    static String values = "";
    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    static Product pro = new Product();

    //ADD
    public static String addProduct(String prodName, String brand, double useCost) {
        pro.setProdName(prodName);
        pro.setBrand(brand);
        pro.setUseCost(useCost);

        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/add");
        values = target.request()
                .post(Entity.entity(pro, MediaType.APPLICATION_JSON),
                        String.class);
        return values;
    }
}
