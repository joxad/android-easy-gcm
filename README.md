# EasyGcm
Use this library to add GCM to your project, only in a few minutes !

# Version:
1.0.5


# Installation

Top Level Gradle :
```groovy
allprojects {
    repositories {
        maven {
            url "http://dl.bintray.com/joxad/maven"
        }
    }
}
```

Project's build.gradle

```groovy
dependencies {
    compile 'com.github.joxad:android-easy-gcm:$currentVersion'
}
```

# Utilisation

In whatever class with Context (better in your AppApplication class). 

## Create EasyGCM
 
```groovy
    new EasyGcm.Builder().context(this).senderId(R.string.app_senderid).enableLog(true).build();
```


## Get Token
 
  
```java
EasyGcm.setTokenListener(new ITokenListener() {
    @Override
        public void onReceived(String token) {
    }
});
           
```

## Notification of Push
```java

EasyGcm.setPushListener(new IPushListener() {
    @Override
    public void onReceive(Push push) {
    }
});

```

## Show an Android Notification 

```java
EasyNotification.show(1,EasyNotification.generate(null,"Title",R.drawable.common_ic_googleplayservices,"Message","SummaryText",true));
```

## Test your push

This website is usefull to easyly test : http://apns-gcm.bryantan.info/

Just put your sender key from console developer , and your device token (visible in the logs).

## ToDO

- Add Rx support
- 

#Contribution 

Feel free to make pull request in order to make some evolutions on it.


#Licence

The MIT License (MIT)
Copyright (c) 2016 Jocelyn David

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
