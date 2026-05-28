public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimentoMensal;

    public ContaPoupanca(String numeroConta, String titular, double saldoInicial, double taxa){
        super(numeroConta, titular, saldoInicial);
        this.taxaRendimentoMensal = taxa;
    }
}