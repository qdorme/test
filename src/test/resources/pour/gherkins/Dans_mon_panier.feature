Feature: Ajouter tout plein truc dans mon panier

  Scenario: J'ajoute des kiwis dans mon panier
    Given J'ai un panier vide
    When J'ajoute 3 kiwi
    Then J'ai 3 fruits dans mon panier

  Scenario: Mon panier n'est pas vide
    Given j'ai un panier rempli avec
      |banane| 2|
      |pomme | 5|
      |kiwi  | 1|
    When J'ajoute 3 kiwi
    Then J'ai 11 fruits dans mon panier
