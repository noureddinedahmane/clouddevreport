package com.org.daoInter;

import java.util.List;

import com.org.entities.Client;
import com.org.entities.Note;

public interface IDaoNote {

	public Note addNote(Note note, Client client);
	public Note getNote(Long idNote, Client client);
	public boolean deleteNote(Long idNote, Client client);
	public Note updateNote(Note note, Client client);
	public List<Note> listClientNote(int min, int max, Client client);
	public List<Note> searchNoteByTitle(int min, int max, String titleMotif, Client client);
	public List<Note> searchNoteByBodyMotif(int min, int max, String bodyMotif, Client client);
	
}
