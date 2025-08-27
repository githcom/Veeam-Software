package apiEngine.endpoints.store.inventory;

import apiEngine.endpoints.store.StoreRequests;
import apiEngine.endpoints.store.inventory.models.InventoryResponse;

public class InventoryRequests extends StoreRequests {

    private static final String ENDPOINT = "/inventory";

    public InventoryResponse getInventory() {
        var response = get(requestSpecBuilder(ENDPOINT));
        return response.as(InventoryResponse.class);
    }
}
