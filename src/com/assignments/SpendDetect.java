package com.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpendDetect
{

    //Map<String, PayDetails> outputMap = new HashMap<String, PayDetails>();

    public void getPayDetails(String payer, int amount, List<String> beneficiary) {

        List<String> consolidatedBenificiary = beneficiary;
        int dividableCount = consolidatedBenificiary.size();
        int amountToBePaid = 0;

        /**
         * Check if the payer is also a beneficiary
         */

        boolean IfPayerIsBenificiary = checkIfPayerIsBenificiary(payer, beneficiary);

        /**
         * If the payer is beneficiary remove the payer from the list of
         * beneficiaries
         */

        if (IfPayerIsBenificiary) {
            consolidatedBenificiary.remove(payer);
        }

        /**
         * Calculate the amount to be payed back by the benificiary
         */

        amountToBePaid = amount / dividableCount;

        /**
         * List the details to be paid by the beneficiary to the payer
         */
        for (String benificiaryIndividual : beneficiary) {
            System.out.println(benificiaryIndividual + " should be paying "
                    + amountToBePaid + " to " + payer);
        }
    }

    /**
     * Method to check if the payer is a benificiary
     *
     * @param payer
     * @param beneficiary
     * @return
     */
    public boolean checkIfPayerIsBenificiary(String payer, List<String> beneficiary) {
       return beneficiary.contains(payer);
    }

    /**
     * Set whether the amount is payable
     *
     * @param isPayable
     * @param amount
     * @param payDetails
     * @return
     */

    public PayDetails setPayableOrToBePayed(boolean isPayable, int amount,
                                            PayDetails payDetails) {
        if (isPayable) {
            payDetails.Payable = payDetails.Payable + amount;
        } else {
            payDetails.toBePayed = payDetails.toBePayed + amount;
        }

        return payDetails;
    }

    public static void main(String[] args) {
        SpendDetect spd = new SpendDetect();
        List<String> benificiaryList = new ArrayList<String>();
        benificiaryList.add("A");
        benificiaryList.add("B");
        benificiaryList.add("C");
        benificiaryList.add("D");

        spd.getPayDetails("A", 100, benificiaryList);
        benificiaryList.clear();

        benificiaryList.add("B");
        benificiaryList.add("C");
        spd.getPayDetails("D", 500, benificiaryList);
        benificiaryList.clear();

        benificiaryList.add("A");
        benificiaryList.add("B");
        benificiaryList.add("C");
        spd.getPayDetails("B", 300, benificiaryList);

    }
}
