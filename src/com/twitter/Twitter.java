package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Predstavlja (sadrzi) listu poruka kao i metode za rad sa njima
 * 
 * @author dhimpt
 *
 */
public class Twitter {
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Vraca listu svih unetih poruka
	 * 
	 * @return poruke Unete poruke od strane korisnika
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Unosi korisnika i njegovu poruku u listu poruke
	 * 
	 * @param korisnik
	 *            Korisnik koji je napisao poruku
	 * @param poruka
	 *            Poruka napisana od strane korisnika
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima
		TwitterPoruka tp = new TwitterPoruka();
		// Inicijalizuje se korisnik poruke kao "korisnik"
		tp.setKorisnik(korisnik);
		// Inicijalizuje se poruka korisnika
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Vraca niz poruka koje sadrze odredjeni tag pri cemu se vodi racuna u
	 * maksimalnom broju poklapanja
	 * 
	 * @param maxBroj
	 *            Maksimalni broj poruka koje se vracaju kao rezultat, a kod
	 *            kojih postoji poklapanje sa unetim tagom
	 * @param tag
	 *            String cija se vrednost pretrazuje u porukama
	 * @return rezultat Niz poruka koje sadrze prosledjeni tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.equals(""))
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace sve
		// poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag. Ako se nadje
		// neka takva, i ako nije prekoracen maxBroj ona se upisuje u niz. Ako
		// je prekoracen maxBroj,pretraga se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac++] = poruke.get(i);
				} else
					break;
		return rezultat;
	}
}