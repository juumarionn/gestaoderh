package com.example.controllers;

import com.example.database.Database;
import com.example.models.DadoProfissional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class DadoProfissionalController {
    @FXML private TextField txtcargoFunc;
    @FXML private TextField txtdepartamentoFunc;
    @FXML private TextField txtfuncaoFunc;
    @FXML private TextField txtmaquinasFunc;
    @FXML private TextField txtadmissaoFunc;
    @FXML private TextField txtsalarioFunc;
    @FXML private TextField txtdadosbancariosFunc;
    @FXML private TextField txtbeneficiosFunc;
    @FXML private TextField txtescolaridadeFunc;
    @FXML private TextField txtctpsFunc;
    @FXML private TextField txtpisFunc;
    @FXML private TextField txtcontratoFunc;
    @FXML private TextField txthorarioFunc;
    @FXML private TextField txtacidentesFunc;
    @FXML private TextField txtadvertenciasFunc;
    

    @FXML private TextField txtcargoAtualizarFunc;
    @FXML private TextField txtdepartamentoAtualizarFunc;
    @FXML private TextField txtfuncaoAtualizarFunc;
    @FXML private TextField txtmaquinasAtualizarFunc;
    @FXML private TextField txtadmissaoAtualizarFunc;
    @FXML private TextField txtsalarioAtualizarFunc;
    @FXML private TextField txtdadosbancariosAtualizarFunc;
    @FXML private TextField txtbeneficiosAtualizarFunc;
    @FXML private TextField txtescolaridadeAtualizarFunc;
    @FXML private TextField txtctpsAtualizarFunc;
    @FXML private TextField txtpisAtualizarFunc;
    @FXML private TextField txtcontratoAtualizarFunc;
    @FXML private TextField txthorarioAtualizarFunc;
    @FXML private TextField txtacidentesAtualizarFunc;
    @FXML private TextField txtadvertenciasAtualizarFunc;
    
 


    @FXML private TableView<DadoProfissional> tableDadoProfissional;
    @FXML private TableColumn<DadoProfissional, String> colcargoFunc;
    @FXML private TableColumn<DadoProfissional, String> coldepartamentoFunc;
    @FXML private TableColumn<DadoProfissional, String> colfuncaoFunc;
    @FXML private TableColumn<DadoProfissional, String> colmaquinasFunc;
    @FXML private TableColumn<DadoProfissional, String> coladmissaoFunc;
    @FXML private TableColumn<DadoProfissional, String> colsalarioFunc;
    @FXML private TableColumn<DadoProfissional, String> coldadosbancariosFunc;
    @FXML private TableColumn<DadoProfissional, String> colbeneficiosFunc;
    @FXML private TableColumn<DadoProfissional, String> colescolaridadeFunc;
    @FXML private TableColumn<DadoProfissional, String> colctpsFunc;
    @FXML private TableColumn<DadoProfissional, String> colpisFunc;
    @FXML private TableColumn<DadoProfissional, String> colcontratoFunc;
    @FXML private TableColumn<DadoProfissional, String> colhorarioFunc;
    @FXML private TableColumn<DadoProfissional, String> colacidentesFunc;
    @FXML private TableColumn<DadoProfissional, String> coladvertenciasFunc;
   


    @FXML private TextField filtrocargoFunc;
    @FXML private TextField filtrodepartamentoFunc;
    @FXML private TextField filtrofuncaoFunc;
    @FXML private TextField filtromaquinasFunc;
    @FXML private TextField filtroadmissaoFunc;
    @FXML private TextField filtrosalarioFunc;
    @FXML private TextField filtrodadosbancariosFunc;
    @FXML private TextField filtrobeneficiosFunc;
    @FXML private TextField filtroescolaridadeFunc;
    @FXML private TextField filtroctpsFunc;
    @FXML private TextField filtropisFunc;
    @FXML private TextField filtrocontratoFunc;
    @FXML private TextField filtrohorarioFunc;
    @FXML private TextField filtroacidentesFunc;
    @FXML private TextField filtroadvertenciasFunc;
   


    @FXML private TabPane tabPaneDadoProfissional;
    @FXML private Tab tabCadastrarDadoProfissional;
    @FXML private Tab tabAtualizarDadoProfissional;
    @FXML private Tab tabListarDadoProfissional;

    private ObservableList<DadoProfissional> listaDadoProfissional = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        
        colcargoFunc.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        coldepartamentoFunc.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        colfuncaoFunc.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        colmaquinasFunc.setCellValueFactory(new PropertyValueFactory<>("maquinas"));
        coladmissaoFunc.setCellValueFactory(new PropertyValueFactory<>("admissao"));
        colsalarioFunc.setCellValueFactory(new PropertyValueFactory<>("salario"));
        coldadosbancariosFunc.setCellValueFactory(new PropertyValueFactory<>("dadosbancarios"));
        colbeneficiosFunc.setCellValueFactory(new PropertyValueFactory<>("beneficios"));
        colescolaridadeFunc.setCellValueFactory(new PropertyValueFactory<>("escolaridade"));
        colctpsFunc.setCellValueFactory(new PropertyValueFactory<>("ctps"));
        colpisFunc.setCellValueFactory(new PropertyValueFactory<>("pis"));
        colcontratoFunc.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        colhorarioFunc.setCellValueFactory(new PropertyValueFactory<>("horario"));
        colacidentesFunc.setCellValueFactory(new PropertyValueFactory<>("acidentes"));
        coladvertenciasFunc.setCellValueFactory(new PropertyValueFactory<>("advertencias"));
        

        carregarDadoProfissional();
    


    tableDadoProfissional.setOnMouseClicked((MouseEvent event) -> {
        if (event.getClickCount() > 1) {
            preencherCamposAtualizacao();
        }
    });
}


