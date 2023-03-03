package data;

public class DataProvider {

    public static Object[] successDataProviderRestriction(){
        return new Object[]{
                "97093236014",
                "60094146012",
                "84809766080",
                "62648716050",
                "26276298085",
                "01317496094",
                "55856777050",
                "19626829001",
                "24094592008",
                "58063164083"
        };
    }

    public static Object[] successDataProviderWithoutRestriction(){
        return new Object[]{
                "66414919004",
                "40397218028",
                "00000000000"
        };
    }

    public static Object[][] successDataProviderSimulator(){
        return new Object[][]{
                {"37009128030","Test A","test-a@gmail.com"}
        };
    }
    public static Object[] SimulatorsId(){
        return new Object[]{
                "11",
                "12"
        };
    }

    public static Object[][] insertDataProviderSimulator(){
        return new Object[][]{
                {"91086598008","Test A","test-a@gmail.com","8500",3,true}
        };
    }

    public static Object[][] insertInvalidDataProviderSimulator(){
        return new Object[][]{
                {"3555831","Test Invalid CPF","test-cpfInvalid@gmail.com","8500",3,false},
                {"35558310030","Test Invalid Seguro","test-valueInvalid@gmail.com","1000",49,"verdadeiro"}
        };
    }

    public static Object[][] insertInvalidLimitDataProviderSimulator(){
        return new Object[][]{
                {"77080003008","Test Invalid Min Value","test-valueInvalid@gmail.com","999",3,false},
                {"81780871031","Test Invalid Max Value","test-valueInvalid@gmail.com","40001",3,false},
                {"03737803030","Test Invalid Min Parcela","test-valueInvalid@gmail.com","1000",1,false},
                {"87810850016","Test Invalid Max Parcela","test-valueInvalid@gmail.com","1000",49,false},
        };
    }
    public static Object[][] insertDuplicateDataProviderSimulator(){
        return new Object[][]{
                {"50304691097","Test Duplicate","test-duplicate1@gmail.com","8500",3,false}
        };
    }
    public static Object[][] updateDataProviderSimulator(){
        return new Object[][]{
                {"97093236014","Fulano de Tal","email123@email.com","8900",3,true}
        };
    }

    public static Object[][] deleteDataProviderSimulator(){
        return new Object[][]{
                {"47767029085","Test Delete","test-d@gmail.com","8580",3,true}
        };
    }

}
