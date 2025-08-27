package apiEngine.endpoints.store.order;

import apiEngine.endpoints.store.StoreRequests;
import apiEngine.endpoints.store.order.models.OrderResponse;

public class OrderRequests extends StoreRequests {

    private static final String ENDPOINT = "/order";
    private static final String ORDER_ID = String.format("%s/{orderId}", ENDPOINT);

    public OrderResponse placeOrder(OrderResponse payload) {
        var requestSpecBuilder = requestSpecBuilder(ENDPOINT)
                .setBody(payload);
        var response = post(requestSpecBuilder);
        return response.as(OrderResponse.class);
    }

    public OrderResponse getOrder(long orderId) {
        var requestSpecBuilder = requestSpecBuilder(ORDER_ID)
                .addPathParam("orderId", orderId);
        var response = get(requestSpecBuilder);
        return response.as(OrderResponse.class);
    }

    public void deleteOrder(long orderId) {
        var requestSpecBuilder = requestSpecBuilder(ORDER_ID)
                .addPathParam("orderId", orderId);
        delete(requestSpecBuilder, 404);
    }
}
