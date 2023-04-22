package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String genre;
    private int countInWarehouse;
    private static Book instance = new Book();

    public int getBook(int quantity) {
        if (quantity <= countInWarehouse) {
            countInWarehouse -= quantity;
            return quantity;
        } else {
            quantity = countInWarehouse;
            countInWarehouse = 0;
            return quantity;
        }
    }

    public boolean hasMoreBooks() {
        return countInWarehouse > 0;
    }

    public static Book getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Book[] objectArray = new Book[7];
        objectArray[0] = new Book();
        objectArray[1] = new Book("Harry Potter", "Rowling", "Bloomsbury Children`s", 2018, "fantasy", 6);
        objectArray[2] = getInstance();
        objectArray[3] = getInstance();

        for (int i = 0; i < objectArray.length; i++) {
            System.out.println(objectArray[i]);
        }
    }
}