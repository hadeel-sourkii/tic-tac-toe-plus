import java.util.InputMismatchException;
import java.util.Scanner;

public class X_O_Plus {

    static String blattform[][];
    static Scanner Sc;
    static String exchange;


    static void printBoard() {
        System.out.println("     1   2   3   ");
        System.out.println("   |---+---+---|");
        System.out.println(" 1 | " + blattform[0][0] + " | " + blattform[0][1] + " | " + blattform[0][2] + " |");
        System.out.println("   |---+---+---|");
        System.out.println(" 2 | " + blattform[1][0] + " | " + blattform[1][1] + " | " + blattform[1][2] + " |");
        System.out.println("   |---+---+---|");
        System.out.println(" 3 | " + blattform[2][0] + " | " + blattform[2][1] + " | " + blattform[2][2] + " |");
        System.out.println("    ---+---+---\n");
    }

    static void populateEmptyBoard() {
        for (int a = 0; a < blattform.length; a++) {
            for (int j = 0; j < blattform.length; j++) {
                blattform[a][j] = "+";
            }
        }
    }

    static String checkWinner() {
        for (int a = 0; a < 8; a++)
        {
            String line = null;
            switch (a) {
                case 0:
                    line = blattform[0][0] + blattform[0][1] + blattform[0][2];
                    break;
                case 1:
                    line = blattform[1][0] + blattform[1][1] + blattform[1][2];
                    break;
                case 2:
                    line = blattform[2][0] + blattform[2][1] + blattform[2][2];
                    break;
                case 3:
                    line = blattform[0][0] + blattform[1][0] + blattform[2][0];
                    break;
                case 4:
                    line = blattform[0][1] + blattform[1][1] + blattform[2][1];
                    break;
                case 5:
                    line = blattform[0][2] + blattform[1][2] + blattform[2][2];
                    break;
                case 6:
                    line = blattform[0][0] + blattform[1][1] + blattform[2][2];
                    break;
                case 7:
                    line = blattform[0][2] + blattform[1][1] + blattform[2][0];
                    break;
            }

            int countX = 0;
            int countO = 0;
            for (int i = 0; i < line.length(); i += 2) {
                if (line.charAt(i) == 'X')
                {
                    countX++;
                    if (countX == 3)
                    {
                        return "X";
                    }

                } else if (line.charAt(i) == 'O') {
                    countO++;
                    if (countO == 3) {
                        return "O";
                    }
                } else continue;
            }
        }
        for (int i = 0; i < blattform.length; i++) {
            for (int j = 0; j < blattform.length; j++) {
                if (blattform[i][j].equals("+")) {
                    break;
                } else if (i == 2 && j == 2) return "draw";
            }
        }
        System.out.println("  enter number to place " + exchange + " in:");
        return null;

    }
    public static void main(String[] args) {

        Sc = new Scanner(System.in);
        exchange = "X";
        blattform = new String[3][3];
        String winner = null;
        populateEmptyBoard();
        // x0 x1 x2  o0  o 1  o2
        int xo[] = {0, 0, 0, 0, 0, 0};


        System.out.println("--**Get started tic tac toe Game!!**--");
        System.out.println();
        printBoard();
        System.out.println("choose a row and a clumen to place X : ");
        while (winner == null) {

            int rowinput;
            int culmeninput;
            int wert;
            try {
                System.out.print("please enter row and culmen");
                rowinput = Sc.nextInt();
                culmeninput = Sc.nextInt();
                System.out.print("please enter wert ");
                wert = Sc.nextInt();


                if (!(rowinput > 0 && rowinput <= 3) || !(culmeninput > 0 && culmeninput <= 3) || !(wert > -1 && wert < 3)) {

                    System.out.println("non-existed number .. retry again!!:");
                    continue;

                }
            } catch (InputMismatchException e) {
                System.out.println("non-existed number .. retry again!!:");
                continue;
            }
            if (blattform[rowinput - 1][culmeninput - 1].equals("+")) {


                if (exchange.equals("X"))
                {
                    if (xo[wert]<2)
                    {
                        blattform[rowinput-1][culmeninput-1] = exchange +String.valueOf(wert) ;
                        xo[wert] += 1;
                        exchange = "O";
                    }
                    else
                    {System.out.println(exchange +wert+" have been used more than 2 times");}
                }
                else {
                    if (xo[wert+2]<2)
                    {
                        blattform[rowinput-1][culmeninput-1] = exchange +String.valueOf(wert) ;
                        xo[wert + 3] += 1;
                        exchange = "X";
                    }
                    else System.out.println( exchange +wert+"have been used");
                }

                printBoard();
                winner = checkWinner();
            }
            else if (blattform[rowinput - 1][culmeninput - 1].equals("X0"))
            {
                if (wert > 0)
                {
                    if (exchange.equals("O"))
                    {
                        if (xo[wert + 3] < 2)
                        {

                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert + 3] += 1;
                            exchange = "X";
                        }
                        else System.out.print("X " + wert + "have been used ");
                    }
                    else
                    {
                        if (xo[wert] < 2)
                        {
                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert] += 1;
                            exchange = "O";
                        }
                        else System.out.print("X " + wert + "have been used ");
                    }
                }


                printBoard();
                winner = checkWinner();
                System.out.println(exchange + wert + "invalid!!");
            }
            else if (blattform[rowinput - 1][culmeninput - 1].equals("X1")) {
                if (wert > 1) {
                    if (exchange.equals("O")) {
                        if (xo[wert + 3] < 2)
                        {

                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert + 3] += 1;
                            exchange = "X";
                        }
                        else System.out.print("X " + wert + "have been used ");
                    } else
                    {

                        if (xo[wert] < 2)
                        {
                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert] += 1;
                            exchange = "O";
                        }
                        else System.out.print("X " + wert + "have been used ");
                    }
                }

                printBoard();
                winner = checkWinner();
                System.out.println(exchange + wert + "ist nicht grosser als X1");
            }
            else if (blattform[rowinput - 1][culmeninput - 1].equals("O0")) {
                if (wert > 0)
                {
                    if (exchange.equals("X"))
                    {
                        if (xo[wert] < 2) {

                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert] += 1;
                            exchange = "O";
                        }
                        else System.out.print("X " + wert + "have been used ");

                    }
                    else
                    {
                        if (xo[wert+3] < 2)
                        {
                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert + 3] += 1;
                            exchange = "X";
                        } else System.out.print("O " + wert + "have been used ");
                    }
                }

                printBoard();
                winner = checkWinner();
                System.out.println(exchange + wert + "is not bigger than O0");
            }
            else if (blattform[rowinput - 1][culmeninput - 1].equals("O1"))
            {
                if (wert > 1) {
                    if (exchange.equals("X"))
                    {
                        if (xo[wert] < 2)
                        {

                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert] += 1;
                            exchange = "O";
                        }
                        else System.out.print("X " + wert + "have been used ");

                    } else
                    {
                        if (xo[wert+3] < 2)
                        {
                            blattform[rowinput - 1][culmeninput - 1] = exchange + String.valueOf(wert);
                            xo[wert + 3] += 1;
                            exchange = "X";
                        }
                        else System.out.print("O " + wert + "have been used ");
                    }
                }

                printBoard();
                winner = checkWinner();
                System.out.println(exchange + wert + "ist not bigger than O1");
            } else {
                System.out.println("is  already taken.. re-enter slot number:");
                continue;
            }

        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! ..try again");
        } else {
            System.out.println("Congrats! " + winner + "have won!");
        }


    }
}

