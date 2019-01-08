package com.memoryaxis.nirvana.base.position;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
@Data
public class TargetPosition {

    @Builder.Default
    List<Position> teamPositionList = Lists.newArrayList();

    @Builder.Default
    List<Position> oppositePositionList = Lists.newArrayList();
}
