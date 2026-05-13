import java.util.Random;

public class Monstre implements Combatent{

	String nom;
	int vida;
	int atac;
	int penalizatcio;
	double valorExperiencia;

	public Monstre(String nom, int vida, int atac, int penalizatcio) {
		setNom(nom);
		setVida(vida);
		setAtac(atac);
		setPenalizatcio(penalizatcio);
		setValorExperiencia(vida,atac);
	}


	public void atacar(Personaje p) {

		p.rebreDany(this.calcularAtac());
	}
	
	@Override
	public int calcularAtac() {
		Random round = new Random();

		int atac = (int)round.nextInt(this.atac)+1;
		
		return atac;
	}
	@Override
	public void rebreDany(int quantitat) {

		this.vida = this.vida-quantitat;	
	}
	
	@Override
	public boolean estaViu() {
		
		if(this.vida>0) {
			return true;
		}else {
			return false;
		}
	}



	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public int getPenalizatcio() {
		return penalizatcio;
	}


	public void setPenalizatcio(int penalizatcio) {
		if(penalizatcio>=0 && penalizatcio<=3) {
			this.penalizatcio = penalizatcio;
		}else {
			this.penalizatcio = 0;
		}
	}


	public double getValorExperiencia() {
		return valorExperiencia;
	}


	public void setValorExperiencia(double vida, double atac) {
		this.valorExperiencia = Math.pow(((vida+atac)/2),2);
	}
	
	public String toString() {
		return this.nom + " | Vida: " + this.vida + " Penalización: " + this.penalizatcio;
	}


	public int getAtac() {
		return atac;
	}


	public void setAtac(int atac) {
		this.atac = atac;
	}


}
