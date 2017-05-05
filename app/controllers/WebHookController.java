package controllers;

import com.google.common.collect.Lists;
import com.stripe.model.*;
import com.stripe.net.APIResource;
import models.Db;
import org.apache.commons.lang3.tuple.Pair;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class WebHookController extends Controller {

    private static final List<String> acceptedEvents = Lists.newArrayList("charge.succeeded",
            "customer.created",
            "customer.subscription.created");

    public Result handle() {
        Event eventJson = APIResource.GSON.fromJson(request().body().asText(), Event.class);
        eventJson.getData().getObject();

        if(acceptedEvents.contains(eventJson.getType())) {
            Object obj = eventJson.getData().getObject();
            Long created = eventJson.getCreated();

            if (obj instanceof Charge) {
                handle(created, (Charge) obj);
            } else if (obj instanceof Customer) {
                handle(created, (Customer) obj);
            } else if (obj instanceof Subscription) {
                handle(created, (Subscription) obj);
            } else {
                System.err.println("Invalid obj detected");
            }
        }

        return ok();
    }

    private void handle(Long created, Charge charge) {
        Db.charges.add(Pair.of(created, charge));
    }

    private void handle(Long created, Customer customer) {
        Db.customers.add(Pair.of(created, customer));
    }

    private void handle(Long created, Subscription subscription) {
        Db.subscriptions.add(Pair.of(created, subscription));
    }
}
