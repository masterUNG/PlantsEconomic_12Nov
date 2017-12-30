package srongklod_bangtamruat.plantseconomic.utility;

/**
 * Created by Administrator on 27/12/2560.
 */

public class SupplierModel {

    private String uidUserString,companyString,addressString,faxString,telephoneString,
    bussinessString, headquartersString;

    public SupplierModel() {
    }

    public SupplierModel(String uidUserString,
                         String companyString,
                         String addressString,
                         String faxString,
                         String telephoneString,
                         String bussinessString,
                         String headquartersString) {
        this.uidUserString = uidUserString;
        this.companyString = companyString;
        this.addressString = addressString;
        this.faxString = faxString;
        this.telephoneString = telephoneString;
        this.bussinessString = bussinessString;
        this.headquartersString = headquartersString;
    }

    public String getUidUserString() {
        return uidUserString;
    }

    public void setUidUserString(String uidUserString) {
        this.uidUserString = uidUserString;
    }

    public String getCompanyString() {
        return companyString;
    }

    public void setCompanyString(String companyString) {
        this.companyString = companyString;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public String getFaxString() {
        return faxString;
    }

    public void setFaxString(String faxString) {
        this.faxString = faxString;
    }

    public String getTelephoneString() {
        return telephoneString;
    }

    public void setTelephoneString(String telephoneString) {
        this.telephoneString = telephoneString;
    }

    public String getBussinessString() {
        return bussinessString;
    }

    public void setBussinessString(String bussinessString) {
        this.bussinessString = bussinessString;
    }

    public String getHeadquartersString() {
        return headquartersString;
    }

    public void setHeadquartersString(String headquartersString) {
        this.headquartersString = headquartersString;
    }
}//Main Class
