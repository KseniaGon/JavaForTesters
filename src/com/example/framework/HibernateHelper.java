package com.example.framework;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.utils.HibernateUtil;
import com.example.utils.SortedListOf;

public class HibernateHelper {

	@SuppressWarnings("unchecked")
	public SortedListOf<Group> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<Group>(
              (List<Group>) session.createQuery("from Group").list());
		} finally {
          trans.commit();
		}
	}

	@SuppressWarnings("unchecked")
	public SortedListOf<Contact> getContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<Contact>(
              (List<Contact>) session.createQuery("from Contact").list());
		} finally {
          trans.commit();
		}
	}

}
