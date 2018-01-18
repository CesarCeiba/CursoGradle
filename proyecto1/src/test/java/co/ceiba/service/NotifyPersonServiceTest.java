package co.ceiba.service;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;

import co.ceiba.services.EmailService;
import co.ceiba.services.NotifyPersonService;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;

public class NotifyPersonServiceTest {
	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	private Mockito mockito;
	
	@Before
	public void setUp(){
		emailService = mockito.mock(EmailService.class);
		mockito.when(emailService.sendMail(mockito.anyString())).thenReturn("Hola mundo");
		notifyPersonService = new NotifyPersonService(emailService);
		
	}
	
	@Test
	public void notifyTest(){
		//Arrange
		Person person = new PersonTestDataBuilder()
							.build();
		
		
		
		//Act
		String message = notifyPersonService.notify(person);		
		//Assert
		Assert.assertNull(message);
		System.out.println(message);
	}
}
