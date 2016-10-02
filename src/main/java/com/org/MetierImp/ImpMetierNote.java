package com.org.MetierImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoNote;
import com.org.entities.Client;
import com.org.entities.Note;
import com.org.metierInter.IMetierNote;

@Transactional
public class ImpMetierNote implements IMetierNote{

	private IDaoNote dao;
	
	@Override
	public Note addNote(Note note, Client client) {
		return dao.addNote(note, client);
	}

	@Override
	public Note getNote(Long idNote, Client client) {
		return dao.getNote(idNote, client);
	}

	@Override
	public boolean deleteNote(Long idNote, Client client) {
		return dao.deleteNote(idNote, client);
	}

	@Override
	public Note updateNote(Note note, Client client) {
		return dao.updateNote(note, client);
	}

	@Override
	public List<Note> listClientNote(int min, int max, Client client) {
		return dao.listClientNote(min, max, client);
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
