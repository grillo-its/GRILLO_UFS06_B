package org.example;

public class Albergo {

    int id;
    String nome;
    float prezzo;
    boolean suite;
    String descrizione;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Albergo(int id, String nome, float prezzo, boolean suite, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.suite = suite;
        this.descrizione = descrizione;
    }
}
