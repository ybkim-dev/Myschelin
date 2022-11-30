package project.myschelin.domain.store.model;

import project.myschelin.exception.domain.EnumNotFoundException;

import java.text.MessageFormat;
import java.util.Arrays;

public enum Category {
    MEAT("meat", "고깃집"), CAFE("cafe", "카페"), KOREAN("korean", "한식");
    private String englishName;
    private String koreanName;


    Category(String englishName, String koreanName) {
        this.englishName = englishName;
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public static Category findByKoreanName(String koreanName) {
        return Arrays.stream(Category.values())
                .filter(category -> category.koreanName.equals(koreanName))
                .findFirst()
                .orElseThrow(() -> new EnumNotFoundException(MessageFormat.format("해당 카테고리가 없습니다. {0}", koreanName)));
    }

    public static Category findByEnglishName(String englishName) {
        return Arrays.stream(Category.values())
                .filter(category -> category.englishName.equals(englishName))
                .findFirst()
                .orElseThrow(() -> new EnumNotFoundException(MessageFormat.format("해당 카테고리가 없습니다. {0}", englishName)));
    }
}
