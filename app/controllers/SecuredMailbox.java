package controllers;

import play.mvc.*;
import play.mvc.Http.*;

public class SecuredMailbox extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("mailboxusername");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Application.index());
    }
}
