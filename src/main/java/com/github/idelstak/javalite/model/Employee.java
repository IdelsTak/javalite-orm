/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.idelstak.javalite.model;

import org.javalite.activejdbc.Model;

/**
 *
 * @author mwangi
 */
public class Employee extends Model {

    public static final String FIRST_NAME_PROP = "firstName";
    public static final String LAST_NAME_PROP = "lastName";
    public static final String CREATED_ON_PROP = "createdOn";
    public static final String MODIFIED_ON_PROP = "modifiedOn";

    static {
        validatePresenceOf(FIRST_NAME_PROP);
    }

    public Employee() {
    }

    public Employee(String firstName) {
        setFirstName(firstName);
    }

    public String getFirstName() {
        return getString(FIRST_NAME_PROP);
    }

    public final void setFirstName(String firstName) {
        setString(FIRST_NAME_PROP, firstName);
    }

    public String getLastName() {
        return getString(LAST_NAME_PROP);
    }

    public void setLastName(String lastName) {
        setString(LAST_NAME_PROP, lastName);
    }
}
