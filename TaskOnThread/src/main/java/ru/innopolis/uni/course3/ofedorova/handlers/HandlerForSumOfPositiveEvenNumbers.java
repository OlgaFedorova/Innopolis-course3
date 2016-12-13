package ru.innopolis.uni.course3.ofedorova.handlers;

import ru.innopolis.uni.course3.ofedorova.StorageForSumOfPositiveEvenNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Olga on 11.12.2016.
 */
public class HandlerForSumOfPositiveEvenNumbers extends HandlerOfResource {

    private final StorageForSumOfPositiveEvenNumbers storageForSum;

    public HandlerForSumOfPositiveEvenNumbers(StorageForSumOfPositiveEvenNumbers sum, InputStream resource) {
        super(resource);
        this.storageForSum = sum;
    }

    @Override
    public void handleResource() {
        List<Integer> listOfNumber = this.checkAndConvertResource();
        if (!listOfNumber.isEmpty()) {
            for (Integer number : listOfNumber) {
                this.storageForSum.addToSum(number);
                System.out.println(this.storageForSum.getSumma());
            }
        }
    }

    @Override
    public void run() {
        this.handleResource();
    }

    private List<Integer> checkAndConvertResource() {
        List<Integer> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(this.getResource()));) {
            String stringRead = "";
            String regexNumber = "(-?\\d+)\\s*";
            Matcher matcher = Pattern.compile(regexNumber).matcher(stringRead);
            while (stringRead != null) {
                stringRead = reader.readLine();
                if (stringRead !=null && stringRead.matches(String.format("(%s){1,}", regexNumber))){
                    matcher.reset(stringRead);
                    if (!this.checkCorrectResource(matcher, result)){
                        result = Collections.emptyList();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private boolean checkCorrectResource(Matcher matcher, List<Integer> list){
        boolean isCorrectResource = false;
        while (matcher.find()){
            final Integer number = Integer.valueOf(matcher.group(1));
            if(number > 0 && number % 2 == 0) {
                list.add(Integer.valueOf(number));
            }
            isCorrectResource = true;
        }
        return isCorrectResource;
    }
}
