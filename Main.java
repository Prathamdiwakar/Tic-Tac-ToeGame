import java.util.*;
class tiktaktoe {
    static String[] board= new String[9];
   public static String turn;

    static String checkwinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[4] + board[8];
                    break;
                case 4:
                    line = board[0] + board[3] + board[6];
                    break;
                case 5:
                    line = board[1] + board[4] + board[7];
                    break;
                case 6:
                    line = board[2] + board[5] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        //
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 8) {
                return "draw";
            }
        }
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }

    static void printboard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2]+" | ");
        System.out.println("------------");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5]+" | ");
        System.out.println("------------");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8]+" | ");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        turn = "X";

        String winner = null;
        // for the index, store  in the array of string and its value
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
        System.out.println(" welcome to the tic-tac-toe game, you have to input X or O as an input, thank you play well");
        printboard();

        while (winner == null) {
            int inptnum;
            inptnum = sc.nextInt();
            try {
                if (!(inptnum > 0 && inptnum <= 9)) {
                    System.out.println("invalid input retry -again");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input retry -again");
                continue;
            }
            // to decide the turn of player
            // and reserved the number
            if (board[inptnum - 1].equals(String.valueOf(inptnum))) {
                board[inptnum - 1] = "turn";
            } else {
                System.out.println("Slot alraedy taken re-entry slot number");
            }
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
        printboard();
        winner = checkwinner();
    }
    if (winner.equalsIgnoreCase("Draw")) {
            System.out.println(" thanks for playing the game is drawn");
        } else {
            System.out.println(" congratulation, you won hurray");
        }
        sc.close();
    }
}