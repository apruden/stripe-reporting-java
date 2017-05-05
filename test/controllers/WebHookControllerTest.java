package controllers;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import models.Db;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.POST;
import static play.test.Helpers.route;

public class WebHookControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testHandle() throws IOException {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .bodyText(Resources.toString(Resources.getResource("event.json"), Charsets.UTF_8))
                .uri("/webhook/handle");

        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals(1, Db.customers.size());
    }
}

