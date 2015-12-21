package edu.iut.io;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.iut.app.ExamEvent;
import edu.iut.app.Person;

//EX 1 Completer la classe 

public class XMLProjectWriter {
	
	public XMLProjectWriter() {		
	}
	
	public static void save(ArrayList<ExamEvent> data, java.io.File xmlfile) throws ParserConfigurationException, TransformerException {
		/*
		  <agenda>
		  		<event date="0123456" room="I205">
		  			<student firstname="raphael" lastname="uzan" email="mail@iut.fr" phone="0123456765" function="Student"/>
		  			<jury firstname="morgan" lastname="feurte" email="mail@iut.fr" phone="0123456765" function="Student"/>
		  			<jury firstname="morgan1" lastname="feurte" email="mail@iut.fr" phone="0123456765" function="Student"/>
		  			<jury firstname="morgan2" lastname="feurte" email="mail@iut.fr" phone="0123456765" function="Student"/>
		  		</event>
		  </agenda>
		 */
		DocumentBuilder builder =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		Document document = builder.newDocument();
		Element root = document.createElement("agenda");

		for(ExamEvent event : data){
			Element eventElement = document.createElement("event");
			
			eventElement.setAttribute("date", Long.toString(event.getExamDate().toInstant().getEpochSecond()));
			eventElement.setAttribute("room", event.getClassroom().getClassRoomNumber());
			Element studentElement = document.createElement("student");
			fillElementFromPerson(studentElement, event.getStudent());
			eventElement.appendChild(studentElement);
			
			for(Person p : event.getJury()){
				Element el = document.createElement("jury");
				fillElementFromPerson(el, p);
				eventElement.appendChild(el);
			}
			document.appendChild(eventElement);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult output = new StreamResult(xmlfile);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.transform(source, output);
		
	}
	
	static Element fillElementFromPerson(Element e, Person p){
		e.setAttribute("firstname", p.getFirstname());
		e.setAttribute("lastname", p.getLastname());
		e.setAttribute("email", p.getEmail());
		e.setAttribute("phone", p.getPhone());
		e.setAttribute("function", p.getFunction().name());
		return e;
	}
}
