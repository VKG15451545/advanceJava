package org.example.games;

import org.example.games.allGames.MagicSquare;
import org.example.games.allGames.SudokuSolver;

public enum GameName {
    MAGIC_SQUARE(1L,"magicSquare",new MagicSquare()),
    SUDOKU_SOLVER(2L,"sudokuSolver",new SudokuSolver());
    private final Long id;
    private final String name;
    private final Game game;

    public Game getGame() {
        return game;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    GameName(long id, String name, Game game) {
        this.id = id;
        this.name = name;
        this.game = game;
    }

    public static void printAllGames(){
        for (GameName game : GameName.values()){
            System.out.println(game.getId()+":"+game.name);
        }
    }
    public static Game getGameByGameId(Long id){
        if(id==null) return null;
        for (GameName enumGame : GameName.values()){
            if(id.equals(enumGame.getId())){
                return enumGame.getGame();
            }
        }
        return null;
    }

}
