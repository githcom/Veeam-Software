package stepdefinitions.API.steps;

import apiEngine.endpoints.store.inventory.InventoryRequests;
import apiEngine.endpoints.store.inventory.models.InventoryResponse;
import apiEngine.endpoints.store.order.OrderRequests;
import apiEngine.endpoints.store.order.OrderUtils;
import apiEngine.endpoints.store.order.models.OrderResponse;
import cucumber.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class StoreSteps {

    private final ScenarioContext scenarioContext;
    private final InventoryRequests inventoryRequests;
    private final OrderRequests orderRequests;

    @Given("get store inventory")
    public void getStoreInventory() {
        var response = inventoryRequests.getInventory();
        scenarioContext.putGenericContext(InventoryResponse.class, response);
    }

    @Then("verify inventory returned")
    public void verifyInventoryReturned() {
        var response = scenarioContext.getGenericContext(InventoryResponse.class);
        assertThat(response).as("Response").isNotNull();
    }

    @Given("place an order")
    public void placeOrder() {
        var payload = OrderUtils.getPreparedOrderResponsePayload();
        var response = orderRequests.placeOrder(payload);
        scenarioContext.putGenericContext(OrderResponse.class, response);
    }

    @Then("verify order returned")
    public void verifyOrderReturned() {
        var response = scenarioContext.getGenericContext(OrderResponse.class);
        assertThat(response.getPetId()).as("PetId").isEqualTo(0);
        assertThat(response.getQuantity()).as("Quantity").isEqualTo(0);
        assertThat(response.getStatus()).as("Status").isEqualTo("placed");
        assertThat(response.getComplete()).as("Complete").isEqualTo(true);
    }

    @Given("get an order")
    public void getOrder() {
        var order = scenarioContext.getGenericContext(OrderResponse.class);
        var response = orderRequests.getOrder(order.getId());
        scenarioContext.putGenericContext(OrderResponse.class, response);
    }

    @Given("delete an order")
    public void deleteOrder() {
        var order = scenarioContext.getGenericContext(OrderResponse.class);
        orderRequests.deleteOrder(order.getId());
    }
}