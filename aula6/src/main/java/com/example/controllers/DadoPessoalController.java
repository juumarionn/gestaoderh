package com.example.controllers;

import com.example.database.Database;
import com.example.models.DadoPessoal;
import com.example.models.DadoProfissional;
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



    @FXML private TabPane tabPaneDadoPessoal;
    @FXML private Tab tabCadastrarDadoPessoal;
    @FXML private Tab tabAtualizarDadoPessoal;
    @FXML private Tab tabListarDadoPessoal;

    @FXML private TabPane tabPaneDadoProfissional;
    @FXML private Tab tabCadastrarDadoProfissional;
    @FXML private Tab tabAtualizarDadoProfissional;
    @FXML private Tab tabListarDadoProfissional;


    private ObservableList<DadoPessoal> listaDadoPessoal = FXCollections.observableArrayList();
    private ObservableList<DadoProfissional> listaDadoProfissional = FXCollections.observableArrayList();


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
    
    


    tableDadoPessoal.setOnMouseClicked((MouseEvent event) -> {
        if (event.getClickCount() > 1) {
            preencherCamposAtualizacao();
        }
    });

    tableDadoProfissional.setOnMouseClicked((MouseEvent event) -> {
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

    private void carregarDadoProfissional() {
        listaDadoProfissional.clear();
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DadoProfissional")) {

            while (rs.next()) {
                listaDadoProfissional.add(new DadoProfissional (rs.getInt("id"), rs.getString("cargo"), rs.getString("departamento"), rs.getString("funcao"), rs.getString("maquinas"), rs.getString("admissao"), rs.getString("salario"), rs.getString("dadosbancarios"), rs.getString("beneficios"), rs.getString("escolaridade"), rs.getString("ctps"), rs.getString("pis"), rs.getString("contrato"), rs.getString("horario"), rs.getString("acidentes"), rs.getString("advertencias")));
            }
            tableDadoProfissional.setItems(listaDadoProfissional);
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










   

    




   

    

        

   

    
    

   
    

        

            
    

