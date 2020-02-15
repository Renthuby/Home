import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        int i = in.nextInt();
        int k = 0;
        while (k < i) {
            b.add(0);
            k++;
        }
        int count = 0;
        for (int j = 0; j < i; j++) { a.add(in.nextInt()); }
        for (int j = 0; j < i; j++) {
            if (j < i - 1 ) {
                b.set(j + 1, a.get(j));
            } else if (j == i-1) {
                b.set(0, a.get(j));
            }
        }
        for (int j = 0; j < i; j++){
            System.out.println(b.get(j) + " ");
        }
    }
}
