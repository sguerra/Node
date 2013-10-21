package model.entities;

public enum UserType
{
    applicant(1),
    company(2),
    admin(3);
   
    int userType;
    private UserType(int userType)
    {
        this.userType = userType;
    }
    public static UserType get(String string)
    {
        for(UserType userType: UserType.values())
        {
            if(userType.toString().equals(string))
                return userType;
        }
        
        return UserType.applicant;
    }
}