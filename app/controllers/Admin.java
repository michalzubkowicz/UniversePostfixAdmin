package controllers;


import models.Label;
import models.User;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.admin;

import java.util.List;

import static play.data.Form.form;

@Security.Authenticated(Secured.class)
public class Admin extends Controller {


    public static Result index() {
        return ok(admin.render());
    }


    public static Result indexLabel() {
        List<Label> o = Label.find.orderBy("name ASC").findList();
        return ok(Json.toJson(o));
    }

    public static Result createLabel() {
        Label o = form(Label.class).bindFromRequest().get();
        o.save();
        return created(Json.toJson(o));
    }

    public static Result updateLabel(Long id) {
        Label o = Label.find.byId(id);
        if (o == null) return notFound("Object not found!");
        o = form(Label.class).bindFromRequest().get();
        o.update();
        return status(202, Json.toJson(o));
    }

    public static Result changepassword() {
        try {
            User.changeCurrentUserPassword(request().body().asFormUrlEncoded().get("password")[0]);
        } catch(Exception e) {
            Logger.error("Error when changing password:"+e.getMessage(),e);
            return internalServerError(e.getMessage());
        }
        return ok("");
    }



}