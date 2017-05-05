package models;

import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Db {
    public static Collection<Pair<Long, Charge>> charges = new ConcurrentLinkedQueue<>();
    public static Collection<Pair<Long, Customer>> customers = new ConcurrentLinkedQueue<>();
    public static Collection<Pair<Long, Subscription>> subscriptions = new ConcurrentLinkedQueue<>();

}
