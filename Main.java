package life;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  int game_size = scanner.nextInt();
	  int seed = scanner.nextInt();
	  int number_of_generations = scanner.nextInt();
	  MatrixGeneration this_matrix = new MatrixGeneration(game_size, seed, number_of_generations);
	  this_matrix.seed = seed;

	  for (int i = 0 ; i < number_of_generations ; i++){
		    char[][] current_gen = this_matrix.Generate_next(game_size);
	  }

	  this_matrix.DrawBoard(current_gen[][]);
    }
}
