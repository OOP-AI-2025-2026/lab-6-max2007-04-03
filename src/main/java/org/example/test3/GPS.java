package org.example.test3;

interface GPS {
    double[] getCoordinates();
}

interface Cellular {
    void makeCall();
    void receiveCall();
}