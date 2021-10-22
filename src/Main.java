public class Main {
    public static void main(String[] args) {
        Queens queen = new Queens(8); //создаём экземпляр класса Queens и инициализируем размерность доски
        queen.backtrack(0); //начинаем backtracking с 0-й строки
    }
}
