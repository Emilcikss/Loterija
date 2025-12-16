package LOT;

import java.beans.IntrospectionException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Stack;

public class Loterija {


		private Stack<Integer> SkS;
		private Stack<Integer> LSkS;
		private LocalDateTime ILaiks;
		
		public Loterija() {
			 SkS = new Stack<>();
			 LSkS = new Stack<>();
			 aizpilditStack();
	}
		private void aizpilditStack() {
			Random rand = new Random();
			for (int i = 0; i < 10; i ++) {
				SkS.push(rand.nextInt(10));
			}
		}

		public void VeiktIzlozi() {
			for (int i = 0; i < 3; i++) {
				if (SkS.isEmpty()) {
					LSkS.push(SkS.pop());
				}
			}
		ILaiks = LocalDateTime.now();
		}
		
		public Stack<Integer> getLSkS() {
			return LSkS;
		}
		
		public LocalDateTime getILaiks() {
			return ILaiks;
		}
		
}
