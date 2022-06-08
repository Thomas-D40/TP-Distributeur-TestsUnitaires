/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.distributeurtestunitaire.entities;

/**
 *
 * @author Tom
 */
public class Product {
    
    private String name;
    private int price;
    private int qte;

    public Product() {
    }

    public Product(String name, int price, int qte) {
        this.name = name;
        this.price = price;
        this.qte = qte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Boisson{" + "name=" + name + ", price=" + price + ", qte=" + qte + '}';
    }

    
    
    
    
}
