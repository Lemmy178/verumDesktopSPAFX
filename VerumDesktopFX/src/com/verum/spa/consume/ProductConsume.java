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
import javax.ws.rs.client.WebTarget;



public class ProductConsume {

    public static void main(String[] args) {
        System.out.println(addProduct("hoal", "hola", 50.5));
    }

    static Client client = ClientBuilder.newClient();
    static WebTarget target;
    static String values = "";
    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();

    public static String addProduct(String proName, String proBrand, double proPrice) {
        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/add");
        String aux = String.valueOf(proPrice);

        Map<String, String> valeurs = new HashMap<String, String>();
        valeurs.put("proName", proName);
        valeurs.put("proBrand", proBrand);
        valeurs.put("proPrice", aux);

//        String json = gson.toJson(valeurs);
        values = target.request()
                .post((valeurs, MediaType.APPLICATION_JSON),
                        String.class);
        
        return values;
    }
    
    public static String addProduct2(String proName, String proBrand, double proPrice) {
        Message newMesage = new Message(4,"hola");
    }

    public String listProduct() {
        //Funcionando
        target = client.
                target("http://localhost:8080/VerumRESTSpa/api/product/productList");
        values = target.request().get(String.class);
        return values;
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
