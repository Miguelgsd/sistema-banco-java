package banco.model;

import javax.swing.JOptionPane;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequEspecial;

    public ContaCorrente(String numeroConta, String titular, double saldoInicial, double limite){
        super(numeroConta, titular, saldoInicial)
        this.limiteChequEspecial = limite;
    }

    @Override
    public void sacar(double valor){
        if(valor > this.saldoInicial){
            this.historico.add("Cheque especial em uso.");
            if(valor <= this.limiteChequEspecial){
                this.saldoInicial -= valor;
                this.limiteChequEspecial += this.saldoInicial;
                this.saldoInicial = 0.0;
                JOptionPane.showMessageDialog(null, "Você está utilizando seu cheque especial", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.saldoInicial -= valor;
            }
        }
    }

    public void usarChequeEspecial(double valor){
        if(valor <= this.limiteChequEspecial){
            this.limiteChequEspecial -= valor;
        } else {
            JOptionPane.showMessageDialog(null, "Valor do cheque insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void exibirHistorico(){
        StringBuilder history = new StringBuilder();
        history.append("--------- Histórico ---------\n\n");

        for(String evento : this.historico){
            history.append(evento).append("\n");
        }
    }

    public double getLimite(){
        return this.limiteChequEspecial;
    }

    @Override
    abstract void gerarExtrato(){
        JOptionPane.showMessageDialog(null, "-------- Extrato -----------\n\nTitular: " + getTitular() + "\nNúmeroda conta: " + getNumeroConta() + "\nSaldo: " getSaldo() + "\nLimite especial: " + getLimite() + "\nHistórico: \n" + getHistorico(), "Extrato da Conta", JOptionPane.INFORMATION_MESSAGE);
    }
}