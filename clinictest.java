import java.util.Scanner;
// Carll Matthew Colocado , Angelo Azana
public class clinictest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // PATIENT INFORMATION INPUT
        System.out.println("===== ENTER PATIENT INFORMATION =====");

        // Basic patient details
        System.out.print("Patient Name: ");
        String name = input.nextLine();

        System.out.print("Birthdate (MM/DD/YYYY): ");
        String birthdate = input.nextLine();

        System.out.print("Sample ID: ");
        int sampleId = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Address: ");
        String address = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Sex (M/F): ");
        String sex = input.nextLine().toUpperCase(); // convert to uppercase for easy comparison

        System.out.print("Date of Collection: ");
        String date = input.nextLine();

        System.out.print("Time of Collection: ");
        String time = input.nextLine();

        System.out.print("Hours Since Last Meal: ");
        int lastMeal = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Requesting Physician: ");
        String physician = input.nextLine();

        // Create Information object (OOP principle)
        Information patient = new Information(
                name, birthdate, sampleId,
                address, age, sex, date, time,
                lastMeal, physician
        );

        // TEST SELECTION SECTION
        System.out.println("\nSelect which tests to perform (Y/N):");

        // Array of all available laboratory tests
        String[] tests = {
                "Fasting Blood Sugar (FBS)", "Random Blood Sugar (RBS)",
                "Total Cholesterol", "HDL", "LDL", "Triglycerides",
                "Creatinine", "Uric Acid", "Blood Urea Nitrogen (BUN)",
                "AST / SGOT", "ALT / SGPT", "Sodium", "Potassium",
                "Chloride", "Total Calcium", "Ionized Calcium"
        };

        // Boolean array to store which tests were selected
        boolean[] selected = new boolean[tests.length];

        // Array to store numeric results of each test
        double[] results = new double[tests.length];

        // Default diagnosis
        String finalDiagnosis = "All results are normal.";

        // Loop to ask user which test to perform
        for (int i = 0; i < tests.length; i++) {
            System.out.print(tests[i] + " (Y/N)? ");
            String choice = input.nextLine().trim().toUpperCase();

            // If user selects YES
            if (choice.equals("Y")) {
                selected[i] = true;
                System.out.print("Enter result for " + tests[i] + ": ");
                results[i] = input.nextDouble();
                input.nextLine(); // clear buffer
            }
        }

       
        // EVALUATE RESULTS
        System.out.println("\n===== LAB RESULTS =====");
        System.out.println("Patient: " + patient.getPatientName());
        System.out.println("Sex: " + patient.getSex());
        System.out.println("Age: " + patient.getAge());
        System.out.println("------------------------------");

        // Loop to evaluate only selected tests
        for (int i = 0; i < tests.length; i++) {

            // Skip if test not selected
            if (!selected[i]) continue;

            double val = results[i];
            String status = "NORMAL";  // default interpretation
            String refRange = "";      // reference range

            // Switch determines which test is being evaluated
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

            // Display formatted result
            System.out.printf("%-25s Result: %.2f  Reference: %s  Interpretation: %s\n",
                    tests[i], val, refRange, status);
        }

       
        // FINAL DIAGNOSIS DISPLAY
        System.out.println("\n===== FINAL DIAGNOSIS =====");
        System.out.println(finalDiagnosis);

        input.close(); // close scanner
    }
}
