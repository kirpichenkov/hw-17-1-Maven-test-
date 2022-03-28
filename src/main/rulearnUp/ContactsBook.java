package main.rulearnUp;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactsBook {
    Map<String, Contact> contBook = new HashMap<>();

    public void add(Contact contact) {
        contBook.put(contact.getPhone(), contact);
    }

    public Contact getContact(String phone) {
        if (contBook.containsKey(phone)) {
            return contBook.get(phone);
        }
        return null;
    }

    public void removeByPhone(String phone) {
        if (contBook.containsKey(phone)) {
            contBook.remove(phone);
        } else {
            throw new PhoneExeption();
        }
    }

    public List<Contact> sortList() {
        List<Contact> list = new ArrayList<>(contBook.values());
        Collections.sort(list);
        return list;
    }

    public void print() {
        for (String phone : contBook.keySet()) {
            System.out.println(contBook.get(phone).toString());
        }
    }

    public List<Contact> sortBy(Predicate<Contact> criteria) {
        List<Contact> list = new ArrayList<>();
        for (Contact contact : contBook.values()) {
            if (criteria.test(contact)) {
                list.add(contact);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        return list;
    }

    public List<Contact> sortBy(String str) {
        if (str.contains("*")) {
            if (str.startsWith("*")) {
                return sortBy(contact -> contact.getName().endsWith(str.substring(1)));
            } else if (str.endsWith("*")) {
                return sortBy(contact -> contact.getName().startsWith(str.substring(0, str.length() - 1)));
            } else {
                int i = str.indexOf("*");
                return sortBy(contact -> contact.getName().startsWith(str.substring(0, i)) && contact.getName().endsWith(str.substring(i + 1)));
            }
        }
        return sortBy(contact -> contact.getName().equals(str));
    }

    public Set<Integer> getCountries() {
        return contBook.keySet().stream()
                .flatMap(phone -> Arrays.stream(phone.split("-")))
                .filter(phone -> phone.contains("+"))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}

