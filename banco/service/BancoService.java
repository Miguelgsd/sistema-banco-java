package banco.service;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoService{
    private List<ContaCorrente> contasCorrentes;
    private List<ContaPoupanca> contasPoupanca;

    public void cadastrarContaCorrente(ContaCorrente cc){
        this.contasCorrentes.add(cc);
    }

    public void cadastrarContaPoupanca(ContaPoupanca cp){
        this.contasPoupanca.add(cp);
    }

    public ContaBancaria buscarConta(String numeroConta){
        
    }
}