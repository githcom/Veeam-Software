package apiEngine.endpoints.store.order.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = OrderResponse.OrderResponseBuilder.class)
public class OrderResponse {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderResponseBuilder {
    }

    @JsonProperty("id")
    private long id;

    @JsonProperty("petId")
    private int petId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("complete")
    private Boolean complete;
}
