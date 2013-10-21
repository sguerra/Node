package model.entities;

public enum UserType
{
    applicant(1),
    company(2),
    admin(3),
    user(3);
   
    int value;
    private UserType(int userType)
    {
        this.value = userType;
    }
    public static UserType get(String string)
    {
        for(UserType userType: UserType.values())
        {
            if(String.valueOf(userType.value).equals(string))
                return userType;
        }
        
        return UserType.user;
    }
}