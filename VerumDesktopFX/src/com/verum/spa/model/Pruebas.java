package com.verum.spa.model;

import com.verum.spa.consume.controller.ProductController;
import com.verum.spa.consumeREST.ProductConsumeREST;

public class Pruebas {

    public static void main(String[] args) {
        ProductConsumeREST pe = new ProductConsumeREST();
        ProductController prod = new ProductController();
        Product prodd = new Product();

        System.out.println(pe.listProduct());

    }

    private static void method() {

    }

}
