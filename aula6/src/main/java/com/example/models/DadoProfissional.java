package com.example.models;

public class DadoProfissional {
    private Integer idprof;
    private String cargo;
    private String departamento;
    private String funcao;
    private String maquina_opera;
    private String admissao;
    private String salario;
    private String dados_bancarios;
    private String beneficios;
    private String escolaridade;
    private String ctps;
    private String pis_pasep;
    private String contrato;
    private String horario_trabalho;
    private String acidentes;
    private String advertencias;

    public DadoProfissional(Integer idprof, String cargo, String departamento, String funcao,  String maquina_opera, String admissao, String salario, String dados_bancarios, String beneficios,
    String escolaridade, String ctps, String pis_pasep, String contrato, String horario_trabalho, String acidentes, String advertencias) {
        this.idprof = idprof;
        this.cargo = cargo;
        this.departamento = departamento;
        this.funcao = funcao;
        this.maquina_opera = maquina_opera;
        this.admissao = admissao;
        this.salario = salario;
        this.dados_bancarios = dados_bancarios;
        this.beneficios = beneficios;
        this.escolaridade = escolaridade;
        this.ctps = ctps;
        this.pis_pasep = pis_pasep;
        this.contrato = contrato;
        this.horario_trabalho = horario_trabalho;
        this.acidentes = acidentes;
        this.advertencias = advertencias;

}

public int getIdprof() {
    return idprof;
}
public void setIdprof(int idprof){
    this.idprof = idprof;
}

public String getCargoFunc() {
    return cargo;
}

public void setCargoFunc(String cargo){
    this.cargo = cargo;
}

public String getDepartamento() {
    return departamento;
}
public void setDepartamento(String departamento){
    this.departamento = departamento;
}

public String getFuncao() {
    return funcao;
}
public void setFuncao(String funcao){
    this.funcao = funcao;
}

public String getMaquina_opera() {
    return maquina_opera;
}
public void setMaquina_opera(String maquina_opera){
    this.maquina_opera = maquina_opera;
}

public String getAdmissao(){
    return admissao;
}
public void setAdmissao(String admissao){
    this.admissao = admissao;
}

public String getSalario() {
    return salario;
}
public void setSalario(String salario){
    this.salario = salario;
}

public String getDados_bancarios() {
    return dados_bancarios;
}
public void setDados_bancarios(String dados_bancarios){
    this.dados_bancarios = dados_bancarios;
}

public String getBeneficios() {
    return beneficios;
}
public void setBeneficios(String beneficios){
    this.beneficios = beneficios;
}

public String getEscolaridade() {
    return escolaridade;
}
public void setEscolaridade(String escolaridade){
    this.escolaridade = escolaridade;
}

public String getCtps() {
    return ctps;
}
public void setCtps(String ctps){
    this.ctps = ctps;
}

public String getpis_pasesp() {
    return pis_pasep;
}
public void setPis_pasesp(String pis_pasesp){
    this.pis_pasep = pis_pasesp;
}

public String getContrato() {
    return contrato;
}
public void setContrato(String contrato){
    this.contrato = contrato;
}

public String getHorario_trabalho() {
    return horario_trabalho;
}
public void setHorario_trabalho(String horario_trabalho){
    this.horario_trabalho = horario_trabalho;
}

public String getAcidentes() {
    return acidentes;
}
public void setAcidentes(String acidentes){
    this.acidentes = acidentes;
}

public String getAdvertencia() {
    return advertencias;
}
public void setAdvertencias(String advertencias){
    this.advertencias = advertencias;
}

}
