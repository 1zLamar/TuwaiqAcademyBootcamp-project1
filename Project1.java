import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Project1 {
    static final int boardSize = 3;
    static final char space = ' ';
    static final char player = 'X';
    static final char computer = 'O';
    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        Scanner S = new Scanner(System.in);

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = space;
            }
        }

        drawBoard(board);

        while (!isFinish()) {

            int choice = 0;
            int row = 0;
            int col = 0;

            try {
                System.out.println("Where do you want to play? (1-9)");
                choice = S.nextInt();
                row = (choice - 1) / boardSize;
                col = (choice - 1) % boardSize;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                S.next();
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

            if (canPlay(row, col)) {
                board[row][col] = player;
                drawBoard(board);
            } else {
                System.out.println(choice + " is not a valid move");
                continue;
            }

            if (isWin(row, col, player)) {
                System.out.println("You won!!!!");
                break;
            }

            if (isFinish()) {
                break;
            }

            // computer's play
            int[] computerMove = computer();
            board[computerMove[0]][computerMove[1]] = computer;
            // row index          /col index
            int number = computerMove[0] * 3 + computerMove[1] + 1;
            System.out.println("Computer chose " + number);
            drawBoard(board);

            if (isWin(computerMove[0], computerMove[1], computer)) {
                System.out.println("Computer wins!");
                break;
            }
        }
    }

    public static boolean isFinish() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == space) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWin(int row, int col, char contain) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            throw new IllegalArgumentException("Invalid input");
        }
        // check row
        for (int i = 0; i < boardSize; i++) {
            if (board[row][i] != contain) {
                break;
            }
            if (i == boardSize - 1) {
                return true;
            }
        }

        // check column
        for (int i = 0; i < boardSize; i++) {
            if (board[i][col] != contain) {
                break;
            }
            if (i == boardSize - 1) {
                return true;
            }
        }
        //\
        if (row == col) {
            for (int i = 0; i < boardSize; i++) {
                if (board[i][i] != contain) {
                    break;
                }
                if (i == boardSize - 1) {
                    return true;
                }
            }
        }
        ///
        if (row + col == boardSize - 1) {
            for (int i = 0; i < boardSize; i++) {
                if (board[i][boardSize - 1 - i] != contain) {
                    break;
                }
                if (i == boardSize - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canPlay(int row, int col) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            return false;
        }
        return board[row][col] == space;
    }

    public static int[] computer() {
        Random random = new Random();
        int row = 0, col = 0;

        do {
            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);
        } while (!canPlay(row, col));

        return new int[] { row, col };
    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if (j != boardSize - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != boardSize - 1) {
                System.out.println("-+-+-");
            }
        }
    }
}