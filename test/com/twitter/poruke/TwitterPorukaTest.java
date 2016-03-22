package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();

	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testGetKorisnik() {

	}

	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Pera");
		assertEquals(tp.getKorisnik(), "Pera");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}

	@Test
	public void testGetPoruka() {

	}

	@Test
	public void testSetPoruka() {
		tp.setPoruka("Pozdrav, ja se zovem Pera!");
		assertEquals(tp.getPoruka(), "Pozdrav, ja se zovem Pera!");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaSaViseKarakteraOdBrojaDozvoljenih() {
		tp.setPoruka(
				"Ova poruka je duza od 140 karaktera i ona ne dozvoljava ponovni unos nove poruke koja ce je zameniti tj. ako izvrsimo unos ove poruke necemo biti u mogucnosti da upisemo novu poruku!");

		assertEquals(tp.getPoruka(),
				"Ova poruka je duza od 140 karaktera i ona ne dozvoljava ponovni unos nove poruke koja ce je zameniti tj. ako izvrsimo unos ove poruke necemo biti u mogucnosti da upisemo novu poruku!");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
		assertEquals(tp.getPoruka(), null);
	}

	@Test
	public void testSetPorukaPrazanString() {
		tp.setPoruka("");
		assertEquals(tp.getPoruka(), "");
	}

	@Test
	public void testToString() {
		tp.setKorisnik("Pera");
		tp.setPoruka("Pozdrav, ja se zovem Pera!");
		assertEquals(tp.toString(), "KORISNIK:" + "Pera" + " PORUKA:" + "Pozdrav, ja se zovem Pera!");
	}

}
