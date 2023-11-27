package pour.gherkins;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PanierTest {

    private Panier panier;

    @Given("J'ai un panier vide")
    public void panierVide() {
        this.panier = new Panier();
    }

    @When("J'ajoute {int} {word}")
    public void ajout(int num, String fruit){
        panier.add(num,fruit);
    }

    @Then("J'ai {int} fruits dans mon panier")
    public void etdonc(int num){
        assertThat(panier.nombre()).isEqualTo(num);
    }

    @Given("j'ai un panier rempli avec")
    public void jAiUnPanierRempliAvec(Map<String,Integer> p) {
        this.panier = new Panier();

        p.entrySet().stream().forEach(e -> panier.add(e.getValue(), e.getKey()));

    }
}
