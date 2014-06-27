package controllers;

import models.User;
import play.data.Form;
import play.mvc.Result;
import views.html.adminlogin;
import views.html.mailboxlogin;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.adminlogin;

import static play.data.Form.form;
import static play.mvc.Controller.flash;
import static play.mvc.Controller.session;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;


public class AuthenticationMailbox  {

    public static Result authenticate() {
        Form<LoginMailbox> loginForm = form(LoginMailbox.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(mailboxlogin.render(loginForm));
        } else {
            session().clear();
            session("username", loginForm.get().username);
            return redirect(
                    routes.MailboxAdmin.index()
            );
        }
    }

    public static Result login() {
        return ok(
                mailboxlogin.render(form(LoginMailbox.class))
        );
    }


    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.AuthenticationMailbox.login()
        );
    }

    public static class LoginMailbox {

        public String username;
        public String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String validate() {
            if (!User.authenticate(username, password)) {
                return "Invalid username or password";
            }
            return null;
        }
    }

}
