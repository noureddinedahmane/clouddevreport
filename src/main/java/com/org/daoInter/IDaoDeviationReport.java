package com.org.daoInter;

import java.util.List;

import com.org.entities.*;

public interface IDaoDeviationReport {

	//deivation
	public 	Deviation addDeviation(Deviation deviation, Client client );
	public Deviation updateDeviation(Deviation deviation, Client client);
	public Deviation getDeviation(String deviationRef, Client client);
	public List<Deviation> listDeviation(Domain domain, Client client, int min, int max);
	public Long getNumberOfDeviationByDomain(Domain domain);
	public Deviation getDeviationById(Long id);
	public List<Deviation> filterDeviation(DeviationFilterForm devFilterForm, Domain domain);
	
	//Attachement
	public Attachement addAttachment(Attachement attachement,Deviation deivation, Client client);
	public Attachement getAttachement(Long idAttachement, Client client);
	public void deleteAttachement(Long idAttachement, Client client);
	public List<Attachement> listAttachement(Long idDeviation, Client client);
	
	//Historical
	public Historical addHistorical(Historical historical,Deviation deivation, Client client);
	public List<Historical> listHistorical(Long idDeviation, Client client);
	
	//Approvement Group
	public ApprovementGroup addApprovementGroup(ApprovementGroup approvementGroup, Domain domain);
	public ApprovementGroup updateApprovementGroup(ApprovementGroup approvementGroup, Domain domaint);
	public void deleteApprovementGroup(Long idApprovementGroup, Domain domain);
	public ApprovementGroup getApprovementGroup(Long idApprovementGroup, Domain domain);
	public List<ApprovementGroup> listApprovementGroup(Domain domain);
	public List<ApprovementGroup> listApprovementGroupByAccount(Account account);
	
	//Approvement
	public Approvement addApprovement(Approvement approvement, Client client);
	public Approvement updateApprovement(Approvement approvement, Client client);
	public Approvement getApprovement(Long idApprovement, Client client);
	public List<Approvement> listApprovement(Deviation deviation, Client client);
	
	//Domain
	public Domain addDomain(Domain domain, Client client);
	public Domain updateDomain(Domain domain, Client client);
	public Domain getDomain(Long idDomain, Client client);
	public void deleteDomain(Long idDomain, Client client);
	public List<Domain> listDomain(Client client);
	public List<Domain> listDomainsByAccount(Account account);
	
	//configuration
	public Configuration addConfiguration(Configuration configuration,Domain domain, Client client);
	public Configuration updateConfiguration(Configuration configuration,Domain domain, Client client);
	public Configuration getConfiguration(Long idConfig, Client client);
	
	
	//user appprovement group
	public UserApprovementGroup addUserApprovementGroup(UserApprovementGroup userApprovementGroup);
	public UserApprovementGroup getUserApprovementGroup(Long id);
	public List<Client> listClientInUserGroup(ApprovementGroup approvementGroup);
	public boolean isUserInGroup(Client client, ApprovementGroup approvementGroup);
	public List<ApprovementGroup> listApprovementGroupByDomain(Domain domain);
	
	
	//deviation type
	public DeviationType addDeviationType(DeviationType deviationType);
	public DeviationType getDeviationType(Long id);
	public List<DeviationType> listDeviationTypeByDomain(Domain domain);
	public DeviationType updateDeviationType(DeviationType deviationType);
	public void deleteDeviationType(Long id);
	
	
	//Notification
	public Notification addNotication(Notification not);
	public Notification updateNotication(Notification not);
	public Notification getNotification(Long idNotification);
	public void deleteNotication(Long idNotification);
	public List<Notification> listNotReadNotificationByClient(Client client);
	public List<Notification> listAllNotificationByClient(Client client);
	
	
	
}
