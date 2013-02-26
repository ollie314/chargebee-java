package com.chargebee.models;

import com.chargebee.*;
import com.chargebee.internal.*;
import com.chargebee.internal.HttpUtil.Method;
import com.chargebee.models.enums.*;
import org.json.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Estimate extends Resource<Estimate> {

    public static class LineItem extends Resource<LineItem> {
        public LineItem(JSONObject jsonObj) {
            super(jsonObj);
        }

        public Timestamp dateFrom() {
            return reqTimestamp("date_from");
        }

        public Timestamp dateTo() {
            return reqTimestamp("date_to");
        }

        public Integer unitAmount() {
            return reqInteger("unit_amount");
        }

        public Integer quantity() {
            return optInteger("quantity");
        }

        public Integer tax() {
            return optInteger("tax");
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return reqString("description");
        }

    }

    public static class Discount extends Resource<Discount> {
        public Discount(JSONObject jsonObj) {
            super(jsonObj);
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return optString("description");
        }

    }

    public static class Tax extends Resource<Tax> {
        public Tax(JSONObject jsonObj) {
            super(jsonObj);
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return optString("description");
        }

    }

    //Constructors
    //============

    public Estimate(String jsonStr) {
        super(jsonStr);
    }

    public Estimate(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public Timestamp createdAt() {
        return reqTimestamp("created_at");
    }

    public Boolean recurring() {
        return reqBoolean("recurring");
    }

    public String subscriptionId() {
        return optString("subscription_id");
    }

    public SubscriptionStatus subscriptionStatus() {
        return optEnum("subscription_status", SubscriptionStatus.class);
    }

    public Timestamp termEndsAt() {
        return optTimestamp("term_ends_at");
    }

    public Boolean collectNow() {
        return reqBoolean("collect_now");
    }

    public Integer amount() {
        return reqInteger("amount");
    }

    public Integer subTotal() {
        return reqInteger("sub_total");
    }

    public List<Estimate.LineItem> lineItems() {
        return optList("line_items", Estimate.LineItem.class);
    }

    public List<Estimate.Discount> discounts() {
        return optList("discounts", Estimate.Discount.class);
    }

    public List<Estimate.Tax> taxes() {
        return optList("taxes", Estimate.Tax.class);
    }

    // Operations
    //===========

    public static CreateSubscriptionRequest createSubscription() throws IOException {
        String url = url("estimates", "create_subscription");
        return new CreateSubscriptionRequest(Method.POST, url);
    }

    public static UpdateSubscriptionRequest updateSubscription() throws IOException {
        String url = url("estimates", "update_subscription");
        return new UpdateSubscriptionRequest(Method.POST, url);
    }


    // Operation Request Classes
    //==========================

    public static class CreateSubscriptionRequest extends Request {

        private CreateSubscriptionRequest(Method httpMeth, String url) {
            super(httpMeth, url);
        }
    
        public CreateSubscriptionRequest billingCycles(Integer billingCycles) {
            params.addOpt("billing_cycles", billingCycles);
            return this;
        }

        public CreateSubscriptionRequest subscriptionId(String subscriptionId) {
            params.addOpt("subscription[id]", subscriptionId);
            return this;
        }

        public CreateSubscriptionRequest subscriptionPlanId(String subscriptionPlanId) {
            params.add("subscription[plan_id]", subscriptionPlanId);
            return this;
        }

        public CreateSubscriptionRequest subscriptionPlanQuantity(Integer subscriptionPlanQuantity) {
            params.addOpt("subscription[plan_quantity]", subscriptionPlanQuantity);
            return this;
        }

        public CreateSubscriptionRequest subscriptionTrialEnd(Timestamp subscriptionTrialEnd) {
            params.addOpt("subscription[trial_end]", subscriptionTrialEnd);
            return this;
        }

        public CreateSubscriptionRequest subscriptionCoupon(String subscriptionCoupon) {
            params.addOpt("subscription[coupon]", subscriptionCoupon);
            return this;
        }

        public CreateSubscriptionRequest addonId(int index, String addonId) {
            params.addOpt("addons[id][" + index + "]", addonId);
            return this;
        }

        public CreateSubscriptionRequest addonQuantity(int index, Integer addonQuantity) {
            params.addOpt("addons[quantity][" + index + "]", addonQuantity);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class UpdateSubscriptionRequest extends Request {

        private UpdateSubscriptionRequest(Method httpMeth, String url) {
            super(httpMeth, url);
        }
    
        public UpdateSubscriptionRequest billingCycles(Integer billingCycles) {
            params.addOpt("billing_cycles", billingCycles);
            return this;
        }

        public UpdateSubscriptionRequest replaceAddonList(Boolean replaceAddonList) {
            params.addOpt("replace_addon_list", replaceAddonList);
            return this;
        }

        public UpdateSubscriptionRequest prorate(Boolean prorate) {
            params.addOpt("prorate", prorate);
            return this;
        }

        public UpdateSubscriptionRequest endOfTerm(Boolean endOfTerm) {
            params.addOpt("end_of_term", endOfTerm);
            return this;
        }

        public UpdateSubscriptionRequest subscriptionId(String subscriptionId) {
            params.add("subscription[id]", subscriptionId);
            return this;
        }

        public UpdateSubscriptionRequest subscriptionPlanId(String subscriptionPlanId) {
            params.addOpt("subscription[plan_id]", subscriptionPlanId);
            return this;
        }

        public UpdateSubscriptionRequest subscriptionPlanQuantity(Integer subscriptionPlanQuantity) {
            params.addOpt("subscription[plan_quantity]", subscriptionPlanQuantity);
            return this;
        }

        public UpdateSubscriptionRequest subscriptionTrialEnd(Timestamp subscriptionTrialEnd) {
            params.addOpt("subscription[trial_end]", subscriptionTrialEnd);
            return this;
        }

        public UpdateSubscriptionRequest subscriptionCoupon(String subscriptionCoupon) {
            params.addOpt("subscription[coupon]", subscriptionCoupon);
            return this;
        }

        public UpdateSubscriptionRequest addonId(int index, String addonId) {
            params.addOpt("addons[id][" + index + "]", addonId);
            return this;
        }

        public UpdateSubscriptionRequest addonQuantity(int index, Integer addonQuantity) {
            params.addOpt("addons[quantity][" + index + "]", addonQuantity);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

}