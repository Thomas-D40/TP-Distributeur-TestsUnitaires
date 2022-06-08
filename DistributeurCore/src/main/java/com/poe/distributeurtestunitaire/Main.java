/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.distributeurtestunitaire;

import com.poe.distributeurtestunitaire.Distributeur;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tom
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Distributeur distributeur = new Distributeur();
        Integer choice = null;
        Integer montant = null;

        while (montant == null) {
            try {
                System.out.println("Combien souhaitez-vous mettre?");
                montant = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Vous n'avez pas renseigné de montant rond");
                input.nextLine();
            }
        }

        distributeur.insererArgent(montant);

        while (choice == null) {
            try {
                System.out.println("Quel produit souhaitez-vous?");                
                for (int i = 0; i < distributeur.getProduits().size(); i++) {
                    System.out.println(String.format("%d - %s", i, distributeur.getProduits().get(i).getName()));
                }
                choice = input.nextInt();
                input.nextLine();

            } catch (Exception e) {
                System.out.println("Ce chiffre ne correspond à aucun produit");
                input.nextLine();
            }
        }

        distributeur.commanderProduit(choice);
        
        
        distributeur.recupererArgent();
        
        System.out.println("Il reste " + distributeur.getCredit() + "€ dans le distributeur.");

    }
}
