package fr.diginamic.bo;

import jakarta.persistence.*;

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
}
