package com.memoryaxis.nirvana.frame;

import com.memoryaxis.nirvana.base.People;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author memoryaxis@gmail.com
 */
@Data
@AllArgsConstructor
public class Round {

    private People attacker;

    private People defender;
}
