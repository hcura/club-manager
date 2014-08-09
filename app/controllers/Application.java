package controllers;

import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    @Inject
    public Application() {
    }

    public Result index() {
        return ok();
    }

}
