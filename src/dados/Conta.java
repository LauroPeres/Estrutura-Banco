package principal.dados;
import java.util.Vector;

public class Conta {
    private String Cliente;
    private float Saldo;
    private String Endereco;
    private Vector<String>dados;

    public Conta(String cliente, float saldo){
        this.Cliente = cliente;
        this.Saldo = saldo;
        this.Endereco = "Ainda nao registrado";
        dados = new Vector<String>();
    }

    public String getCliente(){
        return this.Cliente;
    }

    public String getEndereco(){
        return this.Endereco;
    }

    public void depositar(float valor){
        this.Saldo = this.Saldo + valor;
        armazenarExtratoRetiradaDeposito(this, valor, 0); //Int 0 indica deposito
    }

    public void retirar(float valor){
        this.Saldo = this.Saldo - valor;
        armazenarExtratoRetiradaDeposito(this, valor, 1); //Int 1 indica retirada
    }

    public void transferir(Conta conta, float valor){
        this.Saldo = this.Saldo - valor;
        conta.Saldo = conta.Saldo + valor;
        armazenarExtratoTransferencia(this, conta, valor);
    }

    public void armazenarExtratoRetiradaDeposito(Conta conta, float valor, int tipo){
        if(tipo == 0) { //deposito
            dados.add(conta.Cliente + " fez um deposito de " + valor + " Reais");
        }
        else{ //retirada
            dados.add(conta.Cliente + " fez uma retirada de " + valor + " Reais");
        }
    }
    public void armazenarExtratoTransferencia(Conta depositou, Conta recebeu, float valor){
        this.dados.add(depositou.Cliente + " fez uma transferencia de " + valor + " Reais para "+ recebeu.Cliente);
        recebeu.dados.add(recebeu.Cliente + " recebeu um deposito de " + depositou.Cliente + " de " + valor + " Reais ");
    }

    public void imprimirExtrato(){
        System.out.println("----- Extrato de " + this.Cliente + " -----");
        for(String texto: dados){
            System.out.println(texto);
        }
        System.out.println("-> Saldo total = " + this.Saldo + "\n");
    }
}