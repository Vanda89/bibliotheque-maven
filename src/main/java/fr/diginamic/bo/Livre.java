package fr.diginamic.bo;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "LIVRE")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="TITRE")
    private String titre;

    @Column(name="AUTEUR")
    private String auteur;

    // Non-owning side of the many-to-many relationship with Emprunt
    @ManyToMany(mappedBy = "livres")
    private Set<Emprunt> emprunts;

    public Livre() {

    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
