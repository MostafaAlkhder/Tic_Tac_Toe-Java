package tictactoe_x;

import java.util.Scanner;
import java.util.List;


/**
 *
 * @author Dallal, Z
 */
public class GamePlay {

    TicTac_X_Board board = new TicTac_X_Board(3);

    public void gameOn() {
        System.out.println(board);
        while (true) {
            System.out.println("************USER************");
            getUserMove();
            System.out.println(board);
            if (board.isLoseOnLastMove()) {
                System.out.println("Computer Wins");
                break;
            }
            System.out.println("************Computer************");
            getComputerMove();
            System.out.println(board);
            if (board.isLoseOnLastMove()) {
                System.out.println("User Wins");
                break;
            }
        }

    }

    private void getUserMove() {
        Scanner s = new Scanner(System.in);
        int row;
        while (true) {
            System.out.print("Enter row: ");
            row = s.nextInt();
            System.out.println();
            if ((row > 0) && (row < board.getWidth() + 1)) {
                break;
            }
        }
        int col;
        while (true) {
            System.out.print("Enter column: ");
            col = s.nextInt();
            System.out.println();
            if ((col > 0) && (col < board.getWidth() + 1)) {
                break;
            }
        }

        board.play(row - 1, col - 1);
    }

    public static void main(String[] args) {
        GamePlay g = new GamePlay();
        g.gameOn();
    }

    private void getComputerMove() {
        board = board.getAllNextBoards().get(0);

//        board = maxMove(board).get???;
    }

    private List<Object> maxMove(TicTac_X_Board b) {
		// the fuction returns list of object the first object is the evaluation (type Integer), the second is the state with the max evaluation
//         ************** YOUR CODE HERE ************            \\
        return null;
    }

    private List<Object> minMove(TicTac_X_Board b) {
		// the fuction returns list of object the first object is the evaluation (type Integer), the second is the state with the min evaluation
//         ************** YOUR CODE HERE ************            \\
        return null;
    }

}
