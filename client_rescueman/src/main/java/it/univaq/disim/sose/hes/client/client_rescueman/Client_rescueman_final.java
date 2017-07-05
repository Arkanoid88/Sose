package it.univaq.disim.sose.hes.client.client_rescueman;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import it.univaq.disim.sose.hes.client_rescueman.EmergencyPT;
import it.univaq.disim.sose.hes.client_rescueman.EmergencyService;
import it.univaq.disim.sose.hes.client_rescueman.GetInfoRequest;
import it.univaq.disim.sose.hes.client_rescueman.GetInfoResponse;

public class Client_rescueman_final {

	public static void main(String[] args) {
		
		JFrame frm = new JFrame("Emergency Health System");
		frm.setSize(700, 600);
		Container frmContentPane = frm.getContentPane();

		
////////// setup swing panels /////////////
		
		// center-upper panel
		JPanel centro = new JPanel();
		JTextField campo = new JTextField(5);
		JLabel head = new JLabel("Insert the patient's ID");
		JLabel instr = new JLabel("<html>By pressing the button you will display the map  in the lower pane <br> and the real-time health  informations on the left side </html>", SwingConstants.CENTER);
		centro.add(head);
		centro.add(campo);
		centro.add(instr);
		centro.setMinimumSize(new Dimension(100,100));
		centro.setMaximumSize(new Dimension(100,100));

		// center-lower panel
		JPanel maps = new JPanel();
		
		//split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,centro, maps);
        splitPane.setOneTouchExpandable(false);
        splitPane.setContinuousLayout(false);
		
        // center-footer panel
        JPanel sud = new JPanel();
		JButton button = new JButton("Get Information");
		JButton button2 = new JButton("Visualize Map");
		sud.add(button);
		sud.add(button2);
        
		// left-panel
		JPanel imgleft = new JPanel();
		ImageIcon image = new ImageIcon("src/main/java/images/1.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		imgleft.add(label, BorderLayout.WEST );
		
		// right-panel
		JPanel info = new JPanel();
		JTextArea textArea = new JTextArea(50, 15);
		info.add(textArea, BorderLayout.EAST);

        // adding panels
        frmContentPane.add(imgleft, BorderLayout.WEST);
		frmContentPane.add(splitPane, BorderLayout.CENTER);
		frmContentPane.add(sud, BorderLayout.SOUTH);
		frmContentPane.add(info, BorderLayout.EAST);
		frm.setVisible(true);
		
		// soap setup
		EmergencyService EmergencyService = new EmergencyService();
		EmergencyPT Emergency = EmergencyService.getEmergencyPort();
		GetInfoRequest param = new GetInfoRequest();

//////////end setup swing panels /////////////

		// event related to the get-info button
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent var){

				// set the id and conversion
				int val = Integer.parseInt(campo.getText());
				param.setID(val);
				param.setServiceId(0);
				
				textArea.setEditable(false);
							
				// request to the prosumer
				GetInfoResponse response = Emergency.getInfo(param);
				
				int index = 0;
				// print the patient's data
				while(index<4){
					textArea.append(response.getResponseType().get(index).getResponseInfoType().getName()+"\n");
					textArea.append(response.getResponseType().get(index).getResponseInfoType().getDescription()+"\n");
					textArea.append(response.getResponseType().get(index).getResponseInfoType().getLastUpdate()+"\n");
					frm.setVisible(true);
					index = index + 1;
				}
				
				// added for thread test
				try {
					maps.removeAll();
					JLabel map = new JLabel((new ImageIcon(new URL(response.getResponseType().get(0).getMapsUrl()))));
					maps.add(map);
					
					frm.setVisible(true);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// thread test
				
				;}
		});
		
		// event related to the map button
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent var){
				
				param.setServiceId(1);
				
				// set the id and conversion
				int val = Integer.parseInt(campo.getText());
				param.setID(val);
				
			  	// request to the prosumer
			  	GetInfoResponse response = Emergency.getInfo(param);
				
			  	// map visualization
				try {
					maps.removeAll();
					JLabel map = new JLabel((new ImageIcon(new URL(response.getResponseType().get(0).getMapsUrl()))));
					maps.add(map);
					
					frm.setVisible(true);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
		}
	  });
	}
}