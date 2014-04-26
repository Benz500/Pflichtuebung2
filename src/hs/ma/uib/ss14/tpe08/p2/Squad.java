package hs.ma.uib.ss14.tpe08.p2;

public class Squad {
	private String name;
	public Wesen[] team = new Wesen[0];

	public Squad(String name, Rasse rasse1, int investition1, Rasse rasse2,
			int investition2) {
		this.name = name;
		WesenFactory.kaufeWesen(this, rasse1, investition1);
		WesenFactory.kaufeWesen(this, rasse2, investition2);
	}

	@Override
	public String toString() {
		return name;
	}

	public static Wesen[] arrayErweitern(Wesen[] ursprungsArray, Wesen w) {
		Wesen[] neuesArray = new Wesen[ursprungsArray.length + 1];
		for (int l = 0; l < ursprungsArray.length; l++) {
			neuesArray[l] = ursprungsArray[l];
		}
		neuesArray[neuesArray.length - 1] = w;
		return neuesArray;
	}

	public static Wesen[] arrayKuerzen(Wesen[] ursprungsArray) {
		Wesen[] neuesArray = new Wesen[ursprungsArray.length - 1];
		for (int l = 0; l < ursprungsArray.length - 1; l++) {
			neuesArray[l] = ursprungsArray[l];
		}
		return neuesArray;
	}

	public void erhalteTeamSchaden(double schaden) {
		for (int i = 0; i < this.team.length; i++) {
			this.team[i].erhalteSchaden(schaden);
		}
	}

	public void hinzufuegen(Wesen w) {
		this.team = arrayErweitern(this.team, w);
	}

	public void loesche(Wesen w) {
		for (int i = 0; i < this.team.length - 1; i++) {
			if (this.team[i].equals(w)) {
				this.team[i] = this.team[i + 1];
				this.team = arrayKuerzen(this.team);
			}
		}
	}

	public int getAnzahl() {
		int zaehler = 0;
		for (int i = 0; i < this.team.length; i++) {
			if (this.team[i] != null) {
				zaehler++;
			}
		}
		return zaehler;
	}
}
