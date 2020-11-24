package com.github.leblancjs.client.courriel.pour.manon;

import java.util.List;

public class ClientCourriel {
    private final long delaiAvantReponseEnMs;

    public ClientCourriel(long delaiAvantReponseEnMs) {
        this.delaiAvantReponseEnMs = delaiAvantReponseEnMs;
    }

    public List<Courriel> obtenirCourriels() {
        // Manon ne le sait pas, mais on ne va pas vraiment chercher des courriels...
        // On fait juste semblant
        try {
            Thread.sleep(delaiAvantReponseEnMs);
        } catch (InterruptedException error) {
            System.err.println("Euh... ça n'a pas marché");
        }

        return List.of(
                new Courriel("Ricardo", "La meilleure recette de tarte", "Tu dois essayer cette recette!"),
                new Courriel("Ginette Renaud", "Ma nouvelle chanson", "Salut. Peux-tu écouter mon dernier single et me dire ce que t'en penses? Merci!"),
                new Courriel("Prince Nigérien", "Une fortune à partager", "Hey! Je dois partager mon cash. T'en veux? Donne moi ton numéro de compte, ton NAS, etc. pi je t'envois quelques millions!"));
    }
}
