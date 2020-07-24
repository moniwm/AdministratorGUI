package AdminClient;

import sun.security.provider.MD5;

public class Users {

    private String name;
    private String email;
    private String password;
    private boolean chef;
    private boolean admin;

    public Users(String name, String email, String password, boolean chef, boolean admin){

        this.name = name;
        this.email = email;
        this.chef = chef;
        this.admin = admin;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean isChef(){
        return this.chef;
    }

    public boolean isAdmin(){
        return this.admin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", chef=" + chef +
                ", admin=" + admin +
                '}' + '\n';
    }
}
