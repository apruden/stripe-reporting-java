package controllers;

import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import models.Db;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;

public class StatsControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Before
    public void setUp() {
        cleanUp();
    }

    @After
    public void tearDown() {
        cleanUp();
    }

    private void cleanUp() {
        Db.customers.clear();
        Db.charges.clear();
        Db.subscriptions.clear();
    }

    @Test
    public void testCustomersTotal() {
        Db.customers.add(Pair.of(0L, new Customer()));
        Db.customers.add(Pair.of(200L, new Customer()));
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/stats/customersTotal?from=0&to=100");

        Result result = route(app, request);
        System.out.println(contentAsString(result));

        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("1"));
    }

    @Test
    public void testCustomersTop() {
        Db.charges.add(Pair.of(0L, new Charge()));
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/stats/customersTop?from=0&to=100");

        Result result = route(app, request);
        System.out.println(contentAsString(result));

        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("1"));
    }

    @Test
    public void testSubscriptionsTotal() {
        Db.subscriptions.add(Pair.of(0L, new Subscription()));
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/stats/subscriptionsTotal?from=0&to=100&planId=1");

        Result result = route(app, request);
        System.out.println(contentAsString(result));

        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("1"));
    }
}

