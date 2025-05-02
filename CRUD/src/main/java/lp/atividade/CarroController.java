package lp.atividade;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CarroController {
    @FXML private TextField fabricanteField;
    @FXML private TextField modeloField;
    @FXML private TextField corField;
    @FXML private TableView<Carro> carroTable;
    @FXML private TableColumn<Carro, Integer> idColumn;
    @FXML private TableColumn<Carro, String> fabricanteColumn;
    @FXML private TableColumn<Carro, String> modeloColumn;
    @FXML private TableColumn<Carro, String> corColumn;

    private CarroDAO carroDAO;
    private ObservableList<Carro> carroList;

    public CarroController() {
        carroDAO = new CarroDAO();
        carroList = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        fabricanteColumn.setCellValueFactory(cellData -> cellData.getValue().fabricanteProperty());
        modeloColumn.setCellValueFactory(cellData -> cellData.getValue().modeloProperty());
        corColumn.setCellValueFactory(cellData -> cellData.getValue().corProperty());
        loadCarroData();
    }

    private void loadCarroData() {
        carroList.clear();
        try {
            carroList.addAll(carroDAO.getAllCarros());
            carroTable.setItems(carroList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddCarro() {
        Carro carro = new Carro();
        carro.setFabricante(fabricanteField.getText());
        carro.setModelo(modeloField.getText());
        carro.setCor(corField.getText());
        try {
            carroDAO.addCarro(carro);
            loadCarroData();
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUpdateCarro() {
        Carro selectedCarro = carroTable.getSelectionModel().getSelectedItem();
        if (selectedCarro != null) {
            selectedCarro.setFabricante(fabricanteField.getText());
            selectedCarro.setModelo(modeloField.getText());
            selectedCarro.setCor(corField.getText());
            try {
                carroDAO.updateCarro(selectedCarro);
                loadCarroData();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleDeleteCarro() {
        Carro selectedCarro = carroTable.getSelectionModel().getSelectedItem();
        if (selectedCarro != null) {
            try {
                carroDAO.deleteCarro(selectedCarro.getId());
                loadCarroData();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearFields() {
        fabricanteField.clear();
        modeloField.clear();
        corField.clear();
    }
}
