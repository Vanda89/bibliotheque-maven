package fr.diginamic;

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
            em.getTransaction().commit();

            em.close();
            emf.close();
        } finally {
            em.close();
        }
        emf.close();
    }
}
