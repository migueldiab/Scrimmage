package uy.yki.scrimmage.game;

import uy.yki.scrimmage.player.Player;
import uy.yki.scrimmage.world.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class Game {
    List<Player> players;

    public Game(int numPlayer) {
        players = new ArrayList<Player>(numPlayer);
        for (int i = 0; i < numPlayer; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Player " + i + " name : ");
            try{
                String name = br.readLine();
                Player aPlayer = new Player(name);
                players.add(aPlayer);
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadMap(Map newMap) {
    }
}
