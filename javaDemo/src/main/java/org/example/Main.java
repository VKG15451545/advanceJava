package org.example;

import org.example.games.Game;
import org.example.games.GameName;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Want to Play Game ! Press 'y' ");
        String s = sc.next();
        boolean gameContinued = false;
        if(s.equals("y")){
            gameContinued = true;
        }
        while (gameContinued ){
            playGame(sc);
            System.out.println("Thank you for playing ! want to continue . press 'y' ");
            String usrRes = sc.next();
            if(!usrRes.equals("y")){
                gameContinued = false;
            }
        }
        System.out.println("Game End here. ");
    }
    public static void playGame(Scanner sc){
        System.out.println("select the games !");
        GameName.printAllGames();
        Long gameCode = sc.nextLong();
        Game game = GameName.getGameByGameId(gameCode);
        game.start(sc);
    }
}
