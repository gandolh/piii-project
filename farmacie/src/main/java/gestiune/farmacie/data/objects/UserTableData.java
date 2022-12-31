package gestiune.farmacie.data.objects;

import gestiune.farmacie.controllers.RedirectController;
import gestiune.farmacie.data.access.UserRepository;
import gestiune.farmacie.data.business.objects.User;
import javafx.scene.Node;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserTableData {
    private String userId;
    private String employeeId;
    private String username;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String hiredate;
    private SplitMenuButton actions;
    private BorderPane root;



    public BorderPane getBorderPane() {
        return root;
    }


    public String getUserId() {
        return userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getHiredate() {
        return hiredate;
    }

    public SplitMenuButton getActions() {
        return actions;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public void setActions(SplitMenuButton actions) {
        actions = actions;
    }
    public void setBorderPane(BorderPane root) {
        this.root = root;
    }

    public UserTableData(BorderPane root, User user) {
        userId = user.getUserId();
        employeeId = user.getEmployeeId();
        username = user.getUsername();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        birthdate = PlatformInstance.getDateFormat().format(user.getBirthdate());
        hiredate = PlatformInstance.getDateFormat().format(user.getHiredate());
        actions = new SplitMenuButton();
        actions.setText("Actiuni");
        MenuItem actualizeazaMenuItem = new MenuItem("actualizeaza");
        MenuItem stergeMenuItem = new MenuItem("sterge");

        actualizeazaMenuItem.setOnAction(e -> {
            RedirectController redirect = new RedirectController();
            redirect.goToUpdateUser((Stage) root.getScene().getWindow());
        });

        stergeMenuItem.setOnAction(e -> {
            UserRepository userRepo = new UserRepository();

            boolean isUserDeleted = userRepo.deleteUser(userId, employeeId);
            if(isUserDeleted){
                RedirectController redirect = new RedirectController();
                redirect.goToManageUsers((Stage) root.getScene().getWindow());
            }
        });
        actions.getItems().addAll(actualizeazaMenuItem, stergeMenuItem);

    }
}