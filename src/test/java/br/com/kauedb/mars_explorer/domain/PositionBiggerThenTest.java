package br.com.kauedb.mars_explorer.domain;

import lombok.val;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class PositionBiggerThenTest {

    @DataProvider
    public Object[][] bigger() {
        return new Object[][]{
                {Position.builder().x(0).y(0).build()},
                {Position.builder().x(0).y(1).build()},
                {Position.builder().x(1).y(0).build()},
        };
    }

    @Test(dataProvider = "bigger")
    public void shouldBeBiggerThen(Position position2) throws Exception {
        val position1 = Position.builder().x(1).y(1).build();
        assertThat(position1.biggerThen(position2), is(true));
    }

    @DataProvider
    public Object[][] notBigger() {
        return new Object[][]{
                {Position.builder().x(0).y(0).build()},
                {Position.builder().x(0).y(1).build()},
                {Position.builder().x(1).y(0).build()},
        };
    }


    @Test(dataProvider = "notBigger")
    public void shouldNotBeBiggerThen(Position position2) throws Exception {
        val position1 = Position.builder().x(0).y(0).build();
        assertThat(position1.biggerThen(position2), is(false));
    }


}