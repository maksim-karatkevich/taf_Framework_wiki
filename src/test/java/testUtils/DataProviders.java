package testUtils;


import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "correctSearchData")
    public static Object[][] correctSearchData() {
        return new Object[][]{
                {"ru", "Java"},
                {"en", "Python"},
                {"de", "Ruby"},
                {"be", "JavaScript"},
                {"la", "C++"},
        };
    }

    @DataProvider(name = "incorrectData")
    public static Object[][] incorrectData() {
        return new Object[][]{
                {"ru", "сихофазотрон", "Соответствий запросу не найдено."},
                {"de", "blandit", "Zu deiner Suchanfrage wurden keine Ergebnisse gefunden."},
        };
    }
}
