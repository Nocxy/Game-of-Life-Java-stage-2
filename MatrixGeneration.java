package life;

import java.util.Random;

public class MatrixGeneration {
    char next_gen[][];
    char current_gen[][];
    int game_size;
    int number_generations;
    int seed;


    public MatrixGeneration(int game_size, int seed, int number_generations) {
        this.game_size = game_size;
        this.seed = seed;
        this.number_generations = number_generations;
        Random random = new Random(seed);
        current_gen = new char[game_size][game_size];
        next_gen = new char[game_size][game_size];

        for (int i = 0; i < game_size; i++) {
            for (int j = 0; j < game_size; j++) {
                current_gen[i][j] = ' ';
                if (random.nextBoolean()) {
                    current_gen[i][j] = 'O';
                }
                //System.out.print(current_gen[i][j]);
            }
            //System.out.println();
        }

    }

    public void Generation(int game_size, int seed, int number_generations) {
        this.seed = seed;
        Random random = new Random(seed);

        for (int i = 0; i < game_size; i++) {
            for (int j = 0; j < game_size; j++) {
                current_gen[i][j] = ' ';
                if (random.nextBoolean()) {
                    current_gen[i][j] = 'O';
                }
                //System.out.print(current_gen[i][j]);
            }
            //System.out.println();
        }

    }


    public char[][] Generate_next(int game_size) {
        int neighbors;
        for (int i = 0; i < game_size; i++) {
            for (int j = 0; j < game_size; j++) {
                neighbors = Check_Neighbors(i, j);
                if (current_gen[i][j] == 'O') {
                    if (neighbors != 2 && neighbors != 3) {
                        next_gen[i][j] = ' ';
                    }
                } else {
                    if (neighbors == 3) {
                        next_gen[i][j] = 'O';
                    }
                }
            }
        }
        for (int i = 0; i < game_size; i++) {
            for (int j = 0; j < game_size; j++) {
                current_gen[i][j] = next_gen[i][j];
            }
        }
        return current_gen;
    }


    private int Check_Neighbors(int i, int j) {
        int i_minus = (((i - 1) % game_size) + game_size) % game_size;
        int j_minus = (((j - 1) % game_size) + game_size) % game_size;
        int i_plus = (i + 1) % game_size;
        int j_plus = (j + 1) % game_size;
        int neighbors = 0;
        if (current_gen[i_minus][j_minus] == 'O') {
            neighbors++;
        }
        if (current_gen[i_minus][j] == 'O') {
            neighbors++;
        }
        if (current_gen[i][j_minus] == 'O') {
            neighbors++;
        }
        if (current_gen[i_plus][j] == 'O') {
            neighbors++;
        }
        if (current_gen[i][j_plus] == 'O') {
            neighbors++;
        }
        if (current_gen[i_plus][j_plus] == 'O') {
            neighbors++;
        }
        if (current_gen[i_minus][j_plus] == 'O') {
            neighbors++;
        }
        if (current_gen[i_plus][j_minus] == 'O') {
            neighbors++;
        }
        return neighbors;
    }

    public void DrawBoard(char current_gen[][]) {
        for (int i = 0; i < game_size; i++) {
            for (int j = 0; j < game_size; j++) {
                System.out.print(current_gen[i][j]);
            }
            System.out.println();
        }
    }


}
