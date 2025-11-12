package principal.dados;
import java.util.Vector;

public class Banco {
    private Vector<Conta> contas;
    private String nome;
    
    public Banco(String nome){
        this.nome = nome;
        contas = new Vector<Conta>();
    }

    public String getNome(){
        return this.nome;
    }
    
    public Vector<Conta> getConta(){
        return this.contas;
    }
    
    public void adicionarConta(Conta conta){
        contas.add(conta);
    }
    
    public void imprimirExtrato(){
        System.out.println("----- Extrato do banco " + this.nome + " -----\n");
        for(Conta c: contas){
            c.imprimirExtrato();
        }
    }
}
