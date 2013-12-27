package controllers;

import models.Member;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    @Transactional
    public static Result index() {

        Member member = new Member();
        member.setName("Hugo Cura");

        JPA.em().persist(member);

        //JPA.em().find(Member.class, 1L);

        return ok();
    }

}
