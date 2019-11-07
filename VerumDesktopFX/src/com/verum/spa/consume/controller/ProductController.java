/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
 |       Course:  Spa
 |     Due Date:  10/31/2019
 |  Description:  Product Controller
 |                
 | Deficiencies:  Ninguna detectada. Se hace el control de entrada del usuario  
                  antes de mandar valores a BD
 *===========================================================================*/
package com.verum.spa.consume.controller;

import com.verum.spa.consumeREST.ProductConsumeREST;
import com.verum.spa.model.Product;
import java.io.IOException;
import java.util.ArrayList;

public class ProductController {

    private static Product pro = new Product();
    private static ProductConsumeREST proREST = new ProductConsumeREST();

    public String addProductController(String proName, String brand, double useCost) {
        if (proName.trim().length() > 255 && brand.trim().length() > 255) {
            return "El maximo de caracteres para Nombre de producto y marca es de 255";
        } else {
            pro.setProdName(proName);
            pro.setBrand(brand);
            pro.setUseCost(useCost);
            return proREST.addProduct(pro);
        }
    }

    public String modifyProductController(String proName, String brand, double useCost, int proID) {
        if (proName.trim().length() > 255 && brand.trim().length() > 255) {
            return "El maximo de caracteres para Nombre de producto y Marca es de 255";
        } else {
            pro.setProdName(proName);
            pro.setBrand(brand);
            pro.setUseCost(useCost);
            pro.setProdId(proID);
            return proREST.modifyProduct(pro);
        }
    }

    public String logicalDelteController(int proID) {
        pro.setProdId(proID);
        return proREST.logicalDeleteProduct(pro);
    }

    public ArrayList<Product> productList() throws IOException {
        ArrayList<Product> datosProduct = new ArrayList<>();
        datosProduct=proREST.listProductA();
        return datosProduct;
    }

}
