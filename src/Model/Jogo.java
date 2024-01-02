package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

class Jogo {
    ArrayList<Carta> baralho;
    Stack<Carta> cartasMostradas;
    private int maxTentativas = 15;
    private int contadorCartasClicadas = 0;

    public Jogo(){
        while(true){
            printaBaralho();
            Carta carta1 = baralho.get(pedeCarta());
            Carta carta2 = baralho.get(pedeCarta());
            // Adiciona as cartas na pilha:
            cartasMostradas.push(carta1);
            cartasMostradas.push(carta2);

            if (verificaCartasIguais(carta1, carta2)){
                System.out.println("Você acertou um par de cartas!\n");
            }
            else{
                System.out.println("Você errou!");
                cartasMostradas.pop();
                cartasMostradas.pop();
            }
            
            if (cartasMostradas.size() == baralho.size()){
                System.out.println("VOCE GANHOU!");
                break;
            }
            else if (maxTentativas == 0){
                System.out.println("Voce perdeu :(");
                break;
            }
        }
    }

    public ArrayList<Carta> criaBaralho(){
        baralho = new ArrayList<Carta>();
        cartasMostradas = new Stack<Carta>();
        for(int j = 0; j<2; j++){
            for (int i = 0; i<Simbolos.values().length; i++){
                baralho.add(new Carta(Simbolos.values()[i]));
            }
        }
        Collections.shuffle(baralho);
        return baralho;
    }

    public void printaBaralho(){
        for (int i = 0; i< baralho.size(); i++){
            Carta carta = baralho.get(i);
            String msg = carta.getMostrada() == true? carta.getSimbolo().name() : "???";
            System.out.printf("%d => %s\n",i+1, msg);
        }
        System.out.println("--------------------------------------------");
    }

    public boolean verificaCartasIguais(Carta c1, Carta c2){
        return c1.getSimbolo() == c2.getSimbolo();
    }

    private void escondeCarta(Carta c){
        c.setMostrada(false);
        cartasMostradas.remove(c);
    }

    public int pedeCarta(){
        /** Funcao que retorna o numero da carta escolhida e a coloca como mostrada. */
        System.out.println("Escolha uma carta:");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (cartasMostradas.contains(baralho.get(num-1))){
            System.out.println("Carta já escolhida!\nEscolha uma carta:");
            scan = new Scanner(System.in);
            num = scan.nextInt();
        }
        return num-1;
    }
}
