package lp.atividade;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Carro {
    private final IntegerProperty id;
    private final StringProperty fabricante;
    private final StringProperty modelo;
    private final StringProperty cor;

    public Carro() {
        this.id = new SimpleIntegerProperty();
        this.fabricante = new SimpleStringProperty();
        this.modelo = new SimpleStringProperty();
        this.cor = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getFabricante() {
        return fabricante.get();
    }

    public void setFabricante(String fabricante) {
        this.fabricante.set(fabricante);
    }

    public StringProperty fabricanteProperty() {
        return fabricante;
    }

    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    public StringProperty modeloProperty() {
        return modelo;
    }

    public String getCor() {
        return cor.get();
    }

    public void setCor(String cor) {
        this.cor.set(cor);
    }

    public StringProperty corProperty() {
        return cor;
    }
}
