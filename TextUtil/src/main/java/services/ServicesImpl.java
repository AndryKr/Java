package services;

import java.io.*;
import java.util.*;

public class ServicesImpl implements Services {

    private static ServicesImpl services;

    private ServicesImpl() {
    }

    public static ServicesImpl getInstance() {
        if (services == null)
            services = new ServicesImpl();
        return services;
    }

    @Override
    public void readFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            try (FileInputStream in = new FileInputStream(file)){
                byte[] br = new byte[in.available()];
                in.read(br);
                System.out.println(Arrays.toString(br));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Файл отсутствует");
        }
    }

    @Override
    public void joinFails() {
        List<FileInputStream> list = new ArrayList<>();
        try {
            list.add(new FileInputStream("src/resources/100byte1.txt"));
            list.add(new FileInputStream("src/resources/100byte2.txt"));
            list.add(new FileInputStream("src/resources/100byte3.txt"));
            list.add(new FileInputStream("src/resources/100byte4.txt"));
            list.add(new FileInputStream("src/resources/100byte5.txt"));

            Enumeration<FileInputStream> enumeration = Collections.enumeration(list);

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/resources/mergedFile.txt", true));

            int tmp = -1;

            while (enumeration.hasMoreElements()) {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(enumeration.nextElement()));
                while ((tmp = bReader.read()) != -1) {
                    bos.write(tmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
