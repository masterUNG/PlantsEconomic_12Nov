package srongklod_bangtamruat.plantseconomic.utility;

/**
 * Created by Administrator on 30/12/2560.
 */

public class Myconstan {

    private String[] fieldCustomerStrings = new String[]{
            "lastNameString ",
            "nameString",
            "phoneString",
            "uidUserString ",};

    private String[] fieldSupplierStrings = new String[]{
            "addressString ",
            "bussinessString ",
            "companyString ",
            "faxString ",
            "headquartersString ",
            "telephoneString ",
            "uidUserString "};

    private String[] fieldTransportStrings = new String[]{
            "addressString ",
            "branchString ",
            "companyString ",
            "faxString ",
            "headquarterString ",
            "telephoneString ",
            "uidUserString ",};


    public String[] getFieldCustomerStrings() {
        return fieldCustomerStrings;
    }

    public String[] getFieldSupplierStrings() {
        return fieldSupplierStrings;
    }

    public String[] getFieldTransportStrings() {
        return fieldTransportStrings;
    }
}