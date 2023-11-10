package trabalho_imc;
import java.util.Scanner;

import trabalho_imc.entities.Pessoa;
import trabalho_imc.entities.erro.Numeronegativo;

public class IMC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Boolean loop = true;

        while(loop){
            // Repete o código até que a variavel loop tenha o valor de falso
        
            try{
                // Testa o código que esta dentro das chaves caso tenha o erro marcado no "catch" é redirecionado para la
                System.out.print("Qual seu peso?(kg) [Ex: 60.0] ");
                String kg = sc.nextLine();

                if(kg.contains("-")){
                    throw new Numeronegativo("Por favor informe apenas número positivos");
                }
                
                String[] peso1 = kg.split(" ");
                // Separa os valores da variavel "kg" em diferentes vetores cada vez que tiver um espaço
                Double peso = Double.parseDouble(peso1[0].replace(",", "."));
                // Converte o primeiro valor da variavel "peso1" para Double e troca a "," por um "."
                
                System.out.print("Qual sua altura?(m) [Ex: 1.80] ");
                String tamanho = sc.nextLine();

                if(tamanho.contains("-")){
                    throw new Numeronegativo("Por favor informe apenas número positivos");
                }

                String[] altura1 = tamanho.split(" ");
                // Separa os valores da variavel "tamanho" em diferentes vetores cada vez que tiver um espaço
                Double altura = Double.parseDouble(altura1[0].replace(",", "."));
                // Converte o primeiro valor da variavel "altura1" para Double e troca a "," por um "."

                Pessoa pessoa = new Pessoa(peso, altura);
                // Puxa o valor das variaveis "peso, altura" da class pessoa

                System.out.printf("Seu imc é: %.2f %n", pessoa.calcularImc());
                // Puxa o valor da variavel "calcularImc" que esta na class pessoa


                if (pessoa.calcularImc() <= 18.5 ) {
                    System.out.println("Você esta abaixo do peso.");
                } else if (pessoa.calcularImc() > 18.5 && pessoa.calcularImc() <= 24.9 ) {
                System.out.println("Você esta com o peso normal."); 
                } else if (pessoa.calcularImc() > 24.9 && pessoa.calcularImc() <= 29.9) {
                System.out.println("Você esta com sobre peso.");
                } else if (pessoa.calcularImc() > 29.9 && pessoa.calcularImc() <= 34.9) {
                    System.out.println("Você tem Obesidade grau I");
                } else if (pessoa.calcularImc() > 34.9 && pessoa.calcularImc() <=39.9) {
                    System.out.println("Você tem Obesidade grau II");
                } else if (pessoa.calcularImc() > 40) {
                System.out.println("Você tem Obesidade grau III");
                }
                // Compara o valor da variavel "calcularImc" com os valores da tabela imc

                loop = false;
            }catch(Numeronegativo e){
                // Caso ocorra o erro marcado executa oque esta dentro das chaves do "catch"
                System.out.println(e.getMessage());
            }catch(NumberFormatException e){
                // Caso ocorra o erro marcado executa oque esta dentro das chaves do "catch"
                System.out.println("Por favor informe apenas números! [Não deixe em branco]");
            }

        }

        sc.close();
        
    }

}
