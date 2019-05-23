package edu.miracosta.finalprojecttest.model;
/**
 * Used to get an idea of how to build the game.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 5/22/19
 */

import java.util.Scanner;

import edu.miracosta.finalprojecttest.model.board_game.BoardGame;
import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.enviroment.Weather;
import edu.miracosta.finalprojecttest.model.player.Action;
import edu.miracosta.finalprojecttest.model.player.Damage;
import edu.miracosta.finalprojecttest.model.player.Player;
import edu.miracosta.finalprojecttest.model.player.Regeneration;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;

public class ConsoleTester {

    /**
     * How the program would run, assuming we were on regular java and not android
     * @param args - Allows for command lines of objects
     */
    public static void main(String[] args) {


        Player player = new Player();
        GameTime gameTime = new GameTime();
        Weather weather = new Weather();

        Scanner scan = new Scanner(System.in);

        String input;
        boolean running = true;

        System.out.println("WELCOME TO THE TESTER!");
        System.out.println(player.toString());
        System.out.println(player.inventoryToString());

        while (running) {

            //display gameTime
            System.out.println(gameTime.toString());

            //set the weather and display
            weather.calculateTemp(gameTime);
            System.out.println(weather.toString());

            //Display area details
            System.out.println(RUNNING_GAME_BOARD[player.getY()][player.getX()].toString());
            //If area has a fire, display its fuel
            if(RUNNING_GAME_BOARD[player.getY()][player.getX()].hasCampfire()) {
                System.out.println(RUNNING_GAME_BOARD[player.getY()][player.getX()].getCampFire().toString());
            }

            //take in input
            input = scan.nextLine();
            input.toLowerCase();

            //check input
            //check for movement
            if (input.equals("E") || input.equals("W") ||
                    input.equals("N") || input.equals("S")) {
                //move player
                //movePlayer(input, player, GAME_BOARD);
                movePlayerBoardPiece(input, player, RUNNING_GAME_BOARD);
            }
            //check for Action
            if (input.equals("firewood") || input.equals("harvest food") ||
                input.equals("start fire") || input.equals("collect water") ||
                input.equals("eat food") || input.equals("drink water")) {

                decideAction(input, player, gameTime);
            }
            //calc damage, if any
            Damage.damagePlayerSmall(player, weather , gameTime);
            //calc regen, if any
            Regeneration.regeneratePlayer(player);
            //display player stats
            System.out.println(player.toString());
            //display player inventory
            System.out.println(player.inventoryToString());
            //pass gameTime
            gameTime.passTime(GameTime.PASS_LRG);
            //update game board
            BoardGame.update();
        }



    }

    /**
     * Decides the action of the player based on input
     * @param input - the input the user made
     * @param player - The player playing the game
     * @param gameTime - The in-game timer
     */
    private static void decideAction(String input, Player player, GameTime gameTime) {
        String nullText = null;
        switch (input) {

            case "firewood":

                Action.getFireWood(player, RUNNING_GAME_BOARD, null);
                break;
            case "start fire":

                Action.startFire(player, gameTime, RUNNING_GAME_BOARD);
                break;
            case "harvest food":

                Action.harvestAnimal(player, RUNNING_GAME_BOARD, null);
                break;
            case "collect water":

                Action.collectWater(player, RUNNING_GAME_BOARD, null);
                break;
            case "drink water":

                Action.drinkWater(player, null);
                break;
            case "eat food":

                Action.eatFood(player, null);
                break;
            default:

                System.out.println("FATAL ERROR IN CONSOLE TESTER");
                System.out.println("EXITING PROGRAM");
                System.exit(0);
        }

    }

    /**
     * A method that would allow the player to move throughout the board
     * @param input - The input the user had made
     * @param player - The player the user is playing as
     * @param gameBoard - used to get the position of objects within the gameBoard
     */
    private static void movePlayerBoardPiece(String input, Player player, BoardPiece[][] gameBoard) {

        switch (input)
        {
            case "E":

                if (!gameBoard[player.getY()][player.getX() + 1].isAnObstacle())
                    player.setX(player.getX() + 1);
                break;

            case "W":

                if (!gameBoard[player.getY()][player.getX() - 1].isAnObstacle())
                    player.setX(player.getX() - 1);
                break;

            case "N":

                if (gameBoard[player.getY() - 1][player.getX()].isAnObstacle())
                    player.setY(player.getY() - 1);
                break;

            case "S":

                if (gameBoard[player.getY() + 1][player.getX()].isAnObstacle())
                    player.setY(player.getY() + 1);
                break;

            case "w":
                //wait and do nothing
                break;

            default:
                System.out.println("Sorry, that input was not understood. Try \"north\", \"south\", \"east\", \"west\", \"w\" ");
        }
    }

}
