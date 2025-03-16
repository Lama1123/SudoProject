import java.util.*;
import java.io.*;

public class SudokuBoard {
	static final int GRID=9;

	public static void main(String[] args) {
	printGrid();


		}
	
	private static void printGrid() {
		Random random=new Random();
		int[][] board=new int[9][9];
		for(int i=0; i<9;i++) {
			for(int j=0;j<9;j++) {
				board[i][j]=random.nextInt(9)+1;

			}	

		}
		for( int i=0; i<9;i++) {
			if(i%3==0) System.out.println("--------------------------");
			for(int j=0;j<9;j++) {
				if(j%3==0) System.out.print(" | ");
				System.out.print(board[i][j]+" ");
			}
			System.out.println();


		}
		
	}
	private static boolean NumberInRow (int[][] board, int number, int row) {
		for(int i=0;i<GRID;i++) {
			if(board[row][i]==number) {
				return true;
			}
		}
		return false;
	}
	private static boolean NumberInCol (int[][] board, int number, int col) {
		for(int i=0;i<GRID;i++) {
			if(board[i][col]==number) {
				return true;
			}
		}
		return false;
	}
	private static boolean NumberInBox (int[][] board, int number, int row,int col) {
		int localBoxRow=row-row%3;
		int localBoxCol=col-col%3;

		for(int i=localBoxRow;i<localBoxRow+3;i++) {
			for(int j=localBoxCol;j<localBoxCol+3;j++) {
				if(board[i][j]==number) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean isValid(int board[][],int number, int row, int col) {
		return !NumberInRow(board,number,row) && !NumberInCol(board,number,col) &&
				!NumberInBox(board,number,row,col);
	}
}
