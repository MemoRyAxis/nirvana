package com.memoryaxis.nirvana.base;

import com.memoryaxis.nirvana.base.skill.Skill;
import lombok.Builder;
import lombok.Data;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@Builder
public class People {

    @Builder.Default
    private Integer baseHp = 0;

    @Builder.Default
    private Integer currentHp = 0;

    @Builder.Default
    private Integer atk = 0;

    @Builder.Default
    private Integer currentMp = 0;

    private Skill skill;
}
