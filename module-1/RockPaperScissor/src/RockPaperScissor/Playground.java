package RockPaperScissor;

public class Playground {
    public static void main(String[] args){

        //HandType currentHand = HandType.ROCK;


        Player p1 = new Player();
        p1.setName("Alberto");

        Player p2 = new Player();
        p2.setName("Albertina");

        Game game = new Game(p1, p2, 3);

        game.start();

    }
}