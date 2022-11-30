package project.myschelin.domain.store.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import project.myschelin.exception.domain.EnumNotFoundException;

class CategoryTest {

    @Test
    void Category_영어이름으로_받아오기() throws Exception {
        //given
        Category meat = Category.findByEnglishName("meat");
        // when

        //then
        Assertions.assertThat(meat.getKoreanName()).isEqualTo("고깃집");
    }

    @Test
    void 잘못된_Category_입력받았을_때_에러_반환() throws Exception {
        Assertions.assertThatThrownBy(() -> Category.findByEnglishName("meat1")).isInstanceOf(EnumNotFoundException.class);
    }
}