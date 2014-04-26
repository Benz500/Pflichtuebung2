package hs.ma.uib.ss14.tpe08.p2;

public class Lich extends Untote {

	private static final String name = "Lich";
	private static final double bonus = 2.3;
	private static final String element = "Wasser";

	private static final Lich instance = new Lich();

	private Lich() {
		super.lebenspunkte = lebenspunkte * bonus;
	}

	public static Lich getInstance() {
		return instance;
	}

	public void verwesung(Squad s) {
		lebenspunkte = lebenspunkte + (s.getAnzahl()* 7 );
		s.erhalteTeamSchaden(7);
	}
	
	public String getElement(){
		return element;
	}

	@Override
	public double attack(Kaempfer r) {
		double damage = geschwindigkeit * schaden * spezialAttribut * bonus;
		if (r.getElement().equals("Feuer")) {
			damage = damage * 2;
		}
		r.erhalteSchaden(damage);
		return damage;
	}


	@Override
	public double beschraenkeSchaden(double schaden) {
		return super.beschraenkeSchaden(schaden);
	}

	@Override
	public double erhalteSchaden(double schaden) {
		return super.erhalteSchaden(schaden);
	}

	@Override
	public boolean isLebendig() {
		return super.isLebendig();
	}

	@Override
	public String toString() {
		// Name muss dazu gemacht werden.
		return name + ", " + super.toString();
	}

}
