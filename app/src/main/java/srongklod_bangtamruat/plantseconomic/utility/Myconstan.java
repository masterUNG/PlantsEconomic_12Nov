package srongklod_bangtamruat.plantseconomic.utility;

import srongklod_bangtamruat.plantseconomic.R;

/**
 * Created by Administrator on 30/12/2560.
 */

public class Myconstan {

    private int[] iconCustomerInts = new int[]{
            R.drawable.custom1,R.drawable.custom2,
            R.drawable.custom3,R.drawable.custom4,
            R.drawable.custom5, R.drawable.custom6,};

    private String[] titleCustomerStrings = new String[]{"Home","AddFriend","Massage","News","Shops","Chat"};


    public int[] getIconCustomerInts() {
        return iconCustomerInts;
    }

    public String[] getTitleCustomerStrings() {
        return titleCustomerStrings;
    }

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
