package apiEngine.endpoints.store.order;

import apiEngine.endpoints.store.order.models.OrderResponse;

public class OrderUtils {

    public static OrderResponse getPreparedOrderResponsePayload() {
        return OrderResponse.builder().id(0).petId(0).quantity(0).shipDate("2025-08-26T07:54:17.225Z").status("placed").complete(true).build();
    }
}
