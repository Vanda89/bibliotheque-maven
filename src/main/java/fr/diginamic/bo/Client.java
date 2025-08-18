package fr.diginamic.bo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NOM")
    private String nom;

    @Column(name="PRENOM")
    private String prenom;

    // mapped = "client" indicates that the relationship is managed by the client field in Emprunt
    // @OneToMany → LAZY by default
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Emprunt> emprunts;

    public Client() {
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public Set<Emprunt> getEmprunts() {
            return emprunts;
        }

        public void setEmprunts(Set<Emprunt> emprunts) {
            this.emprunts = emprunts;
        }
}
