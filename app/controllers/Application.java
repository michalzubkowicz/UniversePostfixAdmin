package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.mailboxlogin;

import static play.data.Form.form;

public class Application extends Controller {

    public static Result index() {
        return ok(mailboxlogin.render(form(AuthenticationMailbox.LoginMailbox.class)));
    }



}
