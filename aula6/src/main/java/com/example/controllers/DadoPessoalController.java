package com.example.controllers;

import com.example.database.Database;
import com.example.models.DadoPessoal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class DadoPessoalController {
    @FXML private TextField txtnome_completoFunc;
    @FXML private TextField txtdatanascimentoFunc;
    @FXML private TextField txtsexoFunc;
    @FXML private TextField txtestado_civilFunc;
    @FXML private TextField txtconjugeFunc;
    @FXML private TextField txtdependentesFunc;
    @FXML private TextField txtnacionalidadeFunc;
    @FXML private TextField txtnaturalidadeFunc;
    @FXML private TextField txtcpfFunc;
    @FXML private TextField txtrgFunc;
    @FXML private TextField txtenderecoFunc;
    @FXML private TextField txttelefoneFunc;
    @FXML private TextField txtemailFunc;
    @FXML private TextField txtfiliacaoFunc;
    @FXML private TextField txttipo_sanguineoFunc;
    @FXML private TextField txtcontato_emergenciaFunc;


    @FXML private TextField txtIdAtualizarFunc;
    @FXML private TextField txtNomeAtualizarFunc;
    @FXML private TextField txtDataNascimentoAtualizarFunc;
    @FXML private TextField txtSexoAtualizarFunc;
    @FXML private TextField txtEstadoCivilAtualizarFunc;
    @FXML private TextField txtConjugeAtualizarFunc;
    @FXML private TextField txtDependentesAtualizarFunc;
    @FXML private TextField txtNacionalidadeAtualizarFunc;
    @FXML private TextField txtNaturalidadeAtualizarFunc;
    @FXML private TextField txtCpfAtualizarFunc;
    @FXML private TextField txtRgAtualizarFunc;
    @FXML private TextField txtEnderecoAtualizarFunc;
    @FXML private TextField txtTelefoneAtualizarFunc;
    @FXML private TextField txtEmailAtualizarFunc;
    @FXML private TextField txtFiliacaoAtualizarFunc;
    @FXML private TextField txtTipoSanguineoAtualizarFunc;
    @FXML private TextField txtContatoEmergenciaAtualizarFunc;

 


    @FXML private TableView<DadoPessoal> tableDadoPessoal;
    @FXML private TableColumn<DadoPessoal, Integer> colIdFunc;
    @FXML private TableColumn<DadoPessoal, String> colNomeFunc;
    @FXML private TableColumn<DadoPessoal, String> colDataNascimentoFunc;
    @FXML private TableColumn<DadoPessoal, String> colSexoFunc;
    @FXML private TableColumn<DadoPessoal, String> colEstado_CivilFunc;
    @FXML private TableColumn<DadoPessoal, String> colConjugeFunc;
    @FXML private TableColumn<DadoPessoal, String> colDependentesFunc;
    @FXML private TableColumn<DadoPessoal, String> colNacionalidadeFunc;
    @FXML private TableColumn<DadoPessoal, String> colNaturalidadeFunc;
    @FXML private TableColumn<DadoPessoal, String> colCpfFunc;
    @FXML private TableColumn<DadoPessoal, String> colRgFunc;
    @FXML private TableColumn<DadoPessoal, String> colEnderecoFunc;
    @FXML private TableColumn<DadoPessoal, String> colTelefoneFunc;
    @FXML private TableColumn<DadoPessoal, String> colEmailFunc;
    @FXML private TableColumn<DadoPessoal, String> colFiliacaoFunc;
    @FXML private TableColumn<DadoPessoal, String> colTipo_SanguineoFunc;
    @FXML private TableColumn<DadoPessoal, String> colContato_EmergenciaFunc;


    @FXML private TextField filtroNomeFunc;
    @FXML private TextField filtroDataNascimentoFunc;
    @FXML private TextField filtroSexoFunc;
    @FXML private TextField filtroEstadoCivilFunc;
    @FXML private TextField filtroConjugeFunc;
    @FXML private TextField filtroDependentesFunc;
    @FXML private TextField filtroNacionalidadeFunc;
    @FXML private TextField filtroNaturalidadeFunc;
    @FXML private TextField filtroCpfFunc;
    @FXML private TextField filtroRgFunc;
    @FXML private TextField filtroEnderecoFunc;
    @FXML private TextField filtroTelefoneFunc;
    @FXML private TextField filtroEmailFunc;
    @FXML private TextField filtroFiliacaoFunc;
    @FXML private TextField filtroTipoSanguineoFunc;
    @FXML private TextField filtroContatoEmergenciaFunc;



    @FXML private TabPane tabPaneDadoPessoal;
    @FXML private Tab tabCadastrarDadoPessoal;
    @FXML private Tab tabAtualizarDadoPessoal;
    @FXML private Tab tabListarDadoPessoal;

    private ObservableList<DadoPessoal> listaDadoPessoal = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        colIdFunc.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomeFunc.setCellValueFactory(new PropertyValueFactory<>("nome_completo"));
        colDataNascimentoFunc.setCellValueFactory(new PropertyValueFactory<>("data_nascimento"));
        colSexoFunc.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colEstado_CivilFunc.setCellValueFactory(new PropertyValueFactory<>("estado_civil"));
        colConjugeFunc.setCellValueFactory(new PropertyValueFactory<>("conjuge"));
        colDependentesFunc.setCellValueFactory(new PropertyValueFactory<>("dependentes"));
        colNacionalidadeFunc.setCellValueFactory(new PropertyValueFactory<>("nacionalidade"));
        colNaturalidadeFunc.setCellValueFactory(new PropertyValueFactory<>("naturalidade"));
        colCpfFunc.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colRgFunc.setCellValueFactory(new PropertyValueFactory<>("rg"));
        colEnderecoFunc.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colTelefoneFunc.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colEmailFunc.setCellValueFactory(new PropertyValueFactory<>("email"));
        colFiliacaoFunc.setCellValueFactory(new PropertyValueFactory<>("filiacao"));
        colTipo_SanguineoFunc.setCellValueFactory(new PropertyValueFactory<>("tipo_sanguineo"));
        colContato_EmergenciaFunc.setCellValueFactory(new PropertyValueFactory<>("contato_emergencia"));

        carregarDadoPessoal();
    


    tableDadoPessoal.setOnMouseClicked((MouseEvent event) -> {
        if (event.getClickCount() > 1) {
            preencherCamposAtualizacao();
        }
    });
}

