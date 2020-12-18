package com.epam.google_cloud.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchInListUtil {

    public static void findOptionAndClickToIt(List<WebElement> elements, String term) {
        for (int i = 0; i < elements.size(); i++) {
            WebElement option = elements.get(i);
            if (option.getText().contains(term)) {
                option.click();
                break;
            }
        }
    }
}
