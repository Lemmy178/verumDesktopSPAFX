/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verum.spa.consume.controller;

import com.verum.spa.consumeREST.ProductConsumeREST;
import java.io.IOException;

/**
 *
 * @author ruben
 */
public class NewClass {
    public static void main(String[] args) throws IOException {
        ProductConsumeREST cms= new ProductConsumeREST();
        cms.listProduct();
    }
   
}
