package com.memoryaxis.nirvana.base.effect;

import lombok.Builder;
import lombok.Data;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@Builder
public class Effect {

    @Builder.Default
    private Integer increaseHp = 0;

    @Builder.Default
    private Integer decreaseHp = 0;
}
