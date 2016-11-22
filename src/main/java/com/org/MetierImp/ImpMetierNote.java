package com.org.MetierImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoNote;
import com.org.entities.Client;
import com.org.entities.Note;
import com.org.metierInter.IMetierNote;

@Transactional
public class ImpMetierNote implements IMetierNote{

	private IDaoNote daoNote;
	
	
	
	public void setDaoNote(IDaoNote daoNote) {
		this.daoNote = daoNote;
	}

	@Override
	public Note addNote(Note note, Client client) {
		return daoNote.addNote(note, client);
	}

	@Override
	public Note getNote(Long idNote, Client client) {
		return daoNote.getNote(idNote, client);
	}

	@Override
	public boolean deleteNote(Long idNote, Client client) {
		return daoNote.deleteNote(idNote, client);
	}

	@Override
	public Note updateNote(Note note, Client client) {
		return daoNote.updateNote(note, client);
	}

	@Override
	public List<Note> listClientNote(int min, int max, Client client) {
		return daoNote.listClientNote(min, max, client);
	}

	@Override
	public List<Note> searchNoteByTitle(int min, int max, String titleMotif,
			Client client) {
		return daoNote.searchNoteByTitle(min, max, titleMotif, client);
	}

	@Override
	public List<Note> searchNoteByBodyMotif(int min, int max, String bodyMotif,
			Client client) {
		return daoNote.searchNoteByBodyMotif(min, max, bodyMotif, client);
	}

}
