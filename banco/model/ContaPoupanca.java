public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimentoMensal;

    public ContaPoupanca(String numeroConta, String titular, double saldoInicial, double taxa){
        super(numeroConta, titular, saldoInicial);
        this.taxaRendimentoMensal = taxa;
    }

    public double calcularRendimento(){
        return this.saldo * this.taxaRendimentoMensal;
    }

    public void aplicarRendimento(){
        this.saldo += this.saldo * this.taxaRendimentoMensal;
        this.historico.add("Rendimento aplicado ao saldo.");
    }

    @Override
    abstract void gerarExtrato(){
        JOptionPane.showMessageDialog(null, "--------- Extrato ----------\n\n" + "Titular: " + getTitular() + "\nNúmero: " + getNumeroConta() + "\nSaldo" + getSaldo() + "\nTaxa de rendimento: " + this.taxaRendimentoMensal + "\nRendimento estimado: " + "\nHistórico: \n" + getHistorico());
    }
}