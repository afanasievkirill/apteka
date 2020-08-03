package ru.stqa.pft.web.model;

import java.util.Objects;

public class OrderData {
    private String deliveryType;
    private String comment;
    private String orderId;
    private String fullId;
    private String nameFile;
    private String status;
    private String item;
    private String region;

    public String getDeliveryType() {
        return deliveryType;
    }

    public String getComment() {
        return comment;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFullId() {
        return fullId;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getStatus() {
        return status;
    }

    public String getItem() {
        return item;
    }

    public String getRegion() {
        return region;
    }

    public OrderData withDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
        return this;
    }

    public OrderData withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrderData withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderData withFullId(String fullId) {
        this.fullId = fullId;
        return this;
    }

    public OrderData withNameFile(String nameFile) {
        this.nameFile = nameFile;
        return this;
    }

    public OrderData withItem(String item) {
        this.item = item;
        return this;
    }

    public OrderData withStatus(String status) {
        this.status = status;
        return this;
    }

    public OrderData withRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, nameFile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderData orderData = (OrderData) o;
        return Objects.equals(getDeliveryType(), orderData.getDeliveryType()) &&
                Objects.equals(getComment(), orderData.getComment()) &&
                Objects.equals(getOrderId(), orderData.getOrderId()) &&
                Objects.equals(getFullId(), orderData.getFullId()) &&
                Objects.equals(getNameFile(), orderData.getNameFile()) &&
                Objects.equals(getStatus(), orderData.getStatus()) &&
                Objects.equals(getItem(), orderData.getItem()) &&
                Objects.equals(getRegion(), orderData.getRegion());
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "deliveryType='" + deliveryType + '\'' +
                ", comment='" + comment + '\'' +
                ", orderId='" + orderId + '\'' +
                ", fullId='" + fullId + '\'' +
                ", nameFile='" + nameFile + '\'' +
                ", status='" + status + '\'' +
                ", item='" + item + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
