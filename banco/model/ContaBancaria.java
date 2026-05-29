package banco.model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import banco.interfaces.Operavel;

public abstract class ContaBancaria implements Operavel {
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

    public boolean sacar(double valor){
        if(this.saldo >= valor){
            String horario = LocalDateTime.now().toString();
            this.saldo -= valor;
            this.historico.add(horario + " - Valor retirado: " + valor);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente. Verifique seu saldo e tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
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

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setHistorico(ArrayList<String> historico){
        this.historico = historico;
    }

    public ArrayList<String> getHistorico(){
        return this.historico;
    }

    public abstract void gerarExtrato();
}