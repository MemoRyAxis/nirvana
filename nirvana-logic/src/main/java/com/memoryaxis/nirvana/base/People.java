package com.memoryaxis.nirvana.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

    private Integer baseHp;

    private Integer currentHp;

    private Integer atk;

    public boolean isDead() {
        return this.currentHp < 0;
    }
}
