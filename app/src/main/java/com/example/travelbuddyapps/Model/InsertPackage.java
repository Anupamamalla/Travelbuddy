package com.example.travelbuddyapps.Model;

public class InsertPackage {
    private String packagename;
    private String price;
    private String accomodation;
    private String transporation;

    public InsertPackage(String packagename, String price, String accomodation, String transporation) {
        this.packagename = packagename;
        this.price = price;
        this.accomodation = accomodation;
        this.transporation = transporation;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public String getTransporation() {
        return transporation;
    }

    public void setTransporation(String transporation) {
        this.transporation = transporation;
    }
}
