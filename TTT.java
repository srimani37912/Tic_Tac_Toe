package TicTacToe;
import java.util.*;

public class TTT {

	public static void main(String[] args) {
		//setting up the board
		char[][] board = new char[3][3];
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[row].length;col++) {
				board[row][col] = ' ';
			}
		}
		char player = 'X';
		boolean gameOver = false;
		
		Scanner sc = new Scanner(System.in);
		
		while(!gameOver) {
			printBoard(board);
			System.out.println("player "+player+" - enter row and col : ");
			
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			if(board[row][col] == ' ') { //if it is empty
				
				board[row][col] = player; //..place the element 
				gameOver = Won(board,player);
				
				if(gameOver) {
					System.out.println("player "+player+"has won !!!");
				}
				else {
					if(player == 'X') {
						player = 'O';
					}
					else {
						player = 'X';
					}
				}
			}
			else {
				if(! boardIsFull(board)) {
					System.out.println("Invalid move. Try again ! ");
				}
				else {
					System.out.println("Game over...Nobody wins............. ");
					gameOver = true;
				}
			}
			
		}
		
		printBoard(board);
		
	}
	private static boolean boardIsFull(char[][] board) {
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[0].length; col++) {
				char item = board[row][col] ;
				if(item == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	private static void printBoard(char[][] board) {
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[0].length; col++) {
				char item = board[row][col] ;
				System.out.print(item+" | ");
			}
			System.out.println();
		}
	}
	private static boolean Won(char[][] board, char player) {
		//check for rows
		for(int row=0; row<board.length; row++) {
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
				return true;
			}
		}
		
		//check for cols
		for(int col=0; col<board[0].length; col++) {
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
				return true;
			}
		}
		
		//check for diagonals
		
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
			return true;
		}
		
		if(board[2][0]==player && board[1][1]==player && board[0][2]==player) {
			return true;
		}
		return false;
	}

}
