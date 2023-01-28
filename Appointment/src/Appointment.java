// Appointment.java
// Anne Lopez
// 1/26/23
// Class that creates an appointment


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// Appointment Class
public class Appointment {
    // attributes for Appointment Class
    private String title;
    private String desc;
    private Contact contact;
    private ZonedDateTime appointmentTime;
    private ZonedDateTime reminderTime;
    private static final long REMINDER_HOURS = 12;

    // constructor
    public Appointment(String title, String desc, Contact contact, ZonedDateTime appointmentTime) {
        this.title = title;
        this.desc = desc;
        this.contact = contact;
        this.appointmentTime = appointmentTime;
        this.reminderTime = appointmentTime.minusHours(REMINDER_HOURS);
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


    // toString method for appointment
    @Override
    public String toString() {
        return "Appt:\n" +
                "\t\tTitle: " + title +
                "\n\t\tDesc: " + desc +
                "\n\t\t" + contact +
                "\n\t\tApp Date/Time: " + appointmentTime +
                "\n\t\tReminder: " + reminderTime;

    }

    // method to display the appointment information
    public void displayAppointment() {
        System.out.println(toString());
    }

    // main method
    public static void main(String[] args) {

        final String TITLE = "Test Appointment";
        final String DESC = "This is a test appointment";

        var zone = ZoneId.of("America/New_York");

        //Contact Info
        var contact = new Contact("JohnSmith@email.com", "Smith", "John",
                "904-555-1212", Contact.Preference.EMAIL, zone);

        //Appointment Time
        var date = LocalDateTime.of(2023, 7, 22, 22, 18, 26, 465531500);
        var apptTime = ZonedDateTime.of(LocalDateTime.from(date), zone);

        // create an appointment
        var appointment = new Appointment(TITLE, DESC, contact, apptTime);

        // prints appointment by calling displayAppointment method
        appointment.displayAppointment();

    }

}

// class to store the contact's information
class Contact {
    private StringBuilder name;
    private String emailAddress;
    private String phoneNumber;
    private Preference pref;

    private ZoneId timeZone;

    public Contact(String emailAddress, String lName, String fName,
                   String phoneNumber, Preference pref, ZoneId timeZone) {

        this.emailAddress = emailAddress;
        this.name = new StringBuilder();
        this.name.append(lName).append(",").append(fName);
        this.pref = pref;
        this.phoneNumber = phoneNumber;
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "Contact: " +
                emailAddress + "," +
                "(" + name + ")" +
                phoneNumber + "," +
                pref + ","
                + timeZone;
    }

    public enum Preference {TEXT, EMAIL, NONE}

    ;


}
