package hs.ma.uib.ss14.tpe08.p2;

public class GameController {
// nur ein Test
	public static Squad s1 = new Squad("The walking dead");
	public static Squad s2 = new Squad("Superman is nich super");
	

	public static void runGame() {
		GameController game = new GameController();
		
		s1.hinzufuegen(Farseer.getInstance());
		s2.hinzufuegen(Erzmagier.getInstance());
		
		while (s2.team[0].isLebendig()) { // in dieser Schleife wird alles ablaufen
			s1.team[0].attack(s2.team[0]);
			
			GameViewer.printGame(game);
		}
	}

	public static void main(String[] args) {
		runGame();
	}
}