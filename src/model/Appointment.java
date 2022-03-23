package model;
/**
 * class Appointment.java
 */

/**
 *
 * @author James Trowbridge
 */
import dao.ContactDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.*;

public class Appointment {

    //this class will have info and methods related to the Appointment table
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private String type;
    private String startTime;
    private String endTime;
    private int userId;
    private int customerID;
    private int contactID;
    private String contactName;

    public Appointment(int appointmentID, String title, String description, String location, String type,
                       String startTime, String endTime, int userId, int customerID, int contactID) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
        this.customerID = customerID;
        this.contactID = contactID;

    }

    public Appointment(int appointmentID, String title, String description, String location, String type,
                       String startTime, String endTime, int userId, int customerID, int contactID, String contactName) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
        this.customerID = customerID;
        this.contactID = contactID;
        this.contactName = contactName;

    }

    /**
     * @return the appointmentID
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     * @param appointmentID to set
     */
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title to set
     */
    public void setTitle(String title) {
        this.title = title;

    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}

