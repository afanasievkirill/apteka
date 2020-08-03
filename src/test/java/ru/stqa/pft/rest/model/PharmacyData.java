package ru.stqa.pft.rest.model;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class PharmacyData {

    @Expose
    String Pharmacy;
    @Expose
    String ip;

    public String getPharmacy() {
        return Pharmacy;
    }

    public String getIp() {
        return ip;
    }

    public PharmacyData withIp(String ip) {
        this.ip = ip;
        return this;
    }

    public PharmacyData withPharmacy(String Pharmacy) {
        this.Pharmacy = Pharmacy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyData that = (PharmacyData) o;
        return Objects.equals(Pharmacy, that.Pharmacy) &&
                Objects.equals(ip, that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Pharmacy, ip);
    }

    @Override
    public String toString() {
        return "PharmacyData{" +
                "Pharmacy='" + Pharmacy + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
