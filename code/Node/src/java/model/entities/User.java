package model.entities;

public class User implements java.io.Serializable
{
    private int userId;
    private String name;
    private UserType userType;
    private String username;
    private String password;
    private String email;
    private String image;
    
    public User()
    {
    }
    
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public int getUserId()
    {
        return this.userId;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    
    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }
    public UserType getUserType()
    {
        return this.userType;
    }
    
    public void setUserName(String username)
    {
        this.username = username;
    }
    public String getUserName()
    {
        return this.username;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }
   
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }
    
    public void setImage(String image)
    {
        this.image = image;
    }
    public String getImage()
    {
        return this.image;
    }
}
