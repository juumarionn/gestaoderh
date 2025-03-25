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
    @FXML private ComboBox<String> comboBoxSexo;
    @FXML private ComboBox<String> comboBoxEstadoCivil;
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
    @FXML private ComboBox<String>comboBoxtipo_sanguineoFunc;
    @FXML private TextField txtcontato_emergenciaFunc;

    @FXML private TextField txtcargo;
    @FXML private ComboBox<String> comboBoxdepartamento;
    @FXML private TextField txtfuncao;
    @FXML private TextField txtmaquinas;
    @FXML private TextField txtadmissao;
    @FXML private TextField txtsalario; 
    @FXML private TextField txtdadosbancarios;
    @FXML private TextField txtbeneficios;
    @FXML private TextField txtescolaridade;
    @FXML private TextField txtctps;
    @FXML private TextField txtpis;
    @FXML private ComboBox<String> comboBoxcontrato;
    @FXML private TextField txthorario;
    @FXML private TextField txtacidentes;
    @FXML private TextField txtadvertencias;


    @FXML private TextField txtIdAtualizarFunc;
    @FXML private TextField txtNomeAtualizarFunc;
    @FXML private TextField txtDataNascimentoAtualizarFunc;
    @FXML private ComboBox<String>comboBoxSexoAtualizarFunc;
    @FXML private ComboBox<String>comboBoxEstadoCivilAtualizarFunc;
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
    @FXML private ComboBox<String>comboBoxTipoSanguineoAtualizarFunc;
    @FXML private TextField txtContatoEmergenciaAtualizarFunc;

    @FXML private TextField txtcargoAtualizarFunc;
    @FXML private ComboBox<String> comboBoxdepartamentoAtualizarFunc;
    @FXML private TextField txtfuncaoAtualizarFunc;
    @FXML private TextField txtmaquinasAtualizarFunc;
    @FXML private TextField txtadmissaoAtualizarFunc;
    @FXML private TextField txtsalarioAtualizarFunc;
    @FXML private TextField txtdadosbancariosAtualizarFunc;
    @FXML private TextField txtbeneficiosAtualizarFunc;
    @FXML private TextField txtescolaridadeAtualizarFunc;
    @FXML private TextField txtctpsAtualizarFunc;
    @FXML private TextField txtpisAtualizarFunc;
    @FXML private ComboBox<String>comboBoxcontratoAtualizarFunc;
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
    @FXML private TableColumn<DadoProfissional, String> colNomeJun;
    @FXML private TableColumn<DadoProfissional, String> colCargo;
    @FXML private TableColumn<DadoProfissional, String> coldepartamento;
    @FXML private TableColumn<DadoProfissional, String> colFuncao;
    @FXML private TableColumn<DadoProfissional, String> colMaquinas;
    @FXML private TableColumn<DadoProfissional, String> colDataAdmissao;
    @FXML private TableColumn<DadoProfissional, String> colSalario;
    @FXML private TableColumn<DadoProfissional, String> colDadosBancarios;
    @FXML private TableColumn<DadoProfissional, String> colBeneficios;
    @FXML private TableColumn<DadoProfissional, String> colEscolaridade;
    @FXML private TableColumn<DadoProfissional, String> colCtps;
    @FXML private TableColumn<DadoProfissional, String> colPisPasep;
    @FXML private TableColumn<DadoProfissional, String> colContrato;
    @FXML private TableColumn<DadoProfissional, String> colHorario;
    @FXML private TableColumn<DadoProfissional, String> colAcidentes;
    @FXML private TableColumn<DadoProfissional, String> colAdvertencia;
   


    @FXML private TextField filtroNomeFunc;
    @FXML private TextField filtroDataNascimentoFunc;
    @FXML private ComboBox<String>filtroSexoFunc;
    @FXML private ComboBox<String>filtroEstadoCivilFunc;
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
    @FXML private ComboBox<String>filtroTipoSanguineoFunc;
    @FXML private TextField filtroContatoEmergenciaFunc;

    @FXML private TextField filtrocargo;
    @FXML private ComboBox<String>filtrodepartamento;
    @FXML private TextField filtrofuncao;
    @FXML private TextField filtromaquinas;
    @FXML private TextField filtroadmissao;
    @FXML private TextField filtrosalario;
    @FXML private TextField filtrodadosbancarios;
    @FXML private TextField filtrobeneficios;
    @FXML private TextField filtroescolaridade;
    @FXML private TextField filtroctps;
    @FXML private TextField filtropis;
    @FXML private ComboBox<String>filtrocontrato;
    @FXML private TextField filtrohorario;
    @FXML private TextField filtroacidentes;
    @FXML private TextField filtroadvertencias;

    @FXML private TabPane tabPaneRh;
    @FXML private Tab tabCadastro;
    @FXML private TabPane tabPaneCadastro;
    @FXML private Tab tabDadoPessoal;
    @FXML private Tab tabDadoProfissional;
    @FXML private TabPane tabPaneAtualizar;
    @FXML private Tab tabAtualizarPessoal;
    @FXML private Tab tabAtualizarProfissional;




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

        ObservableList<String> estadosCivis = FXCollections.observableArrayList(
            "Solteiro(a)",
            "Casado(a)",
            "Divorciado(a)",
            "Viúvo(a)",
            "Outro"
);
        comboBoxEstadoCivil.setItems(estadosCivis);

        ObservableList<String> sexos = FXCollections.observableArrayList(
        "Masculino",
        "Feminino",
        "Outro"
);
        comboBoxSexo.setItems(sexos);


        ObservableList<String> tiposSanguineos = FXCollections.observableArrayList(
            "A+",
            "A-",
            "B+",
            "B-",
            "AB+",
            "AB-",
            "O+",
            "O-"
 );
         comboBoxtipo_sanguineoFunc.setItems(tiposSanguineos);

    
            

        
    
        carregarDadoPessoal();

        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        coldepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        colFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        colMaquinas.setCellValueFactory(new PropertyValueFactory<>("maquinas"));
        colDataAdmissao.setCellValueFactory(new PropertyValueFactory<>("admissao"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        colDadosBancarios.setCellValueFactory(new PropertyValueFactory<>("dadosbancarios"));
        colBeneficios.setCellValueFactory(new PropertyValueFactory<>("beneficios"));
        colEscolaridade.setCellValueFactory(new PropertyValueFactory<>("escolaridade"));
        colCtps.setCellValueFactory(new PropertyValueFactory<>("ctps"));
        colPisPasep.setCellValueFactory(new PropertyValueFactory<>("pis"));
        colContrato.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        colHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));
        colAcidentes.setCellValueFactory(new PropertyValueFactory<>("acidentes"));
        colAdvertencia.setCellValueFactory(new PropertyValueFactory<>("advertencias"));

        ObservableList<String> departamentos = FXCollections.observableArrayList(
            "Automação",
            "Estoque",
            "Financeiro",
            "Manutenção",
            "Produção",
            "Rh"
    );
    
        comboBoxdepartamento.setItems(departamentos);



        ObservableList<String> contratos = FXCollections.observableArrayList(
            "Temporário",
            "CLT"
                
        );
        comboBoxcontrato.setItems(contratos);

              

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
private void salvarDadosProfissional() {
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO dadospessoais (nome_completo, data_nascimento, sexo, estado_civil, conjuge, dependentes, nacionalidade, naturalidade, cpf, rg, endereco, telefone, email, filiacao, tipo_sanguineo, contato_emergencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
         PreparedStatement stmt_1 = conn.prepareStatement("INSERT INTO dadosprofissionais (cargo, departamento, funcao, maquina_opera, admissao, salario, dados_bancarios, beneficios, escolaridade, ctps, pis_pasesp, contrato, horario_trabalho, acidentes, advertencias) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                
                stmt.setString(1, txtnome_completoFunc.getText());
                stmt.setString(2, txtdatanascimentoFunc.getText());
                stmt.setString(3, comboBoxSexo.getValue());
                stmt.setString(4, comboBoxEstadoCivil.getValue());
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
                stmt.setString(15, comboBoxtipo_sanguineoFunc.getValue());
                stmt.setString(16, txtcontato_emergenciaFunc.getText());
                stmt.executeUpdate();

                stmt_1.setString(1, txtcargo.getText());
                stmt_1.setString(2, comboBoxdepartamento.getValue());
                stmt_1.setString(3, txtfuncao.getText());
                stmt_1.setString(4, txtmaquinas.getText());
                stmt_1.setString(5, txtadmissao.getText());
                stmt_1.setString(6, txtsalario.getText());
                stmt_1.setString(7, txtdadosbancarios.getText());
                stmt_1.setString(8, txtbeneficios.getText());
                stmt_1.setString(9, txtescolaridade.getText());
                stmt_1.setString(10, txtctps.getText());
                stmt_1.setString(11, txtpis.getText());
                stmt_1.setString(12, comboBoxcontrato.getValue());
                stmt_1.setString(13, txthorario.getText());
                stmt_1.setString(14, txtacidentes.getText());
                stmt_1.setString(15, txtadvertencias.getText());
                stmt_1.executeUpdate();

                carregarDadoProfissional();
                carregarDadoPessoal();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário salvo com sucesso!");
        } catch (SQLException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    @FXML
private void salvarDadoPessoal() {
    tabPaneCadastro.getSelectionModel().select(tabDadoProfissional);
    }
            
    @FXML
    public void atualizarDadoProfissional() {
        
            int id = Integer.parseInt(txtIdAtualizarFunc.getText());
            String estadoCivil = comboBoxEstadoCivilAtualizarFunc.getValue();
            String conjuge = txtConjugeAtualizarFunc.getText();
            String dependentes = txtDependentesAtualizarFunc.getText();
            String endereco = txtEnderecoAtualizarFunc.getText();
            String telefone = txtTelefoneAtualizarFunc.getText();
            String email = txtEmailAtualizarFunc.getText();
            String contato_emergencia = txtContatoEmergenciaAtualizarFunc.getText();

            String cargo = txtcargoAtualizarFunc.getText();
            String departamento = comboBoxdepartamentoAtualizarFunc.getValue();
            String funcao = txtfuncaoAtualizarFunc.getText();
            String maquinas = txtmaquinasAtualizarFunc.getText();
            String salario = txtsalarioAtualizarFunc.getText();
            String dadosbancarios = txtdadosbancariosAtualizarFunc.getText();
            String beneficios = txtbeneficiosAtualizarFunc.getText();                
            String escolaridade = txtescolaridadeAtualizarFunc.getText();
            String contrato = comboBoxcontratoAtualizarFunc.getValue();
            String horario = txthorarioAtualizarFunc.getText();
            String acidentes = txtacidentesAtualizarFunc.getText();
            String advertencias = txtadvertenciasAtualizarFunc.getText();


            try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE dadospessoais SET estado_civil = ?, conjuge = ?, dependentes = ?, endereco = ?, telefone = ?, email = ?, contato_emergencia = ? WHERE id = ?");
                PreparedStatement statement_1 = connection.prepareStatement("UPDATE dadosprofissionais SET cargo = ?, departamento = ?, funcao = ?,maquinas = ?, salario = ?, dadosbancarios = ?, beneficios = ?, escolaridade = ?, contrato = ?, horario = ?, acidentes = ?, advertencias = ?  WHERE id = ?")) {
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
              
                   statement_1.setString(1, cargo);
                   statement_1.setString(2, departamento);
                   statement_1.setString(3, funcao);
                   statement_1.setString(4, maquinas);
                   statement_1.setString(5, salario);
                   statement_1.setString(6, dadosbancarios);
                   statement_1.setString(7, beneficios);
                   statement_1.setString(8, escolaridade);
                   statement_1.setString(9, contrato);
                   statement_1.setString(10, horario);
                   statement_1.setString(11, acidentes);
                   statement_1.setString(12, advertencias);
                   statement_1.executeUpdate();
                   carregarDadoProfissional();

            
                mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário atualizado com sucesso!");
            } catch (SQLException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao atualizar funcionário: " + e.getMessage());
            }
    }

    
        @FXML private void atualizarDadoPessoal() {
    tabPaneAtualizar.getSelectionModel().select(tabAtualizarProfissional);
    }

            
        @FXML
        private void limparCamposAtualizacao() {
            txtIdAtualizarFunc.clear();
            comboBoxEstadoCivilAtualizarFunc.setValue(null);
            txtConjugeAtualizarFunc.clear();
            txtDependentesAtualizarFunc.clear();
            txtEnderecoAtualizarFunc.clear();
            txtTelefoneAtualizarFunc.clear();
            txtEmailAtualizarFunc.clear();
            txtContatoEmergenciaAtualizarFunc.clear();

           
        
       
           
            txtcargoAtualizarFunc.clear();
            comboBoxdepartamentoAtualizarFunc.setValue(null);
            txtfuncaoAtualizarFunc.clear();
            txtmaquinasAtualizarFunc.clear();
            txtsalarioAtualizarFunc.clear();
            txtdadosbancariosAtualizarFunc.clear();
            txtbeneficiosAtualizarFunc.clear();
            txtescolaridadeAtualizarFunc.clear();
            comboBoxcontratoAtualizarFunc.setValue(null);
            txthorarioAtualizarFunc.clear();
            txtacidentesAtualizarFunc.clear();
            txtadvertenciasAtualizarFunc.clear();

           
        }
    
    
        private void preencherCamposAtualizacao() {
            DadoPessoal dadopessoalSelecionado = tableDadoPessoal.getSelectionModel().getSelectedItem();
            if (dadopessoalSelecionado!= null) {
                txtIdAtualizarFunc.setText(String.valueOf(dadopessoalSelecionado.getId()));
                comboBoxEstadoCivilAtualizarFunc.setValue(dadopessoalSelecionado.getEstado_civil());
                txtConjugeAtualizarFunc.setText(dadopessoalSelecionado.getConjuge());
                txtDependentesAtualizarFunc.setText(dadopessoalSelecionado.getDependentes());
                txtEnderecoAtualizarFunc.setText(dadopessoalSelecionado.getEndereco());
                txtTelefoneAtualizarFunc.setText(dadopessoalSelecionado.getTelefone());
                txtEmailAtualizarFunc.setText(dadopessoalSelecionado.getEmail());
                txtContatoEmergenciaAtualizarFunc.setText(dadopessoalSelecionado.getContato_emergencia());

            }
    

            DadoProfissional dadoprofissionalSelecionado = tableDadoProfissional.getSelectionModel().getSelectedItem();
            if (dadoprofissionalSelecionado!= null) {
                txtcargoAtualizarFunc.setText(dadoprofissionalSelecionado.getCargoFunc());
                comboBoxdepartamentoAtualizarFunc.setValue(dadoprofissionalSelecionado.getDepartamento());
                txtfuncaoAtualizarFunc.setText(dadoprofissionalSelecionado.getFuncao());
                txtmaquinasAtualizarFunc.setText(dadoprofissionalSelecionado.getMaquina_opera());
                txtsalarioAtualizarFunc.setText(dadoprofissionalSelecionado.getSalario());
                txtdadosbancariosAtualizarFunc.setText(dadoprofissionalSelecionado.getDados_bancarios());
                txtbeneficiosAtualizarFunc.setText(dadoprofissionalSelecionado.getBeneficios());
                txtescolaridadeAtualizarFunc.setText(dadoprofissionalSelecionado.getEscolaridade());
                comboBoxcontratoAtualizarFunc.setValue(dadoprofissionalSelecionado.getContrato());
                txthorarioAtualizarFunc.setText(dadoprofissionalSelecionado.getHorario_trabalho());
                txtacidentesAtualizarFunc.setText(dadoprofissionalSelecionado.getAcidentes());
                txtadvertenciasAtualizarFunc.setText(dadoprofissionalSelecionado.getAdvertencia());




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
                    ResultSet rs = stmt.executeQuery("SELECT * FROM dadosprofissionais")) {

                    while (rs.next()) {
                        listaDadoProfissional.add(new DadoProfissional (rs.getInt("id"), rs.getString("cargo"), rs.getString("departamento"), rs.getString("funcao"), rs.getString("maquinas"), rs.getString("admissao"), rs.getString("salario"), rs.getString("dadosbancarios"), rs.getString("beneficios"), rs.getString("escolaridade"), rs.getString("ctps"), rs.getString("pis"), rs.getString("contrato"), rs.getString("horario"), rs.getString("acidentes"), rs.getString("advertencias")));
                    }
                    tableDadoProfissional.setItems(listaDadoProfissional);
                } catch (SQLException e) {

                    mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao carregar funcionários: " + e.getMessage());
            }
        }

        @FXML public void filtrarDadopessoal() {
        FilteredList<DadoPessoal> dadosFiltrados = new FilteredList<>(listaDadoPessoal, p -> true);

        dadosFiltrados.setPredicate(dadopessoal -> {
            if (!filtroNomeFunc.getText().isEmpty() && !dadopessoal.getNome_completo().toLowerCase().contains(filtroNomeFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroDataNascimentoFunc.getText().isEmpty() && !dadopessoal.getData_nascimento().toLowerCase().contains(filtroDataNascimentoFunc.getText().toLowerCase())) {
                return false;
            }
            if (!filtroSexoFunc.getValue().isEmpty() && !dadopessoal.getSexo().toLowerCase().contains(filtroSexoFunc.getValue().toLowerCase())) {
                return false;
            }
            if (!filtroEstadoCivilFunc.getValue().isEmpty() && !dadopessoal.getEstado_civil().toLowerCase().contains(filtroEstadoCivilFunc.getValue().toLowerCase())) {
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
            if (!filtroTipoSanguineoFunc.getValue().isEmpty() && !dadopessoal.getTipo_sanguineo().toLowerCase().contains(filtroTipoSanguineoFunc.getValue().toLowerCase())) {
                return false;
            }
            if (!filtroContatoEmergenciaFunc.getText().isEmpty() && !dadopessoal.getContato_emergencia().toLowerCase().contains(filtroContatoEmergenciaFunc.getText().toLowerCase())) {
                return false;
            }

            return true;
        });

        tableDadoPessoal.setItems(dadosFiltrados);
    }

        @FXML
        public void filtrarDadoProfissional() {
            FilteredList<DadoProfissional> dadosFiltrados = new FilteredList<>(listaDadoProfissional, p -> true);
    
            dadosFiltrados.setPredicate(DadoProfissional -> {
                if (!filtrocargo.getText().isEmpty() && !DadoProfissional.getCargoFunc().toLowerCase().contains(filtrocargo.getText().toLowerCase())) {
                    return false;
                }
                if (!filtrodepartamento.getValue().isEmpty() && !DadoProfissional.getDepartamento().toLowerCase().contains(filtrodepartamento.getValue().toLowerCase())) {
                    return false;
                }
                if (!filtrofuncao.getText().isEmpty() && !DadoProfissional.getFuncao().toLowerCase().contains(filtrofuncao.getText().toLowerCase())) {
                    return false;
                }
                if (!filtromaquinas.getText().isEmpty() && !DadoProfissional.getMaquina_opera().toLowerCase().contains(filtromaquinas.getText().toLowerCase())) {
                    return false;
                }
                if (!filtroadmissao.getText().isEmpty() && !DadoProfissional.getAdmissao().toLowerCase().contains(filtroadmissao.getText().toLowerCase())) {
                    return false;
                }
                if (!filtrosalario.getText().isEmpty() && !DadoProfissional.getSalario().toLowerCase().contains(filtrosalario.getText().toLowerCase())) {
                    return false;
                }
                if (!filtrodadosbancarios.getText().isEmpty() && !DadoProfissional.getDados_bancarios().toLowerCase().contains(filtrodadosbancarios.getText().toLowerCase())) {
                    return false;
                }
                if (!filtrobeneficios.getText().isEmpty() && !DadoProfissional.getBeneficios().toLowerCase().contains(filtrobeneficios.getText().toLowerCase())) {
                    return false;
                }
                if (!filtroescolaridade.getText().isEmpty() && !DadoProfissional.getEscolaridade().toLowerCase().contains(filtroescolaridade.getText().toLowerCase())) {
                    return false;
                }
                if (!filtroctps.getText().isEmpty() && !DadoProfissional.getCtps().toLowerCase().contains(filtroctps.getText().toLowerCase())) {
                    return false;
                }
    
                if (!filtropis.getText().isEmpty() && !DadoProfissional.getpis_pasesp().toLowerCase().contains(filtropis.getText().toLowerCase())) {
                    return false;
                }
                    
                if (!filtrocontrato.getValue().isEmpty() && !DadoProfissional.getContrato().toLowerCase().contains(filtrocontrato.getValue().toLowerCase())) {
                    return false;
                }
                if (!filtrohorario.getText().isEmpty() && !DadoProfissional.getHorario_trabalho().toLowerCase().contains(filtrohorario.getText().toLowerCase())) {
                    return false;
                }
                if (!filtroacidentes.getText().isEmpty() && !DadoProfissional.getAcidentes().toLowerCase().contains(filtroacidentes.getText().toLowerCase())) {
                    return false;
                }
                if (!filtroadvertencias.getText().isEmpty() && !DadoProfissional.getAdvertencia().toLowerCase().contains(filtroadvertencias.getText().toLowerCase())) {
                    return false;
                }
                
    
                return true;
            });
    
            tableDadoProfissional.setItems(dadosFiltrados);
        }

    
    @FXML
    public void limparFiltro() {
        filtroNomeFunc.clear();
        filtroDataNascimentoFunc.clear();
        filtroSexoFunc.setValue(null);
        filtroEstadoCivilFunc.setValue(null);
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
        filtroTipoSanguineoFunc.setValue(null);
        filtroContatoEmergenciaFunc.clear();

        tableDadoPessoal.setItems(listaDadoPessoal);

        filtrocargo.clear();
        filtrodepartamento.setValue(null);
        filtrofuncao.clear();
        filtromaquinas.clear();
        filtroadmissao.clear();
        filtrosalario.clear();
        filtrodadosbancarios.clear();
        filtrobeneficios.clear();
        filtroescolaridade.clear();
        filtroctps.clear();
        filtropis.clear();
        filtrocontrato.setValue(null);
        filtrohorario.clear();
        filtroacidentes.clear();
        filtroadvertencias.clear();
       

        tableDadoProfissional.setItems(listaDadoProfissional);
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
               
            } catch (SQLException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao excluir funcionário: " + e.getMessage());
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um funcionário para excluir!");
        }
    }

    @FXML
    public void excluirDadoProfissional(){
        DadoProfissional DadoProfissionalSelecionado = tableDadoProfissional.getSelectionModel().getSelectedItem();
        if (DadoProfissionalSelecionado != null) {
            try (Connection conn = Database.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM DadoProfissional WHERE id = ?")) {
                stmt.setInt(1, DadoProfissionalSelecionado.getIdprof());
                stmt.executeUpdate();
                carregarDadoProfissional();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Funcionário excluído com sucesso!");
                
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
        alerta.showAndWait();;
    }
}











   

    




   

    

        

   

    
    

   
    

        

            
    

