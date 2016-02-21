package com.dtf.educraft.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Rest {
	public static String[] TERMS;
	public static String[] DEFS;
	public Rest() {
		URL url= null;
		try {
			url = new URL("https://api.quizlet.com/2.0/sets/100256611?client_id=wHzUEeKYTK&whitespace=1");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //Insert your JSON query request
        String query = "{'PARAM1': 'VALUE','PARAM2': 'VALUE','PARAM3': 'VALUE','PARAM4': 'VALUE'}";
        //It change the apostrophe char to double colon char, to form a correct JSON string
        query=query.replace("'", "\"");

        try{
            //make connection
            URLConnection urlc = url.openConnection();
            //It Content Type is so importan to support JSON call
            //urlc.setRequestProperty("Content-Type", "application/xml");
            //urlc.setRequestProperty("Authorization", "application/xml");
            Msj("Rest Call: " + url.toString());
            
            //use post mode
            //urlc.setDoOutput(true);
            //urlc.setAllowUserInteraction(false);

            //send query
            /*PrintStream ps = new PrintStream(urlc.getOutputStream());
            ps.print(query);
            Msj("Here: " + query);
            ps.close();*/

            //get result
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String l = null;
            String in = "";
            while ((l=br.readLine())!=null) {
                Msj(l);
                in += l;
            }
            
            GetTerms(in);
            GetDefinitions(in);
            //br.close();
        } catch (Exception e){
            Msj("Error");
            Msj(e.toString());
        }
	}
	
	 private static void Msj(String texto){
	        //System.out.println(texto);
	        
	    }
	    
	          
	    private static void GetTerms(String texto){
	    
		    String[] terms = new String[100]; 	
	            int idx = 0;
	            for(int i = 0; i < texto.length(); i++) {
				char c = texto.charAt(i);
				if(c == '"' && texto.charAt(i+1) == 't' && texto.charAt(i+2) == 'e') {
					while(c != ' ') {
						i++;
						c = texto.charAt(i);
	                                        //System.out.println(c);
					}
					
					i+=2;
					c = texto.charAt(i);
	                                String out = "";
					while(c != '"') {
						out += c;
	                                        i++;
	                                        c = texto.charAt(i);
	                                        //System.out.println(c);
					}
	                                terms[idx] = out;
	                                
	                                idx++;
				}
	                        
	                        
			}

	            
	/*
	       
	            List<String> list = new ArrayList<String>(Arrays.asList(terms));
	            list.removeAll(Arrays.asList(","));
	            list.removeAll(Arrays.asList("      "));
	            
	            terms = list.toArray(terms);

	*/
	   TERMS = terms;
	            
	    for(int i = 0; i < terms.length; i++) {
	    if(terms[i] == null)
	        break;
	    //System.out.println(terms[i]);
	}
	 //System.out.println("Complete.");
	 
	    }
	    
	     private static void GetDefinitions(String texto){
	    
		    String[] definitions = new String[100]; 	
	            int iex = 0;
	            for(int i = 0; i < texto.length(); i++) {
				char c = texto.charAt(i);
				if(c == '"' && texto.charAt(i+1) == 'd' && texto.charAt(i+2) == 'e' && texto.charAt(i+3) == 'f') {
					while(c != ' ') {
						i++;
						c = texto.charAt(i);
	                                        //System.out.println(c);
					}
					
					i+=2;
					c = texto.charAt(i);
	                                String out = "";
					while(c != '"') {
						out += c;
	                                        i++;
	                                        c = texto.charAt(i);
	                                        //System.out.println(c);
					}
	                                definitions[iex] = out;
	                                iex++;
				}
	                        
	                        
			}
	            DEFS = definitions;
		for(int i = 0; i < definitions.length; i++) {
		    if(definitions[i] == null)
		        break;
		    //System.out.println(definitions[i]);
		}
}

}
