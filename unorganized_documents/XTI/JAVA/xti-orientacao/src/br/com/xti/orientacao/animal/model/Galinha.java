package br.com.xti.orientacao.animal.model;

public final class Galinha extends Animal {
	public int ovos;
	public static int ovosDaGranja;

	public Galinha() {
		super(3, "Milho");
	}

	@Override
	public void fazBarulho() {
		System.out.println("Có, có.. Có, có...");
	}

	public void bota() {
		System.out.println("Botou 1 ovo!");
		this.ovos++;
		Galinha.ovosDaGranja++;
	}

	public static float mediaDeOvos(float galinhas) {
		return Galinha.ovosDaGranja / galinhas;
	}

}
