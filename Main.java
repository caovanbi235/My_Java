import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TTT game = new TTT();
		game.initializeBoard();
		System.out.println("Tic-Tac-Toe");
		do
		{
			System.out.println("Current board layout:");
			game.printBoard();
			int row;
			int col;
			do
			{
				System.out.println("Player " + Character.toUpperCase(game.getCurrentPlayerMark()) +
						" , enter and empty row and column to place your mark!");
				row = sc.nextInt() - 1;
				col = sc.nextInt() - 1;
			}
			while (!game.placeMark(row, col));
			game.changePlayer();
		}
		while (!game.checkForWin() && !game.isBoardFull());
		
		if (game.isBoardFull() && !game.checkForWin())
		{
			System.out.println("Current board layout:");
			game.printBoard();
			System.out.println("The game was tie");
		}
		else
		{
			System.out.println("Current board layout:");
			game.printBoard();
			game.changePlayer();
			System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");
		}
		sc.close();
	}
}
