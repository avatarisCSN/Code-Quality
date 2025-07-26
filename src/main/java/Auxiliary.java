public class Auxiliary {
    public static void main(String[] args) {
        char box[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        checkWinner(box, 'X');
    }

    public static void breaker () {
        System.out.println("Hello breaked");
    }
    public static void cleanBox (boolean boxEmpty, char[] box) {
        if(!boxEmpty){
            for(int i = 0; i < 9; i++)
                box[i] = ' ';
            boxEmpty = true;
        }
    }
    public static boolean isCellFree(char c) {
        return c != 'X' && c != 'O';
    }

    public static boolean isMovesLeft(char[] box) {
            for (char c : box) {
                if (isCellFree(c)) return true;
            }
            return false;
        }


    public static boolean checkWinner(char[] box, char symbol) {
        if (checkHorLine(box, symbol) || checkVertLine(box, symbol)
                || (box[0] == symbol && box[4] == symbol && box[8] == symbol)
                || (box[2] == symbol && box[4] == symbol && box[6] == symbol)) {
            return true;
        }
        return false;
    }
    public static boolean checkHorLine(char[] box, char symbol) {
        for (int i = 0; i <= 6; i += 3) {
            if (box[i] == symbol && box[i + 1] == symbol && box[i + 2] == symbol) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkVertLine(char[] box, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (box[i] == symbol && box[i + 3] == symbol && box[i + 6] == symbol) {
                return true;
            }
        }
        return false;
    }

    public static void  printBox(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
}
