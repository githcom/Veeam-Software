package apiEngine.endpoints.store.inventory.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = InventoryResponse.InventoryResponseBuilder.class)
public class InventoryResponse {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InventoryResponseBuilder {
    }

    @JsonProperty("sold")
    private int sold;

    @JsonProperty("string")
    private int string;

    @JsonProperty("availabla")
    private int availabla;

    @JsonProperty("unavailable")
    private int unavailable;

    @JsonProperty("avaliable")
    private int avaliable;

    @JsonProperty("pending")
    private int pending;

    @JsonProperty("test")
    private int test;

    @JsonProperty("available")
    private int available;

    @JsonProperty("xui")
    private int xui;

    @JsonProperty("peric")
    private int peric;
}