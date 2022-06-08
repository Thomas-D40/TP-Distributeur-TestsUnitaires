/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.poe.distributeurtestunitaire.Distributeur;
import com.poe.distributeurtestunitaire.entities.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Tom
 */
public class DistributeurTest {

    static Distributeur distributeur;
    


    @BeforeAll
    public static void setup() {
        distributeur = new Distributeur();
    }
    
    // Inutile dans ce cas, uniquement a but pédagogique    
    @BeforeEach
    public void setupForEach() {
        distributeur = new Distributeur();
    }
    
    @DisplayName("Test d'insertion d'argent")
    @ParameterizedTest
    @CsvSource({"1", "10"})
    public void TestInsererArgent(int montant) {
        distributeur.insererArgent(montant);
        assertEquals(distributeur.getCredit(), montant);
    }

    @ParameterizedTest
    @CsvSource({"10,3", "10,2", "1,1"})
    public void TestCommandesChgtQte(int montant, int idProduit) {
        int initialQte = distributeur.getProduits().get(idProduit).getQte();
        distributeur.insererArgent(montant);

        distributeur.commanderProduit(idProduit);

        if (montant > distributeur.getProduits().get(idProduit).getPrice()) {
            assertEquals(distributeur.getProduits().get(idProduit).getQte(), initialQte - 1);
        } else {
            assertEquals(distributeur.getProduits().get(idProduit).getQte(), initialQte);
        }

    }

    @ParameterizedTest
    @CsvSource({"10,3", "10,2", "1,1"})
    public void TestCommandesChgtMontant(int montant, int idProduit) {
        int initialMontant = montant;
        distributeur.insererArgent(montant);

        distributeur.commanderProduit(idProduit);

        if (montant > distributeur.getProduits().get(idProduit).getPrice()) {
            assertEquals(initialMontant - distributeur.getProduits().get(idProduit).getPrice(), distributeur.getCredit());
        } else {
            assertEquals(initialMontant, distributeur.getCredit());
        }

    }

    @ParameterizedTest
    @CsvSource({"10,3", "10,2", "1,1"})
    public void TestRecupArgent(int montant, int idProduit) {
        distributeur.insererArgent(montant);

        distributeur.commanderProduit(idProduit);

        distributeur.recupererArgent();

        assertEquals(0, distributeur.getCredit());

    }

}
