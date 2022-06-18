public class Person {
    String name;
    String words;

    public Person(String name, String words){
        this.name = name;
        this.words = words;
    }

    @Override
    public String toString(){
        return words;
    }

    public void say(){
        System.out.println(words);
    }
}
