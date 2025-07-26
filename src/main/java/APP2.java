import java.util.Random;
import java.util.Scanner;

public class APP2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randGen = new Random();
        byte input;
        int rand;
        int i;
        boolean boxAvailable = false;
        byte winner = 0;
        char box[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;


        //запускается цикл до победы
        while (true) {

            // отрисовка поля текстом
            APP3.printBox(box);

            // очистка от цифр перед началом игры
            APP3.cleanBox(boxEmpty, box);


            // проверка победы
            if(winner == 1){
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if(winner == 2){
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if(winner == 3){
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }


            // проверка на корректный ввод, ввод
            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                }
                else
                    System.out.println("Invalid input. Enter again.");
            }

            // проверка победы крестов
            if (APP3.checkWinner(box,'X')) {
                winner = 1;
                continue;
            }


            // проверка есть ли свободное место
            boxAvailable = false;
            if (APP3.isMovesLeft(box)) {
                boxAvailable = true;
                break;
            }

            // проверка ничьи
            if(boxAvailable == false){
                winner = 3;
                continue;
            }

            // нолики ходят
            while (true) {
                 rand = randGen.nextInt(9) - 1;
                if (box[rand] != 'X' && box[rand] != 'O') {
                    box[rand] = 'O';
                    break;
                }
            }

            //  проверка победа нулей
            if (APP3.checkWinner(box,'O')) {
                winner = 2;
                continue;
            }
        }

    }
}