@FXML
private void salvarDadoPessoal() {
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO dadospessoais (nome_completo, data_nascimento, sexo, estado_civil, conjuge, dependentes, nacionalidade, naturalidade, cpf, rg, endereco, telefone, email, filiacao, tipo_sanguineo, contato_emergencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, txtnome_completoFunc.getText());
            stmt.setString(2, txtdatanascimentoFunc.getText());
            stmt.setString(3, txtsexoFunc.getText());
            stmt.setString(4, txtestado_civilFunc.getText());
            stmt.setString(5, txtconjugeFunc.getText());
            stmt.setString(6, txtdependentesFunc.getText());
            stmt.setString(7, txtnacionalidadeFunc.getText());
            stmt.setString(8, txtnaturalidadeFunc.getText());
            stmt.setString(9, txtcpfFunc.getText());
            stmt.setString(10, txtrgFunc.getText());
            stmt.setString(11, txtenderecoFunc.getText());
            stmt.setString(12, txttelefoneFunc.getText());
            stmt.setString(13, txtemailFunc.getText());
            stmt.setString(14, txtfiliacaoFunc.getText());
            stmt.setString(15, txttipo_sanguineoFunc.getText());
            stmt.setString(16, txtcontato_emergenciaFunc.getText());
            stmt.executeUpdate();
            carregarDadoPessoal();

            mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário salvo com sucesso!");
        } catch (SQLException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao salvar funcionário: " + e.getMessage());
        }
    }
            
    @FXML
    public void atualizarDadoPessoal() {
        
            int id = Integer.parseInt(txtIdAtualizarFunc.getText());
            String estadoCivil = txtEstadoCivilAtualizarFunc.getText();
            String conjuge = txtConjugeAtualizarFunc.getText();
            String dependentes = txtDependentesAtualizarFunc.getText();
            String endereco = txtEnderecoAtualizarFunc.getText();
            String telefone = txtTelefoneAtualizarFunc.getText();
            String email = txtEmailAtualizarFunc.getText();
            String contato_emergencia = txtContatoEmergenciaAtualizarFunc.getText();


            try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE dadospessoais SET estado_civil = ?, conjuge = ?, dependentes = ?, endereco = ?, telefone = ?, email = ?, contato_emergencia = ? WHERE id = ?")) {
           
                statement.setString(1, estadoCivil);
                statement.setString(2, conjuge);
                statement.setString(3, dependentes);
                statement.setString(4, endereco);
                statement.setString(5, telefone);
                statement.setString(6, email);
                statement.setString(7, contato_emergencia);
                statement.setInt(8, id);
                statement.executeUpdate();
                carregarDadoPessoal();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário atualizado com sucesso!");
            } catch (SQLException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao atualizar funcionário: " + e.getMessage());
            }
        }

        @FXML
        private void limparCamposAtualizacao() {
            txtIdAtualizarFunc.clear();
            txtEstadoCivilAtualizarFunc.clear();
            txtConjugeAtualizarFunc.clear();
            txtDependentesAtualizarFunc.clear();
            txtEnderecoAtualizarFunc.clear();
            txtTelefoneAtualizarFunc.clear();
            txtEmailAtualizarFunc.clear();
            txtContatoEmergenciaAtualizarFunc.clear();

            tabPaneDadoPessoal.getSelectionModel().select(tabListarDadoPessoal);
        }
    
        private void preencherCamposAtualizacao() {
            DadoPessoal dadopessoalSelecionado = tableDadoPessoal.getSelectionModel().getSelectedItem();
            if (dadopessoalSelecionado!= null) {
                txtIdAtualizarFunc.setText(String.valueOf(dadopessoalSelecionado.getId()));
                txtEstadoCivilAtualizarFunc.setText(dadopessoalSelecionado.getEstadoCivil());
                txtConjugeAtualizarFunc.setText(dadopessoalSelecionado.getConjuge());
                txtDependentesAtualizarFunc.setText(dadopessoalSelecionado.getDependentes());
                txtEnderecoAtualizarFunc.setText(dadopessoalSelecionado.getEndereco());
;               txtTelefoneAtualizarFunc.setText(dadopessoalSelecionado.getTelefone());
                txtEmailAtualizarFunc.setText(dadopessoalSelecionado.getEmail());
                txtContatoEmergenciaAtualizarFunc.setText(dadopessoalSelecionado.getContatoEmergencia());

                tabPaneDadoPessoal.getSelectionModel().select(tabAtualizarDadoPessoal);
            }
        }
    


        private void carregarDadoPessoal() {
            listaDadoPessoal.clear();
            try (Connection conn = Database.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM dadospessoais")) {
    
                while (rs.next()) {
                    listaDadoPessoal.add(new DadoPessoal(rs.getInt("id"), rs.getString("nome_completo"), rs.getString("data_nascimento"), rs.getString("sexo"), rs.getString("estado_civil"), rs.getString("conjuge"), rs.getString("dependentes"), rs.getString("nacionalidade"), rs.getString("naturalidade"), rs.getString("cpf"), rs.getString("rg"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("email"), rs.getString("filiacao"), rs.getString("tipo_sanguineo"), rs.getString("contato_emergencia")));
                }
                tableDadoPessoal.setItems(listaDadoPessoal);
            } catch (SQLException e) {

                mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao carregar funcionários: " + e.getMessage());
        }
    }
        @FXML
    public void filtrarDadopessoal() {
        FilteredList<DadoPessoal> dadosFiltrados = new FilteredList<>(listaDadoPessoal, p -> true);

        dadosFiltrados.setPredicate(dadopessoal -> {
            if (!filtroNomeFunc.getText().isEmpty() && !dadopessoal.getNome().toLowerCase().contains(filtroNomeFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroDataNascimentoFunc.getText().isEmpty() && !dadopessoal.getDataNascimento().toLowerCase().contains(filtroDataNascimentoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroSexoFunc.getText().isEmpty() && !dadopessoal.getSexo().toLowerCase().contains(filtroSexoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroEstadoCivilFunc.getText().isEmpty() && !dadopessoal.getEstadoCivil().toLowerCase().contains(filtroEstadoCivilFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroConjugeFunc.getText().isEmpty() && !dadopessoal.getConjuge().toLowerCase().contains(filtroConjugeFunc.getText().toLowerCase())) {
                return false;
            }

            if (!filtroDependentesFunc.getText().isEmpty() && !dadopessoal.getDependentes().toLowerCase().contains(filtroDependentesFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroNacionalidadeFunc.getText().isEmpty() && !dadopessoal.getNacionalidade().toLowerCase().contains(filtroNacionalidadeFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroNaturalidadeFunc.getText().isEmpty() && !dadopessoal.getNaturalidade().toLowerCase().contains(filtroNaturalidadeFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroCpfFunc.getText().isEmpty() && !dadopessoal.getCpf().toLowerCase().contains(filtroCpfFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroRgFunc.getText().isEmpty() && !dadopessoal.getRg().toLowerCase().contains(filtroRgFunc.getText().toLowerCase())) {
                return false;
            }

            if (!filtroEnderecoFunc.getText().isEmpty() && !dadopessoal.getEndereco().toLowerCase().contains(filtroEnderecoFunc.getText().toLowerCase())) {
                return false;
            }
                
            if (!filtroTelefoneFunc.getText().isEmpty() && !dadopessoal.getTelefone().toLowerCase().contains(filtroTelefoneFunc.getText().toLowerCase())) {
                return false;

            }
            if (!filtroEmailFunc.getText().isEmpty() && !dadopessoal.getEmail().toLowerCase().contains(filtroEmailFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroFiliacaoFunc.getText().isEmpty() && !dadopessoal.getFiliacao().toLowerCase().contains(filtroFiliacaoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroTipoSanguineoFunc.getText().isEmpty() && !dadopessoal.getTipoSanguineo().toLowerCase().contains(filtroTipoSanguineoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroContatoEmergenciaFunc.getText().isEmpty() && !dadopessoal.getContatoEmergencia().toLowerCase().contains(filtroContatoEmergenciaFunc.getText().toLowerCase())) {
                return false;
            }

            return true;
        });

        tableDadoPessoal.setItems(dadosFiltrados);
        }
    
    @FXML
    public void limparFiltro() {
        filtroNomeFunc.clear();
        filtroDataNascimentoFunc.clear();
        filtroSexoFunc.clear();
        filtroEstadoCivilFunc.clear();
        filtroConjugeFunc.clear();
        filtroDependentesFunc.clear();
        filtroNacionalidadeFunc.clear();
        filtroNaturalidadeFunc.clear();
        filtroCpfFunc.clear();
        filtroRgFunc.clear();
        filtroEnderecoFunc.clear();
        filtroTelefoneFunc.clear();
        filtroEmailFunc.clear();
        filtroFiliacaoFunc.clear();
        filtroTipoSanguineoFunc.clear();
        filtroContatoEmergenciaFunc.clear();

        tableDadoPessoal.setItems(listaDadoPessoal);
    }


    @FXML
    public void excluirDadoPessoal(){
        DadoPessoal dadoPessoalSelecionado = tableDadoPessoal.getSelectionModel().getSelectedItem();
        if (dadoPessoalSelecionado != null) {
            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM dadopessoal WHERE id = ?")) {
                stmt.setInt(1, dadoPessoalSelecionado.getId());
                stmt.executeUpdate();
                carregarDadoPessoal();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário excluído com sucesso!");
                tabPaneDadoPessoal.getSelectionModel().select(tabListarDadoPessoal);
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










   

    




   

    

        

   

    
    

   
    

        

            
    

