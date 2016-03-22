package com.twitter.poruke;

public class TwitterPoruka {
	/**
	 * Atribut koji pamti podatke o nazivu korisnika (korisnicko ime)
	 */
	private String korisnik;
	/**
	 * Atribut koji pamti sadrzaj poruke koju korisnik salje
	 */
	private String poruka;

	/**
	 * Metoda koja vraca naziv korisnika
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda koja upisuje naziv korisnika koji je prosledjen kao parametar
	 * (korisnicko ime)
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda koja vraca String "poruka"
	 * 
	 * @return "poruka"
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda koja upisuje sadrzaj poruke koji je prosledjen kao parametar
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Metoda toString koja konvertuje sadrzaj objekta u String
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}