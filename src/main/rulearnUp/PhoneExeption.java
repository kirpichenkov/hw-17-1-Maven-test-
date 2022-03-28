package main.rulearnUp;

public class PhoneExeption extends RuntimeException {
    public PhoneExeption(){
        super("Номер не найден, повторите попытку");
    }
}
