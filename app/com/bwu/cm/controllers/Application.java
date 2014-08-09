package com.bwu.cm.controllers;

import javax.inject.Inject;
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
