package fr.xebia;

import javax.inject.Inject;
import javax.inject.Singleton;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import net.codestory.http.WebServer;

public class App {

    private final UserResource userResource;
    private final SlotResource slotResource;

    @Inject
    public App(UserResource userResource, SlotResource slotResource) {
        this.userResource = userResource;
        this.slotResource = slotResource;
    }

    public static void main( String[] args ) {
        DaggerApp_XkeComponent.create().app().start();
    }

    private void start() {
        new WebServer().
                configure(routes -> routes
                                .add(userResource)
                                .add(slotResource)
                ).start();
    }

    @Module
    static class XkeModule {

        @Provides @Singleton UserDB provideUserDB() { return new UserDB(); }

        @Provides @Singleton SlotDB provideSlotDB() { return new SlotDB(); }

        @Provides @Singleton SlotMailer provideSlotMailer() { return new SlotMailer(); }
    }

    @Singleton
    @Component(modules = {XkeModule.class})
    interface XkeComponent {
        App app();
    }
}
