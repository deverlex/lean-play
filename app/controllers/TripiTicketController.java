package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.TripiTicketService;
import utils.ResultFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class TripiTicketController extends Controller {

    private final HttpExecutionContext exc;
    private final TripiTicketService ticketService;

    @Inject
    public TripiTicketController(HttpExecutionContext exc, TripiTicketService ticketService) {
        this.exc = exc;
        this.ticketService = ticketService;
    }

    public CompletionStage<Result> findCheapTicket() {
        CompletableFuture<Result> future = new CompletableFuture<>();
        ticketService.findCheapTicket().subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.from(exc.current()))
            .subscribe(new SingleObserver<ObjectNode>() {
                @Override
                public void onSubscribe(Disposable d) {
                    System.out.println("Do something else!");
                }

                @Override
                public void onSuccess(ObjectNode jsonNodes) {
                    future.complete(ok(ResultFactory.createResponse(jsonNodes, true)));
                }

                @Override
                public void onError(Throwable e) {
                    future.complete(ok(ResultFactory.createResponse(e.getMessage(), false)));
                }
            });
        return future;
    }

}
