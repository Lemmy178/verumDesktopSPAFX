/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verum.spa.pruebas;

import com.verum.spa.consumeREST.ProductConsumeRT;
import com.verum.spa.model.Product;

/**
 *
 * @author ruben
 */
public class NewClass {

    public static void main(String[] args) {
        Product pro = new Product();
        System.out.println(ProductConsumeRT.addProduct("aaaaapopoaa", "aaaa", 40.5));
    }
}
