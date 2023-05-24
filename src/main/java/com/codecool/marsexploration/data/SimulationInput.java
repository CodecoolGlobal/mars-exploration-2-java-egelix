package com.codecool.marsexploration.data;

import com.sun.net.httpserver.Authenticator;

public record SimulationInput(String mapPath, Coordinate landing, int timeout, String logPath, SuccessCondition condition) {

}
