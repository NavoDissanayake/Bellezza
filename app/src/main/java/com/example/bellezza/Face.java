package com.example.bellezza;

public class Face {

    String faceId;
    String faceName;
    String faceBrand;
    String faceDesc;
    String facePrice;
    String faceDate;



    public Face(){

    }

    public Face(String faceId, String faceName, String faceBrand, String faceDesc, String facePrice, String faceDate) {
        this.faceId = faceId;
        this.faceName = faceName;
        this.faceBrand = faceBrand;
        this.faceDesc = faceDesc;
        this.facePrice = facePrice;
        this.faceDate = faceDate;

    }

    public String getFaceId()
    {
        return faceId;
    }

    public String getFaceName()
    {
        return faceName;
    }

    public String getFaceBrand()
    {
        return faceBrand;
    }

    public String getFaceDesc()
    {
        return faceDesc;
    }

    public String getFacePrice() {
        return facePrice;
    }

    public String getFaceDate()
    {
        return faceDate;
    }

}
