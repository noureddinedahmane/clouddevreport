package com.org.loginmodule;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.MetierImp.ImpMetierCalendar;
import com.org.MetierImp.ImpMetierClient;
import com.org.MetierImp.ImpMetierMessage;
import com.org.MetierImp.ImpMetierNote;
import com.org.MetierImp.ImpMetierPatient;
import com.org.MetierImp.ImpMetierTask;
import com.org.entities.Calendar;
import com.org.entities.Client;
import com.org.entities.Message;
import com.org.entities.Note;
import com.org.entities.Patient;
import com.org.entities.Task;

public class TestMetier {

	@Test
	public void testNote() {
		
      try{
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		ImpMetierClient metierClient = (ImpMetierClient) context.getBean("metierClient");
		ImpMetierNote metierNote = (ImpMetierNote) context.getBean("metierNote");
		Client client = metierClient.getClientByUserName("dnoureddine11@gmail.com");
		
		Note note = new Note();
		note.setClient(client);
		note.setTitle("Note Test");
		note.setNote("This is a note content test");
		
		List<Note> list1 =  metierNote.listClientNote(0, 100, client);
		metierNote.addNote(note, client);
		
		List<Note> list2 =  metierNote.listClientNote(0, 100, client);
		
		assertTrue(list1.size()+1==list2.size());
				
      }catch(Exception ex){
    	  assertTrue(ex.getMessage(),false);
	  }
      
	}

	
	@Test
	public void testTask() {
		
      try{
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		ImpMetierClient metierClient = (ImpMetierClient) context.getBean("metierClient");
		ImpMetierTask metierTask = (ImpMetierTask) context.getBean("metierTask");
		Client client = metierClient.getClientByUserName("dnoureddine11@gmail.com");
		
		Task task = new Task();
		task.setClient(client);
		task.setCategory("#eee");
		task.setTaskName("Task Name");
		task.setPriority("Normal");
		task.setStatus("start");
		task.setContent("This a task for testing !!!");
		
		
		List<Task> list1 =  metierTask.listTasks(0, 100, client);
		metierTask.addTask(task, client);
		
		List<Task> list2 = metierTask.listTasks(0, 100, client);
		
		assertTrue(list1.size()+1==list2.size());
				
      }catch(Exception ex){
    	  assertTrue(ex.getMessage(),false);
	  }
      
	}
	
	
	@Test
	public void testPatient() {
		
      try{
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		ImpMetierClient metierClient = (ImpMetierClient) context.getBean("metierClient");
		ImpMetierPatient metierPatient = (ImpMetierPatient) context.getBean("metierPatient");
		Client client = metierClient.getClientByUserName("dnoureddine11@gmail.com");
		
		Patient patient = new Patient();
		patient.setClient(client);
		patient.setFirstName("Noureddine");
		patient.setLastName("Dahmane");
		patient.setGender("Male");
		patient.setEmailAddress("dnoureddine11@gmail.com");
		patient.setOccupation("Student");
		
		
		List<Patient> list1 =  metierPatient.listPatient(0, 100, client);
		metierPatient.addPatient(patient, client);
		
		List<Patient> list2 = metierPatient.listPatient(0, 100, client);
		
		assertTrue(list1.size()+1==list2.size());
				
      }catch(Exception ex){
    	  assertTrue(ex.getMessage(),false);
	  }
      
	}
	
	
	@Test
	public void testMessage() {
		
      try{
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		ImpMetierClient metierClient = (ImpMetierClient) context.getBean("metierClient");
		ImpMetierMessage metierMessage = (ImpMetierMessage) context.getBean("metierMessage");
		Client client = metierClient.getClientByUserName("dnoureddine11@gmail.com");
		
		Message message = new Message();
		message.setClient(client);
		message.setSubject("This a subject for testing!!");
		message.setName("Noureddine Dahmane");
		message.setEmail("dnoureddine11@gmail.com");
		message.setMessageContent("This a Message Content for testinnng !!!!");
		
		
		List<Message> list1 =  metierMessage.listMessages(0, 100, client);
		metierMessage.addMessage(message, client);
		
		List<Message> list2 = metierMessage.listMessages(0, 100, client);
		
		assertTrue(list1.size()+1==list2.size());
				
      }catch(Exception ex){
    	  assertTrue(ex.getMessage(),false);
	  }
      
	}
	
	
	@Test
	public void testCalendar() {
		
      try{
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		ImpMetierClient metierClient = (ImpMetierClient) context.getBean("metierClient");
		ImpMetierCalendar metierCalendar = (ImpMetierCalendar) context.getBean("metierCalendar");
		Client client = metierClient.getClientByUserName("dnoureddine11@gmail.com");
		
		Calendar calendar = new Calendar();
		calendar.setClient(client);
		calendar.setCalendarName("First Calendar");
		
		
		List<Calendar> list1 =  metierCalendar.listCalendar(0, 100, client);
		metierCalendar.addCalendar(calendar, client);
		
		List<Calendar> list2 = metierCalendar.listCalendar(0, 100, client);
		
		assertTrue(list1.size()+1==list2.size());
				
      }catch(Exception ex){
    	  assertTrue(ex.getMessage(),false);
	  }
      
	}
	
	/**   end Test case **/
}
