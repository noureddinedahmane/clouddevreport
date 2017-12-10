package com.org.daoImp;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.org.daoInter.IDaoDeviationReport;
import com.org.entities.Account;
import com.org.entities.Approvement;
import com.org.entities.ApprovementGroup;
import com.org.entities.Attachement;
import com.org.entities.Client;
import com.org.entities.Configuration;
import com.org.entities.Deviation;
import com.org.entities.DeviationFilterForm;
import com.org.entities.DeviationType;
import com.org.entities.Domain;
import com.org.entities.Historical;
import com.org.entities.Notification;
import com.org.entities.UserApprovementGroup;

public class ImpDaoDeviationReport implements IDaoDeviationReport{

	@PersistenceContext
	private EntityManager em;
	 
	@Override
	public Deviation addDeviation(Deviation deviation, Client client) {
		deviation.setClient(client);
		em.persist(deviation);
		return deviation;
	}

	@Override
	public Deviation updateDeviation(Deviation deviation, Client client) {
		deviation.setClient(client);
		em.merge(deviation);
		return deviation;
	}

	@Override
	public Deviation getDeviation(String deviationRef, Client client) {
		
		Query req = em.createQuery("select d from Deviation d where d.deviationRef=:dr");
		req.setParameter("dr", deviationRef);
		
		return (Deviation)req.getSingleResult();
	}

	@Override
	public List<Deviation> listDeviation(Domain domain, Client client, int min,
			int max) {
		
		Query req = em.createQuery("select d from Deviation d where d.client.domain=:dm order by d.idDeviation desc");
		req.setParameter("dm", domain);
		req.setFirstResult(min);
		req.setMaxResults(max);
		
		return req.getResultList();
	}

	@Override
	public Attachement addAttachment(Attachement attachement,Deviation deivation, Client client) {
		attachement.setDeviation(deivation);
		em.persist(attachement);
		return attachement;
	}

	@Override
	public Attachement getAttachement(Long idAttachement, Client client) {
		return em.find(Attachement.class, idAttachement);
	}

	@Override
	public void deleteAttachement(Long idAttachement, Client client) {
		Attachement attach = em.find(Attachement.class, idAttachement);
		em.remove(attach);
		
	}

	@Override
	public List<Attachement> listAttachement(Long idDeviation, Client client) {
		
		Query req = em.createQuery("select a from Attachement a where a.deviation.idDeviation=:d");
		req.setParameter("d", idDeviation);
		
		return req.getResultList();
	}

	@Override
	public Historical addHistorical(Historical historical,Deviation deivation , Client client) {
		historical.setDeviation(deivation);
		em.persist(historical);
		return historical;
	}

	@Override
	public List<Historical> listHistorical(Long idDeviation, Client client) {
		Query req = em.createQuery("select h from Historical h where h.deviation.idDeviation=:d");
		req.setParameter("d", idDeviation);
		
		return req.getResultList();
	}

	@Override
	public ApprovementGroup addApprovementGroup(
			ApprovementGroup approvementGroup, Domain domain) {
		
		approvementGroup.setDomain(domain);;
		em.persist(approvementGroup);
		return approvementGroup;
	}

	@Override
	public ApprovementGroup updateApprovementGroup(
			ApprovementGroup approvementGroup, Domain domain) {
		
		approvementGroup.setDomain(domain);
		em.merge(approvementGroup);
		return approvementGroup;
	}

	@Override
	public void deleteApprovementGroup(Long idApprovementGroup, Domain domain) {
		ApprovementGroup approvementGroup = em.find(ApprovementGroup.class,idApprovementGroup);
		em.remove(approvementGroup);
	}

	@Override
	public ApprovementGroup getApprovementGroup(Long idApprovementGroup,
			Domain domain) {
		return em.find(ApprovementGroup.class,idApprovementGroup);
	}

	@Override
	public List<ApprovementGroup> listApprovementGroup(Domain domain) {
		
		Query req = em.createQuery("select a from ApprovementGroup a where a.domain=:dm");
		req.setParameter("dm", domain);
		
		return req.getResultList();
	}

	@Override
	public Approvement addApprovement(Approvement approvement, Client client) {
		approvement.setClient(client);
		em.persist(approvement);
		return approvement;
	}

