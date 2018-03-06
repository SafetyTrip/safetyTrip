package com.openData;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import com.dto.CountryDTO;
import com.dto.OpenDataDTO;
import com.dto.SafetyDTO;
import com.exception.MyException;
import com.service.CountryService;
import com.service.SafetyService;

import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
    	int no = 1;
    	List<OpenDataDTO> oList = null;
		
    	int size = 1;
    	while(size > 0) {
    		try {
    			oList = getCountrySafetyList(Integer.toString(no));
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	
    		size = oList.size();
    		
    		for(int i=0; i<size; i++) {
    			CountryService cService = new CountryService();
    			String cname = oList.get(i).getCountryName();
    			
    			CountryDTO cDTO = null;
    			try {
    				cDTO = cService.countrySelectByCname(cname);
    				
    				if(cDTO != null) {
    					SafetyService sService = new SafetyService();
    					SafetyDTO sDTO = new SafetyDTO();
    					
    					sDTO.setCouno(cDTO.getCouno());
    					sDTO.setTitle(oList.get(i).getTitle());
    					sDTO.setContent(oList.get(i).getContent());
    					sDTO.setId(oList.get(i).getId());
    					sDTO.setCreateDate(oList.get(i).getWrtDt());
    					
    					sService.safetyInsert(sDTO);
    				}
    			} catch (MyException e) {
					e.printStackTrace();
					break;
				}
    		}
    		
    		String lastDt = oList.get(size-1).getWrtDt();
    		String[] dts = lastDt.split("-");
    		
    		if(dts.length > 0) {
	    		int year = Integer.parseInt(dts[0]);
	    		
	    		if(year < 2016) {
	    			break;
	    		} else {
	    			no++;
	    		}
    		} else {
    			break;
    		}
    	}
        
    }
    
    private static List<OpenDataDTO> getCountrySafetyList(String pageNo) throws Exception {
    	List<OpenDataDTO> list = new ArrayList<>();
    	
    	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountrySafetyService/getCountrySafetyList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=vDWEe0Bak75z6yuaW2hqlyT63bzPTV%2FmYuqosQF7tHGBdAydgsftGPol6dIRdj%2BgO2O7eayjm9bGCZ3EtZGIDA%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("Content","UTF-8") + "=" + URLEncoder.encode("안전여행", "UTF-8")); /*내용*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지 번호*/
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
        	OpenDataDTO oDTO = new OpenDataDTO();
        	Node item = items.item(i);
        	Element ele = (Element)item;

            NodeList contents = ele.getElementsByTagName("content");
            NodeList countryEnNames = ele.getElementsByTagName("countryEnName");
            NodeList countryNames = ele.getElementsByTagName("countryName");
            NodeList ids = ele.getElementsByTagName("id");
            NodeList titles = ele.getElementsByTagName("title");
            NodeList wrtDts = ele.getElementsByTagName("wrtDt");
            
            oDTO.setContent(getTextContent(contents));
            oDTO.setCountryEnName(getTextContent(countryEnNames));
            oDTO.setCountryName(getTextContent(countryNames));
            oDTO.setId(getTextContent(ids));
            oDTO.setTitle(getTextContent(titles));
            oDTO.setWrtDt(getTextContent(wrtDts));
            
            list.add(oDTO);
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