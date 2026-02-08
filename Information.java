public class Information {
    private String patientname;
    private String birthdate;
    private int sampleid;
    private String date, address;
    private int age;
    private String sex, time;
    private int lastmeal;
    private String request;

    public Information(String patientname, String birthdate, int sampleid,
                       String address, int age, String sex,
                       String date, String time,
                       int lastmeal, String request) {

        this.patientname = patientname;
        this.birthdate = birthdate;
        this.sampleid = sampleid;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.date = date;
        this.time = time;
        this.lastmeal = lastmeal;
        this.request = request;
    }
//getters
    public String getPatientName() { 
        return patientname; 
    }
    public String getBirthDate() { 
        return birthdate; 
    }
    public int getSampleId() { 
        return sampleid; 
    }
    public String getAddress() { 
        return address; 
    }
    public int getAge() { 
        return age; 
    }
    public String getSex() { 
        return sex; 
    }
    public String getDate() { 
        return date;
     }
    public String getTime() { 
        return time; 
    }
    public int getLastMeal() { 
        return lastmeal; 
    }
    public String getRequest() { 
        return request;
     }
}
