package uk.gov.pay.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Refund Summary", description = "A structure representing the refunds availability")
public class RefundSummary {

    private String status;

    @JsonProperty("amount_available")
    private long amountAvailable;

    @JsonProperty("amount_submitted")
    private long amountSubmitted;

    public RefundSummary() {}

    public RefundSummary(String status, long amountAvailable, long amountSubmitted) {
        this.status = status;
        this.amountAvailable = amountAvailable;
        this.amountSubmitted = amountSubmitted;
    }

    @ApiModelProperty(value = "Availability status of the refund", example = "available")
    public String getStatus() {
        return status;
    }

    @ApiModelProperty(value = "Amount available for refund in pence")
    public long getAmountAvailable() {
        return amountAvailable;
    }

    @ApiModelProperty(value = "Amount submitted for refunds on this Payment in pence")
    public long getAmountSubmitted() {
        return amountSubmitted;
    }
}
