//package exercises;
//
//import nu.xom.*;
//
//import java.io.*;
//import java.util.*;
//
//
//class Person {
//    private String first, last, address;
//
//    public Person(String first, String last, String address) {
//        this.first = first;
//        this.last = last;
//        this.address = address;
//    }
//
//    // Produce an XML Element from this Person object:
//    public Element getXML() {
//        Element person = new Element("person");
//        Element firstName = new Element("first");
//        firstName.appendChild(first);
//        Element lastName = new Element("last");
//        lastName.appendChild(last);
//        Element address = new Element("address");
//        address.appendChild(this.address);
//        person.appendChild(firstName);
//        person.appendChild(lastName);
//        person.appendChild(address);
//        return person;
//    }
//
//    // Constructor to restore a Person from an XML Element:
//    public Person(Element person) {
//        first = person.getFirstChildElement("first").getValue();
//        last = person.getFirstChildElement("last").getValue();
//        address = person.getFirstChildElement("address").getValue();
//    }
//
//    public String toString() {
//        return first + " " + last + " " + address;
//    }
//
//    // Make it human-readable:
//    public static void format(OutputStream os, Document doc) throws Exception {
//        Serializer serializer = new Serializer(os, "ISO-8859-1");
//        serializer.setIndent(4);
//        serializer.setMaxLength(60);
//        serializer.write(doc);
//        serializer.flush();
//    }
//
//    public static void main(String[] args) throws Exception {
//        List<Person> people = Arrays.asList(
//                new Person("Dr. Bunsen", "Honeydew", "Hollywood"),
//                new Person("Gonzo", "The Great", "Moscow"),
//                new Person("Phillip J.", "Fry", "Sochi"));
//        System.out.println(people);
//        Element root = new Element("people");
//        for (Person p : people)
//            root.appendChild(p.getXML());
//        Document doc = new Document(root);
//        format(System.out, doc);
//        format(new BufferedOutputStream(new FileOutputStream(
//                "People.xml")), doc);
//    }
//}
//
//class People extends ArrayList<Person> {
//    public People(String fileName) throws Exception {
//        Document doc = new Builder().build(fileName);
//        Elements elements = doc.getRootElement().getChildElements();
//        for (int i = 0; i < elements.size(); i++)
//            add(new Person(elements.get(i)));
//    }
//
//    public static void main(String[] args) throws Exception {
//        People p = new People("People.xml");
//        System.out.println(p);
//    }
//}
//
//public class _17_31_XMLExample {
//    public static void main(String[] args) throws Exception {
//        Person.main(null);
//        People.main(null);
//    }
//}
