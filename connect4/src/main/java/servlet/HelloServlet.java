package servlet;

import java.io.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
)
public class HelloServlet extends HttpServlet {
    private static String[][] counters = new String[7][6]; //array to store code for counters
    private static char[][] players = new char[7][6]; //array to store where players have played counters
    private static int rows = 6;
    private static int cols = 7;
    private static int turn = 0;
    private static String player = "Player1"; //stores which player's turn it is
    private final char player1 = '1';
    private final char player2 = '2';
    private static String allCounters = ""; //stores Strings for the codes of the counters
    private int col;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        if (req.getParameter("username")!=null){ //checks for username given for leaderboard to update
            FileReader leaderboard = new FileReader("leaderboard.txt");
            Scanner ls = new Scanner(leaderboard);
            boolean newName = true;
            String text = "";
            while(ls.hasNextLine()){
                String curLine = ls.nextLine();
                String[] line = curLine.split("-");
                String num = line[1].replace("<br>","");
                if(line[0].equals(req.getParameter("username"))){ //checks if name already exists
                    newName= false;
                    int wins = Integer.parseInt(num)+1;
                    String newLine = curLine.replaceAll(num,Integer.toString(wins));
                    text = text+newLine+"\n";
                }
                else{
                    text = text+curLine+"\n";
                }
            }
            FileWriter writer = new FileWriter("leaderboard.txt");
            writer.write(text); //updates leaderboard
            writer.close();
            if(newName){ //checks for new name
                FileWriter writer1 = new FileWriter("leaderboard.txt",true);
                writer1.append(req.getParameter("username")+"-1<br>\n"); //adds new name to leaderboard
                writer1.close();
            }
            resetGame(players,counters);
        }
        FileReader mainFile = new FileReader("main_page.txt"); //file has javascript code for main page
        Scanner s = new Scanner(mainFile);
        Path l_file = Path.of("leaderboard.txt"); //file has leaderboard
        String leaderboard = Files.readString(l_file);
        if(turn==0){ //checks if no one has played yet
            while(s.hasNextLine()){
                out.write(s.nextLine().replace("%Player%",player).replace("%%",allCounters).replace("Leaderboard: ",leaderboard));
                out.write("\n");
            }
            turn = 1;
        }else {
            while (true) { //validates input
                try {
                    col = Integer.parseInt(req.getParameter("column"));
                    break;
                } catch (Exception e) {
                }
            }
            if (counters[col - 1][rows - 1] != null) {
                while (s.hasNextLine()) { //checks if column chosen is full
                    out.write(s.nextLine().replace("%Player%", "Column is full " + player).replace("%%", allCounters).replace("Leaderboard: ", leaderboard));
                    out.write("\n");
                }
            } else {
                for (int j = 0; j < rows; j++) { //adds new counter
                    if (counters[col - 1][j] == null) {
                        if (player.equals("Player1")) {
                            counters[col - 1][j] = "ctx.beginPath();\nctx.arc(" + ((col - 1) * 100 + 53) + ", " + (615 - (j * 100) - 60) + ", 45, 0, 2 * Math.PI);\nctx.fillStyle = \"yellow\";\nctx.fill();\nctx.stroke();";
                            players[col - 1][j] = player1;
                        } else {
                            counters[col - 1][j] = "ctx.beginPath();\nctx.arc(" + ((col - 1) * 100 + 53) + ", " + (615 - (j * 100) - 60) + ", 45, 0, 2 * Math.PI);\nctx.fillStyle = \"red\";\nctx.fill();\nctx.stroke();";
                            players[col - 1][j] = player2;
                        }
                        allCounters = allCounters + counters[col - 1][j] + "\n";
                        break;
                    }
                }
                if (isWinner(player1, players)) { //checks if player1 has won
                    while (s.hasNextLine()) {
                        out.write(s.nextLine().replace("%Player%", player).replace("%%", allCounters).replace("var win = 0;", "ctx.font = \"90px Fantasy,Copperplate Gold\";\nctx.fillStyle = \"SpringGreen\"\nctx.fillText(\"Winner - Player 1!\", 30, 308);").replace("which column would you like to play in", "what is your name").replace("<input type=\"number\" max=\"7\" min=\"1\" name=\"column\">", "<input type=\"text\" name=\"username\" required>").replace("Column:", "").replace("Leaderboard: ", leaderboard));
                        out.write("\n");
                    }
                } else if (isWinner(player2, players)) { //checks if player2 has won
                    while (s.hasNextLine()) {
                        out.write(s.nextLine().replace("%Player%", player).replace("%%", allCounters).replace("var win = 0;", "ctx.font = \"90px Fantasy,Copperplate Gold\";\nctx.fillStyle = \"SpringGreen\"\nctx.fillText(\"Winner - Player 2!\", 30, 308);").replace("which column would you like to play in", "what is your name").replace("<input type=\"number\" max=\"7\" min=\"1\" name=\"column\">", "<input type=\"text\" name=\"username\" required>").replace("Column:", "").replace("Leaderboard: ", leaderboard));
                        out.write("\n");
                    }
                    System.out.println(req.getParameter("username"));
                } else if (turn == 42) { //checks if grid is full
                    while (s.hasNextLine()) {
                        out.write(s.nextLine().replace("%Player%", player).replace("%%", allCounters).replace("var win = 0;", "ctx.font = \"90px Fantasy,Copperplate Gold\";\nctx.fillStyle = \"SpringGreen\"\nctx.fillText(\"It's a draw!\", 30, 308);").replace("Leaderboard: ", leaderboard));
                        out.write("\n");
                    }
                } else {
                    if (player.equals("Player1")) { //switches player each turn
                        player = "Player2";
                    } else {
                        player = "Player1";
                    }
                    while (s.hasNextLine()) {
                        out.write(s.nextLine().replace("%Player%", player).replace("%%", allCounters).replace("Leaderboard: ", leaderboard));
                        out.write("\n");
                    }
                }
            }
            turn = turn + 1;
        }
    }
    public static boolean isWinner(char player,char[][] players){
        for(int i = 0; i<cols; i++){  //check for 4 horizontal
            for (int j = 0;j < rows - 3;j++){
                if (players[i][j] == player   &&
                        players[i][j+1] == player &&
                        players[i][j+2] == player &&
                        players[i][j+3] == player){
                    return true;
                }
            }
        }
        for(int i = 0; i < cols - 3; i++){ //check for 4 vertical
            for(int j = 0; j < rows; j++){
                if (players[i][j] == player   &&
                        players[i+1][j] == player &&
                        players[i+2][j] == player &&
                        players[i+3][j] == player){
                    return true;
                }
            }
        }
        for(int i = 3; i < cols; i++){  //check for 4 upward diagonal
            for(int j = 0; j < rows - 3; j++){
                if (players[i][j] == player   &&
                        players[i-1][j+1] == player &&
                        players[i-2][j+2] == player &&
                        players[i-3][j+3] == player){
                    return true;
                }
            }
        }
        for(int i = 0; i < cols - 3; i++){  //check for 4 downward diagonal
            for(int j = 0; j < rows - 3; j++){
                if (players[i][j] == player   &&
                        players[i+1][j+1] == player &&
                        players[i+2][j+2] == player &&
                        players[i+3][j+3] == player){
                    return true;
                }
            }
        }
        return false;
    }
    public static void resetGame(char[][] players,String[][] counters){ //resets game
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                players[i][j] = ' ';
            }
        }
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                counters[i][j] = null;
            }
        }
        player = "Player1";
        allCounters = "";
        turn = 0;
    }


}