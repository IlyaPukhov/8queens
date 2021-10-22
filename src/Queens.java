public class Queens {
    final int SIZE;
    final int[][] board;
    int num;

    //конструктор
    public Queens(int N) {
        SIZE = N;
        board = new int[N][N];
        num = 0;
    }

    public boolean checkQueen(int row, int col) {
        //проверка столбца
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        //проверка строки
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        //проверка по левой диагонали
        for (int i = 1; i <= row && col - i >= 0; i++)
            if (board[row - i][col - i] == 1) return false;

        //проверка по правой диагонали
        for (int i = 1; i <= row && col + i < SIZE; i++)
            if (board[row - i][col + i] == 1) return false;

        return true;
    }

    //алгоритм перебора в возвратом
    public void backtrack(int row) {
        //проверяем на конец доски
        if (row == SIZE) {
            num++;
            System.out.print('\n' + "Result №" + num + ": " + '\n');
            showBoard();
            return; //возращаемся на 49 строку
        }

        //проверяем каждую ячейку данной строки на соответствие условию
        for (int i = 0; i < SIZE; i++) {
            if (checkQueen(row, i)) {
                //если ячейка прошла проверку, то ставим ферзя на неё и идём на следующую строку
                board[row][i] = 1;
                backtrack(row + 1);
                board[row][i] = 0; //убираем последнего поставленного ферзя и ищем ему новое место в row строке
            }
        }
    }

    //метод для вывода конечной доски
    public void showBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print((board[row][col] == 1) ? "Q  " : "·  ");
            }
            System.out.print("\n");
        }
    }
}