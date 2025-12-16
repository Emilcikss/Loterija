package LOT;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class galvena {
Random rand = new Random();
	public static void main(String[] args) {
		String izvele;
		
		
		public Loterija() {
			
		}
		
		String[] darbibas = {"Veikt izlozi", "Apskatīt pēdējo rezultātu", "iziet"};
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "darbību saraksts",
					JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			switch(izvele) {
			case "Veikt izlozi":
				if(!S1.isEmpty())
					
				
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
