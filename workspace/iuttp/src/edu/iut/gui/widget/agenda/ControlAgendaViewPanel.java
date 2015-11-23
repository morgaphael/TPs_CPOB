package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

import edu.iut.app.ApplicationSession;

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		
		Calendar calendar =  Calendar.getInstance();
		
		
		JComboBox<String> days = new JComboBox<String>();
		for(String d : ApplicationSession.instance().getDays()){
			days.addItem(d);
		}
		days.setSelectedItem(Calendar.DAY_OF_WEEK);
		this.add(days);

		JComboBox<String> months = new JComboBox<String>();
		for(String m : ApplicationSession.instance().getMonths()){
			months.addItem(m);
		}
		months.setSelectedItem(ApplicationSession.instance().getMonths()[calendar.get(Calendar.MONTH)]);
		this.add(months);

		int currentYear = calendar.get(Calendar.YEAR);
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(currentYear, currentYear-5, currentYear+5, 1));
		
		this.add(spinner);
		
	}
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
