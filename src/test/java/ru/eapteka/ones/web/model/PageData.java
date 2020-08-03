package ru.stqa.pft.web.model;

import com.google.gson.annotations.Expose;
import org.openqa.selenium.By;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class PageData {

    @Expose
    private String validValue;
    @Expose
    private By path;

    public PageData() {
        this.validValue = validValue;
        this.path = path;
    }

    public String getValidValue() {
        return validValue;
    }

    public By getPath() {
        return path;
    }

    public void setPath(By path) {
        this.path = path;
    }

    public PageData withPath(By path) {
        this.path = path;
        return this;
    }

    public PageData withValidValue(String validValue) {
        this.validValue = validValue;
        return this;
    }

    public void setValidValue(String validValue) {
        this.validValue = validValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(validValue, path);
    }
}
