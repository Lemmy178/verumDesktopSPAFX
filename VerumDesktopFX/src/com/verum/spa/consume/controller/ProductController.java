package com.verum.spa.consume.controller;

import com.verum.spa.consumeREST.ProductConsumeREST;
import com.verum.spa.model.Product;
import java.util.ArrayList;

public class ProductController {

    private Product pro = new Product();
    private ProductConsumeREST proREST = new ProductConsumeREST();

    public String addProductController(String proName, String brand, double useCost) {
        if (proName.trim().length() > 255 && brand.trim().length() > 255) {
            return "El maximo de caracteres para Nombre de producto y Marca es de 255";
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

    public ArrayList<Product> productList() {
        return null;
    }

}