private void salvarDadoProfissional() {
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO DadoProfissional (cargo, departamento, funcao, maquinas, admissao, salario, dadosbancarios, beneficios, escolaridade, ctps, pis, contrato, horario, acidentes, advertencias) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, txtcargoFunc.getText());
            stmt.setString(2, txtdepartamentoFunc.getText());
            stmt.setString(3, txtfuncaoFunc.getText());
            stmt.setString(4, txtmaquinasFunc.getText());
            stmt.setString(5, txtadmissaoFunc.getText());
            stmt.setString(6, txtsalarioFunc.getText());
            stmt.setString(7, txtdadosbancariosFunc.getText());
            stmt.setString(8, txtbeneficiosFunc.getText());
            stmt.setString(9, txtescolaridadeFunc.getText());
            stmt.setString(10, txtctpsFunc.getText());
            stmt.setString(11, txtpisFunc.getText());
            stmt.setString(12, txtcontratoFunc.getText());
            stmt.setString(13, txthorarioFunc.getText());
            stmt.setString(14, txtacidentesFunc.getText());
            stmt.setString(15, txtadvertenciasFunc.getText());
            stmt.executeUpdate();
            carregarDadoProfissional();

            mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário salvo com sucesso!");
        } catch (SQLException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao salvar funcionário: " + e.getMessage());
        }
    }
            
    @FXML
    public void atualizarDadoProfissional() {
        
            
            String cargo = txtcargoAtualizarFunc.getText();
            String departamento = txtdepartamentoAtualizarFunc.getText();
            String funcao = txtfuncaoAtualizarFunc.getText();
            String maquinas = txtmaquinasAtualizarFunc.getText();
            String salario = txtsalarioAtualizarFunc.getText();
            String dadosbancarios = txtdadosbancariosAtualizarFunc.getText();
            String beneficios = txtbeneficiosAtualizarFunc.getText();
            String escolaridade = txtescolaridadeAtualizarFunc.getText();
            String contrato = txtcontratoAtualizarFunc.getText();
            String horario = txthorarioAtualizarFunc.getText();
            String acidentes = txtacidentesAtualizarFunc.getText();
            String advertencias = txtadvertenciasAtualizarFunc.getText();
          


            try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE DadoProfissional SET cargo = ?, departamento = ?, funcao = ?,maquinas = ?, salario = ?, dadosbancarios = ?, beneficios = ?, escolaridade = ?, contrato = ?, horario = ?, acidentes = ?, advertencias = ?  WHERE id = ?")) {
           
                statement.setString(1, cargo);
                statement.setString(2, departamento);
                statement.setString(3, funcao);
                statement.setString(4, maquinas);
                statement.setString(5, salario);
                statement.setString(6, dadosbancarios);
                statement.setString(7, beneficios);
                statement.setString(8, escolaridade);
                statement.setString(9, contrato);
                statement.setString(10, horario);
                statement.setString(11, acidentes);
                statement.setString(12, advertencias);
                statement.executeUpdate();
                carregarDadoProfissional();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário atualizado com sucesso!");
            } catch (SQLException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao atualizar funcionário: " + e.getMessage());
            }
        }

        private void limparCamposAtualizacao() {
           
            txtcargoAtualizarFunc.clear();
            txtdepartamentoAtualizarFunc.clear();
            txtfuncaoAtualizarFunc.clear();
            txtmaquinasAtualizarFunc.clear();
            txtsalarioAtualizarFunc.clear();
            txtdadosbancariosAtualizarFunc.clear();
            txtbeneficiosAtualizarFunc.clear();
            txtescolaridadeAtualizarFunc.clear();
            txtcontratoAtualizarFunc.clear();
            txthorarioAtualizarFunc.clear();
            txtacidentesAtualizarFunc.clear();
            txtadvertenciasAtualizarFunc.clear();

            tabPaneDadoProfissional.getSelectionModel().select(tabListarDadoProfissional);
        }
    
        private void preencherCamposAtualizacao() {
            DadoProfissional DadoProfissionalSelecionado = tableDadoProfissional.getSelectionModel().getSelectedItem();
            if (DadoProfissionalSelecionado!= null) {
                
                txtcargoAtualizarFunc.setText(DadoProfissionalSelecionado.getCargo());
                txtdepartamentoAtualizarFunc.setText(DadoProfissionalSelecionado.getDepartamento());
                txtfuncaoAtualizarFunc.setText(DadoProfissionalSelecionado.getFuncao());
                txtmaquinasAtualizarFunc.setText(DadoProfissionalSelecionado.getMaquina_opera());
;               txtsalarioAtualizarFunc.setText(DadoProfissionalSelecionado.getSalario());
                txtdadosbancariosAtualizarFunc.setText(DadoProfissionalSelecionado.getDados_bancarios());
                txtbeneficiosAtualizarFunc.setText(DadoProfissionalSelecionado.getBeneficios());
                txtescolaridadeAtualizarFunc.setText(DadoProfissionalSelecionado.getEscolaridade());
                txtcontratoAtualizarFunc.setText(DadoProfissionalSelecionado.getContrato());
;               txthorarioAtualizarFunc.setText(DadoProfissionalSelecionado.getHorario_trabalho());
                txtacidentesAtualizarFunc.setText(DadoProfissionalSelecionado.getAcidentes());
                txtadvertenciasAtualizarFunc.setText(DadoProfissionalSelecionado.getAdvertencia());




                tabPaneDadoProfissional.getSelectionModel().select(tabAtualizarDadoProfissional);
            }
        }
    


        private void carregarDadoProfissional() {
            listaDadoProfissional.clear();
            try (Connection conn = Database.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM DadoProfissional")) {
    
                while (rs.next()) {
                    listaDadoProfissional.add(new DadoProfissional (rs.getString("cargo"), rs.getString("departamento"), rs.getString("funcao"), rs.getString("maquinas"), rs.getString("admissao"), rs.getString("salario"), rs.getString("dadosbancarios"), rs.getString("beneficios"), rs.getString("escolaridade"), rs.getString("ctps"), rs.getString("pis"), rs.getString("contrato"), rs.getString("horario"), rs.getString("acidentes"), rs.getString("advertencias")));
                }
                tableDadoProfissional.setItems(listaDadoProfissional);
            } catch (SQLException e) {

                mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao carregar funcionários: " + e.getMessage());
        }
    }
        @FXML
    public void filtrarDadoProfissional() {
        FilteredList<DadoProfissional> dadosFiltrados = new FilteredList<>(listaDadoProfissional, p -> true);

        dadosFiltrados.setPredicate(DadoProfissional -> {
            if (!filtrocargoFunc.getText().isEmpty() && !DadoProfissional.getCargo().toLowerCase().contains(filtrocargoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtrodepartamentoFunc.getText().isEmpty() && !DadoProfissional.getDepartamento().toLowerCase().contains(filtrodepartamentoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtrofuncaoFunc.getText().isEmpty() && !DadoProfissional.getFuncao().toLowerCase().contains(filtrofuncaoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtromaquinasFunc.getText().isEmpty() && !DadoProfissional.getMaquina_opera().toLowerCase().contains(filtromaquinasFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroadmissaoFunc.getText().isEmpty() && !DadoProfissional.getAdmissao().toLowerCase().contains(filtroadmissaoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtrosalarioFunc.getText().isEmpty() && !DadoProfissional.getSalario().toLowerCase().contains(filtrosalarioFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtrodadosbancariosFunc.getText().isEmpty() && !DadoProfissional.getDados_bancarios().toLowerCase().contains(filtrodadosbancariosFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtrobeneficiosFunc.getText().isEmpty() && !DadoProfissional.getBeneficios().toLowerCase().contains(filtrobeneficiosFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroescolaridadeFunc.getText().isEmpty() && !DadoProfissional.getEscolaridade().toLowerCase().contains(filtroescolaridadeFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroctpsFunc.getText().isEmpty() && !DadoProfissional.getCtps().toLowerCase().contains(filtroctpsFunc.getText().toLowerCase())) {
                return false;
            }

            if (!filtropisFunc.getText().isEmpty() && !DadoProfissional.getpis_pasep().toLowerCase().contains(filtropisFunc.getText().toLowerCase())) {
                return false;
            }
                
            if (!filtrocontratoFunc.getText().isEmpty() && !DadoProfissional.getContrato().toLowerCase().contains(filtrocontratoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtrohorarioFunc.getText().isEmpty() && !DadoProfissional.getHorario_trabalho().toLowerCase().contains(filtrohorarioFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroacidentesFunc.getText().isEmpty() && !DadoProfissional.getAcidentes().toLowerCase().contains(filtroacidentesFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroadvertenciasFunc.getText().isEmpty() && !DadoProfissional.getAdvertencia().toLowerCase().contains(filtroadvertenciasFunc.getText().toLowerCase())) {
                return false;
            }
            

            return true;
        });

        tableDadoProfissional.setItems(dadosFiltrados);
    }
    
    @FXML
    public void limparFiltro() {
        filtrocargoFunc.clear();
        filtrodepartamentoFunc.clear();
        filtrofuncaoFunc.clear();
        filtromaquinasFunc.clear();
        filtroadmissaoFunc.clear();
        filtrosalarioFunc.clear();
        filtrodadosbancariosFunc.clear();
        filtrobeneficiosFunc.clear();
        filtroescolaridadeFunc.clear();
        filtroctpsFunc.clear();
        filtropisFunc.clear();
        filtrocontratoFunc.clear();
        filtrohorarioFunc.clear();
        filtroacidentesFunc.clear();
        filtroadvertenciasFunc.clear();
       

        tableDadoProfissional.setItems(listaDadoProfissional);
    }


    @FXML
    public void excluirDadoProfissional(){
        DadoProfissional DadoProfissionalSelecionado = tableDadoProfissional.getSelectionModel().getSelectedItem();
        if (DadoProfissionalSelecionado != null) {
            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM DadoProfissional WHERE id = ?")) {
                stmt.setInt(1, DadoProfissionalSelecionado.getId());
                stmt.executeUpdate();
                carregarDadoProfissional();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário excluído com sucesso!");
                tabPaneDadoProfissional.getSelectionModel().select(tabListarDadoProfissional);
            } catch (SQLException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao excluir funcionário: " + e.getMessage());
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um funcionário para excluir!");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
