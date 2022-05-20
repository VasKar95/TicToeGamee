import java.util.*;

/**
 * This is a Tic Toe Game
 * @author Vasilis Karamanis
 * */

public class TicToeGame {
    /**
     * @param  player1Position represents the position of player1
     * @param  player2Position represents the position of player2
     *
     * */
    static ArrayList<Integer> player1Position=new ArrayList<Integer>();
    static ArrayList<Integer>player2Position=new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /**
         * @param board is 3x3 array and represents the choices of the two players.
         *              X for player 1
         *              and
         *              Y for player 2
         * */
        char[][] board=new char[3][3];

        /**
         * @param pos1 represents in which place player one wants to play
         * @param pos2 represents in which place player two wants to play
         *
         * */
        int pos1,pos2;

//represents the TicToe board
        TicTable(board);
        //while board cells are empty
        while (true) {

            //Player one choose where he wants to play
            while (true) {
                try {
                    System.out.println("Player 1 where you would like to play?Choose (1-9)");
                    pos1 = in.nextInt();
                    if(pos1<1||pos1>9){
                        System.out.println("Please insert a number between 1-9");
                    }else {
                        break;
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Please insert a number between 1-9");
                    in.nextLine();
                }
            }

            // we check if the array cell is null or contains other player choice
            while (player1Position.contains(pos1)||player2Position.contains(player1Position)){
                System.out.println("This position have been taken!! Enter another one");
                pos1=in.nextInt();
            }

            placeMove(board, pos1, "player1");

            String result=checkWinner();
            if(result.length()>9) {
                System.out.println(result);
                break;
            }
            //Player two choose where he wants to play
            while (true) {
                try {
                    System.out.println("Player 2 where you would like to play?Choose (1-9)");
                    pos2 = in.nextInt();

                    if(pos2<1||pos2>9){
                        System.out.println("Please insert a number between 1-9");
                    }else {
                        break;
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Please insert a number between 1-9");
                    in.nextLine();
                }
            }

            // we check if the array cell is null or contains other player choice
            while (player2Position.contains(pos2)||player1Position.contains(player2Position)){
                System.out.println("This position have been taken!! Enter another one");
                pos2=in.nextInt();
            }
            placeMove(board, pos2, "player2");
            TicTable(board);

            result=checkWinner();
            if(result.length()>9) {
                System.out.println(result);
                break;
            }
        }

    }

    /**we check all the possible winning moves,and we add them to list.
     * After, if one  of these moves happen
     * we say if we have and which is the winner.
     * After, we return the answer to the main*/
    public static String checkWinner(){
        //check which rows wins
        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List botRow= Arrays.asList(7,8,9);
        //check which columns wins
        List leftCol= Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List rightCol= Arrays.asList(3,6,9);
        //check which cross wins
        List cross1= Arrays.asList(1,5,7);
        List cross2= Arrays.asList(7,5,3);

        List<List>winning=new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l:winning){
            if(player1Position.containsAll(l)){
                return "Player 1 with X won!";
            }else  if(player2Position.containsAll(l)){
                return "Player 2 with Y won!";
            }else if(player1Position.size()+ player2Position.size()==9){
                return "No winner in this game ";
            }
        }
        return " ";
    }



    /**This method  connects array cells with a number from user input*/
    public static void placeMove(char[][] board,int pos,String user){
        char symbol=' ' ;
        if(user.equals("player1")){
            symbol='X';
            player1Position.add(pos);
        }else if (user.equals("player2")){
            symbol='O';
            player2Position.add(pos);
        }

        switch (pos) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("No valid letter");
                break;
        }
        TicTable(board);

    }

    /**
     * This method represents the Tic toe table outlook
     * */
    public static void TicTable(char[][] board){
        for(int i=0;i< board.length;i++){
            for (int j=0;j< board[i].length;j++){
                System.out.print("|"+board[i][j]+"  ");
            }
            System.out.println("| ");
            System.out.println("|---|---|---|");
        }
        System.out.println();
    }
}




