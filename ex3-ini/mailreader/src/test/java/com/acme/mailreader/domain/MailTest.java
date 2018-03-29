package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Ignore;
import org.junit.Test;

import com.acme.mailreader.utils.DateIncorrecteException;

public class MailTest {
	

	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateAvant1970() throws DateIncorrecteException {
		Mail mail = new Mail();
		mail.setDate(Instant.parse("1969-02-02T00:00:00.00Z"));
	}
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateApres2100() throws DateIncorrecteException {
		Mail mail = new Mail();
		mail.setDate(Instant.parse("2101-02-02T00:00:00.00Z"));
	}
	
	@Test
	public final void fauxSiNonImportant() {
		Mail mail = new Mail();
		mail.setImportant(false);
		assertThat(mail.isImportant(), is(false));
	}
}
