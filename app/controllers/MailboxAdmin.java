package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import views.html.mailboxadmin;

public class MailboxAdmin extends Controller {

    public static Result index() {
        return ok(mailboxadmin.render());
    }

}
