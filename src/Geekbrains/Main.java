package Geekbrains;

public class Main {

    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0]= new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",500253,41);
        persArray[1]= new Employee("Ivanov Ivan1", "Engineer1", "iviva@mailbox.com", "89231256",50058,25);
        persArray[2]= new Employee("Ivanov Ivan2", "Engineer1", "iviv@mailbox.com", "89232589",50369,18);
        persArray[3]= new Employee("Ivanov Ivan3", "Engineer1", "ivi@mailbox.com", "892311478",50874,31);
        persArray[4]= new Employee("Ivanov Ivan4", "Engineer1", "iv@mailbox.com", "892311258",500185,45);
        for(int i=0;i<persArray.length;i++){
            if(persArray[i].getAge() > 40){
                persArray[i].infoEmployee();
            }
        }

    }
}
