package principal.teste;
import principal.dados.*;

public class TestesManuais{
    public static void main(String[] args) {
        System.out.println("Iniciando testes manuais do sistema bancário...\n");

        
        Banco itau = new Banco("Itaú");
        Banco bb = new Banco("Banco do Brasil");

        Conta joao = new Conta("João", 500);
        Conta maria = new Conta("Maria", 1000);
        Conta ana = new Conta("Ana", 0);
        Conta carlos = new Conta("Carlos", 50);

        itau.adicionarConta(joao);
        itau.adicionarConta(maria);
        bb.adicionarConta(ana);
        bb.adicionarConta(carlos);

        joao.depositar(250);
        maria.depositar(500);
        ana.depositar(100);
        maria.retirar(200);
        carlos.retirar(30);
        maria.transferir(joao, 100); 
        joao.transferir(maria, 50);  
        carlos.transferir(ana, 10);  
        
        joao.imprimirExtrato();
        maria.imprimirExtrato();
        ana.imprimirExtrato();
        carlos.imprimirExtrato();

        itau.imprimirExtrato();
        bb.imprimirExtrato();
    }
}