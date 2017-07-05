package it.univaq.disim.sose.hes.maps.client.client_maps;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Renderer {

	private JLabel png;
	private JFrame f;
	
	
	public Renderer(String url) throws MalformedURLException, IOException {
		this.generateGUI(url);
	}
	
	private void generateGUI(String url) throws MalformedURLException, IOException {
		f = new JFrame("Maps");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setMinimumSize(new Dimension(700, 700));
		f.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 350, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 350);
		
		Container cp = f.getContentPane();
		FlowLayout groupLayout = new FlowLayout(FlowLayout.CENTER);
		cp.setLayout(groupLayout);
		
		this.png = new JLabel("Please use console");
		
		cp.add(this.png);
		
		f.pack();
		f.setVisible(true);
		this.OpenStreetMap(url);
		
	}
	
	private void OpenStreetMap(String url) throws MalformedURLException, IOException {

		
		String completeSite = url;
		
		
		//String completeSite = "http://staticmap.openstreetmap.de/staticmap.php?center=" + latitude + "," + longitude + "&zoom=13&size=512x512&maptype=osmarenderer";
		JFrame f = new JFrame("Map for ");
		f.setSize(400, 400);
		
		System.out.println("Processing request. Address: " + completeSite);
		
		try {
			this.png.setIcon(new ImageIcon(new URL(completeSite)));
			f.repaint();
			System.out.print("Process finished. Look at GUI");
		} catch (MalformedURLException e) {
			System.err.println("Cannot download map, aborting...");
			this.png.setText("Cannot download map, please retry");
			e.printStackTrace();
			return;
		}
	}
	
}
