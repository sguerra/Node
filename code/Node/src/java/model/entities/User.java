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
    private int age;
    private String phone;
    private String address;
    private String description;
    private String contact;
    
    public User()
    {
        this.name = "";
        this.email = "";
        this.phone = "";
        this.address = "";
        this.description = "";
        this.contact = "";
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
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setContact(String contact){
        this.contact = contact;
    }
    public String getContact(){
        return this.contact;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    
    @Override
    public boolean equals(Object obj) 
    {   
        User user = (User)obj;
        return this.getUserName().equals(user.getUserName())&& this.getPassword().equals(user.getPassword());
    }
}
