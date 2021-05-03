/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.idelstak.javalite.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author mwangi
 */
public class EmployeeTest /*extends DBSpec*/ {

    private static final Logger LOGGER = Logger.getLogger(EmployeeTest.class.getName());
    private static DB db;

    public EmployeeTest() {
    }

    @Test
    public void shouldValidateEmployeeAttributesOnSaving() {
        var employee = new Employee();

        var successfulSave = employee.save();

        if (!successfulSave) {
            var errors = employee.errors();
            LOGGER.log(Level.INFO, "Some errors were found: {0}", errors);
        } else if (!employee.exists()) {
            employee.set(Employee.CREATED_ON_PROP, Timestamp.from(Instant.now()));
        }

        assertFalse("Employee saving should not be successful because of validation errors", successfulSave);

        employee.set(Employee.FIRST_NAME_PROP, "Mary", Employee.LAST_NAME_PROP, "Jane");

        assertTrue("Employee should be valid", employee.isValid());

        successfulSave = employee.save();

        if (employee.exists()) {
            employee.set(Employee.MODIFIED_ON_PROP, Timestamp.from(Instant.now()));
        }

        assertTrue("Employee saving should be successful", successfulSave);
    }

    @BeforeClass
    public static void initDb() {
        var driver = "org.apache.derby.client.ClientAutoloadedDriver";
        var url = "jdbc:derby://localhost:1527/javalite-test-db";
        var user = "root";
        var password = "admin123";

        LOGGER.log(Level.INFO, "Opening DB connection...");

        db = Base.open(driver, url, user, password);

        LOGGER.log(Level.INFO, "DB connection is open? {0}", db.hasConnection());
    }

    @AfterClass
    public static void closeDb() {
        LOGGER.log(Level.INFO, "Closing DB connection...");
        db.close();
        LOGGER.log(Level.INFO, "DB connection is closed? {0}", !db.hasConnection());
    }
}
