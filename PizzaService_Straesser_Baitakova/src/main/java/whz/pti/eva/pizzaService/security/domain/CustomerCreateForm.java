package whz.pti.eva.pizzaService.security.domain;

import javax.validation.constraints.NotEmpty;

public class CustomerCreateForm {

    @NotEmpty
    private String firstName = "";

    @NotEmpty
    private String lastName = "";

    @NotEmpty
    private String loginName = "";
    
    @NotEmpty
    private String password = "";

    @NotEmpty()
    private String passwordRepeated = "";

//    @NotNull
    private Role role = Role.USER;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "loginName='" + loginName + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                ", role=" + role +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                '}';

    }

}
