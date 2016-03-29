package com.twitter.poruke;

/**
 * Predstavalja (sarzi) podatke o korisniku i poruci koju je uneo
 * 
 * @author dhimpt
 */
public class TwitterPoruka {
	/**
	 * Naziv korisnika (korisnicko ime) kao String
	 */
	private String korisnik;
	/**
	 * Sadrzaj poruke koju korisnik salje kao String
	 */
	private String poruka;

	/**
	 * Metoda koja vraca vrednost atributa korisnik
	 * 
	 * @return korisnik Vraca podatke o korisniku koji je napisao poruku
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Postavlja novu vrednost za atribut korisnik (korisnicko ime)
	 * 
	 * @param korisnik
	 *            Ime korisnika
	 * @throws java.lang.RuntimeException
	 *             Ako nije uneto ime korisnika
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda koja vraca vrednost atributa poruka
	 * 
	 * @return poruka Poruka koju je uneo korisnik
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Postavlja vrednost atributa poruka
	 * 
	 * @param poruka
	 *            Poruka napisana od strane korisnika
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Konvertuje sadrzaj objekta u String
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPoruka other = (TwitterPoruka) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (poruka == null) {
			if (other.poruka != null)
				return false;
		} else if (!poruka.equals(other.poruka))
			return false;
		return true;
	}

}