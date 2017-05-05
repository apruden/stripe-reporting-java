package controllers;

import com.google.common.collect.Maps;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import models.Db;
import org.apache.commons.lang3.tuple.Pair;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;
import static play.libs.Json.toJson;


public class StatsController extends Controller {

    public Result customersTotal(long from, long to) {
        long total = getInterval(Db.customers, from, to).count();

        return ok(toJson(toMap("customersTotal", total)));
    }

    public Result customersTop(long from, long to) {
        Map<Customer, Long> amountByCustomer = getInterval(Db.charges, from, to).collect(
                groupingBy(Charge::getCustomerObject, summingLong(Charge::getAmount)));

        List<Customer> top = amountByCustomer.entrySet().stream()
                .sorted(comparingByValue())
                .map(Map.Entry::getKey)
                .limit(10)
                .collect(toList());

        return ok(toJson(toMap("customersTop", top)));
    }

    public Result subscriptionsTotal(long from, long to, String planId) {
        int total = (int) getInterval(Db.subscriptions, from, to)
                .filter((s) -> s.getPlan().getId().equals(planId))
                .count();

        return ok(toJson(toMap("subscriptionsTotal", total)));
    }

    private <V> Stream<V> getInterval(Collection<Pair<Long, V>> in, long from, long to) {
        return in.stream().filter((v) -> v.getLeft() >= from && v.getLeft() <= to).map(Pair::getRight);
    }

    private Map<String, Object> toMap(String name, Object value) {
        Map<String, Object> res = Maps.newHashMap();
        res.put(name, value);
        return res;
    }
}
