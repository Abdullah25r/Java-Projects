import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {


    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "bhatti2739";


    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);
            while (true){
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.print("Enter your Choice: ");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                    //Add patients
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        //View patients
                        patient.viewPatients();
                        System.out.println();
                        break;
                    case 3:
                        // view doctors
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        // Book appointment
                        bookAppointment( connection, scanner,patient,doctor);
                        System.out.println();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Enter a valid choice!!!");
                }
            }


        } catch (SQLException e){
            e.printStackTrace();
        }


    }
    public static void bookAppointment(Connection connection, Scanner scanner, Patient patient, Doctor doctor){
        System.out.print("Enter patient Id:");
        int patientId = scanner.nextInt();
        System.out.print("Enter doctor Id:");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment date(yyyy-mm-dd):");
        String appointmentDate = scanner.next();
        if (patient.getPatientById(patientId) && doctor.getDoctorById(doctorId)){
            if (checkDoctorAvailablitly(doctorId, appointmentDate, connection)){
                String appointmentquery = "insert into appointments(patient_id, doctor_id, apppointment_date) values (?, ?, ?)";
                try{
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentquery);
                    preparedStatement.setInt(1,patientId);
                    preparedStatement.setInt(2,doctorId);
                    preparedStatement.setString(3,appointmentDate);
                    int rowAffected = preparedStatement.executeUpdate();
                    if (rowAffected>0){
                        System.out.println("Appointment Booked");
                    }
                    else
                        System.out.println("Failed to Book Appoinment!");
                }catch (SQLException e){
                    e.printStackTrace();
                }




            }else
                System.out.println("Doctor not available on this date!!!");
        }else
            System.out.println("Either doctor or patient doesn't exist!!!");




    }

    public static boolean checkDoctorAvailablitly(int doctorId, String appointmentDate, Connection connection){
        String query = "select count(*) from appointments where doctor_id = ? AND apppointment_date = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,doctorId);
            preparedStatement.setString(2,appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                if (count ==0) return true;
                else  return false;
            }




        }catch (SQLException e){
            e.printStackTrace();
        }
return false;

    }


}
