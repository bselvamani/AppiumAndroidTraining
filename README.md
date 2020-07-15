# AppiumAndroidTraining
Training project for Appium for Android App and Web


Basic Command for running on command line for Appium, Android and IOS.
=

brew install carthage

Appium:
======

1) Install Appium
$npm install -g appium

2) start appium server
$appium --port 4723

3) Close appium server
$appium --port 4723


Android:
=======

You need to first run adb start-server and then run emulator -avd <avd_name>

adb -s emulator-5554 emu avd name

Android on Mac:

1)Add Environment Variable )
 $export ANDROID_HOME=/Users/$(whoami)/Library/Android/sdk
 $export PATH=$PATH:$ANDROID_HOME/platform-tools
 $export PATH=$PATH:$ANDROID_HOME/tools

2) Get all list of Advs
 $cd /Users/$(whoami)/Library/Android/sdk/emulator
 $emulator -list-avds

3)Run your Emulator Command Mode
 $emulator -avd Nexus_6P
    
IOS:
===
cd  /Applications/Xcode.app/Contents/Developer/Applications

1) List all Devices
$xcrun simctl list

2) Create a new Simulator
xcrun simctl create <name> <device type> <runtime>

$xcrun simctl create "Test Phone" "iPhone XR" iOS13.0

3) Open Simulator
$open -a Simulator --args -CurrentDeviceUDID 1CD844FE-9E9B-4C2B-BFD7-3CFA5A79D946

4) Close Simulator
$xcrun simctl shutdown all
$killall "Simulator"

5) Erase Simulator
$xcrun simctl erase 1CD844FE-9E9B-4C2B-BFD7-3CFA5A79D946
  
IOS Real Device:
===============

IOS Real Device Automation :


/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

brew install libimobiledevice

brew install ios-deploy


