package tictactoe_x;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dallal, Z
 */
public class TicTac_X_Board {

    private int width = 3;

    private char[][] board;

    private int last_move_r = -1;
    private int last_move_c = -1;

    public TicTac_X_Board(int width) {
        this.width = width;
        board = new char[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public TicTac_X_Board(TicTac_X_Board state) {
        this.width = state.width;
        board = new char[width][width];
        for (int i = 0; i < width; i++) {
            System.arraycopy(state.board[i], 0, board[i], 0, width);
        }

    }

    public int getWidth() {
        return this.width;
    }

    public void play(int x, int y) {
        if (board[x][y] == ' ') {
            board[x][y] = 'X';
        }
        this.last_move_r = x;
        this.last_move_c = y;
    }

    public List<TicTac_X_Board> getAllNextBoards() {
        List<TicTac_X_Board> nextBoards = new LinkedList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == ' ') {
                    TicTac_X_Board nextBoard = new TicTac_X_Board(this);
                    nextBoard.play(i, j);
                    nextBoards.add(nextBoard);
                }
            }
        }
        return nextBoards;
    }

    public int eval() {
        /*    your code here
        write a function to evaluate the state for a computer
        this fucntion should return a low value if the last move results in loss
        
        and an evalutation for the state that estimates the "goodness" of the state
        (the heigher value the better the state)
        
        for this week only: make the function return a low value if it results in
        loss and 0 otherwise (since you can't evalute a win case unless it happens)

         */
        return 0;
    }

    public boolean isLoseOnLastMove() {
        int row = this.last_move_r;
        int col = this.last_move_c;
        //check row
        List<Character> collected_row = new LinkedList<>();
        for (int c = 0; c < width; c++) {
            collected_row.add(board[row][c]);
        }
        if (all_X(collected_row)) {
            return true;
        }
        //check row
        List<Character> collected_col = new LinkedList<>();
        for (int r = 0; r < width; r++) {
            collected_col.add(board[r][col]);
        }
        if (all_X(collected_col)) {
            return true;
        }
        // check diag 1
        if (row == col) {
            List<Character> collected_d1 = new LinkedList<>();
            for (int i = 0; i < width; i++) {
                collected_d1.add(board[i][i]);
            }
            if (all_X(collected_d1)) {
                return true;
            }
        }

        // check diag 2
        if (row == (width - (col + 1))) {
            List<Character> collected_d1 = new LinkedList<>();
            for (int i = 0; i < width; i++) {
                collected_d1.add(board[i][width - (i + 1)]);
            }
            if (all_X(collected_d1)) {
                return true;
            }
        }
        return false;
    }

    private boolean all_X(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 'X') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < width; i++) {
            sb.append(i+1);
            sb.append(" | ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("\n");
        sb.append("   ");
        for (int i = 0; i < width; i++) {
            sb.append("....");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("\n");
        for (int i = 0; i < width; i++) {
            sb.append(i+1);
            sb.append(": ");
            for (int j = 0; j < width; j++) {
                sb.append(board[i][j]);
                sb.append(" | ");
            }
            sb.delete(sb.length() - 2, sb.length() - 1);
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        TicTac_X_Board board = new TicTac_X_Board(3);
//        board.play(1, 1);
//        board.play(0, 1);
//        board.play(2, 2);
//        System.out.println(board);
//        boolean val = board.isLoseOnLastMove();
//        System.out.println(val);
//
//        List<State> next = board.getAllNextBoards();
//        int i = 1;
//        for (TicTac_X_Board b : next) {
//            System.out.println(i + ": (" + b.eval() + ")");
//            System.out.println(b);
//            val = b.isLoseOnLastMove();
//            System.out.println(val);
//            i++;
//        }
    }
}
