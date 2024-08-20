package gianlucamessina.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity //facciamo in modo che la classe sia mappata ad una tabella nel DB
public class Evento {
    @Id //serve a dichiarare che l'attributo sarà la chiave primaria
    @GeneratedValue //genera un valore il DB
    private long id;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "data_evento")
    @Temporal(TemporalType.DATE)
    private Date dataEvento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    //cambio il comportamento di default degli enum nel DB, che normalmente verrebbero trattati come interi
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private Integer numeroMassimoPartecipanti;

    //COSTRUTTORE
    //RIGOROSAMENTE VUOTO!!
    public Evento() {
    }

    public Evento(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    //GETTER E SETTER


    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
