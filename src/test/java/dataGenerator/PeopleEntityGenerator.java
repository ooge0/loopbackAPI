package dataGenerator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import model.item.ItemData;
import model.people.People;
import model.people.PeopleData;
import model.people.UserAddress;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PeopleEntityGenerator {

    @Parameter(names = "-c", description = "Item count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
        PeopleEntityGenerator generator = new PeopleEntityGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<PeopleData> people = generateItems(count);
        if (format.equals("csv")) {
            saveAsXml(people, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(people, new File(file));
        } else {
            System.out.println("Please check format for save file");
        }
    }

    private void saveAsJson(List<PeopleData> people, File file) throws IOException {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(people);
        try (Writer writer = new FileWriter(file);) {
            writer.write(json);
        }
    }

    private void saveAsXml(List<PeopleData> people, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ItemData.class);
        String xml = xstream.toXML(people);
        try (Writer writer = new FileWriter(file);) {
            writer.write(xml);
        }

    }


    UserAddress userAddress = new UserAddress(
            "Main Street",
            "42A",
            "Magdeburg",
            "Germany"
    );
    People peopleObject = new People(
            "Norman",
            "norman@futurestud.io",
            26,
            true,
            userAddress
    );

    private List<PeopleData> generateItems(int count) {
        List<PeopleData> people = new ArrayList<PeopleData>();
        for (int i = 0; i < count; i++) {
            people.add(new PeopleData()
                    .withName(String.format("generated_Item %s", i))
                    .withAge(i));
        }
        return people;
    }
}
