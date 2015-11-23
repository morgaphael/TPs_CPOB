package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;

public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;

	protected void setupUI() {

		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(
				layerLayout, contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);

		contentPane.add(dayView, ActiveView.DAY_VIEW.name());
		contentPane.add(weekView, ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView, ActiveView.MONTH_VIEW.name());

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				agendaViewPanel, contentPane);
		this.setContentPane(splitPane);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		/* File Menu */
		/** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP **/

		ActionListener not_implemented = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Not implemented");
			}
		};

		menu = new JMenu("File");

		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);

		menuItem = new JMenuItem("Load");
		menu.add(menuItem);
		menuItem.addActionListener(not_implemented);

		menuItem = new JMenuItem("Save");
		menu.add(menuItem);
		menuItem.addActionListener(not_implemented);

		menuItem = new JMenuItem("Quit");
		menu.add(menuItem);
		menuItem.addActionListener(not_implemented);

		menu = new JMenu("Edit");

		menu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(menu);

		JMenu sub = new JMenu("View");
		menu.add(sub);

		JMenuItem menuItem1 = new JMenuItem("Month");
		sub.add(menuItem1);
		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layerLayout.show(contentPane, ActiveView.MONTH_VIEW.name());
			}
		});

		menuItem1 = new JMenuItem("Week");
		sub.add(menuItem1);
		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layerLayout.show(contentPane, ActiveView.WEEK_VIEW.name());
			}
		});

		menuItem1 = new JMenuItem("Day");
		sub.add(menuItem1);
		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layerLayout.show(contentPane, ActiveView.DAY_VIEW.name());
			}
		});

		menu = new JMenu("Help");

		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);

		menuItem = new JMenuItem("Display");
		menu.add(menuItem);
		menuItem.addActionListener(not_implemented);

		menuItem = new JMenuItem("About");
		menu.add(menuItem);
		menuItem.addActionListener(not_implemented);

		this.setJMenuBar(menuBar);
		this.pack();
		layerLayout.next(contentPane);
	}

	public SchedulerFrame() {
		super();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}

	public SchedulerFrame(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setupUI();
	}

}
