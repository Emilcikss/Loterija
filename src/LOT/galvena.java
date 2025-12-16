package LOT;

import java.util.Stack;

import javax.swing.JOptionPane;

public class galvena {

	public static void main(String[] args) {
		String izvele;
		Stack<Integer> LAIMIGAIS = new Stack<>();
		Stack<Integer> NELAIMIGAIS = new Stack<>();
		Stack<Integer> NELAIMIGAIS1 = new Stack<>();
		
		String[] darbibas = {"Veikt izlozi", "Apskatīt pēdējo rezultātu", "iziet"};
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "darbību saraksts",
					JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			switch(izvele) {
			case "Veikt izlozi":
				break;
			case "Apskatīt pēdējo rezultātu":
				break;
			case "iziet":
				break;
			}
break;
		}while((!izvele.equals("Apturet")));
	}

}
