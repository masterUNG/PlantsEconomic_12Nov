package srongklod_bangtamruat.plantseconomic.utility;

import android.content.Context;

/**
 * Created by masterung on 27/12/2017 AD.
 */

public class CustomerModel {

    private String uidUserString, nameString, lastNameString, phoneString;

    public CustomerModel() {

    }

    public CustomerModel(String uidUserString,
                         String nameString,
                         String lastNameString,
                         String phoneString) {
        this.uidUserString = uidUserString;
        this.nameString = nameString;
        this.lastNameString = lastNameString;
        this.phoneString = phoneString;
    }

    public String getUidUserString() {
        return uidUserString;
    }

    public void setUidUserString(String uidUserString) {
        this.uidUserString = uidUserString;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getLastNameString() {
        return lastNameString;
    }

    public void setLastNameString(String lastNameString) {
        this.lastNameString = lastNameString;
    }

    public String getPhoneString() {
        return phoneString;
    }

    public void setPhoneString(String phoneString) {
        this.phoneString = phoneString;
    }
}   // Main Class