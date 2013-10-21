package controller;

import model.petition.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataModel;
import model.response.Response;

public class ServletController extends HttpServlet 
{
    private final String URL_SEPARATOR = "/";
    private final String INS_SEPARATOR = ".";
    private DataModel dataModel;
    
    @Override
    public void init()
    {
        dataModel = DataModel.getInstance();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String fullUrl = request.getRequestURL().toString();
        
        if(fullUrl.indexOf(INS_SEPARATOR)<=0)
        {
            this.sendError(request, response);
            return;
        }
        String [] splitUrl = fullUrl.split(URL_SEPARATOR);
      
        String urlPattern = splitUrl[splitUrl.length-1];
        if(urlPattern.indexOf(INS_SEPARATOR)<=0)
        {
            this.sendError(request, response);
            return;
        }
      
        Map<PetitionParam, Object> params = mapParemeters(request);
        Petition petition = parsePetition(urlPattern, params);
  
        Response dataResponse = dataModel.execute(petition);
        
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
        String sfunction = urlPattern.substring(sub_index +1,urlPattern.length());
        
        if(sfunction.equals("add"))
                return Function.add;
        
        return Function.none;
    }
    private Entity parseEntity(String urlPattern)
    {
        int sub_index = urlPattern.indexOf(INS_SEPARATOR);
        String sentity = urlPattern.substring(0,sub_index);
        
        return Entity.valueOf(sentity);
    }
    
    protected void sendError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        RequestDispatcher distatcher = request.getRequestDispatcher("pages/error.jsp");
        distatcher.forward(request, response);
    }
}
