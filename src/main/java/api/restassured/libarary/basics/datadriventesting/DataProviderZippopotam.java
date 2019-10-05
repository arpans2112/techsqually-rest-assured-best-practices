package api.restassured.libarary.basics.datadriventesting;


import org.testng.annotations.DataProvider;

public class DataProviderZippopotam {


    @DataProvider(name="getCallUsingContryCodeAndPostalCode")
    public Object[][] dataProviderForGetCall(){
        Object[][] dataTable = {
                {"us","90210","Beverly Hills"},
                {"us","12345","Schenectady"},
                {"ca","B2R","Waverley"},

        };
        return dataTable;
    }





}
