/**
 * Java. Level 1. Lesson 4. Home work
 *
 * @author Andry Krasikov
 * @version Aug 24, 2018
 */

import java.util.Random;
import java.util.Scanner;

class HomeWork4_5x5 {

    final int SIZE = 5;
    final int WIN_SIZE = 4;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new HomeWork4_5x5();
    }

    HomeWork4_5x5() {
        initMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..5):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    boolean checkWin(char dot) {
		int x = 0, y = 0, z = 0, w = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == dot) {
					x++;
					if (x == WIN_SIZE)
						return true;
				}
				else
					x = 0;
				if (map[j][i] == dot)
						y++;
					if (y == WIN_SIZE) 
						return true;
					else {
						y = 0;
					}
				if (i<SIZE-1 && j<SIZE-1) {
					if (map[i][j] == dot && map[i + 1][j + 1] == dot && Math.abs(i-j)==Math.abs(j-i))
						z++;
					if (z == WIN_SIZE-1)
						return true;
					else {
						continue;
						}
				}
				if (j<WIN_SIZE || i<WIN_SIZE) {
					if (map[j][i] == dot && map[i][j] == map[j][i])
						w++;
					if (w == WIN_SIZE-1) return true;
					else {
						continue;
					}
				}
			}
		}
	return false;
	}

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY; // by DSerov
    }
}