# CameraBattery README

## Overview
This project implements a `CameraBattery` class that models a rechargeable and removable camera battery. The battery can be charged by connecting it to a camera via USB or using an external charger with adjustable settings. It supports tracking charging, draining, and the current battery status.

## Features
- **Battery Charging:** The battery charges when connected to either the camera or an external charger.
- **Battery Draining:** The battery discharges based on camera power consumption.
- **Charging Settings:** The external charger has multiple settings, adjustable by the user.
- **Battery Movement:** The battery can be connected, disconnected, or moved between the camera and external charger.

## Public Methods
- `buttonPress()`: Increment the external charger's setting, looping back to zero after the maximum setting.
- `cameraCharge(double minutes)`: Charge the battery through the camera based on time.
- `drain(double minutes)`: Drain the battery based on camera power consumption.
- `externalCharge(double minutes)`: Charge the battery through the external charger.
- `moveBatteryCamera()`: Move the battery to the camera.
- `moveBatteryExternal()`: Move the battery to the external charger.
- `removeBattery()`: Remove the battery from any connected device.
- `getBatteryCapacity()`: Get the maximum battery capacity.
- `getBatteryCharge()`: Get the current battery charge.
- `getChargerSetting()`: Get the current charger setting.
- `getTotalDrain()`: Get the total battery drain since the last reset.
- `resetBatteryMonitor()`: Reset the total battery drain count.
