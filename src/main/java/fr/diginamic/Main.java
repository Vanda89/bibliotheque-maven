package fr.diginamic;

import fr.diginamic.bo.Client;
import fr.diginamic.bo.Emprunt;
import fr.diginamic.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "bibliotheque");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Livre newLivre = new Livre("Coder proprement", "Robert C. MARTIN");
            em.persist(newLivre);

            Livre livre = em.find(Livre.class, 1);
            if (livre != null) {
                System.out.println("Livre trouvé, id = " + livre.getId());
            }

            Livre livre2 = em.find(Livre.class, 6);
            if (livre != null) {
                System.out.println("Livre trouvé, id = " + livre2.getId() +
                        " titre= " + livre2.getTitre() + " auteur= " + livre2.getAuteur());
            }

            Emprunt emprunt = em.find(Emprunt.class, 1);
            if (emprunt != null) {
                System.out.println("Emprunt trouvé, id = " + emprunt.getId() +
                        " dateDebut= " + emprunt.getDateDebut() +
                        " dateFin= " + emprunt.getDateFin() +
                        " delai= " + emprunt.getDelai() +
                        " client= " + (emprunt.getClient() != null ? emprunt.getClient().getNom() + " " + emprunt.getClient().getPrenom() : "aucun client") +
                        " livres= " + (emprunt.getLivres() != null ? emprunt.getLivres().stream().map(Livre::getTitre).toList() : "aucun livre"));
            }

            Client client = em.find(Client.class, 1);
            if (client != null) {
                System.out.println("Client trouvé, id = " + client.getId() +
                        " nom= " + client.getNom() +
                        " prenom= " + client.getPrenom() +
                        " emprunts= " + (client.getEmprunts() != null ? client.getEmprunts().stream().map(Emprunt::getId).toList() : "aucun emprunt"));
            }



            em.getTransaction().commit();

            em.close();
            emf.close();
        } finally {
            em.close();
        }
        emf.close();
    }
}
