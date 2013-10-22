
package controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.petition.Entity;
import model.petition.Function;
import model.petition.Petition;
import model.petition.PetitionParam;

public class PetitionFactory 
{
    private final String URL_SEPARATOR = "/";
    private final String INS_SEPARATOR = ".";
    
    private static PetitionFactory petitionFactory;
    private PetitionFactory()
    {
    }
    public static PetitionFactory getInstance()
    {
        if(petitionFactory==null)
            petitionFactory = new PetitionFactory();
        
        return petitionFactory;
    }
    
    public Petition newPetition(HttpServletRequest request, String fullUrl)
    {
        // Parse Petition
        String urlPattern = getUrlPattern(fullUrl);
        Map<PetitionParam, Object> params = mapParemeters(request);
        Petition petition = parsePetition(urlPattern, params);
  
        return petition;
    }
    
    private String getUrlPattern(String fullUrl)
    {
        String [] splitUrl = fullUrl.split(URL_SEPARATOR);
        String urlPattern = splitUrl[splitUrl.length-1];
        
        return urlPattern;
    }
    
    private Map<PetitionParam,Object> mapParemeters(HttpServletRequest request)
    {
        Map<PetitionParam,Object> map = new HashMap<PetitionParam,Object>();
        
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements())
        {
            String name = names.nextElement();
            map.put(PetitionParam.valueOf(name), request.getParameter(name));
        }
        
        return map;
    }
    private Petition parsePetition(String urlPattern, Map<PetitionParam,Object> params)
    {
        Entity entity = parseEntity(urlPattern);
        Function function = parseFunction(urlPattern);
        Petition petition = new Petition(entity, function);
        petition.setParams(params);
       
        return petition;
    }
    private Function parseFunction(String urlPattern)
    {
        int sub_index = urlPattern.indexOf(INS_SEPARATOR);
        String function = urlPattern.substring(sub_index +1,urlPattern.length());
        
        return Function.valueOf(function);
    }
    private Entity parseEntity(String urlPattern)
    {
        int sub_index = urlPattern.indexOf(INS_SEPARATOR);
        String entity = urlPattern.substring(0,sub_index);
        
        return Entity.valueOf(entity);
    }
    
    public boolean ValidPattern(String fullUrl)
    {
        // Pattern Separators
        if(fullUrl.indexOf(URL_SEPARATOR)<=0)
            return false;
        
        String urlPattern = getUrlPattern(fullUrl);
        if(urlPattern.indexOf(INS_SEPARATOR)<=0)
            return false;
      
        return true;
    }
}
