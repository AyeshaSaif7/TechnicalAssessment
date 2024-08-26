package myapps.utils;

import pages.TestPage;

public class PageInitializer {

    public static TestPage testPage;


    public static void initializePageObjects(){
        testPage=new TestPage();
    }
}
