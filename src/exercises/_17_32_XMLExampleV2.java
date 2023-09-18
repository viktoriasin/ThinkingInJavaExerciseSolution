//package exercises;
//
//import nu.xom.*;
//import testPackage.TextFile;
//
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//class WordToXml {
//    private int counter;
//    private String word;
//
//    public WordToXml(String word, int counter) {
//        this.word = word;
//        this.counter = counter;
//    }
//
//    public Element getXML() {
//        Element word = new Element("word");
//        Element counterWord = new Element("counter");
//        counterWord.appendChild(String.valueOf(counter));
//        Element wordName = new Element("wordName");
//        wordName.appendChild(this.word);
//        word.appendChild(wordName);
//        word.appendChild(counterWord);
//        return word;
//    }
//
//    public WordToXml(Element person) {
//        word = person.getFirstChildElement("wordName").getValue();
//        counter = Integer.parseInt(person.getFirstChildElement("counter").getValue());
//    }
//
//    public String toString() {
//        return word + " occurs " + counter + " times";
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
//}
//
//
//
//public class _17_32_XMLExampleV2 {
//    public static void main(String[] args) throws Exception {
//        Map<String, Integer> words = new HashMap<>();
//        for (String word : new TextFile("./src/exercises/_16_17_SlowMap.java", "\\W+")) {
//            Integer count = words.get(word);
//            words.put(word, count == null ? 1 : ++count);
//        }
//        System.out.println(words);
//
//        Element root = new Element("words");
//        for (String w : words.keySet())
//            root.appendChild(new WordToXml(w, words.get(w)).getXML());
//        Document doc = new Document(root);
//        WordToXml.format(System.out, doc);
//        WordToXml.format(new BufferedOutputStream(new FileOutputStream("Words.xml")), doc);
//    }
//}
//
