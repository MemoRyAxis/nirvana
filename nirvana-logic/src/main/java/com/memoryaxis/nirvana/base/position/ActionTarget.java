package com.memoryaxis.nirvana.base.position;

import com.google.common.collect.Lists;
import com.memoryaxis.nirvana.frame.team.Team;

import java.util.List;

/**
 * @author memoryaxis@gmail.com
 */
public interface ActionTarget {

    TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition);

    enum Impl implements ActionTarget {
        TEAM_SELF {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                targetPosition.setTeamPositionList(Lists.newArrayList(currentPosition));
                return targetPosition;
            }
        },

        TEAM_COL {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                List<Position> positionList = attackTeam.getPositionList();
                List<Position> targetPositionList = Lists.newArrayList();
                for (Position position : positionList) {
                    if (position.getCol() == currentPosition.getCol()) {
                        targetPositionList.add(position);
                    }
                }
                targetPosition.setTeamPositionList(targetPositionList);
                return targetPosition;
            }
        },

        TEAM_FRONT_ROW {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                List<Position> positionList = attackTeam.getPositionList();
                List<Position> targetPositionList = Lists.newArrayList();
                boolean haveTargetRow = false;
                for (Position position : positionList) {
                    if (position.getRow() == Rows.FRONT) {
                        haveTargetRow = true;
                        targetPositionList.add(position);
                    }
                }
                if (haveTargetRow) {
                    targetPosition.setTeamPositionList(targetPositionList);
                } else {
                    targetPosition.setTeamPositionList(positionList);
                }
                return targetPosition;
            }
        },

        TEAM_BACK_ROW {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                List<Position> positionList = attackTeam.getPositionList();
                List<Position> targetPositionList = Lists.newArrayList();
                boolean haveTargetRow = false;
                for (Position position : positionList) {
                    if (position.getRow() == Rows.BACK) {
                        haveTargetRow = true;
                        targetPositionList.add(position);
                    }
                }
                if (haveTargetRow) {
                    targetPosition.setTeamPositionList(targetPositionList);
                } else {
                    targetPosition.setTeamPositionList(positionList);
                }
                return targetPosition;
            }
        },

        TEAM_ALL {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                targetPosition.setTeamPositionList(Lists.newArrayList(attackTeam.getPositionList()));
                return targetPosition;
            }
        },

        OPPOSITE_DEFAULT {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                Position defendPosition = null;
                int minDistance = Integer.MAX_VALUE;
                for (Position position : defendTeam.getPositionList()) {
                    int distance = currentPosition.getDistance(position);
                    if (distance < minDistance) {
                        minDistance = distance;
                        defendPosition = position;
                    }
                }
                targetPosition.setOppositePositionList(Lists.newArrayList(defendPosition));
                return targetPosition;
            }
        },

        OPPOSITE_COL {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                Position defendPosition = null;
                int minDistance = Integer.MAX_VALUE;
                for (Position position : defendTeam.getPositionList()) {
                    int distance = currentPosition.getDistance(position);
                    if (distance < minDistance) {
                        minDistance = distance;
                        defendPosition = position;
                    }
                }
                List<Position> targetPositionList = Lists.newArrayList();
                if (defendPosition != null) {
                    for (Position position : defendTeam.getPositionList()) {
                        if (position.getCol() == defendPosition.getCol()) {
                            targetPositionList.add(position);
                        }
                    }
                }
                targetPosition.setOppositePositionList(targetPositionList);
                return targetPosition;
            }
        },

        OPPOSITE_FRONT_ROW {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                List<Position> positionList = defendTeam.getPositionList();
                List<Position> targetPositionList = Lists.newArrayList();
                boolean haveTargetRow = false;
                for (Position position : positionList) {
                    if (position.getRow() == Rows.FRONT) {
                        haveTargetRow = true;
                        targetPositionList.add(position);
                    }
                }
                if (haveTargetRow) {
                    targetPosition.setOppositePositionList(targetPositionList);
                } else {
                    targetPosition.setOppositePositionList(positionList);
                }
                return targetPosition;
            }
        },

        OPPOSITE_BACK_ROW {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                List<Position> positionList = defendTeam.getPositionList();
                List<Position> targetPositionList = Lists.newArrayList();
                boolean haveTargetRow = false;
                for (Position position : positionList) {
                    if (position.getRow() == Rows.BACK) {
                        haveTargetRow = true;
                        targetPositionList.add(position);
                    }
                }
                if (haveTargetRow) {
                    targetPosition.setOppositePositionList(targetPositionList);
                } else {
                    targetPosition.setOppositePositionList(positionList);
                }
                return targetPosition;
            }
        },

        OPPOSITE_ALL {
            @Override
            public TargetPosition getTargetPosition(Team attackTeam, Team defendTeam, Position currentPosition) {
                TargetPosition targetPosition = new TargetPosition();
                targetPosition.setOppositePositionList(Lists.newArrayList(defendTeam.getPositionList()));
                return targetPosition;
            }
        }
    }
}
