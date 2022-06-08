/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.distributeurtestunitaire;

import com.poe.distributeurtestunitaire.entities.Product;
import java.util.ArrayList;


/**
 *
 * @author Tom
 */
public class Distributeur {

    private int credit = 0;

    private ArrayList<Product> produits = new ArrayList<>();



    public Distributeur() {
        produits.add(new Product("Coca", 1, 15));
        produits.add(new Product("Orangina", 2, 25));
        produits.add(new Product("Kitkat", 3, 5));
        produits.add(new Product("Malteiser", 3, 10));
    }
    
    
    public void insererArgent(int montant) {
        credit = montant;
    }

    public void commanderProduit(int idProduit) {

        for (int i = 0; i < produits.size(); i++) {
            if (i == idProduit) {
                if (credit > produits.get(i).getPrice()) {
                    produits.get(i).setQte(produits.get(i).getQte() - 1);
                    credit -= produits.get(i).getPrice();
                    System.out.println("Achat effectué");
                    System.out.println("Il vous reste désormais " + credit + " €.");
                } else {
                    System.out.println("Vous n'avez pas assez pour cette boisson");
                }
            }
        }
    }
    
    public void recupererArgent() {
        credit = 0;
    }

    // Getters et setters   
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public ArrayList<Product> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Product> produits) {
        this.produits = produits;
    }
    
    

    @Override
    public String toString() {
        return "Distributeur{" + "credit=" + credit + ", produits=" + produits + '}';
    }

}
