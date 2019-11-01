/*=============================================================================
 |       Author:  Erick Ruben Ramos Vazquez
 |       Course:  Spa
 |     Due Date:  10/18/2019
 |  Description:  Product Model
 |                
 | Deficiencies:  No detected.
 *===========================================================================*/
package com.verum.spa.model;

public class Product {

    private int prodId;
    private String prodName;
    private String brand;
    private int prodStatus;
    private double useCost;

    public Product() {
    }

    public Product(int prodId, String prodName, String brand, int prodStatus, double useCost) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.brand = brand;
        this.prodStatus = prodStatus;
        this.useCost = useCost;
    }

    public Product(String prodName, String brand, double useCost) {
        this.prodName = prodName;
        this.brand = brand;
        this.useCost = useCost;
    }

    public Product(String sales_Department, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(int prodStatus) {
        this.prodStatus = prodStatus;
    }

    public double getUseCost() {
        return useCost;
    }

    public void setUseCost(double useCost) {
        this.useCost = useCost;
    }

}
