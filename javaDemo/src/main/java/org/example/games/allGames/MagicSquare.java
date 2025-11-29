package org.example.games.allGames;

import org.example.games.Game;
import org.example.games.commonMethods.PrintAnyArray;

import java.util.Scanner;

public class MagicSquare implements Game {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int size;

    public static void printMagicSquare(Integer k){
        if(k%2==0){
            System.out.println("Invalid Square Size Given");
            return;
        }
        Integer[][] grid = new Integer[k][k];
        int st_c = k/2;
        int st_r = 0;
        int counter = 2;
        grid[st_r][st_c] = 1;
        while(counter <= k*k){
            st_c++;
            st_r--;
            if(st_r <0 && st_c>=k){
                st_r = 1;
                st_c = k-1;
                grid[st_r][st_c]=counter;
            }
            else if(st_r <0){
                st_r = k-1;
                grid[st_r][st_c] = counter;
            }
            else if(st_c>=k){
                st_c=0;
                grid[st_r][st_c]=counter;
            }
            else{
                if(grid[st_r][st_c] != null){
                    st_r = st_r+2;
                    st_c = st_c-1;
                }
                grid[st_r][st_c] = counter;
            }
            counter++;
        }
        PrintAnyArray.print2DArray(grid);
    }

    @Override
    public void start(Scanner sc) {
        System.out.println("Starting Magic Square: ");
        System.out.println("enter a magic Square Size: ");
        Integer s = sc.nextInt();
        try {
            printMagicSquare(s);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Run any Other Game");
        }
    }
}
