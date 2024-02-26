package dima.senko.bookstore.dto;

public record BookSearchParametersDto(
        String[] titles,
        String[] authors,
        String[] price,
        String[] isbn
) {
}
