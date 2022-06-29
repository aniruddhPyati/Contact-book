package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Contact {

        private String name;
        private String phonenumber ;
        private String birthdate;
        private int age;


        public Contact(String name, String phonenumber , String birthdate) throws ParseException {
               if (name==null || name.isEmpty()){
                       throw new IllegalArgumentException("Name can't be null or blank");
               }
               if (phonenumber==null || phonenumber.isEmpty()){
                       throw new IllegalArgumentException("Phone number cant be null or blank");
               }
               if (phonenumber.length()<10){
                       throw new IllegalArgumentException("Cannot be less than 10 digits");
               }
                this.name = name;
                this.phonenumber = phonenumber;
                this.birthdate = birthdate;
                this.age= toage(birthdate);
            }

            public Contact(Contact source){      // Copy constructor to avoid any reference trap
                    this.name = source.name;
                    this.phonenumber = source.phonenumber;
                    this.birthdate = source.birthdate;
                    this.age= source.age;
            }



        public String getName() {
                return name;
        }

        public int getAge() {
                return age;
        }

        public String getBirthdate() {
                return birthdate;
        }

        public String getPhonenumber() {
                return phonenumber;
        }

        public void setName(String name) {
                if (name==null|| name.isEmpty()){
                        throw new IllegalArgumentException("Name cant be null or blank");
                }
                this.name = name;
        }

        private void setAge(int age) {
                this.age = age;
        }


        public void setBirthdate(String birthdate) throws ParseException {
                this.birthdate = birthdate;
                setAge(toage(birthdate)); // To AUTOMATICALLY update the age parameter when the caller gives the birth date.
        }


        public void setPhonenumber(String phonenumber) {
                if (phonenumber==null || phonenumber.isEmpty()){
                        throw new IllegalArgumentException("Phone number cannot be null or blank");
                }
                if (phonenumber.length()<10){
                        throw new IllegalArgumentException("Cannot be less than 10 digits");
                }

                this.phonenumber = phonenumber;
        }


        public int toage(String birthdate ) throws ParseException{

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formatter.parse(birthdate);       // Converts the string specified to an integer value
                formatter.setLenient(false);  // To strictly adhere to the format given in the formatter (optional)
                long milli = date.getTime();                 // Converting the given date to milliseconds
                long diff = new Date().getTime() - milli;   // to get the age of the person
                this.age= (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365 );     // to convert milli seconds to years
                return this.age;

        }

        public String toString(){
                return "Name: " + this.name + "\n" +

                        "Phone number: " + this.phonenumber + "\n" +

                        "Birth Date: " + this.birthdate + "\n" +

                        "Age: " + this.age + " years old\n";
        }
}





