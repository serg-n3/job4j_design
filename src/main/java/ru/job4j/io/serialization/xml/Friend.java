package ru.job4j.io.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;
@XmlRootElement(name = "friend")
@XmlAccessorType(XmlAccessType.FIELD)

public class Friend {
    @XmlAttribute
    private  boolean haveHome;

    @XmlAttribute
    private  int age;
    private  String name;
    private  Contact contact;
    @XmlElementWrapper(name = "otherFriends")
    @XmlElement(name = "otherFriend")
    private  String[] otherFriend;

    public Friend() {

    }

    public Friend(boolean haveHome, int age, String name, Contact contact, String[] otherFriend) {
        this.haveHome = haveHome;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.otherFriend = otherFriend;
    }

    @Override
    public String toString() {
        return "Person{"
                + "haveHome=" + haveHome
                + ", age=" + age
                + ", name=" + name
                + ", contact=" + contact
                + ", otherFriend=" + Arrays.toString(otherFriend)
                + '}';
    }
    public static void main(String[] args) throws JAXBException {

        final Friend friend = new Friend(false, 30, "Ivan", new Contact("11-111"),
                new String[] {"Petr", "Sergey"});

        JAXBContext context = JAXBContext.newInstance(Friend.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(friend, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
