package br.com.kauedb.mars_explorer.domain;

import lombok.val;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class PositionLesserThenTest {

    @DataProvider
    public Object[][] lesser() {
        return new Object[][]{
                {Position.builder().x(0).y(-1).build()},
                {Position.builder().x(-1).y(0).build()},
                {Position.builder().x(-1).y(-1).build()},
        };
    }


    @Test(dataProvider = "lesser")
    public void shouldBeLesserThen(Position position1) {
        val position2 = Position.builder().x(0).y(0).build();
        assertThat(position1.lesserThen(position2), is(true));
    }

    @Test
    public void shouldNotBeLesserThen() {
        val position1 = Position.builder().x(0).y(0).build();
        val position2 = Position.builder().x(0).y(0).build();
        assertThat(position1.lesserThen(position2), is(false));
    }


}