package br.com.kauedb.mars_explorer.domain;

import lombok.Builder;
import lombok.Value;

/**
 *
 */
@Value
@Builder
public class Position {

    Integer x;
    Integer y;
    Direction direction;

}
