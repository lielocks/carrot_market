package project.carrot.entity.enums;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum CategoryName {

    DIGITAL("디지털기기"),
    FURNITURE("가구/인테리어"),
    KITCHEN("생활/주방"),
    BOOK("유아도서/도서"),
    SPORTS("스포츠/레저"),
    GAME("취미/게임/음반"),
    TICKET("티켓/교환권"),
    FOOD("가공식품")
    ;

    private String name;

    CategoryName(String name) {
        this.name = name;
    }
//    public static Optional<CategoryName> check(String name) {
//        try { return Optional.of(CategoryName.valueOf(name)); }
//        catch (Exception e) {/* do nothing */}
//        return Optional.empty();
//    }
}