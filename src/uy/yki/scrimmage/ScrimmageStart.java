package uy.yki.scrimmage;

import uy.yki.scrimmage.game.Game;
import uy.yki.scrimmage.world.Map;
import uy.yki.scrimmage.world.Zone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: migueldiab@gmail.com
 * Date: 05/03/2015
 */

public class ScrimmageStart {
    private static ScrimmageStart instance;

    private ScrimmageStart() {
        System.out.println("Welcome to Scrimmage");
    }

    public static synchronized ScrimmageStart getInstance() {
        if (null == instance) {
            instance = new ScrimmageStart();
        }
        return instance;
    }

    public static void main(String [] args) {
        ScrimmageStart start = ScrimmageStart.getInstance();
        System.out.print("Number of Players (1-6): ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String s = br.readLine();
            int i = Integer.parseInt(s);
            start.startGame(i);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame(int players) {
        System.out.println("Playing with " + players + " players");
        Game aGame = new Game(players);
        Map newMap = createStubMap();
        aGame.loadMap(newMap);

    }

    private Map createStubMap() {
        Map map = new Map("Westeros");
        Zone bayOfIce = new Zone("Bay of Ice", null, null, 0, 0, false);
        Zone castleBlack = new Zone("Castle Black", null, null, 0, 1, true);
        Zone winterfell = new Zone("Winterfell", null, null, 0, 1, true);

        return map;
    }
}
