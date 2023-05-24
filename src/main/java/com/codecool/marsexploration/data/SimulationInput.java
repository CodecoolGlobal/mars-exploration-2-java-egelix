package com.codecool.marsexploration.data;

import com.sun.net.httpserver.Authenticator;

public record SimulationInput(String mapPath, Coordinate landing, long timeout, String logPath, SuccessCondition condition) {

}
