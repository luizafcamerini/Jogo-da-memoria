package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Jogo {
    ArrayList<Carta> baralho;
    ArrayList<Carta> cartasDescobertas;
    ArrayList<Carta> cartasMostradas;
    private int maxTentativas = 15;

    public Jogo(){
        baralho = criaBaralho();
        while(true){
            printaBaralho();
            Carta carta1 = baralho.get(pedeCarta());
            mostraCarta(carta1);
            Carta carta2 = baralho.get(pedeCarta());
            mostraCarta(carta2);

            if (verificaCartasIguais(carta1, carta2)){
                System.out.println("Você acertou um par de cartas!\n");
                Collections.addAll(cartasDescobertas, carta1, carta2);
            }
            else{
                System.out.println("Você errou!");
                escondeCarta(carta2);
                escondeCarta(carta1);
            }
            
            if (cartasDescobertas.size() == baralho.size()){
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
        cartasDescobertas = new ArrayList<Carta>();
        cartasMostradas = new ArrayList<Carta>();
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

    private boolean verificaCartasIguais(Carta c1, Carta c2){
        return c1.getSimbolo() == c2.getSimbolo();
    }

    private void mostraCarta(Carta c){
        c.setMostrada(true);
        cartasMostradas.add(c);
        printaBaralho();
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
