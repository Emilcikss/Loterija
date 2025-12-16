package LOT;
import javax.swing.JOptionPane;
import java.util.Stack;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.Duration;

public class loterija {

    static Stack<Integer> skaitluSteks = new Stack<>();
    static Stack<Integer> laimigoSteks = new Stack<>();
    static LocalDateTime pedejasIzlozesLaiks = null;

    public static void main(String[] args) {

        while (true) {

            String izvele = JOptionPane.showInputDialog(
                    "Izvēlies darbību:\n" +
                    "1 - Veikt izlozi\n" +
                    "2 - Apskatīt visus skaitļus\n" +
                    "3 - Apskatīt laimīgos skaitļus\n" +
                    "4 - Iziet"
            );

            if (izvele == null || izvele.equals("4")) {
                JOptionPane.showMessageDialog(null, "Programma pabeigta.");
                break;
            }

            switch (izvele) {
                case "1":
                    veiktIzlozi();
                    break;
                case "2":
                    apskatitVisusSkaitlus();
                    break;
                case "3":
                    apskatitLaimigos();
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Nepareiza izvēle.",
                            "Kļūda",
                            JOptionPane.ERROR_MESSAGE
                    );
            }
        }
    }

    static void veiktIzlozi() {

        if (pedejasIzlozesLaiks != null) {
            Duration starpiba = Duration.between(pedejasIzlozesLaiks, LocalDateTime.now());
            if (starpiba.toSeconds() < 60) {
                JOptionPane.showMessageDialog(
                        null,
                        "Izloze iespējama tikai pēc 1 minūtes.",
                        "Informācija",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        }

        skaitluSteks.clear();
        laimigoSteks.clear();

        Random gadijumaSkaitlis = new Random();

        for (int skaititajs = 0; skaititajs < 10; skaititajs++) {
            skaitluSteks.push(gadijumaSkaitlis.nextInt(10));
        }

        JOptionPane.showMessageDialog(
                null,
                "Steks aizpildīts ar 10 nejaušiem skaitļiem.\nIzloze tiek veikta."
        );

        for (int skaititajs = 0; skaititajs < 3; skaititajs++) {
            laimigoSteks.push(skaitluSteks.pop());
        }

        pedejasIzlozesLaiks = LocalDateTime.now();

        JOptionPane.showMessageDialog(
                null,
                "Izloze pabeigta.\nIzlozes laiks:\n" + pedejasIzlozesLaiks
        );
    }

    static void apskatitVisusSkaitlus() {

        if (skaitluSteks.empty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nav datu. Vispirms veic izlozi."
            );
            return;
        }

        String teksts = "Skaitļi, kas palika stekā:\n";

        Stack<Integer> kopija = new Stack<>();
        kopija.addAll(skaitluSteks);

        while (!kopija.empty()) {
            teksts += kopija.pop() + "\n";
        }

        JOptionPane.showMessageDialog(null, teksts);
    }

    static void apskatitLaimigos() {

        if (laimigoSteks.empty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Laimīgie skaitļi vēl nav noteikti."
            );
            return;
        }

        String teksts = "Laimīgie skaitļi:\n";
        teksts += "Izlozes laiks:\n" + pedejasIzlozesLaiks + "\n\n";

        Stack<Integer> kopija = new Stack<>();
        kopija.addAll(laimigoSteks);

        while (!kopija.empty()) {
            teksts += kopija.pop() + "\n";
        }

        JOptionPane.showMessageDialog(null, teksts);
    }
}