	@Override
	public Approvement updateApprovement(Approvement approvement, Client client) {
		em.merge(approvement);
		return approvement;
	}

	@Override
	public Approvement getApprovement(Long idApprovement, Client client) {
		return em.find(Approvement.class, idApprovement);
	}

	@Override
	public List<Approvement> listApprovement(Deviation deviation, Client client) {
		
		Query req = em.createQuery("select a from Approvement a where a.deviation=:d");
		req.setParameter("d", deviation);
		
		return req.getResultList();
	}

	@Override
	public Domain addDomain(Domain domain, Client client) {
		domain.setClient(client);
		em.persist(domain);
		return domain;
	}

	@Override
	public Domain updateDomain(Domain domain, Client client) {
		domain.setClient(client);
		em.merge(domain);
		return domain;
	}

	@Override
	public Domain getDomain(Long idDomain, Client client) {
		return em.find(Domain.class, idDomain);
	}

	@Override
	public void deleteDomain(Long idDomain, Client client) {
		Domain domain = em.find(Domain.class, idDomain);
		em.remove(domain);
	}

	@Override
	public List<Domain> listDomain(Client client) {
		Query req = em.createQuery("select d from Domain d where d.client.idClient=:c");
		req.setParameter("c", client.getIdClient());
		
		return req.getResultList();
	}

	@Override
	public Configuration addConfiguration(Configuration configuration, Domain domain,
			Client client) {
		
		configuration.setDomain(domain);
		em.persist(configuration);
		return configuration;
	}

	@Override
	public Configuration updateConfiguration(Configuration configuration,Domain domain,
			Client client) {
		configuration.setDomain(domain);
		em.merge(configuration);
		return configuration;
	}

	@Override
	public Configuration getConfiguration(Long idConfig, Client client) {
       return em.find(Configuration.class, idConfig);
	}

	@Override
	public List<Domain> listDomainsByAccount(Account account) {
		Query req = em.createQuery("select d from Domain d where d.account=:a");
		req.setParameter("a", account);
		
		return req.getResultList();
	}

	@Override
	public List<ApprovementGroup> listApprovementGroupByAccount(Account account) {
		Query req = em.createQuery("select a from ApprovementGroup a where a.domain.account=:x");
		req.setParameter("x", account);
		
		return req.getResultList();
	}

	@Override
	public UserApprovementGroup addUserApprovementGroup(UserApprovementGroup userApprovementGroup) {
		em.persist(userApprovementGroup);
		return userApprovementGroup;
	}

	@Override
	public UserApprovementGroup getUserApprovementGroup(Long id) {
		return em.find(UserApprovementGroup.class, id);
	}

	@Override
	public List<Client> listClientInUserGroup(ApprovementGroup approvementGroup) {
		Query req = em.createQuery("select a.client from UserApprovementGroup a where a.approvementGroup=:x");
		req.setParameter("x", approvementGroup);
		
		return req.getResultList();
	}

	@Override
	public boolean isUserInGroup(Client client, ApprovementGroup approvementGroup) {
		Query req = em.createQuery("select a from UserApprovementGroup a where a.approvementGroup=:x and a.client=:y");
		req.setParameter("x", approvementGroup);
		req.setParameter("y", client);
		
		if(req.getResultList().size() == 0) {
			return false;
		}else {
			return true;
		}

	}

	@Override
	public List<ApprovementGroup> listApprovementGroupByDomain(Domain domain) {
		Query req = em.createQuery("select a from ApprovementGroup a where a.domain=:x");
		req.setParameter("x", domain);
		
		return req.getResultList();
	}

	@Override
	public DeviationType addDeviationType(DeviationType deviationType) {
		em.persist(deviationType);
		return deviationType;
	}

	@Override
	public DeviationType getDeviationType(Long id) {
		DeviationType deviationType = em.find(DeviationType.class, id);
		return deviationType;
	}

	@Override
	public List<DeviationType> listDeviationTypeByDomain(Domain domain) {
		Query req = em.createQuery("select d from DeviationType d where d.domain=:x");
		req.setParameter("x", domain);
		
		return req.getResultList();
	}

	@Override
	public DeviationType updateDeviationType(DeviationType deviationType) {
		em.merge(deviationType);
		return deviationType;
	}

