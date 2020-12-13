package com.java.game.ticTac;

import java.util.Arrays;
import java.util.Scanner;

public class TicTac {
	public static String[] arr;

	public static void printPattern(String[] arr) {
		System.out.println("|---|---|---|");
		System.out.println("| " + arr[0] + " | " + arr[1] + " | " + arr[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + arr[3] + " | " + arr[4] + " | " + arr[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + arr[6] + " | " + arr[7] + " | " + arr[8] + " |");
		System.out.println("|---|---|---|");
	}

	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			String winner = null;
			String turn = "X";
			arr = new String[9];
			for (int j = 0; j < 9; j++) {
				arr[j] = String.valueOf(j + 1);
			}
			printPattern(arr);
			System.out.println("First turn will be of X");
			while (winner == null) {
				System.out.println("please select the number " + turn);
				int newInput = scan.nextInt();
				arr[newInput - 1] = turn;
				if (turn == "X") {
					turn = "O";
				} else {
					turn = "X";
				}
				printPattern(arr);
				winner = checkWinner(arr);

			}
			System.out.println("the winner is ===" + winner);
		} catch (Exception e) {
			System.out.println("Exception =" + e);
		} finally {
			scan.close();
		}

	}

	private static String checkWinner(String[] board) {
		for (int i = 0; i < 9; i++) {
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
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line != null) {
				if (line.equals("XXX")) {
					return "X";

				} else if (line.equals("OOO")) {
					return "O";

				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (Arrays.asList(arr).contains(String.valueOf(i + 1))) {
				break;
			} else if (i == 8) {
				return "draw";
			}
		}

		return null;

	}

}
