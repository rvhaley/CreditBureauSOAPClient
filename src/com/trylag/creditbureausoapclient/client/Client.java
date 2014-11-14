package com.trylag.creditbureausoapclient.client;

/**
 *
 * @author Richard Haley III
 */
public class Client {

    private static int creditScore(java.lang.String ssn) {
        com.trylag.creditbureausoapclient.service.CreditScoreService_Service service = new com.trylag.creditbureausoapclient.service.CreditScoreService_Service();
        com.trylag.creditbureausoapclient.service.CreditScoreService port = service.getCreditScoreServicePort();
        return port.creditScore(ssn);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Check main method arguments for array length
        if (args.length < 1) {
            System.exit(1);
        }

        // Get SSN element at first position
        String ssn = args[0];

        // Check SSN String is 11 characters in length
        if (ssn.length() == 11) {
            System.out.println(" [X] Validated SSN ");
            System.out.println(" [X] Checking credit score for SSN: " + ssn);

            // Get credit score from web service
            int creditScore = creditScore(ssn);
            System.out.println(" [X] Got credit score of: " + creditScore + " back from credit bureau ");

        } else {
            System.out.println(" [X] Invalid SSN entered! ");
            System.out.println("... exiting");
        }

    }

}
