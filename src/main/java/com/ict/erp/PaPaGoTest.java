package com.ict.erp;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PaPaGoTest {

	private String clientId = "aVMEeje3zSn8VVRQ9Zue";
	private String clientSecret = "D0cwboSiKl";
	
	@Test
	public void test() throws MalformedURLException {
		HttpURLConnection huc;
		BufferedReader br = null;
		String text = "hi";
		URL url;
		try {
			url = new URL("https://openapi.naver.com/v1/papago/n2mt");
			huc = (HttpURLConnection) url.openConnection();
			huc.setRequestProperty("X-Naver-Client-Id", clientId);
			huc.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			String param = "source=en&target=ko&text=" + text;
			
			huc.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(huc.getOutputStream());
			dos.writeBytes(param);
			dos.flush();
			dos.close();
			
			int status = huc.getResponseCode();
			
			String result;
			StringBuffer sb = new StringBuffer();
			while((result = br.readLine()) != null) {
				sb.append(result);
			}
			br.close();
			if(status!=200) {
				System.out.println(sb.toString());
				throw new IOException(sb.toString());
			}
			ObjectMapper om = new ObjectMapper();
			NaverMsg nm = om.readValue(sb.toString(), NaverMsg.class);
			
			System.out.println(text+ "번역->"+nm.gdtMessage(nm.getResult().getReanslatedText());
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fail("Not yet implemented");
	}

}
