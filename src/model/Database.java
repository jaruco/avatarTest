package model;

import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;

public class Database {
		
	public static void sendRequest(String site, String nickname) throws Exception {
		
		String urlSite = (site==null?"MLA":site);
		
		String url = "https://api.mercadolibre.com/sites/"+urlSite+"/search?nickname="+nickname;
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; charset=utf-8");

		con.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.flush();
		wr.close();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		if(response.toString().contains("seller")) {
			JOptionPane.showMessageDialog(null, "USER FOUND IT \n"
					+ "SELLER ID {"+response.toString().substring(32,41)+"}");
		} else {
			JOptionPane.showMessageDialog(null, "USER NOT FOUND!");
		} 
		

	}
}
