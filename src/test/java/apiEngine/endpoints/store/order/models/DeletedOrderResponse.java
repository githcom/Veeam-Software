package apiEngine.endpoints.store.order.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DeletedOrderResponse.DeletedOrderReponseBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeletedOrderResponse {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeletedOrderReponseBuilder {
    }

    @JsonProperty("code")
    private int code;

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;
}
