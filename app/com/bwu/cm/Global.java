package com.bwu.cm;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

    private Injector injector;

    @Override
    public void onStart(Application app) {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
            }
        });

        super.onStart(app);
    }

    @Override
    public void onStop(Application app) {
        super.onStop(app);
    }

    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        return injector.getInstance(controllerClass);
    }

}
