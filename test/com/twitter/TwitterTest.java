package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter tw;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	@Test
	public void testUnesi() {
		tw.unesi("Pera", "Ja sam Pera!");
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Pera");
		tp.setPoruka("Ja sam Pera!");
		assertEquals(tw.vratiSvePoruke().getLast(), tp);

	}

	@Test
	public void testVratiPoruke() {
		tw.unesi("Pera", "Ja sam Pera!");
		tw.unesi("Lepi", "Ja sam Pera!");
		tw.unesi("Mika", "Ja sam Mika!");
		tw.unesi("Joka", "Ja sam Joka!");
		TwitterPoruka[] poruke = tw.vratiPoruke(0, "Pera!");
		int br = 0;
		for (int i = 0; i < poruke.length; i++)
			if (poruke[i] != null)
				br++;
			else
				break;
		assertTrue(br == 2);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagJeNull() {
		tw.vratiPoruke(10, null);

	}

	@Test(expected = java.lang.RuntimeException.class)
    public void testVratiPorukeTagJePrazanString() {
        tw.vratiPoruke(10, new String(""));
    }

	@Test
	public void testVratiPorukeBrojJeNula() {
		tw.unesi("Pera", "Ja sam Pera!");
		tw.unesi("Lepi", "Ja sam Pera!");
		tw.unesi("Mika", "Ja sam Mika!");
		tw.unesi("Joka", "Ja sam Joka!");
		TwitterPoruka[] poruke = tw.vratiPoruke(0, "Pera!");
		int br = 0;
		for (int i = 0; i < poruke.length; i++)
			if (poruke[i] != null)
				br++;
			else
				break;
		assertTrue(br == 2);

	}

}
