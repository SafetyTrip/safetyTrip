package com.openData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.dto.CityDTO;
import com.dto.HotelDTO;
import com.exception.MyException;
import com.service.CityService;
import com.service.HotelService;

public class GoogleMapAPI {

	public static void main(String[] args) {
		CityService cService = new CityService();
		HotelService hService = new HotelService();
		String pageToken = null;
		
		List<CityDTO> cList = null;
		List<HotelDTO> hList = new ArrayList<>();
		
		try {
			cList = cService.getCityList();
			for(int i=0; i<cList.size(); i++) {
				int cityno = cList.get(i).getCityno();
				String cityename = cList.get(i).getCityename();
				
				try {
					hList = getCountrySafetyList(cityename, pageToken);
					
					for(HotelDTO dto: hList) {
						dto.setCityno(cityno);
						System.out.println(dto);
						hService.hotelInsert(dto);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} catch (MyException e1) {
			e1.printStackTrace();
		}
	}

	private static List<HotelDTO> getCountrySafetyList(String city, String pageToken) throws Exception {
    	List<HotelDTO> list = new ArrayList<>();
    	
    	StringBuilder urlBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/textsearch/xml"); /*URL*/
    	urlBuilder.append("?" + URLEncoder.encode("query","UTF-8") + "=hotel+in+"+city); /*Query*/
    	urlBuilder.append("&" + URLEncoder.encode("key","UTF-8") + "=AIzaSyDx8zY9GlEPzdFHI7Q4DlWgRD8t2K4mf9M"); /*Service Key*/
    	
    	if(pageToken != null)
    		urlBuilder.append("&" + URLEncoder.encode("pagetoken","UTF-8") + "=" + URLEncoder.encode(pageToken, "UTF-8")); /*한 페이지 결과 수*/
        
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
        
        NodeList items = doc.getElementsByTagName("result");

        for(int j=0; j<items.getLength(); j++) {
        	Node item = items.item(j);
        	Element ele = (Element)item;
        	
        	NodeList name = ele.getElementsByTagName("name");
            NodeList address = ele.getElementsByTagName("formatted_address");
            NodeList lat = ele.getElementsByTagName("lat");
            NodeList lng = ele.getElementsByTagName("lng");
            
            HotelDTO dto = new HotelDTO();
            
            dto.setHname(getTextContent(name));
            dto.setAddress(getTextContent(address));
            dto.setLat(getTextContent(lat));
            dto.setLng(getTextContent(lng));
            list.add(dto);
        }
        
        return list;
    }
    
    private static Document stringToDom(String xmlSource) 
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    }
    
    private static String getTextContent(NodeList nl) {
    	Node n = nl.item(0);
    	Element ele = (Element) n;
    	
    	return ele.getTextContent();
    }
}
