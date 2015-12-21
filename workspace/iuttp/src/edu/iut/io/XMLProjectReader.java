package edu.iut.io;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import edu.iut.app.Classroom;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;
import edu.iut.app.Person.PersonFunction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// EX 1 Completer la classe

public class XMLProjectReader {
	public XMLProjectReader() {
		
	}
	
	public static ArrayList<ExamEvent> load(java.io.File xmlfile) throws Exception {
		ArrayList<ExamEvent> data = new ArrayList<ExamEvent>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document= builder.parse(xmlfile);
			
			Element root = document.getDocumentElement();
			NodeList rootChildren = root.getElementsByTagName("event");
			
			for(int ci = 0; ci < rootChildren.getLength(); ci++){
				/* pour chaque exam event */
				Element event = (Element) rootChildren.item(ci);
				if(event.hasAttributes() && event.hasChildNodes()){ // test de validité
					Instant instant = java.time.Instant.ofEpochSecond(Long.parseLong(event.getAttribute("date")));
					Date examDate = Date.from(instant);
					Classroom room = new Classroom(event.getAttribute("room"));
					
						
					/* etudiant */
					Element studentElement = (Element)event.getElementsByTagName("student").item(0);
					
					Person student = parsePerson(studentElement);
					
					/* jury */
					// le jury
					ArrayList<Person> jury = new ArrayList<Person>();
					NodeList juryNodes = event.getElementsByTagName("jury");
					for(int j = 0; j < juryNodes.getLength(); j++){
						jury.add(parsePerson((Element)juryNodes.item(j)));
					}
					data.add(new ExamEvent(examDate, student, jury, room, null));
				}
				else
				{
					throw new Exception("xml file error");
				}
			}
			
			
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
	
	static Person parsePerson(Element e){		
		String firstname = e.getAttribute("firstname");
		String lastname = e.getAttribute("lastname");
		String email = e.getAttribute("email");
		String phone = e.getAttribute("phone");
		String function = e.getAttribute("function");
		PersonFunction f = PersonFunction.valueOf(function.toUpperCase());
		/* definir le type */
		return new Person(f, firstname, lastname, email, phone);		
	}
}
