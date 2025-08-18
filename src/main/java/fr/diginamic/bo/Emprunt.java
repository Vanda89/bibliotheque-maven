package fr.diginamic.bo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="DATE_DEBUT")
    private LocalDate dateDebut;

    @Column(name="DATE_FIN")
    private LocalDate dateFin;

    @Column(name="DELAI")
    private Integer delai;

    // Many side of the many-to-one relationship with Client
    // The ID_CLIENT column in the EMPRUNT table will reference the ID of the CLIENT table
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    // Owning side of the many-to-many relationship with Livre
    // The ID_EMP column in the COMPO table will reference the ID of the EMPRUNT table
    // The ID_LIV column in the COMPO table will reference the ID of the LIVRE table
    @ManyToMany
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")
    )
    private Set<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(Integer id, LocalDate dateDebut, LocalDate dateFin, Integer delai, Client client, Set<Livre> livres) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
        this.livres = livres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}
