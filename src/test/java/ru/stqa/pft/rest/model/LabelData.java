package ru.stqa.pft.rest.model;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class LabelData {

    @Expose
    private String GUID;
    @Expose
    private String id_77;
    @Expose
    private String cod;
    @Expose
    private String codFull;
    @Expose
    private String verifyPath;

    public String getGuid() {
        return GUID;
    }

    public String getId_77() {
        return id_77;
    }

    public String getCod() {
        return cod;
    }

    public String getCodFull() {
        return codFull;
    }

    public String getVerifyPath() {
        return verifyPath;
    }

    public LabelData withGuid(String GUID) {
        this.GUID = GUID;
        return this;
    }

    public LabelData withId_77(String id_77) {
        this.id_77 = id_77;
        return this;
    }

    public LabelData withCod(String cod) {
        this.cod = cod;
        return this;
    }

    public LabelData withCodFull(String codFull) {
        this.codFull = codFull;
        return this;
    }

    public LabelData withverifyPath(String verifyPath) {
        this.verifyPath = verifyPath;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelData labelData = (LabelData) o;
        return Objects.equals(GUID, labelData.GUID) &&
                Objects.equals(id_77, labelData.id_77) &&
                Objects.equals(cod, labelData.cod) &&
                Objects.equals(codFull, labelData.codFull) &&
                Objects.equals(verifyPath, labelData.verifyPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(GUID, id_77, cod, codFull, verifyPath);
    }

    @Override
    public String toString() {
        return "LabelData{" +
                "GUID='" + GUID + '\'' +
                ", id_77='" + id_77 + '\'' +
                ", cod='" + cod + '\'' +
                ", codFull='" + codFull + '\'' +
                ", verifyPath='" + verifyPath + '\'' +
                '}';
    }
}
