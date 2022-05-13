import dto.CWaitingTimeline;
import model.WaitingTimeline;
import repository.Repo;
import service.CreateObject;
import service.CustomMethods;
import service.impl.CreateObjectImpl;
import service.impl.CustomMethodsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.println("\n:: AppStarted\n");

        CreateObject createObjects = new CreateObjectImpl();
        CustomMethods customMethod = new CustomMethodsImpl();
        Repo repo = new Repo();
        Map<Long, WaitingTimeline> mapa = repo.getMapa();

        Stream<String> lines = Files.lines(Paths.get("src/main/resources/testLines.txt"));
        List<String> listStrings = lines.collect(Collectors.toList());

        try {
            if (listStrings.size() >= 100000 || listStrings.size() != (Integer.parseInt(listStrings.get(0).trim())) + 1) {
                System.err.println("Please check DOC FILE");
                throw new IOException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("DOC FILE IS INCORRECT !!!");
        }

        int j = 0;
        for (Object oneOfList : listStrings) {
            System.out.println("It is " + j++ + " element {" + oneOfList + "} of the file");
            try {
                createObjects.createObj((String) oneOfList);
            } catch (ClassCastException ex) {
                System.out.println("CLASS CAST EX!");
                ex.getStackTrace();
            }
        }

        //System.out.println("My map here:\n" + mapa);
        Collection<WaitingTimeline> valuesFromMap = mapa.values();

        long result = 0;
        int count = 0;
        int k = 0;
        List<WaitingTimeline> storageCWaitingTimeline = new ArrayList<>();
        for (WaitingTimeline valueWT : valuesFromMap) {
            if (valueWT.getLineStartsCharacter().getValue().equals("C")) {
                storageCWaitingTimeline.add(valueWT);
            } else if (valueWT.getLineStartsCharacter().getValue().equals("D")) {

                for (WaitingTimeline wtFromStorage : storageCWaitingTimeline) {
                    if (customMethod.equalsForSimilar(valueWT, wtFromStorage, customMethod)
                    ) {
                        count++;
                        result += ((CWaitingTimeline) wtFromStorage).getWaitingTime();
                    } else {

                    }
                }
                if (count != 0) {
                    System.out.println("It is " + ++k + " query :  -> " + (result /= count));
                    result = 0;
                    count = 0;
                } else {
                    System.out.println("It is " + ++k + " query :  -> " + "\"-\"");
                }
            }
        }


    }

/*    private static boolean equalsForSimilar(CustomMethods cMethods, WaitingTimeline valueWT, WaitingTimeline wtFromStorage) {
        return valueWT.getCompanyService().getType().replaceAll("\\.(.*)", "").equals(wtFromStorage.getCompanyService().getType().replaceAll("\\.(.*)", ""))
                //&& (valueWT.getQuestion().getType().equals("*") ? true : valueWT.getQuestion().getType().replaceAll("\\.(.*)", "").equals(wtFromStorage.getQuestion().getType().replaceAll("\\.(.*)", "")))
                && (valueWT.getQuestion().getType().equals("*") || valueWT.getQuestion().getType().replaceAll("\\.(.*)", "").equals(wtFromStorage.getQuestion().getType().replaceAll("\\.(.*)", "")))
                // only for questions !!! ignore all category && sub-category
                && cMethods.checkBetweenDate(
                ((CWaitingTimeline) wtFromStorage).getDateReq(),
                ((DWaitingTimeline) valueWT).getDateFrom(),
                ((DWaitingTimeline) valueWT).getDateTo());
    }*/
}
