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

    private int idPro;
    private String proName;
    private String proBrand;
    private double proPrice;
    private boolean proStatus;

    public Product() {
    }

    public Product(int idPro, String proName, String proBrand, double proPrice, boolean proStatus) {
        this.idPro = idPro;
        this.proName = proName;
        this.proBrand = proBrand;
        this.proPrice = proPrice;
        this.proStatus = proStatus;
    }

    //Constructor para addProduct
    public Product(String proName, String proBrand, double proPrice) {
        this.proName = proName;
        this.proBrand = proBrand;
        this.proPrice = proPrice;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProBrand() {
        return proBrand;
    }

    public void setProBrand(String proBrand) {
        this.proBrand = proBrand;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    public boolean isProStatus() {
        return proStatus;
    }

    public void setProStatus(boolean proStatus) {
        this.proStatus = proStatus;
    }

}