	@Override
	public void deleteDeviationType(Long id) {
		DeviationType deviationType = em.find(DeviationType.class, id);
		if(deviationType != null) {
			em.remove(deviationType);
		}
		
	}

	@Override
	public Long getNumberOfDeviationByDomain(Domain domain) {
		Query req = em.createQuery("select count(d) from Deviation d where d.domain=:x");
		req.setParameter("x", domain);
		
		return (Long)req.getSingleResult();
	}

	@Override
	public Notification addNotication(Notification not) {
		em.persist(not);
		return not;
	}

	@Override
	public Notification updateNotication(Notification not) {
		em.merge(not);
		return not;
	}

	@Override
	public Notification getNotification(Long idNotification) {
		return em.find(Notification.class, idNotification);
	}

	@Override
	public void deleteNotication(Long idNotification) {
		Notification not = em.find(Notification.class, idNotification);
		if(not != null) {
			em.remove(not);
		}
		
	}

	@Override
	public List<Notification> listNotReadNotificationByClient(Client client) {
		Query req = em.createQuery("select n from Notification n where n.client=:x and n.isRead=:y");
		req.setParameter("x", client);
		req.setParameter("y", false);
		
		return req.getResultList();
	}

	@Override
	public List<Notification> listAllNotificationByClient(Client client) {
		Query req = em.createQuery("select n from Notification n where n.client=:x");
		req.setParameter("x", client);
		
		return req.getResultList();
	}

	@Override
	public Deviation getDeviationById(Long id) {
		return em.find(Deviation.class, id);
	}

	@Override
	public List<Deviation> filterDeviation(DeviationFilterForm devFilterForm, Domain domain) {
       
		/*
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Deviation> criteriaQuery = builder.createQuery(Deviation.class);
		Root<Deviation> deviationRoot = criteriaQuery.from(Deviation.class);
		criteriaQuery.select(deviationRoot);
		
		criteriaQuery.where(builder.equal(deviationRoot.get("domain"), domain));
		
		if(devFilterForm.getDeviationRef() != "") {
			criteriaQuery.where(builder.equal(deviationRoot.get("deviationRef"),devFilterForm.getDeviationRef()));
		}
		if(devFilterForm.getAnlage() != "") {
			criteriaQuery.where(builder.equal(deviationRoot.get("anlage"),devFilterForm.getAnlage()));
		}
		if(devFilterForm.getProduct() != "") {
			criteriaQuery.where(builder.equal(deviationRoot.get("product"),devFilterForm.getProduct()));
		}
		if(!devFilterForm.getDeviationType().equals("none")) {
			criteriaQuery.where(builder.equal(deviationRoot.get("deviationType"),devFilterForm.getDeviationType()));
		}
		if(devFilterForm.getStartDate() != null && devFilterForm.getEndDate() != null) {
			criteriaQuery.where(builder.between(deviationRoot.get("dateCreation").as(Date.class), devFilterForm.getStartDate(), devFilterForm.getEndDate()));
		}
		*/
		
		String query = "Select d from Deviation d where ";
		
		if(devFilterForm.getDeviationRef() != "") {
			query += "d.deviationRef = '" + devFilterForm.getDeviationRef() + "' and ";
		}
		if(devFilterForm.getAnlage() != "") {
			query += "d.anlage = '" + devFilterForm.getAnlage() + "' and ";
		}
		if(devFilterForm.getProduct() != "") {
			query += "d.product = '" + devFilterForm.getProduct() + "' and ";
		}
		if(!devFilterForm.getDeviationType().equals("none")) {
			query += "d.deviationType = '" + devFilterForm.getDeviationType() + "' and ";
		}
		if(devFilterForm.getStartDate() != null && devFilterForm.getEndDate() != null) {
			//criteriaQuery.where(builder.between(deviationRoot.get("dateCreation").as(Date.class), devFilterForm.getStartDate(), devFilterForm.getEndDate()));
			query += "d.dateCreation between '" +  devFilterForm.getStartDate() + "' and  '" + devFilterForm.getEndDate() + "' and ";
		}

		//make sure all deviations belong the user domain
		query += "d.domain=:dm";
		
		
		Query req = em.createQuery(query);
		
		req.setParameter("dm", domain);
		
		return req.getResultList();
		
	}

}
