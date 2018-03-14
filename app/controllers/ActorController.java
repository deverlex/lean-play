package controllers;

import actors.HelloActor;
import akka.actor.*;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import javax.inject.*;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;

import actors.HelloActorProtocol.*;

import com.google.inject.Singleton;

@Singleton
public class ActorController  extends Controller {

    final ActorRef helloActor;

    @Inject public ActorController(ActorSystem system) {
        helloActor = system.actorOf(HelloActor.getProps());
    }

    public CompletionStage<Result> sayHello(String name) {
        return FutureConverters.toJava(ask(helloActor, new SayHello(name), 1000))
                .thenApply(response -> ok((String) response));
    }
}
