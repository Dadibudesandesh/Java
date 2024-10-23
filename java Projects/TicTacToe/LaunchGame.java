import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    static char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }

    public void initBoard() { // this method for initialize blank board (3 rows X 3 columns).
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static public void displayBoard() { // this method for the displaying broard of the tic tac toe game.
        System.out.println(" -------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println(" -------------");

        }
    }

    static public void placeMark(int row, int column, char mark) { // this method for the user given position row and
                                                                   // column formate this position place the mark.
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            board[row][column] = mark;
        } else {
            System.out.println("Invalid Position.....");
        }
    }

    static public boolean checkColWin() { // this method for when player mark repeated three times in column then find
                                          // and this is a win or return a column win true value.
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    static public boolean checkRowWin() { // this methd for the check player mark in row they are same in three times
                                          // then return true.
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    static public boolean checkDiagoWin() { // this method for when player mark and then diagonal repeadedly three times
                                            // then return true.
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
                || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;

    }

    static public boolean checkDraw() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}

abstract class Player {
    String name;
    char mark;

    abstract void makeMove();

    public boolean isValid(int row, int col) { // this method for when player can give the position in row and column
                                               // formate so this is valid or not this is check this method if valid
                                               // then return true.
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (TicTacToe.board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }
}

class AIPlayer extends Player {

    public AIPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public void makeMove() {
        Random random = new Random();
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        if (isValid(row, col)) {
            TicTacToe.placeMark(row, col, mark);
        } else {
            System.out.println("Enter valid move....");
            makeMove();
        }
    }
}

class HumanPlayer extends Player {
    public HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public void makeMove() { // this method for make the move means assign the mark as a given position.
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Position (Row and Column) : ");
        int row = scan.nextInt();
        int col = scan.nextInt();
        if (isValid(row, col)) {
            TicTacToe.placeMark(row, col, mark);
        } else {
            System.out.println("Enter valid move....");
            makeMove();
        }
    }

}

public class LaunchGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToe ttt = new TicTacToe();
        Player p1 = new HumanPlayer("Sandesh", 'X');
        Player p2 = new HumanPlayer("samii", 'O'); // when you can play with human then you can create another object of
                                                   // the humanPlayer class.
        // Player p2 = new AIPlayer("AI", 'O'); // this object is a AI , so
        // automatically they are make move or give the inputs.
        System.out.println("Mark of " + p1.name + " is : " + p1.mark);
        System.out.println("Mark of " + p2.name + " is : " + p2.mark);
        System.out.println("\n\nLet's Start....");
        ttt.displayBoard();
        Player cp = p1;

        while (true) {
            System.out.println(cp.name + " Turn");
            cp.makeMove();
            TicTacToe.displayBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkDiagoWin() || TicTacToe.checkRowWin()) { // here are we can
                                                                                                   // check the win
                                                                                                   // situations and
                                                                                                   // then change the
                                                                                                   // player turn.
                System.out.println(cp.name + " Won The Match");
                break;
            } else if (TicTacToe.checkDraw()) {
                System.out.println("Game was Draw....!");
                break;
            } else {
                if (cp == p1) {
                    cp = p2;
                } else {
                    cp = p1;
                }
            }

        }

        // I N S E R T I N T O C O L U M N

        // ttt.placeMark(0, 0, 'X');
        // ttt.placeMark(1, 0, 'X');
        // ttt.placeMark(2, 0, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkColWin());
        // ttt.placeMark(0, 1, 'X');
        // ttt.placeMark(1, 1, 'X');
        // ttt.placeMark(2, 1, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkColWin());
        // ttt.placeMark(0, 2, 'X');
        // ttt.placeMark(1, 2, 'X');
        // ttt.placeMark(2, 2, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkColWin());

        // I N S E R T I N T O R O W O R C H E C K W I N O R N O T

        // ttt.placeMark(0, 0, 'X');
        // ttt.placeMark(0, 1, 'X');
        // ttt.placeMark(0, 2, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkRowWin());
        // ttt.placeMark(1, 0, 'X');
        // ttt.placeMark(1, 1, 'X');
        // ttt.placeMark(1, 2, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkRowWin());
        // ttt.placeMark(2, 0, 'X');
        // ttt.placeMark(2, 1, 'X');
        // ttt.placeMark(2, 2, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkRowWin());

        // D I A G O N A L C H E C K

        // ttt.placeMark(0, 0, 'X');
        // ttt.placeMark(1, 1, 'X');
        // ttt.placeMark(2, 2, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkDiagoWin());
        // ttt.placeMark(0, 2, 'X');
        // ttt.placeMark(1, 1, 'X');
        // ttt.placeMark(2, 0, 'X');
        // ttt.displayBoard();
        // System.err.println(ttt.checkDiagoWin());

    }
}