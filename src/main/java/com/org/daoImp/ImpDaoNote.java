package com.org.daoImp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.org.daoInter.IDaoNote;
import com.org.entities.Client;
import com.org.entities.Note;

public class ImpDaoNote implements IDaoNote{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Note addNote(Note note, Client client) {
		note.setClient(client);
		em.persist(note);
		
		return note;
	}

	@Override
	public Note getNote(Long idNote, Client client) {
		
		Note note =em.find(Note.class, idNote);
		if(note!=null){
			if(note.getClient().equals(client)){
				return note;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public boolean deleteNote(Long idNote, Client client) {
		Note note =em.find(Note.class, idNote);
		if(note!=null){
			if(note.getClient().equals(client)){
				   
				em.remove(note);
				return true;
			}else{
				
				return false;
			}
		}else{
			return false;
		}
		
	}

	@Override
	public Note updateNote(Note note, Client client) {
		 
		if(note.getClient().equals(client)){
			
			em.merge(note);
			return note;
		}else{
			
			return null;
		}
	}

	@Override
	public List<Note> listClientNote(int min, int max, Client client) {
		 
		Query req = em.createQuery("select n from Note n where n.client=:c");
		req.setParameter("c", client);
		req.setFirstResult(min);
		req.setMaxResults(max);
		
		return req.getResultList();
	}

	@Override
	public List<Note> searchNoteByTitle(int min, int max, String titleMotif,
			Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> searchNoteByBodyMotif(int min, int max, String bodyMotif,
			Client client) {
		// TODO Auto-generated method stub
		return null;
	}

}
