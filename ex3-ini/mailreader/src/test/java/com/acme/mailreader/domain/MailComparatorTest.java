package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}

	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(MailComparator.EGAUX));
	}
	
	@Test
	public final void sujetsDifferents() {
		Mail mail1 = new Mail.Builder("SujetMail1").build();
		Mail mail2 = new Mail.Builder("SujetMail2").build();
		assertThat(comparator.compare(mail1, mail2), is(not(MailComparator.EGAUX)));
	}
	
	@Test
	public final void mail1Important() {
		Mail mail1 = new Mail.Builder("Sujet").important(true).build();
		Mail mail2 = new Mail.Builder("Sujet").important(false).build();
		assertThat(comparator.compare(mail1, mail2), is(MailComparator.PREMIER_PLUS_GRAND));
	}	
	
}
