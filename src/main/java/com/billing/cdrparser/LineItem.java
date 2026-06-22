package com.billing.cdrparser;

import com.opencsv.bean.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LineItem {

    @CsvBindByName(column = "contract_id")
    private int contractId;

    @CsvBindByName(column = "dial_a")
    private String dialA;

    @CsvBindByName(column = "dial_b")
    private String dialB;

    @CsvBindByName(column = "service_type")
    private short serviceType;

    @CsvBindByName(column = "duration")
    private BigDecimal duration;

    @CsvBindByName(column = "start_time")
    @CsvDate("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @CsvBindByName(column = "external_fee_piasters")
    private int externalFeePiasters;

    @CsvBindByName(column = "is_rated")
    private boolean isRated;

    public LineItem() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getDialA() {
        return dialA;
    }

    public void setDialA(String dialA) {
        this.dialA = dialA;
    }

    public String getDialB() {
        return dialB;
    }

    public void setDialB(String dialB) {
        this.dialB = dialB;
    }

    public short getServiceType() {
        return serviceType;
    }

    public void setServiceType(short serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getExternalFeePiasters() {
        return externalFeePiasters;
    }

    public void setExternalFeePiasters(int externalFeePiasters) {
        this.externalFeePiasters = externalFeePiasters;
    }

    public boolean isRated() {
        return isRated;
    }

    public void setRated(boolean isRated) {
        this.isRated = isRated;
    }
}
