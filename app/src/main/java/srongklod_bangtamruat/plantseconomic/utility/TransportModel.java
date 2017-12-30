package srongklod_bangtamruat.plantseconomic.utility;

/**
 * Created by Administrator on 27/12/2560.
 */

public class TransportModel {

    private String uidUserString,companyString,
    addressString,faxString,telephoneString,branchString,headquarterString;

    public TransportModel() {
    }

    public TransportModel(String uidUserString,
                          String companyString,
                          String addressString,
                          String faxString,
                          String telephoneString,
                          String branchString,
                          String headquarterString) {
        this.uidUserString = uidUserString;
        this.companyString = companyString;
        this.addressString = addressString;
        this.faxString = faxString;
        this.telephoneString = telephoneString;
        this.branchString = branchString;
        this.headquarterString = headquarterString;
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

    public String getBranchString() {
        return branchString;
    }

    public void setBranchString(String branchString) {
        this.branchString = branchString;
    }

    public String getHeadquarterString() {
        return headquarterString;
    }

    public void setHeadquarterString(String headquarterString) {
        this.headquarterString = headquarterString;
    }
}//Main Call
