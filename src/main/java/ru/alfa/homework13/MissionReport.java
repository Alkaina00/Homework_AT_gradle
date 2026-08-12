package ru.alfa.homework13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MissionReport {
    private String missionName;
    private List<Alien> capturedAliens;
    private int squadSize;

    public MissionReport(String missionName, int squadSize) {
        this.missionName = missionName;
        this.capturedAliens = new ArrayList<>();
        this.squadSize = squadSize;
    }

    public MissionReport(String missionName, List<Alien> capturedAliens, int squadSize) {
        this.missionName = missionName;
        this.capturedAliens = new ArrayList<>(capturedAliens);  // Копируем список
        this.squadSize = squadSize;
    }

    @Override
    public String toString() {
        return "Миссия: " + missionName + "\nПоймано пришельцев: " + capturedAliens.size() + "\nРазмер отряда: " + squadSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionReport that = (MissionReport) o;
        return squadSize == that.squadSize &&
                Objects.equals(missionName, that.missionName) &&
                Objects.equals(capturedAliens, that.capturedAliens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionName, capturedAliens, squadSize);
    }
}
