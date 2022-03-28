package main.rulearnUp;

public class Main {
    public static <Client> void main(String[] args) {
        ContactsBook book = new ContactsBook();
        book.add(new Contact("Алексей", "+7-922_94524556"));
        book.add(new Contact("Андрей", "+7-9745374"));
        book.add(new Contact("Бродобрей", "14-917_914385"));
        book.add(new Contact("Аликсей", "+41-922_2745322"));
        book.add(new Contact("Вячеслав", "+14-27_9745347"));
        book.add(new Contact("Алкадий", "+12-17_9748522"));
        book.add(new Contact("Аркадий", "+4-17_9745341"));
        System.out.print("Коды стран:");
        System.out.println(book.getCountries());


    }

}
