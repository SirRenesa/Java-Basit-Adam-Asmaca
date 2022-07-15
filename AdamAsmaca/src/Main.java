import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String getMasked(ArrayList<Character> guessList, String word, String guess) {

        String result = ""; //Sonuç (Maskeli Kelime)

        for (int i = 0; i < word.length(); i++) {

            char checkLetter;
            checkLetter = word.charAt(i);

            String checkLetterStr = "" + checkLetter; //checkLetter'ı Stringe Dönüştürme

            if (guessList.contains(checkLetter)) {

                result = result.concat(checkLetterStr);

            } else {
                result = result.concat("#");
            }

        }

        return result;
    }

    public static void main(String[] args) {

        //----Kullanıcıdan Kelimeyi Alma----\\

        System.out.println("Lutfen Gizli Kelimeyi Yazip Cihazi Yaninizdaki Arkadasiniza Veriniz.");

        Scanner wordinput = new Scanner(System.in);
        String secretword = wordinput.nextLine();
        secretword = secretword.trim(); //Kelimenin başında veya sonundaki boşluğu silme

        String secretwordnonspace = secretword.toLowerCase();

        secretwordnonspace = secretwordnonspace.replace(" ", " / ");

        int trychance = 15;
        String guess;

        ArrayList<Character> guessList = new ArrayList<>();

        for (int i = 0; i < trychance; i++) {

            System.out.println("Lutfen Harf Tahmininizi Yapiniz (HARF TAHMINLERININ TAMAMINI KUCUK HARFLE YAPINIZ!)");
            System.out.println(i + ". Tahmininizdesiniz / Toplam Tahmin Hakkiniz: 15");
            System.out.println("Yaptiginiz tahminler: " + guessList);

            Scanner charinput = new Scanner(System.in);
            guess = charinput.next();
            guessList.add(guess.charAt(0));

            String maskedword = Main.getMasked(guessList, secretwordnonspace, guess);
            System.out.println(maskedword);

            System.out.println("  -----------------------------------  ");

        }

    }


}

