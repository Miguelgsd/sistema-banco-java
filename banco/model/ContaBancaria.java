package banco.model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public abstract class ContaBancaria {
    private String numeroConta;
    private Cliente titular;
    private double saldo;
    private ArrayList<String> historico;

    public ContaBancaria(String numero, Cliente titular, double saldo){
        this.numeroConta = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.historico = new ArrayList<>();
    }

    public void depositar(double valor){
        String horario = LocalDateTime.now().toString();
        this.saldo += valor;
        this.historico.add(horario + " - Valor depositado: " + valor);
    }

    public void sacar(double valor){
        if(this.saldo <= valor){
            String horario = LocalDateTime.now().toString();
            this.saldo -= valor;
            this.historico.add(horario + " - Valor retirado: " + valor);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente. Verifique seu saldo e tente novamente", "Erro", JOptionPane.ERROR_MESSAGE); 
            }
    }

    public void exibirSaldo(){
        String formatado = String.format("%.2f", this.saldo);
        JOptionPane.showMessageDialog(null, "Saldo atual: R$" + formatado);
    }

    protected void registrarTransacao(String descricao){
        String horario = LocalDateTime.now().toString();
        this.historico.add(horario + " - " + descricao);
    }

    public void exibirHistorico(){
        StringBuilder history = new StringBuilder();
        history.append("--------- Histórico ---------\n\n");

        for(String evento : this.historico){
            history.append(evento).append("\n");
        }

        JOptionPane.showMessageDialog(null, history.toString(), "Histórico da Conta", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setNumeroConta(String numero){
        this.numeroConta = numero;
    }

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public void setTitular(String titular){
        this.titular = titular;
    }

    public String getTitular(){
        return this.titular;
    }

    public void setSaldo(String saldo){
        this.saldo = saldo;
    }

    public String getSaldo(){
        return this.saldo;
    }

    public void setHistorico(String historico){
        this.historico = historico;
    }

    public String getHistorico(){
        return this.historico;
    }

    abstract void gerarExtrato();
}