package br.com.kauedb.mars_explorer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

/**
 *
 */
@Value
@Builder
@NonFinal
@AllArgsConstructor
public class Position {

    protected Integer x;
    protected Integer y;

    public boolean biggerThen(Position limit) {
        return x > limit.getX() || y > limit.getY();
    }

    public boolean lesserThen(Position limit) {
        return x < limit.getX() || y < limit.getY();
    }

}
