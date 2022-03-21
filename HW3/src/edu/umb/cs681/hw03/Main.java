package edu.umb.cs681.hw03;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("");
        PVI pvi = new PVI();
        List<List<String>> matrix = pvi.PVI();
//        System.out.println(matrix);
        ArrayList<Double> massPvi = new ArrayList<>();
        for(int i = 1; i < matrix.size(); i++){
            if(matrix.get(i).get(3).contains("Massachusetts")) {
                String pviString = matrix.get(i).get(0);
                double pviValue = Double.parseDouble(pviString.substring(1, pviString.length() - 1));
                massPvi.add(pviValue);
            }
        }
//        System.out.println(massPvi.toString());
        double averagePvi = massPvi.stream().reduce(new double[2], (result, pviAvg) ->{
            double average = ((result[0] * result[1]) + pviAvg)/(result[0]+1);
            result[0]++;
            result[1] = average;
            return result;},(finalResult, intermediateResult) -> finalResult)[1];
        System.out.println("Average PVI values of Massachusetts counties: " + averagePvi);
    }
}