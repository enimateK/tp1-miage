package com.acme.mailreader.domaine;

import java.util.Comparator;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {

	public int compare(Mail mail1, Mail mail2) {
		if(this.oneMailNull(mail1, mail2)) {
			return 0;
		}
		if (this.notSameImportance(mail1, mail2)) {
			return orderByImportance(mail1, mail2);
		}
		if (this.notSameStatus(mail1, mail2)) {
			return this.orderByStatus(mail1, mail2);
		}
		if (notSameSubject(mail1, mail2)) {
			return orderBySubject(mail1, mail2);
		}
		return orderByDate(mail1, mail2);
	}
	
	private boolean oneMailNull(Mail mail1, Mail mail2) {
		return mail1 == null || mail2 == null;
	}
	
	private boolean notSameImportance(Mail mail1, Mail mail2) {
		return mail1.isImportant() != mail2.isImportant();
	}
	
	private int orderByImportance(Mail mail1, Mail mail2) {
		if (mail1.isImportant() && !mail2.isImportant()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	private boolean notSameStatus(Mail mail1, Mail mail2) {
		return mail1.getStatut() != mail2.getStatut();
	}
	
	private boolean notSameSubject(Mail mail1, Mail mail2) {
		return mail1.getSujet() != mail2.getSujet();
	}

	private int orderByStatus(Mail mail1, Mail mail2) {
		int comp = mail1.getStatut().ordinal()
				- mail2.getStatut().ordinal();
		return comp > 0 ? -1 : 1;
	}
	
	private int orderBySubject(Mail mail1, Mail mail2) {
		return mail2.getSujet().compareTo(mail1.getSujet());
	}
	
	private int orderByDate(Mail mail1, Mail mail2) {
		return mail2.getDate().compareTo(mail1.getDate());
	}
}
