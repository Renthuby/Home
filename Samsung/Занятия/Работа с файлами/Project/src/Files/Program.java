package Files;

public class Program {

    public static void main(String[] args) {
        String s1 = "IT School Samsung";
        String s2 = "IT школа  Samsung";
        String s3 = "";
        String rasdelitel = "_";

        String[] a1 = s1.split(s3);
        String[] a2 = s2.split(s3);

        for (String a : a1) {
            System.out.print(a);
        }

        System.out.println();

        if (s1.length() >= s2.length()) {
            for (int i = 0; i < a2.length; i++) {
                if (a1[i].equals(a2[i])) {
                    System.out.print(" ");
                } else System.out.print(rasdelitel);
            }
            for (int i = 0; i < s1.length() - s2.length(); i++) {
                System.out.print(rasdelitel);
            }
        } else {
            for (int i = 0; i < a1.length; i++) {
                if (a1[i].equals(a2[i])) {
                    System.out.print(" ");
                } else System.out.print(rasdelitel);
            }
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                System.out.print(rasdelitel);
            }
        }

        System.out.println();

        for (String a : a2) {
            System.out.print(a);
        }
    }
}







