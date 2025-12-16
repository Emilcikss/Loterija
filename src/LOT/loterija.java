package LOT;

import java.util.Stack;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.Duration;
import javax.swing.JOptionPane;

public class loterija {

    public static void main(String[] args) {

        String izvele;
        Stack<Integer> skaitluSteks = new Stack<>();
        Stack<Integer> laimigoSteks = new Stack<>();
        LocalDateTime pedejasIzlozesLaiks = null;

        String[] darbibas = {
                "Veikt izlozi",
                "Apskatīt visus skaitļus",
                "Apskatīt laimīgos skaitļus",
                "Apturēt"
        };

        do {
            izvele = (String) JOptionPane.showInputDialog(
                    null,
                    "Izvēlies darbību",
                    "Darbību saraksts",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    darbibas,
                    darbibas[0]
            );

            if (izvele == null) {
                izvele = "Apturēt";
            }

            switch (izvele) {

               
                case "Veikt izlozi":

                    if (pedejasIzlozesLaiks != null) {
                        Duration starpiba = Duration.between(pedejasIzlozesLaiks, LocalDateTime.now());
                        if (starpiba.toSeconds() < 60) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Izloze iespējama tikai pēc 1 minūtes!",
                                    "Brīdinājums",
                                    JOptionPane.WARNING_MESSAGE
                            );
                            break;
                        }
                    }

                    skaitluSteks.clear();
                    laimigoSteks.clear();

                    Random random = new Random();

                    for (int i = 0; i < 10; i++) {
                        skaitluSteks.push(random.nextInt(10));
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Steks aizpildīts ar 10 nejaušiem skaitļiem.",
                            "Paziņojums",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    for (int i = 0; i < 3; i++) {
                        laimigoSteks.push(skaitluSteks.pop());
                    }

                    pedejasIzlozesLaiks = LocalDateTime.now();

                    JOptionPane.showMessageDialog(
                            null,
                            "Izloze pabeigta.\nIzlozes laiks:\n" + pedejasIzlozesLaiks,
                            "Paziņojums",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    break;

       
                case "Apskatīt visus skaitļus":

                    if (skaitluSteks.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Steks ir tukšs!",
                                "Paziņojums",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        String teksts = "Skaitļi, kas palika stekā:\n";

                        Stack<Integer> kopija = new Stack<>();
                        kopija.addAll(skaitluSteks);

                        while (!kopija.isEmpty()) {
                            teksts += kopija.pop() + "\n";
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                teksts,
                                "Paziņojums",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                    break;

   
                case "Apskatīt laimīgos skaitļus":

                    if (laimigoSteks.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Laimīgie skaitļi vēl nav noteikti!",
                                "Paziņojums",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        String teksts = "Laimīgie skaitļi:\n";
                        teksts += "Izlozes laiks:\n" + pedejasIzlozesLaiks + "\n\n";

                        Stack<Integer> kopija = new Stack<>();
                        kopija.addAll(laimigoSteks);

                        while (!kopija.isEmpty()) {
                            teksts += kopija.pop() + "\n";
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                teksts,
                                "Paziņojums",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                    break;

         
                case "Apturēt":
                    JOptionPane.showMessageDialog(
                            null,
                            "Programma apturēta.",
                            "Paziņojums",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
            }

        } while (!izvele.equals("Apturēt"));
    }
}
