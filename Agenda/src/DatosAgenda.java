public class DatosAgenda {

    private String contactName;
    private String contactPhoneNumber;
    private String contactEmail;
    private String contactGroup;

    public DatosAgenda(String contactName, String contactPhoneNumber, String contactEmail, String contactGroup) {
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactEmail = contactEmail;
        this.contactGroup = contactGroup;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactGroup() {
        return contactGroup;
    }
}
