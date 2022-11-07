public class Contacts {

    public int contactID;
    public String contactName;
    public String contactPhone;
    public String contactRelationship;

    public Contacts(){
        //Empty constructor
    }

    public Contacts(int id, String name, String phone, String relationship){
        this.contactID = id;
        this.contactName = name;
        this.contactPhone = phone;
        this.contactRelationship = relationship;
    }

    public int getContactID() {
        return contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactRelationship() {
        return contactRelationship;
    }
}
