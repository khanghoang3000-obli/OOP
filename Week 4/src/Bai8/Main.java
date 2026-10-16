package Bai8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface WifiConnectable {
    void connectWifi();
}

abstract class Device {
    protected String id;
    protected String name;
    protected boolean isOn;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println(name + " turned off");
    }

    public String getName() {
        return name;
    }
}

class SmartLight extends Device {
    public SmartLight(String id, String name) {
        super(id, name);
    }
}

class AirConditioner extends Device implements WifiConnectable {
    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class SmartSpeaker extends Device implements WifiConnectable {
    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class Curtain extends Device {
    public Curtain(String id, String name) {
        super(id, name);
    }
}

class CentralHub {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device d) {
        devices.add(d);
    }

    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");
        for (Device d : devices) {
            d.turnOff();
        }
    }

    public void setupWifi() {
        System.out.println("\nSetup Wifi:");
        for (Device d : devices) {
            if (d instanceof WifiConnectable) {
                ((WifiConnectable) d).connectWifi();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CentralHub hub = new CentralHub();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("L")) {
                hub.addDevice(new SmartLight(id, name));
            } else if (type.equals("AC")) {
                hub.addDevice(new AirConditioner(id, name));
            } else if (type.equals("S")) {
                hub.addDevice(new SmartSpeaker(id, name));
            } else if (type.equals("C")) {
                hub.addDevice(new Curtain(id, name));
            }
        }

        hub.turnOffAll();
        hub.setupWifi();

        sc.close();
    }
}
