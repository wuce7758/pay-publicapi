package uk.gov.pay.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CreatePaymentRequest", description = "The Payment Request Payload")
public class CreatePaymentRequest {

    public static final String AMOUNT_FIELD_NAME="amount";
    public static final String RETURN_URL_FIELD_NAME="return_url";
    public static final String REFERENCE_FIELD_NAME="reference";
    public static final String DESCRIPTION_FIELD_NAME="description";

    private int amount;
    private String returnUrl;
    private String reference;
    private String description;

    public CreatePaymentRequest(int amount, String returnUrl, String reference, String description) {
        this.amount = amount;
        this.returnUrl = returnUrl;
        this.reference = reference;
        this.description = description;
    }

    @ApiModelProperty(value = "service return url", required = true, example = "https://service-name.gov.uk/transactions/12345")
    @JsonProperty("return_url")
    public String getReturnUrl() {
        return returnUrl;
    }

    @ApiModelProperty(value = "amount in pence", required = true, allowableValues = "range[1, 10000000]", example = "12000")
    public int getAmount() {
        return amount;
    }

    @ApiModelProperty(value = "payment reference", required = true, example = "12345")
    public String getReference() {
        return reference;
    }

    @ApiModelProperty(value = "payment description", required = true, example = "New passport application")
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CreatePaymentRequest{" +
                "amount=" + amount +
                ", returnUrl='" + returnUrl + '\'' +
                ", reference='" + reference + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
