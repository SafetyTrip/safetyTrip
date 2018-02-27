package openData;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountrySafetyService/getCountrySafetyList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=vDWEe0Bak75z6yuaW2hqlyT63bzPTV%2FmYuqosQF7tHGBdAydgsftGPol6dIRdj%2BgO2O7eayjm9bGCZ3EtZGIDA%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("Content","UTF-8") + "=" + URLEncoder.encode("안전여행", "UTF-8")); /*내용*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//        urlBuilder.append("&" + URLEncoder.encode("title","UTF-8") + "=" + URLEncoder.encode("소식", "UTF-8")); /*제목*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        String strSb = sb.toString();
        System.out.println(strSb);
        
        Document doc = null;
        try {
			doc = stringToDom(strSb);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        NodeList items = doc.getElementsByTagName("item");

        for(int i=0; i<items.getLength(); i++) {
        	Node item = items.item(i);
        	Element ele = (Element)item;

            NodeList contents = ele.getElementsByTagName("content");
            NodeList countryEnNames = ele.getElementsByTagName("countryEnName");
            NodeList countryNames = ele.getElementsByTagName("countryName");
            NodeList ids = ele.getElementsByTagName("id");
            NodeList titles = ele.getElementsByTagName("title");
            NodeList wrtDts = ele.getElementsByTagName("wrtDt");
            
            String content = getTextContent(contents);
            String contryEnName = getTextContent(countryEnNames);
            String countryName = getTextContent(countryNames);
            String id = getTextContent(ids);
            String title = getTextContent(titles);
            String wrtDt = getTextContent(wrtDts);
            
            System.out.println();
            System.out.println(content);
            System.out.println(contryEnName);
            System.out.println(countryName);
            System.out.println(id);
            System.out.println(title);
            System.out.println(wrtDt);
            System.out.println();
        }
        
    }
    
    public static Document stringToDom(String xmlSource) 
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    }
    
    public static String getTextContent(NodeList nl) {
    	Node n = nl.item(0);
    	Element ele = (Element)n;
    	
    	return ele.getTextContent();
    }

}