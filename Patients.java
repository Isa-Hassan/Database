
package za.ac.cput.dentistappointment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Patients {


    private String name;
    private String surname;
    private String contactNO;
    private String doctor;
    private String date;
    private String time;
    FileHandler fh;

    public Patients(String name, String surname, String contactNO, String doctor, String date, String time) {
        this.name = name;
        this.surname = surname;
        this.contactNO = contactNO;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        fh = new FileHandler();
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContactNO() {
        return contactNO;
    }

    public void setContactNO(String contactNO) {
        this.contactNO = contactNO;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
 public void writeToFile() throws IOException{
        fh.openFile("Appointments.txt");
        fh.processFile(String.format("%s#%s#%s#%s#%s#%s", name, surname, contactNO, doctor, date, time ));
        fh.closeFile();
        
    }

}
    


