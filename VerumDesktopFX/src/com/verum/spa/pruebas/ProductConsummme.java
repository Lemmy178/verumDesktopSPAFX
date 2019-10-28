/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verum.spa.pruebas;

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
public class ProductConsummme {
   
    public static void main(String[] args) {
        consumeProduct("nombre", "mara", 10.88);
    }    
    public static String consumeProduct(String proN, String proB, double proP) {
        
        Client client = ClientBuilder.newClient();
        WebTarget target;
        String values = "";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Product producto = new Product();
        producto.setProName(proN);
        producto.setProBrand(proB);
        producto.setProPrice(proP);
        
        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/add");
        
        values = target.request()
                .post(Entity.entity(producto, MediaType.APPLICATION_JSON),
                        String.class);
        
        return values;
        
    }
}
