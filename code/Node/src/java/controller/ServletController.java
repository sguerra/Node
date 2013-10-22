package controller;

import model.petition.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DataModel;
import model.entities.*;
import model.response.Response;
import model.response.ResponseObject;
import model.response.Status;

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
        
        if(!this.ValidPattern(fullUrl))
        {
            this.sendError(request, response);
            return;
        }
        
        // Parse Petition
        String urlPattern = getUrlPattern(fullUrl);
        Map<PetitionParam, Object> params = mapParemeters(request);
        Petition petition = parsePetition(urlPattern, params);
  
        //Dispatch Response
        Response dataResponse = dataModel.execute(petition);
        this.dispatch(request, response, dataResponse);
    }
    
    private boolean ValidPattern(String fullUrl)
    {
        // Pattern Separators
        if(fullUrl.indexOf(URL_SEPARATOR)<=0)
            return false;
        String urlPattern = getUrlPattern(fullUrl);
        if(urlPattern.indexOf(INS_SEPARATOR)<=0)
            return false;
      
        return true;
    }
    private String getUrlPattern(String fullUrl)
    {
        String [] splitUrl = fullUrl.split(URL_SEPARATOR);
        String urlPattern = splitUrl[splitUrl.length-1];
        
        return urlPattern;
    }
    
    
    private void dispatch(HttpServletRequest request,HttpServletResponse response, Response dataResponse) throws ServletException, IOException 
    {
        Petition petition = dataResponse.getPetition();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/error.jsp");
        HttpSession session = request.getSession();
        
        switch(petition.getFunction())
        {
            case login:
                
                if(petition.getEntity()==Entity.user)
                {
                    if(dataResponse.getStatus()== Status.Succes)
                    {   
                        User user = (User)dataResponse.get(ResponseObject.user);
                        session.setAttribute(Entity.user.toString(), user);

                        if(user.getUserType()==UserType.admin)
                            dispatcher = request.getRequestDispatcher("/admin.jsp");
                        else
                            dispatcher = request.getRequestDispatcher("/prospects.jsp");
                    }
                    else
                    {
                        dispatcher = request.getRequestDispatcher("/index.jsp");
                    }
                        
                }
                
                break;
            case add:
                
                if(petition.getEntity()==Entity.user)
                {
                    User user = (User)dataResponse.get(ResponseObject.user);
                    session.setAttribute(Entity.user.toString(), user);
                    dispatcher = request.getRequestDispatcher("/profile.jsp");
                }
                
                break;
            case apply:
                break;
            case delete:
                
                if(petition.getEntity()==Entity.user)
                {
                    session.removeAttribute(Entity.user.toString());
                    session.removeAttribute(Entity.applicant.toString());
                    session.removeAttribute(Entity.company.toString());
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                
                break;
            case modify:
                
                if(petition.getEntity()==Entity.applicant)
                {
                    session.setAttribute(Entity.user.toString(), dataResponse.get(ResponseObject.applicant));
                    dispatcher = request.getRequestDispatcher("/profile.jsp");
                }
                if(petition.getEntity()==Entity.company)
                {
                    session.setAttribute(Entity.user.toString(), dataResponse.get(ResponseObject.company));
                    dispatcher = request.getRequestDispatcher("/profile.jsp");
                }
                
                break;
            case logout:
                
                if(petition.getEntity()==Entity.user)
                {
                    session.removeAttribute(Entity.user.toString());
                    session.removeAttribute(Entity.applicant.toString());
                    session.removeAttribute(Entity.company.toString());
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                
                break;
            case get:
                
                this.dispatchGetJSON(request, response, dataResponse);
                
                break;
            default:
                return;
        }
        
        dispatcher.forward(request, response);
    }
    
    private void dispatchGetJSON(HttpServletRequest request,HttpServletResponse response, Response dataResponse) throws ServletException, IOException
    {
        response.setHeader("content-type","application/json");
        PrintWriter out = response.getWriter();
        try 
        {
            switch(dataResponse.getPetition().getEntity()){
                case skill:
                    
                    out.write(dataResponse.get(ResponseObject.skills).toString());
                    
                    break;
                case employment:
                    
                    out.write(dataResponse.get(ResponseObject.employments).toString());
                    
                    break;
                default:
                    break;
            }
        } finally {
            out.close();
        }
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
    protected void sendError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        RequestDispatcher distatcher = request.getRequestDispatcher("/pages/error.jsp");
        distatcher.forward(request, response);
    }
}
