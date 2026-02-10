import java.util.Scanner;
 
// Carll Matthew Colocado , Angelo Azana
public class clinictest {
 
    public static void main(String[] args) {
 
        Scanner input = new Scanner(System.in);
 
        // PATIENT INFORMATION INPUT
        System.out.println("===== ENTER PATIENT INFORMATION =====");
 
        System.out.print("Patient Name: ");
        String name = input.nextLine();
 
        System.out.print("Birthdate (MM/DD/YYYY): ");
        String birthdate = input.nextLine();
 
        System.out.print("Sample ID: ");
        int sampleId = input.nextInt();
        input.nextLine();
 
        System.out.print("Address: ");
        String address = input.nextLine();
 
        System.out.print("Age: ");
        int age = input.nextInt();
        input.nextLine();
 
        System.out.print("Sex (M/F): ");
        String sex = input.nextLine().toUpperCase();
 
        System.out.print("Date of Collection: ");
        String date = input.nextLine();
 
        System.out.print("Time of Collection: ");
        String time = input.nextLine();
 
        System.out.print("Hours Since Last Meal: ");
        int lastMeal = input.nextInt();
        input.nextLine();
 
        System.out.print("Requesting Physician: ");
        String physician = input.nextLine();
 
        // Create Information object
        Information patient = new Information(
                name, birthdate, sampleId,
                address, age, sex, date, time,
                lastMeal, physician
        );
 
        // TEST LIST
        String[] tests = {
                "Fasting Blood Sugar (FBS)", "Random Blood Sugar (RBS)",
                "Total Cholesterol", "HDL", "LDL", "Triglycerides",
                "Creatinine", "Uric Acid", "Blood Urea Nitrogen (BUN)",
                "AST / SGOT", "ALT / SGPT", "Sodium", "Potassium",
                "Chloride", "Total Calcium", "Ionized Calcium"
        };
 
        boolean[] selected = new boolean[tests.length];
        double[] results = new double[tests.length];
 
        String finalDiagnosis = "All results are normal.";
 
        //SELECTOR MENU
        System.out.println("\n===== AVAILABLE LAB TESTS =====");
        for (int i = 0; i < tests.length; i++) {
            System.out.println((i + 1) + ". " + tests[i]);
        }
 
        System.out.print("\nEnter test that you want  to choose: ");
        String selectionInput = input.nextLine();
 
        String[] choices = selectionInput.split(",");
 
        for (String c : choices) {
            int index = Integer.parseInt(c.trim()) - 1;
 
            if (index >= 0 && index < tests.length) {
                selected[index] = true;
                System.out.print("Enter result for " + tests[index] + ": ");
                results[index] = input.nextDouble();
                input.nextLine();
            }
        }
 
        //EVALUATE RESULTS
        System.out.println("\n===== LAB RESULTS =====");
        System.out.println("Patient: " + patient.getPatientName());
        System.out.println("Sex: " + patient.getSex());
        System.out.println("Age: " + patient.getAge());
        System.out.println("------------------------------");
 
        for (int i = 0; i < tests.length; i++) {
 
            if (!selected[i]) continue;
 
            double val = results[i];
            String status = "NORMAL";
            String refRange = "";
 
            switch (i) {
 
                case 0: // FBS
                    refRange = "74-100 mg/dL";
                    if (val < 74) status = "LOW";
                    else if (val > 100) {
                        status = "HIGH";
                        finalDiagnosis = "Possible Diabetes.";
                    }
                    break;
 
                case 1: // RBS
                    refRange = "70-140 mg/dL";
                    if (val < 70) status = "LOW";
                    else if (val > 140) {
                        status = "HIGH";
                        finalDiagnosis = "Possible Diabetes.";
                    }
                    break;
 
                case 2: // Total Cholesterol
                    refRange = "150-200 mg/dL";
                    if (val < 150) status = "LOW";
                    else if (val > 200) {
                        status = "HIGH";
                        finalDiagnosis = "Possible Hypercholesterolemia.";
                    }
                    break;
 
                case 3: // HDL
                    if (sex.equals("M")) {
                        refRange = "35-80 mg/dL";
                        if (val < 35) status = "LOW";
                        else if (val > 80) status = "HIGH";
                    } else {
                        refRange = "42-88 mg/dL";
                        if (val < 42) status = "LOW";
                        else if (val > 88) status = "HIGH";
                    }
                    break;
 
                case 4: // LDL
                    refRange = "50-130 mg/dL";
                    if (val < 50) status = "LOW";
                    else if (val > 130) {
                        status = "HIGH";
                        finalDiagnosis = "Possible Hypercholesterolemia.";
                    }
                    break;
 
                case 5: // Triglycerides
                    if (sex.equals("M")) {
                        refRange = "60-165 mg/dL";
                        if (val < 60) status = "LOW";
                        else if (val > 165) {
                            status = "HIGH";
                            finalDiagnosis = "Possible Hypertriglyceridemia.";
                        }
                    } else {
                        refRange = "40-140 mg/dL";
                        if (val < 40) status = "LOW";
                        else if (val > 140) {
                            status = "HIGH";
                            finalDiagnosis = "Possible Hypertriglyceridemia.";
                        }
                    }
                    break;
 
                case 6: // Creatinine
                    if (sex.equals("M")) {
                        refRange = "0.9-1.3 mg/dL";
                        if (val < 0.9) status = "LOW";
                        else if (val > 1.3) {
                            status = "HIGH";
                            finalDiagnosis = "Possible Kidney Dysfunction.";
                        }
                    } else {
                        refRange = "0.6-1.2 mg/dL";
                        if (val < 0.6) status = "LOW";
                        else if (val > 1.2) {
                            status = "HIGH";
                            finalDiagnosis = "Possible Kidney Dysfunction.";
                        }
                    }
                    break;
            }
 
            System.out.printf(
                    "%-25s Result: %.2f  Reference: %s  Interpretation: %s%n",
                    tests[i], val, refRange, status
            );
        }
 
        // FINAL DIAGNOSIS
        System.out.println("\n===== FINAL DIAGNOSIS =====");
        System.out.println(finalDiagnosis);
 
        input.close();
    }
}