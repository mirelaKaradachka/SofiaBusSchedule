package view.service.readers;
import java.io.IOException;

import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;

public class HtmlReader {
    private static final String VEHILE_TYPE_TRAM = "0";
    private static final String VEHILE_TYPE_BUS = "1";
    private static final String VEHILE_TYPE_TROLLEY = "2";
    private static final String BASE_URL = "http://m.sofiatraffic.bg/";
    

    public static void main(String args[])  {
            Document doc;
            try {
                //http://m.sofiatraffic.bg/schedules/
                doc = Jsoup.connect("http://m.sofiatraffic.bg/schedules?tt=1&ln=94&s=%D0%A2%D1%8A%D1%80%D1%81%D0%B5%D0%BD%D0%B5").get();
            
            String title = doc.title();
              //  doc.charset();
            System.out.println("title is: " + title);  
                //<input type="hidden" value="1" name="vt"/>
                //Elements el = doc.getElementsBy("vt");
                
                //getURLSearchParams(doc);
                long timeStart = java.lang.System.currentTimeMillis();
                 getBusStops(doc);
                long timeEnd = java.lang.System.currentTimeMillis();
                System.out.println("Result: " + (timeEnd - timeStart));
    //            String string = doc.toString();
    //            System.out.println(string);

                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        /**
         * Print attributes used in search in post method @link{rid},@param{lid}, @param vt
         * @param doc
         */
        public static void getURLSearchParams(Document doc){
            String rid = null;
            String lid = null;
            String vt = null;
            Elements inputElements = doc.getElementsByTag("input");
            List<String> paramList = new ArrayList<String>();
            for (Element inputElement : inputElements) {
                String key = inputElement.attr("name");
                String value = null;
                //<input type="hidden" value="140" name="rid">
                if(key!=null){
                    value = inputElement.attr("value");
                    if (key.equals("rid")){
                        rid=value;
                        System.out.println("Rid: " + "  Value: " + value);
                    }
                    if (key.equals("lid")){
                        lid =value;
                        System.out.println("Lit: " + "  Value: " + value);
                    }
                    if (key.equals("vt")){
                        vt= value;
                        System.out.println("Vt: " + "  Value: " + value);
                    }
                }
                System.out.println("Lid:" + lid);
                System.out.println("Rid:" + rid);
                System.out.println("Vt:" + vt);
            }
        }
        
        
        public static void getBusStops(Document doc){
            Map<String,String> stops = new HashMap <String,String>();
            Elements selectItems = doc.getElementsByAttributeValue("name", "stop");
            if(selectItems !=null){
                for (Element selectItem : selectItems){
                Elements options = selectItem.children();
                    System.out.println();
                for (Element option : options) {
                String id = option.id();
                String name = option.text();
                    if(id !=null && name !=null){
                        stops.put(id,name);
                        System.out.println("Id: "+ id + "Name: "+ name);
                        }
                    }
                }
            }
                //css selector
                //String selectedVal = doc.select("select[name=stop]").val();
           // }    
        }
        
    public static Map<String,String> getBusStopsAll(){
        Document doc = null;
        try {
            //http://m.sofiatraffic.bg/schedules/
            doc = Jsoup.connect("http://m.sofiatraffic.bg/schedules?tt=1&ln=94&s=%D0%A2%D1%8A%D1%80%D1%81%D0%B5%D0%BD%D0%B5").get();
        }catch (IOException e) {
                e.printStackTrace();
            }
        Map<String,String> stops = new HashMap <String,String>();
        Elements selectItems = doc.getElementsByAttributeValue("name", "stop");
        if(selectItems !=null){
            for (Element selectItem : selectItems){
            Elements options = selectItem.children();
                System.out.println();
            for (Element option : options) {
            String id = option.id();
            String name = option.text();
                if(id !=null && name !=null){
                    stops.put(id,name);
                    System.out.println("Id: "+ id + "Name: "+ name);
                    }
                }
            }
        }
            //css selector
            //String selectedVal = doc.select("select[name=stop]").val();
       // }    
        return stops;
    }
    
    public static Document searchByBus(String busType, String number){
        Document document = null;
        if(isValidBusType(busType) && number !=null){
            //generateUrl
            //parseResponse
        }
        return document;
    }
    
    private static boolean isValidBusType(String busType){
        boolean isValid = false;
        if(busType != null && (busType.equals(VEHILE_TYPE_TRAM) || busType.equals(VEHILE_TYPE_BUS) || busType.equals(VEHILE_TYPE_TROLLEY))){
            isValid= true;
        }
        return isValid;
    }
    
    //"http://m.sofiatraffic.bg/schedules?tt=1&ln=94&s=%D0%A2%D1%8A%D1%80%D1%81%D0%B5%D0%BD%D0%B5"
    private static String generateURL(String vehileType, String vehileLine){
        String url = null;
// check url parameters is it valid 
        url = BASE_URL + "schedules?" + "tt"+ "=" + vehileType + "&" + "ln"+ "=" + vehileLine + "&" + "s" + "=" + "%D0%A2%D1%8A%D1%80%D1%81%D0%B5%D0%BD%D0%B5";
        System.out.println("URL: " + url);
        return url;
    }
        
}
