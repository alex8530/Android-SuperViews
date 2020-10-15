# Android-SuperButton

## This library make these things : 

- improve the Button , and add the possibility of changing these attributes :
- corner form one side only or more, for example from top Left
- change the radius of corner
- the shadow color
- the stroke color and stroke radius

![Image Result](https://i.ibb.co/W21YsKS/Screenshot-2020-10-16-022754.png)
 

## Getting started
* In ``` build.gradle ``` (  Project Level  )

Add maven of jitback

 ```
allprojects { 
     repositories { 
        maven { url 'https://jitpack.io' }
      }
 }   
```
* In ``` build.gradle ``` (  app Level  )

Add library as dependency [![JitPack](https://jitpack.io/v/alex8530/Android-SuperButton.svg)](https://jitpack.io/#alex8530/Android-SuperButton/Tag)
```
   implementation 'com.github.alex8530:Android-SuperButton:Tag'
```
and be sure you have material
```
 implementation "com.google.android.material:material:1.2.1"
```
   

## How to use

* First, add  ```xml  android:clipChildren="false" ``` to the parent layout to enable shadow appears 
  

```xml
    <alex.superbuttonlibrary.SuperButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_alex"
        android:padding="10dp"
        app:alex_topRightCornerRadius="@dimen/dimen_30"
        app:alex_topRightCornerFamily="Cut"
        app:alex_topLeftCornerRadius="@dimen/dimen_30"
        app:alex_topLeftCornerFamily="Round"
        app:alex_bottomLeftCornerRadius="@dimen/dimen_30"
        app:alex_bottomLeftCornerFamily="Round|Cut"
        app:alex_bottomRightCornerRadius="@dimen/dimen_30"
        app:alex_bottomRightCornerFamily="Cut"
        app:alex_fillColor="@color/colorAccent"
        app:alex_shadowColor="@color/colorGreen"
        app:alex_shadowElevation="@dimen/dimen_30"
        app:alex_strokeColor="@color/colorRed"  />
```

  * Enjoy!


## What are next ?
* improve the  <b>CardView</b> and add the possibility of changing these attributes :  
 - corner form one side only or more, for example from top Left
 - change the radius of corner
 - the shadow color
 - the stroke color and stroke radius  
  
## License

```
Copyright (c) 2020 Ali Abu Harb

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
