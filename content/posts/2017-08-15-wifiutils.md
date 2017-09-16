---
layout: post
keywords: android, library, wifi, utils, auto, connect
title: "Easily Connect to WiFi Networks"
date: "2017-08-15 23:00"
icon: fa fa-sticky-note
metaImage: "/images/posts/mayi_flow.png"
categories: [android, android-library, wifi]
comments: true   #disables/enables comments section for the post
published: true
---
After the tremendous success of my first Library [MayI](/posts/mayi/) :P I decided to make another one. In general I like to make stuff I wanna use in my
personal projects but before I get to that step, I always do a research first in the abundance of open source libraries to find something that could fit my needs.
So that's what I did but to my surprise I only came across one or two outdated libraries that wouldn't fulfill my expectations.

<!--more-->

Therefore I would like to introduce to you **_WiFi Utils_**. A library that provides a set of convenience methods for managing WiFi State, WiFi Scan, And
WiFi Connection to Hotspots. If you have ever worked with `WifiManager` you should know how painful it is to make a simple wifi network scan or even worse
to connect to a hotspot programmatically. So that's what my new library is all about. To make it easier for me and hopefully for other developers as well
to do those kind of tasks from Java code. So lets jump right in some code examples.

**NOTE:** All of the examples presented here, use [Retrolambda](https://github.com/evant/gradle-retrolambda) plugin to make the whole code more compact.
You are not required to use it if you don't want to.

### Enabling/Disabling WiFi
turn on device's wifi using the following:

```java:nl
 WifiUtils.withContext(getApplicationContext()).enableWifi(this::checkResult);
```

Where `checkResult` could be a custom-defined method of your own that would deal accordingly in each situation. For Example:

```java:nl
  private void checkResult(boolean isSuccess)
    {
        if (isSuccess)
            Toast.makeText(MainActivity.this, "WIFI ENABLED", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "COULDN'T ENABLE WIFI", Toast.LENGTH_SHORT).show();
    }
```

If you don't want to deal with call backs you can just pass `null` to `enableWifi` method like so.

```java:nl
 WifiUtils.withContext(getApplicationContext()).enableWifi(null);
```

Similarly you can turn off the wifi using this:

```java:nl
WifiUtils.withContext(getApplicationContext()).disableWifi();
```

### Connecting to WiFi Networks
Now lets get to the interesting stuff. You can connect to any WiFi network programmatically knowing only SSID and WPA/WPA2 key: 

```java:nl
   WifiUtils.withContext(getApplicationContext())
                        .connectWith("MitsarasWiFi", "MitsarasPassword123")
                        .onConnectionResult(this::checkResult)
                        .start();
```

Again checkResult could be something like:

```java:nl
  private void checkResult(boolean isSuccess)
    {
        if (isSuccess)
            Toast.makeText(MainActivity.this, "CONNECTED YAY", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "COULDN'T CONNECT", Toast.LENGTH_SHORT).show();
    }
```

There are also a few other options that would allow you to do the same job: For example you can connect using SSID, BSSID and WPA/WPA2 Key:

```java:nl
 WifiUtils.withContext(getApplicationContext())
                      .connectWith("MitsarasWiFi", "AB:CD:EF:12:34:56", "MitsarasPassword123")
                      .onConnectionResult(this::checkResult)
                      .start();
```

Lastly WifiUtils can also connect using a specified `scanResult` after a WiFi Scan is complete, for example:

```java:nl
WifiUtils.withContext(getApplicationContext())
                     .connectWithScanResult("MitsarasPasword123", scanResults -> scanResults.get(0))
                     .onConnectionResult(this::checkResult)
                     .start();
```

The above example will perform a WiFi Scan and `connectWithScanResult` will return a `List<ScanResult> scanResults` with all the available WiFi networks
around. The method then expects you to Return a single `scanResult` out of the list of results of your choice so that it can try to connect to it. The rest is
pretty much the same.

### Canceling an ongoing connection
You have two options to cancel a connection in progress.

* If Connection takes too long to complete and just hangs in there without calling back `onConnectionResult` You can specify a **TimeOut** in milliseconds.

```java:nl
WifiUtils.withContext(getApplicationContext())
                     .connectWith("MitsarasWiFi", "MitsarasPassword123")
                     .setTimeout(15000)
                     .onConnectionResult(this::checkResult)
                     .start();
```

The Connection will fail in 15 seconds. The default timeOut is 30 seconds.

* You can also cancel an ongoing connection immediately using the following:

```java:nl
 WifiConnectorBuilder.WifiUtilsBuilder builder = WifiUtils.withContext(getApplicationContext());
 builder.connectWith("MitsarasWiFi", "MitsarasPassword123")
 .onConnectionResult(this::checkResult)
 .start();
 builder.cancelAutoConnect();
```

### Connecting with WPS keys.
On Androids 5.0 and greater there is also an option to connect using WPS keys. This library makes it easier and safer to connect using WPS than the stock android
API.

```java:nl
WifiUtils.withContext(getApplicationContext())
                     .connectWithWps("d8:74:95:e6:f5:f8", "51362485")
                     .onConnectionWpsResult(this::checkResult)
                     .start();
```

### Enable Logging
If you want to receive some extra logging info comming from WiFi Utils you can enable its logging capabilities with `WifiUtils.enableLog(true);`

### Permissions
Damn You are required to set a few permissions in order for this lib to work correctly :(

```xml:nl
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/> <!-- for Android 6 and above -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/> <!-- for Android 6 and above -->
```

### Add it to your project
[![Download](https://api.bintray.com/packages/thanosfisherman/maven/wifiutils/images/download.svg)](https://bintray.com/thanosfisherman/maven/wifiutils/_latestVersion)

Add the following to your **app module** `build.gradle` file
    
```groovy:nl
    dependencies {
       compile 'com.thanosfisherman.wifiutils:wifiutils:<latest version here>'
    }
```

### Apps using this library

My app of course <a href="${link '/gwparedirect.html'}">GWPA Finder</a> Duh :P

---

### Contributing?
There are a few more things to cover in this tutorial. Hopefully I will improve upon this in the future.

Feel free to add/correct/fix something to this library, I will be glad to improve it with your help.

License
-------
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

    Copyright 2017 Thanos Psaridis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.