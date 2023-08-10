package Activities;

abstract class Book{
    String title;
    String getTitle(){
        return title;
    }

    abstract void setTitle(String s);
}

class MyBook extends Book{

    public void setTitle(String t){
        title = t;
    }
}

public class Activity5 {

    public static void main(String[] args) {

        MyBook newNovel = new MyBook();
        newNovel.setTitle("New Book");
        System.out.println("Title of the book is: " + newNovel.getTitle());
    }
}