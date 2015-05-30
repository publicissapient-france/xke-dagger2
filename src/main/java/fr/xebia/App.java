package fr.xebia;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import net.codestory.http.WebServer;

import javax.inject.Inject;
import javax.inject.Singleton;

public class App {

    private final SlotResource slotResource;
    private final UserResource userResource;

    @Inject
    public App(SlotResource slotResource, UserResource userResource) {
        this.slotResource = slotResource;
        this.userResource = userResource;
    }

    public static void main( String[] args ) {
        ObjectGraph objectGraph = ObjectGraph.create(new XkeModule());
        App app = objectGraph.get(App.class);
        app.start();
    }

    private void start() {
        new WebServer().
                configure(routes -> routes
                                .add(userResource)
                                .add(slotResource)
                ).start();
    }

    @Module(
            injects = App.class,
            includes = {UserModule.class, SlotModule.class}
    )
    static class XkeModule {

    }

    @Module(
            library=true
    )
    static class UserModule {

        @Provides @Singleton UserDB providesUserDB(){
            return new UserDB();
        }

        @Provides
        Mailer providesMailer(){
            return new Mailer();
        }

    }

    @Module(
            library=true
    )
    static class SlotModule {

        @Provides @Singleton SlotDB providesSlotDB(){
            return new SlotDB();
        }

        @Provides
        Mailer providesMailer(){
            return new Mailer();
        }

    }

}
